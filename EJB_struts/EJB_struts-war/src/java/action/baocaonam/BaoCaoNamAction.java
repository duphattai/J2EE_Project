/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action.baocaonam;

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
 * @author MinhNhan
 */
public class BaoCaoNamAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "baocaonam";

    public ActionForward index(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ManageSessionBean msb = new ManageSessionBean();
        int a = msb.tblphieudatchoFacade.getDoanhThu(6, 2016);
        request.setAttribute("doanhthu", msb.tblphieudatchoFacade.getDoanhThu(6, 2016));
        
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward getData(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ManageSessionBean msb = new ManageSessionBean();
        int nam = Integer.parseInt(request.getParameter("nam"));
        
        List<Integer> doanhthu = new ArrayList<>();
        for(int i = 0; i < 11; i++){
            
            doanhthu.add(msb.tblphieudatchoFacade.getDoanhThu(i, nam));
        }
        
        response.setContentType("text/xml;charset=utf-8");
        response.setHeader("cache-control", "no-cache");

        String xml = "<DOCUMENT>";
        xml += "<DOANHTHU>" + doanhthu + "</DOANHTHU>";
        xml += "</DOCUMENT>";
        
        response.getWriter().println(xml);
        response.getWriter().flush();
        
        return null;
    }
    
}
