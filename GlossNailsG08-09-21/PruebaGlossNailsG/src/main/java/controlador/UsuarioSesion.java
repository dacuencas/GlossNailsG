/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejb.RolFacadeLocal;
import ejb.TipoDireccionFacadeLocal;
import ejb.TipoIdentificacionFacadeLocal;
import ejb.TipoTelefonoFacadeLocal;
import ejb.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Rol;
import modelo.TipoDireccion;
import modelo.TipoIdentificacion;
import modelo.TipoTelefono;
import modelo.Usuario;
import org.primefaces.PrimeFaces;

@Named(value = "usuarioSesion")
/**
 *
 * @author Frederick Bosa S
 */
@SessionScoped
public class UsuarioSesion implements Serializable {

    //Conexion con facades local
    //Punto de conexion a bd
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;

    //Estructuras para llaves foraneas Usuario
    @EJB
    private TipoDireccionFacadeLocal tipoDireccionFacadeLocal;
    @EJB
    private TipoTelefonoFacadeLocal tipoTelefonoFacadeLocal;
    @EJB
    private TipoIdentificacionFacadeLocal tipoIdentificacionFacadeLocal;
    @EJB
    private RolFacadeLocal rolFacadeLocal;

    //Creacion de instancia clase mapeada
    private Usuario usuario;

    //Estructura para llaves foraneas Usuario (Funcionalidades)
    @Inject
    private TipoDireccion tipoDireccion;
    @Inject
    private TipoTelefono tipoTelefono;
    @Inject
    private TipoIdentificacion tipoIdentificacion;
    @Inject
    private Rol rol;

    //Lista Local (Nombres Listas en prural)
    private List<Usuario> usuarios;
    //Estructura Para llaves foraneas
    private List<TipoDireccion> tipodirecciones;
    private List<TipoTelefono> tipotelefonos;
    private List<TipoIdentificacion> tipoidentificaciones;
    private List<Rol> roles;

    //Instancias de Sesion
    private Usuario usuReg = new Usuario();
    private Usuario usuLog = new Usuario();
    private Usuario usuTemporal = new Usuario();
    private String correoIn;
    private String claveIn;

    //Estructura para encontrar elementos al iniciar la app (Listar datos en la vista)
    @PostConstruct
    public void init() {
        //Usar para estructura local 
        usuarios = usuarioFacadeLocal.findAll();
        //Estrucutura para llaves foraneas
        tipodirecciones = tipoDireccionFacadeLocal.findAll();
        tipotelefonos = tipoTelefonoFacadeLocal.findAll();
        tipoidentificaciones = tipoIdentificacionFacadeLocal.findAll();
        roles = rolFacadeLocal.findAll();
        //Limpiar Formulario
        usuario = new Usuario();
      
    }

    public void validarUsuario() {
        try {
            usuLog = usuarioFacadeLocal.validarUsuario(correoIn, claveIn);
            if (usuLog != null) {
                if (usuLog.getUsuEstado() == Short.parseShort("1")) {
                    FacesContext fc = FacesContext.getCurrentInstance();
                    fc.getExternalContext().redirect("index.xhtml");
                } else {
                    PrimeFaces.current().executeScript("Swal.fire({"
                            + "  title: 'Usuario !',"
                            + "  text: 'Inactivo ....',"
                            + "  icon: 'info',"
                            + "  confirmButtonText: 'Comuniquese con el administrador !!!!'"
                            + "})");
                }
            } else {
                PrimeFaces.current().executeScript("Swal.fire({"
                        + "  title: 'Usuario !',"
                        + "  text: 'No encontrado ....',"
                        + "  icon: 'error',"
                        + "  confirmButtonText: 'valide sus datos !!!!'"
                        + "})");
            }
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire({"
                    + "  title: 'Problemas !',"
                    + "  text: 'No se puede realizar esta accion',"
                    + "  icon: 'error',"
                    + "  confirmButtonText: 'Ok'"
                    + "})");
        }
    }
    
    //registrat usuario 
    public void registrarUsuario() {
        try {
            //Estructura para llaves foraneas
            this.usuReg.setTipoDireccionIdDireccion(tipoDireccion);
            this.usuReg.setTipoIdentificacionIdIdentificación(tipoIdentificacion);
            this.usuReg.setTipoTelefonoIdTelefono(tipoTelefono);
            this.usuReg.setRolIdRol(rol);
            //Creacion de usuario
            usuarioFacadeLocal.create(usuReg);
            //Limpiar Formulario de registro
            usuReg = new Usuario() ;
            //Render Usuarios
            usuarios = usuarioFacadeLocal.findAll();
        } catch (Exception e) {
            System.out.println("Error de registro");
        }
    }

    //Recuperar datos temporales para editar usuario
    public void guardarTemporal(Usuario u) {
        usuTemporal = u;
    }

    //Editar Usuario
    public void editarUsuario() {
        try {
            //Usutemporal sirve para el ciclo de vida de sólo la edición
            this.usuTemporal.setTipoDireccionIdDireccion(tipoDireccion);
            this.usuTemporal.setTipoIdentificacionIdIdentificación(tipoIdentificacion);
            this.usuTemporal.setTipoTelefonoIdTelefono(tipoTelefono);
            this.usuTemporal.setRolIdRol(rol);
            //Edicion de Usuario 
            usuarioFacadeLocal.edit(usuTemporal);
            //Fin del ciclo de vida
           
            //Encontrar datos
            usuarios = usuarioFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    //Eliminar Usuario
    public void eliminarUsuario(Usuario u) {
        try {
            this.usuarioFacadeLocal.remove(u);
            usuarios = usuarioFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoDireccion getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(TipoDireccion tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }

    public TipoTelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(TipoTelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<TipoDireccion> getTipodirecciones() {
        return tipodirecciones;
    }

    public void setTipodirecciones(List<TipoDireccion> tipodirecciones) {
        this.tipodirecciones = tipodirecciones;
    }

    public List<TipoTelefono> getTipotelefonos() {
        return tipotelefonos;
    }

    public void setTipotelefonos(List<TipoTelefono> tipotelefono) {
        this.tipotelefonos = tipotelefono;
    }

    public List<TipoIdentificacion> getTipoidentificaciones() {
        return tipoidentificaciones;
    }

    public void setTipoidentificaciones(List<TipoIdentificacion> tipoidentificaciones) {
        this.tipoidentificaciones = tipoidentificaciones;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Usuario getUsuReg() {
        return usuReg;
    }

    public void setUsuReg(Usuario usuReg) {
        this.usuReg = usuReg;
    }

    public Usuario getUsuLog() {
        return usuLog;
    }

    public void setUsuLog(Usuario usuLog) {
        this.usuLog = usuLog;
    }

    public Usuario getUsuTemporal() {
        return usuTemporal;
    }

    public void setUsuTemporal(Usuario usuTemporal) {
        this.usuTemporal = usuTemporal;
    }

    public String getCorreoIn() {
        return correoIn;
    }

    public void setCorreoIn(String correoIn) {
        this.correoIn = correoIn;
    }

    public String getClaveIn() {
        return claveIn;
    }

    public void setClaveIn(String claveIn) {
        this.claveIn = claveIn;
    }
    
    

}
