/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenptah.dao;

import co.com.origenptah.entidades.Pedidos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author danie
 */
@Stateless
public class PedidosFacade extends AbstractFacade<Pedidos> implements PedidosFacadeLocal {

    @PersistenceContext(unitName = "OrigenPtahPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

//    @Override
//    public int countRef() {
//
//        int contador = 0;
//        String consulta;
//        try {
//            consulta="SELECT p FROM Pedidos";
//            Query q = em.createQuery(consulta);
//            contador = q.getFirstResult();
//            System.out.println(contador+1);
//        } catch (NumberFormatException e) {
//            throw e;
//        }
//        return contador;
//    }

    public PedidosFacade() {
        super(Pedidos.class);
    }

}
