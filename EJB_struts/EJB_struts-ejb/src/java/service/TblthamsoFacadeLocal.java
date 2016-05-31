/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tblthamso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tai
 */
@Local
public interface TblthamsoFacadeLocal {

    void create(Tblthamso tblthamso);

    void edit(Tblthamso tblthamso);

    void remove(Tblthamso tblthamso);

    Tblthamso find(Object id);

    List<Tblthamso> findAll();

    List<Tblthamso> findRange(int[] range);

    int count();
    
}
