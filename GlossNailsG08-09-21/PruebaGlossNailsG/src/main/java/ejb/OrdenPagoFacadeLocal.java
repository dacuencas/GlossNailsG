/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.OrdenPago;

/**
 *
 * @author Frederick Bosa S
 */
@Local
public interface OrdenPagoFacadeLocal {

    void create(OrdenPago ordenPago);

    void edit(OrdenPago ordenPago);

    void remove(OrdenPago ordenPago);

    OrdenPago find(Object id);

    List<OrdenPago> findAll();

    List<OrdenPago> findRange(int[] range);

    int count();
    
}
