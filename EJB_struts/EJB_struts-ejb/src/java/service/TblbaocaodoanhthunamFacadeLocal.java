/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblbaocaodoanhthunam;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TblbaocaodoanhthunamFacadeLocal {

    void create(Tblbaocaodoanhthunam tblbaocaodoanhthunam);

    void edit(Tblbaocaodoanhthunam tblbaocaodoanhthunam);

    void remove(Tblbaocaodoanhthunam tblbaocaodoanhthunam);

    Tblbaocaodoanhthunam find(Object id);

    List<Tblbaocaodoanhthunam> findAll();

    List<Tblbaocaodoanhthunam> findRange(int[] range);

    int count();
    
}
