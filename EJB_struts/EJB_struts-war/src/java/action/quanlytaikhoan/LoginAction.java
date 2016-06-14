/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.quanlytaikhoan;

import actionform.quanlytaikhoan.LoginForm;
import actionform.quanlytaikhoan.QLTaiKhoanForm;
import entity.Tblphanquyen;
import entity.Tbltaikhoan;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managesessionbean.ManageSessionBean;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author HaiHamHo
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private final ManageSessionBean msb = new ManageSessionBean();
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        QLTaiKhoanForm f = (QLTaiKhoanForm) form;
        Tbltaikhoan tk = msb.tbltaikhoanFacade.checkExistUserAndPass(f.getTentaikhoan(), f.getMatkhau()); 
        if(tk != null){
        f.setMaquyen(tk.getMaquyen());
        f.setHoten(tk.getHoten());
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        String ngaysinh = sf.format(tk.getNgaysinh());
        f.setNgaysinh(ngaysinh);
        f.setCmnd(tk.getCmnd());
        f.setDiachi(tk.getDiachi());
        Tblphanquyen quyen = msb.tblphanquyenFacade.find(tk.getMaquyen());
        f.setQuyen(quyen.getQuyen());
        request.setAttribute("tk", f);
        return mapping.findForward(SUCCESS); 
        }
        else{
            return mapping.findForward(FAIL); 
        }
    }
}
