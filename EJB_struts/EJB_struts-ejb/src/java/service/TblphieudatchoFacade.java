/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.*;
import java.util.Date;
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
    
    public List<Tblphieudatcho> traCuuPhieuDatCho(String hoten, Date ngaydi, String dienthoai, int machuyendi){
       try{

                      
            String sql = "SELECT DISTINCT pdc"
                        +" FROM Tblphieudatcho pdc, Tblchitietphieudatcho ctpdc"
                        +" WHERE pdc.maphieu = ctpdc.maphieu AND ctpdc.machuyendi = :machuyendi " 
                        +" AND (pdc.hoten LIKE :hoten OR pdc.dienthoai LIKE :dienthoai)";
            Query query = getEntityManager().createQuery(sql);
            query.setParameter("machuyendi", machuyendi);
            query.setParameter("hoten", "%" + hoten);
            query.setParameter("dienthoai", "%" + dienthoai + "%");
            
            return query.getResultList();
        }catch(Exception ex){
            return null;
        }
    }
}
