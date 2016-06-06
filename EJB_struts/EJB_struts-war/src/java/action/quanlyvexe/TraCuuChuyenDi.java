/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.quanlyvexe;

import actionform.quanlyvexe.TraCuuChuyenDiForm;
import entity.Tblbenxe;
import entity.Tblchuyendi;
import entity.Tblloaixe;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managesessionbean.ManageSessionBean;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Tai
 */
public class TraCuuChuyenDi extends org.apache.struts.action.Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        TraCuuChuyenDiForm myform = (TraCuuChuyenDiForm)form;
        
        managesessionbean.ManageSessionBean msb = new ManageSessionBean();
        
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        Date khoiHanh = sf.parse(myform.getKhoiHanh());
        List<Object[]> listChuyenDi = msb.tblchuyendiFacade.traCuuChuyenDi(myform.getMaBenDi(), myform.getMaBenDen(), khoiHanh);
        
        String html = "";
        for (Object object[] : listChuyenDi) {
            
            Tblchuyendi chuyendi = (Tblchuyendi)object[0];
            Tblbenxe benxedi = (Tblbenxe)object[1];
            Tblbenxe benxeden = (Tblbenxe)object[2];
            Tblloaixe lx = (Tblloaixe)object[3];
            
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm 'Ngày' dd/MM/yyyy");
            String khoihanh = sdf.format(chuyendi.getKhoihanh());
            String ketthuc =  sdf.format(chuyendi.getKetthuc());
            String soghe = chuyendi.getSoghedat() + "/" + (chuyendi.getSoghedat() + chuyendi.getSoghetrong());
            
            html += "<tr class=\"text_middle\">" +
                    "<td><a href=\"#\">" + benxedi.getTenbenxe() + " đến " + benxeden.getTenbenxe() + "</a></td>" +
                    "<td class=\"row\">" + khoihanh +
                    "<i class=\"fa fa-long-arrow-right\" style=\"padding: 0 10px;\" aria-hidden=\"true\"></i>"+ ketthuc +
                    "</td>" +
                    "<td>" + lx.getLoaixe() + "</td>" +
                    "<td>" + soghe + "</td>" +
                    "<td>" + chuyendi.getDongia()+ "</td>" +
                    "<td>" +
                    "<a href=\"#\" class=\"btn btn-warning\" data-toggle=\"modal\" data-target=\"#lapVeModal\">Lập vé</a>" +
                    "</td>" +
                    "</tr>";
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
}
