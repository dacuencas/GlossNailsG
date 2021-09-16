/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.EstadoCita;

/**
 *
 * @author Frederick Bosa S
 */
@Stateless
public class EstadoCitaFacade extends AbstractFacade<EstadoCita> implements EstadoCitaFacadeLocal {

    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoCitaFacade() {
        super(EstadoCita.class);
    }
    
}
