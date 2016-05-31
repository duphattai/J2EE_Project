/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblchitiettuyen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TblchitiettuyenFacadeLocal {

    void create(Tblchitiettuyen tblchitiettuyen);

    void edit(Tblchitiettuyen tblchitiettuyen);

    void remove(Tblchitiettuyen tblchitiettuyen);

    Tblchitiettuyen find(Object id);

    List<Tblchitiettuyen> findAll();

    List<Tblchitiettuyen> findRange(int[] range);

    int count();
    
}
