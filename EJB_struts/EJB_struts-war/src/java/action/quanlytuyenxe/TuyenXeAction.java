/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.quanlytuyenxe;

import actionform.quanlytuyenxe.TuyenXeForm;
import entity.Tblbenxe;
import entity.Tbltuyenxe;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managesessionbean.ManageSessionBean;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Quoc
 */
public class TuyenXeAction extends org.apache.struts.actions.DispatchAction {

    public ActionForward index(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ManageSessionBean msb = new ManageSessionBean();
        List<TuyenXeForm> listTuyenXe = new ArrayList<>();
        //thêm bến xe
        for (Tbltuyenxe tx : msb.tbltuyenxeFacade.findAll()) {
            Tblbenxe bxdi = msb.tblbenxeFacade.find(tx.getMabendi());
            Tblbenxe bxden = msb.tblbenxeFacade.find(tx.getMabenden());

            listTuyenXe.add(new TuyenXeForm(tx.getMatuyen(), bxdi.getMabenxe(), bxden.getMabenxe(), bxdi.getTenbenxe(), bxden.getTenbenxe(), tx.getThoigian(), tx.getDongia()));
        }

        request.setAttribute("listtuyenxe", listTuyenXe);
        request.setAttribute("listbenxe", msb.tblbenxeFacade.findAll());

        return mapping.findForward("listtuyenxe");

    }

    public ActionForward add(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ManageSessionBean msb = new ManageSessionBean();
        TuyenXeForm myform = (TuyenXeForm) form;
        Tbltuyenxe xe = new Tbltuyenxe();
        xe.setMabendi(myform.getMabendi());
        xe.setMabenden(myform.getMabenden());
        xe.setThoigian(myform.getThoigian());
        xe.setDongia(myform.getDongia());        
        msb.tbltuyenxeFacade.create(xe);
//        ManageSessionBean msb = new ManageSessionBean();
//        TuyenXeForm txf = (TuyenXeForm) form;
//        String xml = "<DOCUMENT>";
//        xml += "<ERROR>";
//        String message = "";
//        Tbltuyenxe tx = msb.tbltuyenxeFacade.getTuyenXeForBenXeDiAndBenXeDen(txf.getMabendi(), txf.getMabenden());
//        if (tx == null) {
//            Tbltuyenxe ad = new Tbltuyenxe();
//            ad.setThoigian(txf.getThoigian());
//            ad.setMabendi(txf.getMabendi());
//            ad.setMabenden(txf.getMabenden());
//            ad.setDongia(txf.getDongia());
//            msb.tbltuyenxeFacade.create(tx);
//            
//            message = "Tạo tuyến thành công";
//        } else {
//            message = "Tuyến xe đã có ! vui lòng chọn tuyến khác";
//            xml += "Lỗi";
//        }
//        xml += "</ERROR>";
//        xml += "<MESSAGE>" + message + "</MESSAGE>";
//        xml += "</DOCUMENT>";
//
//        response.setContentType("text/xml;charset=utf-8");
//        response.setHeader("cache-control", "no-cache");
//        response.getWriter().println(xml);
//        response.getWriter().flush();
        return index(mapping, form, request, response);
    }

    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ManageSessionBean msb = new ManageSessionBean();
        TuyenXeForm myform = (TuyenXeForm) form;
        Tbltuyenxe xe = msb.tbltuyenxeFacade.find(myform.getMatuyen());        
        xe.setMabendi(myform.getMabendi());
        xe.setMabenden(myform.getMabenden());
        xe.setThoigian(myform.getThoigian());
        xe.setDongia(myform.getDongia());        
        msb.tbltuyenxeFacade.edit(xe);
        
        return index(mapping, form, request, response);
    }
       
    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception { 
        ManageSessionBean msb = new ManageSessionBean();
        int id = Integer.parseInt(request.getParameter("matuyen"));
        Tbltuyenxe xe = msb.tbltuyenxeFacade.find(id);
        msb.tbltuyenxeFacade.remove(xe);
        
        return index(mapping, form, request, response);
    }
}
