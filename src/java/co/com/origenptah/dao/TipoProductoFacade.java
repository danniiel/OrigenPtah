/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenptah.dao;

import co.com.origenptah.entidades.TipoProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author danie
 */
@Stateless
public class TipoProductoFacade extends AbstractFacade<TipoProducto> implements TipoProductoFacadeLocal {

    @PersistenceContext(unitName = "OrigenPtahPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProductoFacade() {
        super(TipoProducto.class);
    }
    
}
