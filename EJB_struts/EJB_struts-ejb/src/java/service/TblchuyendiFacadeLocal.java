/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblchuyendi;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TblchuyendiFacadeLocal {

    void create(Tblchuyendi tblchuyendi);

    void edit(Tblchuyendi tblchuyendi);

    void remove(Tblchuyendi tblchuyendi);

    Tblchuyendi find(Object id);

    List<Tblchuyendi> findAll();

    List<Tblchuyendi> findRange(int[] range);

    int count();
    
    List<Object[]> traCuuChuyenDi(int mabendi, int mabenden);
    List<Object[]> traCuuChuyenDi(List<Integer> matuyen);
    List<Tblchuyendi> getChuyenDiByMaXe(int maxekhach);
}
