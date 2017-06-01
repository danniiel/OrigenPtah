/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenptah.dao;

import co.com.origenptah.entidades.Productos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author danie
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> implements ProductosFacadeLocal {

    @PersistenceContext(unitName = "OrigenPtahPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Productos> findByRef(String ref) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Productos.findByRef").setParameter("referenciaProducto", "%"+ref+"%");
        return q.getResultList();
    }
    
    public ProductosFacade() {
        super(Productos.class);
    }
    
}
