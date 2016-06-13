/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.quanlychuyendi;

import actionform.quanlychuyendi.ChuyenDiForm;
import entity.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
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
public class ChuyenDiAction extends DispatchAction {

    private ManageSessionBean msb = new ManageSessionBean();
    private String[] dayOfWeek = {"Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy", "Chủ nhật"};
    
    public ActionForward index(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        int mabendi = Integer.parseInt(request.getParameter("mabendi"));
        int mabenden = Integer.parseInt(request.getParameter("mabenden"));
        
        List<Tbltuyenxe> listTX = new ArrayList<>();
        if(mabendi == -1 && mabenden == -1)
           listTX = msb.tbltuyenxeFacade.findAll();
        else if(mabendi == -1 && mabenden != -1)
           listTX = msb.tbltuyenxeFacade.getTuyenXeForBenXeDen(mabenden);
        else if(mabenden == -1 && mabendi != -1)
           listTX = msb.tbltuyenxeFacade.getTuyenXeForBenXeDi(mabendi);
        else
            listTX.add(msb.tbltuyenxeFacade.getTuyenXeForBenXeDiAndBenXeDen(mabendi, mabenden));
        
        List<Integer> listMaTuyen = listTX.stream().map(sc->sc.getMatuyen()).collect(Collectors.toList());
 
        
        List<ChuyenDiForm> listChuyenDi = new ArrayList<>();
        for(Object[] object: msb.tblchuyendiFacade.traCuuChuyenDi(listMaTuyen)){
            Tblchuyendi cd = (Tblchuyendi)object[0];
            Tblbenxe bxdi = (Tblbenxe)object[1];
            Tblbenxe bxden = (Tblbenxe)object[2];
            Tblloaixe lx = (Tblloaixe)object[3];
            Tblxekhach xk = (Tblxekhach) object[4];
            Tbltuyenxe tx = (Tbltuyenxe) object[5];
            listChuyenDi.add(new ChuyenDiForm(cd, xk, bxdi, bxden, lx, tx));
        }
        request.setAttribute("listchuyendi", listChuyenDi);
        request.setAttribute("listbenxedi", msb.tbltuyenxeFacade.getAllBenXeDi());
        request.setAttribute("listbenxeden", msb.tbltuyenxeFacade.getAllBenXeDen());

        return mapping.findForward("success");
    }

    public ActionForward tracuuxekhach(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        int mabendi = Integer.parseInt(request.getParameter("mabendi"));
        int mabenden = Integer.parseInt(request.getParameter("mabenden"));
        
        List<Tbltuyenxe> listTX = new ArrayList<>();
        if(mabendi == -1 && mabenden == -1)
           listTX = msb.tbltuyenxeFacade.findAll();
        else if(mabendi == -1 && mabenden != -1)
           listTX = msb.tbltuyenxeFacade.getTuyenXeForBenXeDen(mabenden);
        else if(mabenden == -1 && mabendi != -1)
           listTX = msb.tbltuyenxeFacade.getTuyenXeForBenXeDi(mabendi);
        else
            listTX.add(msb.tbltuyenxeFacade.getTuyenXeForBenXeDiAndBenXeDen(mabendi, mabenden));
        
        List<Integer> listMaTuyen = listTX.stream().map(sc->sc.getMatuyen()).collect(Collectors.toList());
 
        List<ChuyenDiForm> listXeKhach = new ArrayList<>();
        for(Object[] object: msb.tblxekhachFacade.getXeKhachByTuyenXeList(listMaTuyen)){
            Tblbenxe bxdi = (Tblbenxe)object[0];
            Tblbenxe bxden = (Tblbenxe)object[1];
            Tblloaixe lx = (Tblloaixe)object[2];
            Tblxekhach xk = (Tblxekhach) object[3];
            Tbltuyenxe tx = (Tbltuyenxe) object[4];
            listXeKhach.add(new ChuyenDiForm(null, xk, bxdi, bxden, lx, tx));
        }
        
        request.setAttribute("listxekhach", listXeKhach);
        request.setAttribute("listbenxedi", msb.tbltuyenxeFacade.getAllBenXeDi());
        request.setAttribute("listbenxeden", msb.tbltuyenxeFacade.getAllBenXeDen());

        return mapping.findForward("tracuuxekhach");
    }

    
    
    public ActionForward edit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ChuyenDiForm frm = (ChuyenDiForm) form;
        
        Boolean error = false;
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm a");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR, sf.parse(frm.getKhoihanh()).getHours());
        calendar.set(Calendar.MINUTE, sf.parse(frm.getKhoihanh()).getMinutes());
        
        String xml = "<DOCUMENT>";
        xml += "<MESSAGE>";
        String message = "";
        for (Tblchuyendi cd : msb.tblchuyendiFacade.getChuyenDiByMaXe(frm.getMaxekhach())) {
            if(cd.getMachuyendi() != frm.getMachuyendi()){
                for (String dayofweek : frm.getNgaytrongtuan()) {
                    // set day of week
                    calendar.set(Calendar.DAY_OF_WEEK, Integer.parseInt(dayofweek));
                    Date kh = calendar.getTime();
                    if(kh.getHours() == cd.getKhoihanh().getHours() &&  
                        kh.getMinutes() == cd.getKhoihanh().getMinutes() && kh.getDay() == cd.getKhoihanh().getDay()){
                        message += dayOfWeek[Integer.parseInt(dayofweek)] + " ";
                        xml += "Khởi hành " + dayOfWeek[Integer.parseInt(dayofweek)] + " " +  frm.getKhoihanh() +" bị trùng thời gian!<br/>";
                        error = true;
                    }
                }
            }
        }
        if(!message.isEmpty()){
            xml += "Khởi hành " + message +  frm.getKhoihanh() +" bị trùng thời gian!<br/>";
        }
        
        if(!error){
            calendar.set(Calendar.HOUR, sf.parse(frm.getKhoihanh()).getHours());
            calendar.set(Calendar.MINUTE, sf.parse(frm.getKhoihanh()).getMinutes());
            for (String dayofweek : frm.getNgaytrongtuan()) {
                Tblchuyendi editCD = msb.tblchuyendiFacade.find(frm.getMachuyendi());

                calendar.set(Calendar.DAY_OF_WEEK, Integer.parseInt(dayofweek));
                editCD.setKhoihanh(calendar.getTime());
                
                calendar.add(Calendar.MINUTE, frm.getThoigiandi());
                editCD.setKetthuc(calendar.getTime());

                msb.tblchuyendiFacade.edit(editCD);
            }
            
            xml += "Cập nhật thành công";
        }
        xml += "</MESSAGE>";
        xml += "</DOCUMENT>";
                
        response.setContentType("text/xml;charset=utf-8");
        response.setHeader("cache-control", "no-cache");
        response.getWriter().println(xml);
        response.getWriter().flush();
        
        return null;
    }

     public ActionForward add(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ChuyenDiForm frm = (ChuyenDiForm) form;
        
        Boolean error = false;
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm a");
        Calendar calendar = new GregorianCalendar();
        
        calendar.set(Calendar.HOUR, sf.parse(frm.getKhoihanh()).getHours());
        calendar.set(Calendar.MINUTE, sf.parse(frm.getKhoihanh()).getMinutes());
        
        String xml = "<DOCUMENT>";
        xml += "<MESSAGE>";
        String message = "";
        for (Tblchuyendi cd : msb.tblchuyendiFacade.getChuyenDiByMaXe(frm.getMaxekhach())) {
            for (String dayofweek : frm.getNgaytrongtuan()) {
                // set day of week
                calendar.set(Calendar.DAY_OF_WEEK, Integer.parseInt(dayofweek));
                calendar.set(Calendar.WEEK_OF_MONTH, 1);
                Date kh = calendar.getTime();
                if(kh.getHours() == cd.getKhoihanh().getHours() &&  
                    kh.getMinutes() == cd.getKhoihanh().getMinutes() && kh.getDay() == cd.getKhoihanh().getDay()){
                    message += dayOfWeek[Integer.parseInt(dayofweek)] + " ";
                    error = true;
                }
            }
        }
        if(!message.isEmpty()){
            xml += "Khởi hành " + message +  frm.getKhoihanh() +" bị trùng thời gian!<br/>";
        }
        
        
        if(!error){
            calendar.set(Calendar.HOUR, sf.parse(frm.getKhoihanh()).getHours());
            calendar.set(Calendar.MINUTE, sf.parse(frm.getKhoihanh()).getMinutes());
            
            for (String dayofweek : frm.getNgaytrongtuan()) {
                Tblchuyendi cd = new Tblchuyendi();
                calendar.set(Calendar.DAY_OF_WEEK, Integer.parseInt(dayofweek));
                calendar.set(Calendar.WEEK_OF_MONTH, 1);
                
                cd.setKhoihanh(calendar.getTime());
                
                calendar.add(Calendar.MINUTE, frm.getThoigiandi());
                cd.setKetthuc(calendar.getTime());
                cd.setMaxe(frm.getMaxekhach());
                cd.setSoghedat(0);
                cd.setSoghetrong(0);
            
                msb.tblchuyendiFacade.create(cd);
            }
            
            xml += "Thêm thành công";
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
