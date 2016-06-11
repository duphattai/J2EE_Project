/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.quanlychuyendi;

import actionform.quanlychuyendi.ChuyenDiForm;
import entity.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public ActionForward index(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ManageSessionBean msb = new ManageSessionBean();
        
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
            
            listChuyenDi.add(new ChuyenDiForm(cd.getMachuyendi(), xk.getMaxe(), xk.getBiensoxe(), lx.getLoaixe(), xk.getSoghe(),
                    bxdi.getTenbenxe(), bxden.getTenbenxe(), cd.getKhoihanh().toString(), cd.getKetthuc().toString()));
        }
        request.setAttribute("listchuyendi", listChuyenDi);
        request.setAttribute("listbenxedi", msb.tbltuyenxeFacade.getAllBenXeDi());
        request.setAttribute("listbenxeden", msb.tbltuyenxeFacade.getAllBenXeDen());

        return mapping.findForward("success");
    }

    public ActionForward myAction2(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward("");
    }
}
