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
                        +" AND (pdc.hoten LIKE :hoten OR pdc.dienthoai LIKE :dienthoai) AND FUNC('MONTH', pdc.ngaydi) = FUNC('MONTH', :ngaydi) "
                        +" AND FUNC('DATE', pdc.ngaydi) = FUNC('DATE', :ngaydi) AND FUNC('YEAR', pdc.ngaydi) = FUNC('YEAR', :ngaydi)";
            
            Query query = getEntityManager().createQuery(sql);
            query.setParameter("machuyendi", machuyendi);
            query.setParameter("hoten", "%" + hoten);
            query.setParameter("ngaydi", ngaydi);
            query.setParameter("dienthoai", "%" + dienthoai + "%");
            
            return query.getResultList();
        }catch(Exception ex){
            return null;
        }
    }
    
    @Override
    public int getDoanhThu(int thang, int nam) {
        try{
            String sql = "SELECT SUM(tx.dongia) " +
                    " FROM Tblphieudatcho pdc, Tblchitietphieudatcho ctpdc, Tbltuyenxe tx, Tblxekhach xk, Tblchuyendi cd" +
                    " WHERE (pdc.maphieu = ctpdc.maphieu) AND tx.matuyen = xk.matuyen AND xk.maxe = cd.maxe" +
                    " AND (ctpdc.layve = 1) AND cd.machuyendi = ctpdc.machuyendi " +
                    " AND FUNC('MONTH', pdc.ngaydi) = :thang "+
                    " AND FUNC('YEAR', pdc.ngaydi) = :nam ";
            Query query = getEntityManager().createQuery(sql);
            query.setParameter("thang", thang);
            query.setParameter("nam", nam);
            return Integer.parseInt(query.getResultList().get(0).toString());
        }catch(Exception ex){
            return 0;
        }
    }
}
