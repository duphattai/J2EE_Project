/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblxekhach;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tai
 */
@Stateless(mappedName = "TblxekhachFacade")
public class TblxekhachFacade extends AbstractFacade<Tblxekhach> implements TblxekhachFacadeLocal {

    @PersistenceContext(unitName = "EJB_struts-ejbPU")
    private EntityManager em = Persistence.createEntityManagerFactory("EJB_struts-ejbPU").createEntityManager();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblxekhachFacade() {
        super(Tblxekhach.class);
    }
    
}
