/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Frederick Bosa S
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido"),
    @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByDetalleDireccion", query = "SELECT u FROM Usuario u WHERE u.detalleDireccion = :detalleDireccion"),
    @NamedQuery(name = "Usuario.findByNumeroTelefono", query = "SELECT u FROM Usuario u WHERE u.numeroTelefono = :numeroTelefono"),
    @NamedQuery(name = "Usuario.findByNumeroDocumento", query = "SELECT u FROM Usuario u WHERE u.numeroDocumento = :numeroDocumento")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "detalle_direccion")
    private String detalleDireccion;
    @Size(max = 60)
    @Column(name = "numero_telefono")
    private String numeroTelefono;
    @Size(max = 100)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdUsuario")
    private List<OrdenCompra> ordenCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdUsuario")
    private List<OrdenPago> ordenPagoList;
    @JoinColumn(name = "rol_id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Rol rolIdRol;
    @JoinColumn(name = "tipo_direccion_id_direccion", referencedColumnName = "id_direccion")
    @ManyToOne(optional = false)
    private TipoDireccion tipoDireccionIdDireccion;
    @JoinColumn(name = "tipo_identificacion_id_identificaci\u00f3n", referencedColumnName = "id_identificaci\u00f3n")
    @ManyToOne(optional = false)
    private TipoIdentificacion tipoIdentificacionIdIdentificación;
    @JoinColumn(name = "tipo_telefono_id_telefono", referencedColumnName = "id_telefono")
    @ManyToOne(optional = false)
    private TipoTelefono tipoTelefonoIdTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdUsuario")
    private List<Cita> citaList;
    @Column(name = "estado")
    private Short usuEstado;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombre, String contrasena, String correo, String detalleDireccion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
        this.detalleDireccion = detalleDireccion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDetalleDireccion() {
        return detalleDireccion;
    }

    public void setDetalleDireccion(String detalleDireccion) {
        this.detalleDireccion = detalleDireccion;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @XmlTransient
    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
    }

    @XmlTransient
    public List<OrdenPago> getOrdenPagoList() {
        return ordenPagoList;
    }

    public void setOrdenPagoList(List<OrdenPago> ordenPagoList) {
        this.ordenPagoList = ordenPagoList;
    }

    public Rol getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(Rol rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    public TipoDireccion getTipoDireccionIdDireccion() {
        return tipoDireccionIdDireccion;
    }

    public void setTipoDireccionIdDireccion(TipoDireccion tipoDireccionIdDireccion) {
        this.tipoDireccionIdDireccion = tipoDireccionIdDireccion;
    }

    public TipoIdentificacion getTipoIdentificacionIdIdentificación() {
        return tipoIdentificacionIdIdentificación;
    }

    public void setTipoIdentificacionIdIdentificación(TipoIdentificacion tipoIdentificacionIdIdentificación) {
        this.tipoIdentificacionIdIdentificación = tipoIdentificacionIdIdentificación;
    }

    public TipoTelefono getTipoTelefonoIdTelefono() {
        return tipoTelefonoIdTelefono;
    }

    public void setTipoTelefonoIdTelefono(TipoTelefono tipoTelefonoIdTelefono) {
        this.tipoTelefonoIdTelefono = tipoTelefonoIdTelefono;
    }

    public Short getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Short usuEstado) {
        this.usuEstado = usuEstado;
    }
    
    

    @XmlTransient
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
