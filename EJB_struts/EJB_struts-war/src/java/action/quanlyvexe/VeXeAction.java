/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.quanlyvexe;

import actionform.quanlyvexe.TraCuuChuyenDiForm;
import actionform.quanlyvexe.VeXeForm;
import entity.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managesessionbean.ManageSessionBean;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Tai
 */
public class VeXeAction extends DispatchAction {

    private String[] dayOfWeek = {"Chủ nhật ", "Thứ hai ", "Thứ ba ", "Thứ tư ", "Thứ năm ", "Thứ sáu ", "Thứ bảy "};
    
    public ActionForward index(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ManageSessionBean msb = new ManageSessionBean();
        
        request.setAttribute("listbenxedi", msb.tbltuyenxeFacade.getAllBenXeDi());
        request.setAttribute("listbenxeden", msb.tbltuyenxeFacade.getAllBenXeDen());
        
        return mapping.findForward("vexe");
    }

    public ActionForward tracuuchuyendi(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        TraCuuChuyenDiForm myform = (TraCuuChuyenDiForm)form;
        
        managesessionbean.ManageSessionBean msb = new ManageSessionBean();
        
        List<Object[]> listChuyenDi = msb.tblchuyendiFacade.traCuuChuyenDi(myform.getMaBenDi(), myform.getMaBenDen());
        
        String html = "";
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
        Date khoiHanh = new Date(myform.getKhoiHanh());
        if(listChuyenDi != null){
            for (Object object[] : listChuyenDi) {
                Tblchuyendi chuyendi = (Tblchuyendi)object[0];
                if(chuyendi.getKhoihanh().getDay() == khoiHanh.getDay() &&
                       sf.parse(myform.getKhoiHanh()).compareTo(sf.parse(sf.format(chuyendi.getKhoihanh()))) < 0)
                {
                    Tblbenxe benxedi = (Tblbenxe)object[1];
                    Tblbenxe benxeden = (Tblbenxe)object[2];
                    Tblloaixe lx = (Tblloaixe)object[3];
                    Tbltuyenxe tx = (Tbltuyenxe)object[4];
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String khoihanh = sf.format(chuyendi.getKhoihanh());
                    String ketthuc =  sf.format(chuyendi.getKetthuc());
                    String soghe = chuyendi.getSoghedat() + "/" + (chuyendi.getSoghedat() + chuyendi.getSoghetrong());


                    String function = String.format("initFormLapVe('%1s','%2s','%3s','%4s')", benxedi.getTenbenxe() + " - " + benxeden.getTenbenxe(),
                                                                                              khoihanh + " " + sdf.format(khoiHanh), tx.getDongia(), chuyendi.getMachuyendi());

                    html += "<tr class=\"text_middle\">" +
                            "<td><a href=\"#\">" + benxedi.getTenbenxe() + " đến " + benxeden.getTenbenxe() + "</a></td>" +
                            "<td class=\"row\">" + dayOfWeek[chuyendi.getKhoihanh().getDay()] + khoihanh +
                            "<i class=\"fa fa-long-arrow-right\" style=\"padding: 0 10px;\" aria-hidden=\"true\"></i>"+ dayOfWeek[chuyendi.getKetthuc().getDay()] + ketthuc +
                            "</td>" +
                            "<td>" + lx.getLoaixe() + "</td>" +
                            "<td>" + soghe + "</td>" +
                            "<td>" + tx.getDongia() + "</td>" +
                            "<td>" +
                            "<a href=\"#\" class=\"btn btn-warning\" data-toggle=\"modal\" data-target=\"#lapVeModal\" onclick=\"" + function +"\">Lập vé</a>" +
                            "</td>" +
                            "</tr>";
                }
            }
        }
       
        response.setContentType("text/xml;charset=utf-8");
        response.setHeader("cache-control", "no-cache");
        
        if(html.isEmpty()){
            html += "Không tìm thấy dữ liệu";
        }

        response.getWriter().println(html);
        response.getWriter().flush();

        return null;
    }
    
    public ActionForward thongtinchuyendi(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        managesessionbean.ManageSessionBean msb = new ManageSessionBean();
        Object id = request.getParameter("idchuyendi");
        int machuyendi = id != null ? Integer.parseInt(id.toString().trim()) : -1;
        
        String xml = "";
        ArrayList<String> listBookedPayment = new ArrayList<>();
        ArrayList<String> listBookedNotPayment = new ArrayList<>();
        for(Tblchitietphieudatcho pdc: msb.tblchitietphieudatchoFacade.getCTPhieuDatChoForMaChuyenDi(machuyendi)){
            if(pdc.getLayve())
                listBookedPayment.add(pdc.getVitrighe());
            else
                listBookedNotPayment.add(pdc.getVitrighe());
        }
        response.setContentType("text/xml;charset=utf-8");
        response.setHeader("cache-control", "no-cache");

        xml += "<List>";
        xml += "<BookedPayment>" + listBookedPayment + "</BookedPayment>";
        xml += "<BookedNotPayment>" + listBookedNotPayment + "</BookedNotPayment>";
        xml += "</List>";
        
        response.getWriter().println(xml);
        response.getWriter().flush();
        
        return null;
    }
    
    public ActionForward taoPhieuDatCho(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        
        String xml = "<DOCUMENT>";
        managesessionbean.ManageSessionBean msb = new ManageSessionBean();
        VeXeForm myForm = (VeXeForm) form;
        final String format = ", "; // format phu thuoc vao initSeats() strong datve.js
        
        xml += "<MESSAGE>";
        // validate logic
        Boolean error = false;
        if(msb.tblchuyendiFacade.find(myForm.getMachuyendi()) == null){
            error = true;
            xml += "Chuyến đi không tồn tại";
        }
        
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        Date ngaydi = sf.parse(myForm.getNgaydi());
        
        String message = "";
        for (String item : myForm.getDanhsachghe().split(format)) {
            if(msb.tblchitietphieudatchoFacade.checkExistForMaChuyenDiAndViTriGhe(myForm.getMachuyendi(), item, ngaydi)){
                message += item + ", ";
                error = true;
            }
        }
        if(!message.isEmpty()){
            xml += "Ghế " + message + " không còn trống<br/>";
        }
       
        
        
        // setup data
        if(!error){
            Tblphieudatcho pdc = new Tblphieudatcho();
            
            try{
                pdc.setDienthoai(myForm.getDienthoai());
                pdc.setEmail(myForm.getEmail());
                pdc.setNgaydat(new Date());
                pdc.setHoten(myForm.getHoten());
                pdc.setNgaydi(ngaydi);
                msb.tblphieudatchoFacade.create(pdc);


                for (String item : myForm.getDanhsachghe().split(format)) {
                    Tblchitietphieudatcho ctpdc = new Tblchitietphieudatcho();
                    ctpdc.setLayve(myForm.isThanhtoan());
                    ctpdc.setMaphieu(pdc.getMaphieu());
                    ctpdc.setMachuyendi(myForm.getMachuyendi());
                    ctpdc.setNgaylay(new Date());
                    ctpdc.setVitrighe(item);

                    msb.tblchitietphieudatchoFacade.create(ctpdc);
                }

                xml += "Lập vé thành công";
            }catch(RuntimeException ex){
                xml += "Không thể thêm phiếu đặt chỗ";
                msb.tblphieudatchoFacade.remove(pdc);
            }
            catch(Exception ex){
                xml += "Không thể thêm phiếu đặt chỗ";
            }
        }
        
        xml += "</MESSAGE>";
        xml += "</DOCUMENT>";
        response.setContentType("text/xml;charset=utf-8");
        response.setHeader("cache-control", "no-cache");
        
        response.getWriter().println(xml);
        response.getWriter().flush();
        return null;
    }
}
