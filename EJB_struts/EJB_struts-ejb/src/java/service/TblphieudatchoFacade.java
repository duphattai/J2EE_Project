/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblphieudatcho;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tai
 */
@Stateless(mappedName = "TblphieudatchoFacade")
public class TblphieudatchoFacade extends AbstractFacade<Tblphieudatcho> implements TblphieudatchoFacadeLocal {

    @PersistenceContext(unitName = "EJB_struts-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblphieudatchoFacade() {
        super(Tblphieudatcho.class);
    } 

    @Override
    public int getDoanhThu(int thang, int nam) {
        try{
            String sql = " SELECT COUNT(pdc.ngaydi) " +
                    " FROM Tblphieudatcho pdc, Tblchitietphieudatcho ctpdc " +
                    " WHERE (pdc.maphieu = ctpdc.maphieu) " +
                    " AND (ctpdc.layve = 1) " +
                    " AND FUNC('MONTH', pdc.ngaydi) = "+ thang +
                    " AND FUNC('YEAR', pdc.ngaydi) = "+ nam +"";
            Query query = getEntityManager().createQuery(sql);
            return Integer.parseInt(query.getResultList().get(0).toString());
        }catch(Exception ex){
            return 0;
        }
    }
}
