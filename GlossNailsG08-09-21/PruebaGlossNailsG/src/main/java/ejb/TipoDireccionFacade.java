/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.TipoDireccion;

/**
 *
 * @author Frederick Bosa S
 */
@Stateless
public class TipoDireccionFacade extends AbstractFacade<TipoDireccion> implements TipoDireccionFacadeLocal {

    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDireccionFacade() {
        super(TipoDireccion.class);
    }
    
}
