/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entity.Tblchuyendi;
import entity.Tbltuyenxe;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author Tai
 */
@Stateless(mappedName = "TblchuyendiFacade")
public class TblchuyendiFacade extends AbstractFacade<Tblchuyendi> implements TblchuyendiFacadeLocal {

    @PersistenceContext(unitName = "EJB_struts-ejbPU")
    private EntityManager em = Persistence.createEntityManagerFactory("EJB_struts-ejbPU").createEntityManager();


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblchuyendiFacade() {
        super(Tblchuyendi.class);
    }
    
    
    public List<Object[]> traCuuChuyenDi(int mabendi, int mabenden){
        try{
            Tbltuyenxe tx = (new TbltuyenxeFacade()).getTuyenXeForBenXeDiAndBenXeDen(mabendi, mabenden);
            
            String sql = "SELECT cd, bxdi, bxden, lx, tx"
                        +" FROM Tblxekhach xk, Tblchuyendi cd, Tblbenxe bxdi, Tblbenxe bxden, Tbltuyenxe tx, Tblloaixe lx"
                        +" WHERE xk.matuyen = :matuyen AND xk.maxe = cd.maxe AND tx.matuyen = xk.matuyen" 
                        +" AND bxdi.mabenxe = tx.mabendi AND bxden.mabenxe = tx.mabenden AND xk.maloaixe = lx.maloaixe";
            Query query = getEntityManager().createQuery(sql);
            query.setParameter("matuyen", tx.getMatuyen());
         
            return query.getResultList();
        }catch(Exception ex){
            return null;
        }
    }
    
    public List<Tblchuyendi> getChuyenDiByMaXe(int maxekhach){
        try{
            Query query = getEntityManager().createNamedQuery("Tblchuyendi.findByMaxe");
            query.setParameter("maxe", maxekhach);
         
            return query.getResultList();
        }catch(Exception ex){
            return null;
        }
    }
    
    public List<Object[]> traCuuChuyenDi(List<Integer> matuyen){
        try{
            String sql = "SELECT cd, bxdi, bxden, lx, xk, tx"
                        +" FROM Tblxekhach xk, Tblchuyendi cd, Tblbenxe bxdi, Tblbenxe bxden, Tbltuyenxe tx, Tblloaixe lx"
                        +" WHERE xk.matuyen IN :matuyens AND xk.maxe = cd.maxe AND tx.matuyen = xk.matuyen" 
                        +" AND bxdi.mabenxe = tx.mabendi AND bxden.mabenxe = tx.mabenden AND xk.maloaixe = lx.maloaixe";
            Query query = getEntityManager().createQuery(sql);
            query.setParameter("matuyens", matuyen);
            
            return query.getResultList();
        }catch(Exception ex){
            return null;
        }
    }
}
