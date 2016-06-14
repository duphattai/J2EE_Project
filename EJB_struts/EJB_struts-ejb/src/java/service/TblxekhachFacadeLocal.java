/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblxekhach;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TblxekhachFacadeLocal {

    void create(Tblxekhach tblxekhach);

    void edit(Tblxekhach tblxekhach);

    void remove(Tblxekhach tblxekhach);

    Tblxekhach find(Object id);

    List<Tblxekhach> findAll();

    List<Tblxekhach> findRange(int[] range);

    int count();
    
    List<Object[]> getXeKhachByTuyenXeList(List<Integer> matuyen);
    
    Tblxekhach getXeKhachByTuyenXe(int matuyen);
}
