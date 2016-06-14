/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblchitietphieudatcho;
import entity.Tblxekhach;
import java.util.Date;
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
    public Boolean checkExistForMaChuyenDiAndViTriGhe(int machuyendi, String vitrighe, Date ngaydi){
        try{
            String sql = "SELECT ctpdc FROM Tblchitietphieudatcho ctpdc, Tblphieudatcho pdc"
                    +" WHERE ctpdc.maphieu = pdc.maphieu AND pdc.machuyendi = :machuyendi AND pdc.vitrighe = :vitrighe"
                    +" AND MONTH(pdc.ngaydat) = MONTH(:ngaydi) AND DAY(pdc.ngaydat) = DAY(:ngaydi)";
            Query query = getEntityManager().createQuery(sql);
            query.setParameter("machuyendi", machuyendi);
            query.setParameter("vitrighe", vitrighe);
            query.setParameter("ngaydi", ngaydi, TemporalType.TIMESTAMP);
            
            return query.getResultList().size() == 0 ? false : true;
        }catch(Exception ex){
            return false;
        }  
    }
    
    public List<Tblchitietphieudatcho> getCTPhieuDatChoForMaPhieu(int maphieu){
        try{
            Query query = getEntityManager().createNamedQuery("Tblchitietphieudatcho.findByMaphieu");
            query.setParameter("maphieu", maphieu);
         
            return query.getResultList();
        }catch(Exception ex){
            return null;
        }
    }
}
