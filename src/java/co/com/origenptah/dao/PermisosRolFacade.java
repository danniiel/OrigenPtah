/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenptah.dao;

import co.com.origenptah.entidades.PermisosRol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author danie
 */
@Stateless
public class PermisosRolFacade extends AbstractFacade<PermisosRol> implements PermisosRolFacadeLocal {

    @PersistenceContext(unitName = "OrigenPtahPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermisosRolFacade() {
        super(PermisosRol.class);
    }
    
}
