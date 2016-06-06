/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblbenxe;
import entity.Tbltuyenxe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tai
 */
@Stateless(mappedName = "TbltuyenxeFacade")
public class TbltuyenxeFacade extends AbstractFacade<Tbltuyenxe> implements TbltuyenxeFacadeLocal {

    @PersistenceContext(unitName = "EJB_struts-ejbPU")
    private EntityManager em = Persistence.createEntityManagerFactory("EJB_struts-ejbPU").createEntityManager();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbltuyenxeFacade() {
        super(Tbltuyenxe.class);
    }
    
    public List<Tblbenxe> getAllBenXeDi(){
        try{
            String sql = "SELECT DISTINCT bx FROM Tblbenxe bx, Tbltuyenxe tx WHERE bx.mabenxe = tx.mabendi";
            Query query = getEntityManager().createQuery(sql);
            return query.getResultList();
        }catch(Exception ex){
            return null;
        }
    }
    public List<Tblbenxe> getAllBenXeDen(){
        try{
            String sql = "SELECT DISTINCT bx FROM Tblbenxe bx, Tbltuyenxe tx WHERE bx.mabenxe = tx.mabenden";
            Query query = getEntityManager().createQuery(sql);
            return query.getResultList();
        }catch(Exception ex){
            return null;
        }
    }
    
    public Tbltuyenxe getTuyenXeForBenXeDiAndBenXeDen(int mabendi, int mabenden){
        try{
            String sql = "SELECT tx FROM Tbltuyenxe tx WHERE tx.mabendi = :mabendi AND tx.mabenden = :mabenden";
            Query query = getEntityManager().createQuery(sql);
            query.setParameter("mabendi", mabendi);
            query.setParameter("mabenden", mabenden);
            return (Tbltuyenxe)query.getSingleResult();
        }catch(Exception ex){
            return null;
        }
    }
}
