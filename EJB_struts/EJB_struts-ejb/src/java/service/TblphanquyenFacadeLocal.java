/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblphanquyen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TblphanquyenFacadeLocal {

    void create(Tblphanquyen tblphanquyen);

    void edit(Tblphanquyen tblphanquyen);

    void remove(Tblphanquyen tblphanquyen);

    Tblphanquyen find(Object id);

    List<Tblphanquyen> findAll();

    List<Tblphanquyen> findRange(int[] range);

    int count();
    
}
