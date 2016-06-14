/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblphieudatcho;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TblphieudatchoFacadeLocal {

    void create(Tblphieudatcho tblphieudatcho);

    void edit(Tblphieudatcho tblphieudatcho);

    void remove(Tblphieudatcho tblphieudatcho);

    Tblphieudatcho find(Object id);

    List<Tblphieudatcho> findAll();

    List<Tblphieudatcho> findRange(int[] range);

    int count();
    
    List<Tblphieudatcho> traCuuPhieuDatCho(String hoten, Date ngaydi, String dienthoai, int machuyendi);
}
