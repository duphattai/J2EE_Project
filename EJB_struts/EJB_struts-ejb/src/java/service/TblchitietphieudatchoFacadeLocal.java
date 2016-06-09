/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblchitietphieudatcho;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TblchitietphieudatchoFacadeLocal {

    void create(Tblchitietphieudatcho tblchitietphieudatcho);

    void edit(Tblchitietphieudatcho tblchitietphieudatcho);

    void remove(Tblchitietphieudatcho tblchitietphieudatcho);

    Tblchitietphieudatcho find(Object id);

    List<Tblchitietphieudatcho> findAll();

    List<Tblchitietphieudatcho> findRange(int[] range);

    int count();
    
    List<Tblchitietphieudatcho> getCTPhieuDatChoForMaChuyenDi(int machuyendi);
}
