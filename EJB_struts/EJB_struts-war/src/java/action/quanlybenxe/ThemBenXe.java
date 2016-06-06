/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.quanlybenxe;

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
public class ThemBenXe extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ManageSessionBean sessionBean = new ManageSessionBean();
        
        entity.Tblbenxe benxe = new Tblbenxe(1, "test");
        sessionBean.tblbenxeFacade.create(benxe);
        
        return mapping.findForward(SUCCESS);
    }
}
