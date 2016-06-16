/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.quanlytaikhoan;

import actionform.quanlytaikhoan.QLTaiKhoanForm;
import com.sun.javafx.scene.control.skin.VirtualFlow;
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
 * @author HaiHamHo
 */
public class TaiKhoanAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final ManageSessionBean msb = new ManageSessionBean();

    public ActionForward list(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<QLTaiKhoanForm> listtk = new ArrayList<>();
        for (Tbltaikhoan tk : msb.tbltaikhoanFacade.findAll()) {
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
            String ngaysinh = sf.format(tk.getNgaysinh());
            Tblphanquyen quyen = msb.tblphanquyenFacade.find(tk.getMaquyen());
            listtk.add(new QLTaiKhoanForm(tk.getTentaikhoan(),
                                          quyen.getQuyen(),
                                          tk.getMatkhau(),
                                          tk.getHoten(),                                         
                                          tk.getCmnd(),
                                          tk.getDiachi(),
                                          ngaysinh));
        }
        
        request.setAttribute("listquyen", msb.tblphanquyenFacade.findAll());
        request.setAttribute("list", listtk);
        return mapping.findForward(SUCCESS);
    }


    public ActionForward add(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        QLTaiKhoanForm myform = (QLTaiKhoanForm) form;
        Tbltaikhoan tk = new Tbltaikhoan();
        tk.setTentaikhoan(myform.getTentaikhoan());
        tk.setMaquyen(myform.getMaquyen());
        tk.setMatkhau(myform.getMatkhau());
        tk.setHoten(myform.getHoten());
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaysinh = sf.parse(myform.getNgaysinh());
        tk.setNgaysinh(ngaysinh);
        tk.setCmnd(myform.getCmnd());
        tk.setDiachi(myform.getDiachi());
        msb.tbltaikhoanFacade.create(tk);
        
        return list(mapping, form, request, response);
    }
    
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        QLTaiKhoanForm myform = (QLTaiKhoanForm) form;
        Tbltaikhoan tk = new Tbltaikhoan();
        tk.setTentaikhoan(myform.getTentaikhoan());
        tk.setMaquyen(myform.getMaquyen());
        tk.setMatkhau(myform.getMatkhau());
        tk.setHoten(myform.getHoten());
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaysinh = sf.parse(myform.getNgaysinh());
        tk.setNgaysinh(ngaysinh);
        tk.setCmnd(myform.getCmnd());
        tk.setDiachi(myform.getDiachi());
        msb.tbltaikhoanFacade.edit(tk);
        
        return list(mapping, form, request, response);
    }
    
     public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception { 
        String taikhoan = request.getParameter("tentaikhoan");
        Tbltaikhoan tk = msb.tbltaikhoanFacade.find(taikhoan);
        msb.tbltaikhoanFacade.remove(tk);
        
        return list(mapping, form, request, response);
    }
}
