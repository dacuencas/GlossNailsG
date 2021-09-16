/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoDireccion;

/**
 *
 * @author Frederick Bosa S
 */
@Local
public interface TipoDireccionFacadeLocal {

    void create(TipoDireccion tipoDireccion);

    void edit(TipoDireccion tipoDireccion);

    void remove(TipoDireccion tipoDireccion);

    TipoDireccion find(Object id);

    List<TipoDireccion> findAll();

    List<TipoDireccion> findRange(int[] range);

    int count();
    
}
