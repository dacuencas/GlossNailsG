/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.EstadoCita;

/**
 *
 * @author Frederick Bosa S
 */
@Local
public interface EstadoCitaFacadeLocal {

    void create(EstadoCita estadoCita);

    void edit(EstadoCita estadoCita);

    void remove(EstadoCita estadoCita);

    EstadoCita find(Object id);

    List<EstadoCita> findAll();

    List<EstadoCita> findRange(int[] range);

    int count();
    
}
