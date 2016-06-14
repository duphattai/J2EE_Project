/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblxekhach;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tai
 */
@Stateless(mappedName = "TblxekhachFacade")
public class TblxekhachFacade extends AbstractFacade<Tblxekhach> implements TblxekhachFacadeLocal {

    @PersistenceContext(unitName = "EJB_struts-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblxekhachFacade() {
        super(Tblxekhach.class);
    }
    public List<Object[]> getXeKhachByTuyenXeList(List<Integer> matuyen){
        try{
            String sql = "SELECT bxdi, bxden, lx, xk, tx"
                        +" FROM Tblxekhach xk, Tblbenxe bxdi, Tblbenxe bxden, Tbltuyenxe tx, Tblloaixe lx"
                        +" WHERE xk.matuyen IN :matuyens AND tx.matuyen = xk.matuyen" 
                        +" AND bxdi.mabenxe = tx.mabendi AND bxden.mabenxe = tx.mabenden AND xk.maloaixe = lx.maloaixe";
            Query query = getEntityManager().createQuery(sql);
            query.setParameter("matuyens", matuyen);
            
            return query.getResultList();
        }catch(Exception ex){
            return null;
        }
    }
    
    public Tblxekhach getXeKhachByTuyenXe(int matuyen){
        try{
            Query query = getEntityManager().createNamedQuery("Tblxekhach.findByMatuyen");
            query.setParameter("matuyen", matuyen);
         
            return (Tblxekhach)query.getSingleResult();
        }catch(Exception ex){
            return null;
        }
    }
}
