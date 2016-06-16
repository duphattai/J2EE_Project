/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.quanlyxe;


import actionform.quanlyxe.QLXeForm;
import entity.*;
import java.util.ArrayList;
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
 * @author HaiHamHo
 */
public class QuanLyXeAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final ManageSessionBean msb = new ManageSessionBean();

    public ActionForward list(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<QLXeForm> listxe = new ArrayList<>();
        for(Tblxekhach xk : msb.tblxekhachFacade.findAll()){
            String loaixe = getLoaiXe(xk.getMaloaixe());
            String tuyen = getTuyenXe(xk.getMatuyen());
            listxe.add(new QLXeForm(xk.getMaxe(),
                                    loaixe,
                                    xk.getTaixe(),
                                    xk.getBiensoxe(),
                                    xk.getSoghe(),
                                    tuyen));
        }
        
        List<QLXeForm> listtuyenxe = new ArrayList<>();
        for(Tbltuyenxe tx : msb.tbltuyenxeFacade.findAll()){            
            String tuyen = getTuyenXe(tx.getMatuyen());
            listtuyenxe.add(new QLXeForm(tx.getMatuyen(),                                    
                                    tuyen));
        }
        
        request.setAttribute("listloaixe", msb.tblloaixeFacade.findAll());
        request.setAttribute("listtuyenxe", listtuyenxe);
        request.setAttribute("list", listxe);
        return mapping.findForward(SUCCESS);
    }
    
    public String getTuyenXe(int id){
        String tuyen;
        Tbltuyenxe tx = msb.tbltuyenxeFacade.find(id);
        tuyen = getBenXe(tx.getMabendi()) + " - " + getBenXe(tx.getMabenden());       
        return tuyen;
    }
    
    public String getBenXe(int id)
    {
        String benxe;
        Tblbenxe bx = msb.tblbenxeFacade.find(id);
        benxe = bx.getTenbenxe();
        return benxe;
    }
    
    public String getLoaiXe(int id)
    {
        String loaixe;
        Tblloaixe lx = msb.tblloaixeFacade.find(id);
        loaixe = lx.getLoaixe();
        return loaixe;
    }

    public ActionForward add(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        QLXeForm myform = (QLXeForm) form;
        Tblxekhach xe = new Tblxekhach();        
        xe.setMaloaixe(myform.getMaloaixe());
        xe.setTaixe(myform.getTaixe());
        xe.setBiensoxe(myform.getBiensoxe());
        xe.setMatuyen(myform.getMatuyen());
        xe.setSoghe(myform.getSoghe());
        msb.tblxekhachFacade.create(xe);
        
        return list(mapping, form, request, response);
    }
       
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        QLXeForm myform = (QLXeForm) form;
        Tblxekhach xe = msb.tblxekhachFacade.find(myform.getMaxe());        
        xe.setMaloaixe(myform.getMaloaixe());
        xe.setTaixe(myform.getTaixe());
        xe.setBiensoxe(myform.getBiensoxe());
        xe.setMatuyen(myform.getMatuyen());
        xe.setSoghe(myform.getSoghe());
        msb.tblxekhachFacade.edit(xe);
        
        return list(mapping, form, request, response);
    }
       
    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception { 
        int id = Integer.parseInt(request.getParameter("maxe"));
        Tblxekhach xe = msb.tblxekhachFacade.find(id);
        msb.tblxekhachFacade.remove(xe);
        
        return list(mapping, form, request, response);
    }
}
