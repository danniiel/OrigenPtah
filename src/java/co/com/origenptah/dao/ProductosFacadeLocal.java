/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenptah.dao;

import co.com.origenptah.entidades.Productos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface ProductosFacadeLocal {

    void create(Productos productos);

    void edit(Productos productos);

    void remove(Productos productos);

    Productos find(Object id);

    List<Productos> findByRef(String ref);
    
    List<Productos> findAll();

    List<Productos> findRange(int[] range);

    int count();
    
}
