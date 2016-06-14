/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tbltaikhoan;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tai
 */
@Stateless(mappedName = "TbltaikhoanFacade")
public class TbltaikhoanFacade extends AbstractFacade<Tbltaikhoan> implements TbltaikhoanFacadeLocal {

    @PersistenceContext(unitName = "EJB_struts-ejbPU")
    private EntityManager em = Persistence.createEntityManagerFactory("EJB_struts-ejbPU").createEntityManager();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbltaikhoanFacade() {
        super(Tbltaikhoan.class);
    }
    
    @Override
    public Tbltaikhoan checkExistUserAndPass(String user, String pass){
        try{
             
            String sql = "SELECT tk FROM Tbltaikhoan tk WHERE tk.tentaikhoan = :user AND tk.matkhau = :pass";
            Query query = getEntityManager().createQuery(sql);
            query.setParameter("user", user);
            query.setParameter("pass", pass);          
            return (Tbltaikhoan)query.getSingleResult();
        }catch(Exception ex){
            
            return null;
        }
    }
}
