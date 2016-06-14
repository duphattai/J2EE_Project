/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblbenxe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tai
 */
@Stateless(mappedName = "TblbenxeFacade")
public class TblbenxeFacade extends AbstractFacade<Tblbenxe> implements TblbenxeFacadeLocal {

    @PersistenceContext(unitName = "EJB_struts-ejbPU")
    private EntityManager em = Persistence.createEntityManagerFactory("EJB_struts-ejbPU").createEntityManager();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblbenxeFacade() {
        super(Tblbenxe.class);
    }
    
    public boolean checkBenXeExist(String tenben){
        try {
            Query query = getEntityManager().createNamedQuery("Tblbenxe.findByTenbenxe");
            query.setParameter("tenbenxe", tenben);

            return query.getResultList().size() == 0 ? false : true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
}
