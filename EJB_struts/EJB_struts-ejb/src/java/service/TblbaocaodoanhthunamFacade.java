/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblbaocaodoanhthunam;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tai
 */
@Stateless
public class TblbaocaodoanhthunamFacade extends AbstractFacade<Tblbaocaodoanhthunam> implements TblbaocaodoanhthunamFacadeLocal {

    @PersistenceContext(unitName = "EJB_struts-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblbaocaodoanhthunamFacade() {
        super(Tblbaocaodoanhthunam.class);
    }
    
}
