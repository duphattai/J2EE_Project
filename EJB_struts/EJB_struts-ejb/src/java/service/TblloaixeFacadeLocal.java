/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblloaixe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TblloaixeFacadeLocal {

    void create(Tblloaixe tblloaixe);

    void edit(Tblloaixe tblloaixe);

    void remove(Tblloaixe tblloaixe);

    Tblloaixe find(Object id);

    List<Tblloaixe> findAll();

    List<Tblloaixe> findRange(int[] range);

    int count();
    
}
