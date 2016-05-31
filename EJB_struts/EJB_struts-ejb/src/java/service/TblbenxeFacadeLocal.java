/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblbenxe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TblbenxeFacadeLocal {

    void create(Tblbenxe tblbenxe);

    void edit(Tblbenxe tblbenxe);

    void remove(Tblbenxe tblbenxe);

    Tblbenxe find(Object id);

    List<Tblbenxe> findAll();

    List<Tblbenxe> findRange(int[] range);

    int count();
    
}
