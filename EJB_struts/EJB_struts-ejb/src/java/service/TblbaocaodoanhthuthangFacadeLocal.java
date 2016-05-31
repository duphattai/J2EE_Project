/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblbaocaodoanhthuthang;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TblbaocaodoanhthuthangFacadeLocal {

    void create(Tblbaocaodoanhthuthang tblbaocaodoanhthuthang);

    void edit(Tblbaocaodoanhthuthang tblbaocaodoanhthuthang);

    void remove(Tblbaocaodoanhthuthang tblbaocaodoanhthuthang);

    Tblbaocaodoanhthuthang find(Object id);

    List<Tblbaocaodoanhthuthang> findAll();

    List<Tblbaocaodoanhthuthang> findRange(int[] range);

    int count();
    
}
