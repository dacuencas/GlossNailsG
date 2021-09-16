/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.Insumo;

/**
 *
 * @author Frederick Bosa S
 */
@Local
public interface InsumoFacadeLocal {

    void create(Insumo insumo);

    void edit(Insumo insumo);

    void remove(Insumo insumo);

    Insumo find(Object id);

    List<Insumo> findAll();

    List<Insumo> findRange(int[] range);

    int count();
    
}
