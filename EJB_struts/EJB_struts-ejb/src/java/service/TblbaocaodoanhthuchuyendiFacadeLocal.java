/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblbaocaodoanhthuchuyendi;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TblbaocaodoanhthuchuyendiFacadeLocal {

    void create(Tblbaocaodoanhthuchuyendi tblbaocaodoanhthuchuyendi);

    void edit(Tblbaocaodoanhthuchuyendi tblbaocaodoanhthuchuyendi);

    void remove(Tblbaocaodoanhthuchuyendi tblbaocaodoanhthuchuyendi);

    Tblbaocaodoanhthuchuyendi find(Object id);

    List<Tblbaocaodoanhthuchuyendi> findAll();

    List<Tblbaocaodoanhthuchuyendi> findRange(int[] range);

    int count();
    
}
