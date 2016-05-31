/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tbltuyenxe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TbltuyenxeFacadeLocal {

    void create(Tbltuyenxe tbltuyenxe);

    void edit(Tbltuyenxe tbltuyenxe);

    void remove(Tbltuyenxe tbltuyenxe);

    Tbltuyenxe find(Object id);

    List<Tbltuyenxe> findAll();

    List<Tbltuyenxe> findRange(int[] range);

    int count();
    
}
