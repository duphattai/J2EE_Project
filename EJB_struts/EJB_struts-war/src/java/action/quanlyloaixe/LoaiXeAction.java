/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.quanlyloaixe;

import actionform.quanlyloaixe.Loaixe;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managesessionbean.ManageSessionBean;
import entity.*;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author HaiHamHo
 */
public class LoaiXeAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    
    private final ManageSessionBean msb = new ManageSessionBean();

    public ActionForward list(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {       
        request.setAttribute("list", msb.tblloaixeFacade.findAll());
        return mapping.findForward(SUCCESS);
    }

    public ActionForward add(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Loaixe myform = (Loaixe) form;
        Tblloaixe lxe = new Tblloaixe();
        lxe.setMaloaixe(myform.getMaloaixe());
        lxe.setLoaixe(myform.getLoaixe());
        msb.tblloaixeFacade.create(lxe);
        
        return list(mapping, form, request, response);
    }
    
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        Loaixe myform = (Loaixe) form;
        Tblloaixe lxe = new Tblloaixe();
        lxe.setMaloaixe(myform.getMaloaixe());
        lxe.setLoaixe(myform.getLoaixe());
        msb.tblloaixeFacade.edit(lxe);
        
        return list(mapping, form, request, response);
    }
      
    
    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception { 
        int id = Integer.parseInt(request.getParameter("maloaixe"));
        Tblloaixe lxe = msb.tblloaixeFacade.find(id);
        msb.tblloaixeFacade.remove(lxe);
        
        return list(mapping, form, request, response);
    }
}
