/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblchitietphieudatcho;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author Tai
 */
@Stateless(mappedName = "TblchitietphieudatchoFacade")
public class TblchitietphieudatchoFacade extends AbstractFacade<Tblchitietphieudatcho> implements TblchitietphieudatchoFacadeLocal {

    @PersistenceContext(unitName = "EJB_struts-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblchitietphieudatchoFacade() {
        super(Tblchitietphieudatcho.class);
    }
    
    public List<Tblchitietphieudatcho> getCTPhieuDatChoForMaChuyenDi(int machuyendi){
        try{
            String sql = "SELECT pdc "
                    +" FROM Tblchitietphieudatcho pdc"
                    +" WHERE pdc.machuyendi = :machuyendi";
            Query query = getEntityManager().createQuery(sql);
            query.setParameter("machuyendi", machuyendi);
         
            return query.getResultList();
        }catch(Exception ex){
            return null;
        }  
    }
}
