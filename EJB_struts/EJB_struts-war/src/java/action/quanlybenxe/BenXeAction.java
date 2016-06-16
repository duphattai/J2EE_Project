/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.quanlybenxe;

import actionform.quanlybenxe.BenXeForm;
import entity.Tblbenxe;
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
public class BenXeAction extends org.apache.struts.actions.DispatchAction {

    public ActionForward index(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ManageSessionBean msb = new ManageSessionBean();
        request.setAttribute("listbenxe", msb.tblbenxeFacade.findAll());

        return mapping.findForward("listbenxe");
    }

    public ActionForward them(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ManageSessionBean msb = new ManageSessionBean();
        BenXeForm myform = (BenXeForm) form;
        Tblbenxe lxe = new Tblbenxe();
//        lxe.setMabenxe(myform.getMabenxe());
        lxe.setTenbenxe(myform.getTenbenxe());
        msb.tblbenxeFacade.create(lxe);

//        BenXeForm txf = (BenXeForm) form;
//        String xml = "<DOCUBMENT>";
//        xml += "<MESSAGE>";
//        String message = "";
//        boolean result = msb.tblbenxeFacade.checkBenXeExist(txf.getTenBenXe());
//        if (!result) {
//            Tblbenxe ad = new Tblbenxe();
//            ad.setTenbenxe(txf.getTenBenXe());
//            msb.tblbenxeFacade.create(ad);
//            message = "<font color=\"blue\">Thêm thành công</font>";
//        } else {
//            message = "<font color=\"red\">Bến xe đã có ! vui lòng chọn tuyến khác</font>";
//        }
//
//        response.setContentType("text/xml;charset=utf-8");
//        response.setHeader("cache-control", "no-cache");
//        xml += message;
//        xml += "</MESSAGE>";
//        xml += "</DOCUMENT>";
//
//        response.getWriter().println(xml);
//        response.getWriter().flush();
        return index(mapping, form, request, response);
    }
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ManageSessionBean msb = new ManageSessionBean();
        BenXeForm myform = (BenXeForm) form;
        Tblbenxe bxe = msb.tblbenxeFacade.find(myform.getMabenxe());
        
        bxe.setTenbenxe(myform.getTenbenxe());
        msb.tblbenxeFacade.edit(bxe);
        
        request.setAttribute("listbenxe", msb.tblbenxeFacade.findAll());
        return mapping.findForward("listbenxe");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ManageSessionBean msb = new ManageSessionBean();
        int benxe = Integer.parseInt(request.getParameter("mabenxe"));
        Tblbenxe tk = msb.tblbenxeFacade.find(benxe);
        if(tk != null)
            msb.tblbenxeFacade.remove(tk);
        
        request.setAttribute("listbenxe", msb.tblbenxeFacade.findAll());
        return mapping.findForward("listbenxe");
    }
}
