/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.InsumoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.Insumo;
@Named(value = "inventarioBeanss")
/**
 *
 * @author Frederick Bosa S
 */
@SessionScoped
public class InventarioBeanss implements Serializable{
   
    @EJB
    private InsumoFacadeLocal insumoFacadeLocal;
    
    private Insumo insumo;
    
    private List<Insumo> insumos;
    
    private Insumo insumReg = new Insumo();
    private Insumo insumTemp = new Insumo();
    
    @PostConstruct
    public void init() {
        //Usar para estructura local 
        insumos = insumoFacadeLocal.findAll();
        
        //Limpiar Formulario
        insumo = new Insumo();
      
    }
    
     public void registrarInsumo() {
        try {
            //Creacion de usuario
            insumoFacadeLocal.create(insumReg);
            //Limpiar Formulario de registro
            insumReg = new Insumo() ;
            //Render Usuarios
            insumos = insumoFacadeLocal.findAll();
        } catch (Exception e) {
            System.out.println("Error de registro");
        }
    }
    public void guardarTemporal(Insumo i) {
        insumTemp = i;
    }
    
     public void editarInsumo() {
        try {
            //Usutemporal sirve para el ciclo de vida de sólo la edición
            //Edicion de Usuario 
            insumoFacadeLocal.edit(insumTemp);
            //Fin del ciclo de vida
           
            //Encontrar datos
            insumos = insumoFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    //Eliminar Usuario
    public void eliminarUsuario(Insumo i) {
        try {
            this.insumoFacadeLocal.remove(i);
            insumos = insumoFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    public InsumoFacadeLocal getInsumoFacadeLocal() {
        return insumoFacadeLocal;
    }

    public void setInsumoFacadeLocal(InsumoFacadeLocal insumoFacadeLocal) {
        this.insumoFacadeLocal = insumoFacadeLocal;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }

    public Insumo getInsumReg() {
        return insumReg;
    }

    public void setInsumReg(Insumo insumReg) {
        this.insumReg = insumReg;
    }

    public Insumo getInsumTemp() {
        return insumTemp;
    }

    public void setInsumTemp(Insumo insumTemp) {
        this.insumTemp = insumTemp;
    }
    
    
}
