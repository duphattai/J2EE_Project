/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tbltaikhoan;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TbltaikhoanFacadeLocal {

    void create(Tbltaikhoan tbltaikhoan);

    void edit(Tbltaikhoan tbltaikhoan);

    void remove(Tbltaikhoan tbltaikhoan);

    Tbltaikhoan find(Object id);

    List<Tbltaikhoan> findAll();

    List<Tbltaikhoan> findRange(int[] range);

    int count();
    
    Tbltaikhoan checkExistUserAndPass(String user, String pass);
}
