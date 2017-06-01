/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenptah.dao;

import co.com.origenptah.entidades.EstadoPersonas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface EstadoPersonasFacadeLocal {

    void create(EstadoPersonas estadoPersonas);

    void edit(EstadoPersonas estadoPersonas);

    void remove(EstadoPersonas estadoPersonas);

    EstadoPersonas find(Object id);

    List<EstadoPersonas> findAll();

    List<EstadoPersonas> findRange(int[] range);

    int count();
    
}
