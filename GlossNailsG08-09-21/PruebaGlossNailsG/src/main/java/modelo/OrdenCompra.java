/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Frederick Bosa S
 */
@Entity
@Table(name = "orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompra.findAll", query = "SELECT o FROM OrdenCompra o"),
    @NamedQuery(name = "OrdenCompra.findByIdLiquidacion", query = "SELECT o FROM OrdenCompra o WHERE o.idLiquidacion = :idLiquidacion"),
    @NamedQuery(name = "OrdenCompra.findByEmpresa", query = "SELECT o FROM OrdenCompra o WHERE o.empresa = :empresa"),
    @NamedQuery(name = "OrdenCompra.findByNombreAsesor", query = "SELECT o FROM OrdenCompra o WHERE o.nombreAsesor = :nombreAsesor"),
    @NamedQuery(name = "OrdenCompra.findByCostoUnitario", query = "SELECT o FROM OrdenCompra o WHERE o.costoUnitario = :costoUnitario"),
    @NamedQuery(name = "OrdenCompra.findByDescripcionInsumo", query = "SELECT o FROM OrdenCompra o WHERE o.descripcionInsumo = :descripcionInsumo"),
    @NamedQuery(name = "OrdenCompra.findByCostoTotal", query = "SELECT o FROM OrdenCompra o WHERE o.costoTotal = :costoTotal")})
public class OrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_liquidacion")
    private Integer idLiquidacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "empresa")
    private String empresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_asesor")
    private String nombreAsesor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_unitario")
    private double costoUnitario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion_insumo")
    private String descripcionInsumo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_total")
    private double costoTotal;
    @JoinColumn(name = "forma_pago_id_forma_pago", referencedColumnName = "id_forma_pago")
    @ManyToOne(optional = false)
    private FormaPago formaPagoIdFormaPago;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdUsuario;

    public OrdenCompra() {
    }

    public OrdenCompra(Integer idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }

    public OrdenCompra(Integer idLiquidacion, String empresa, String nombreAsesor, double costoUnitario, String descripcionInsumo, double costoTotal) {
        this.idLiquidacion = idLiquidacion;
        this.empresa = empresa;
        this.nombreAsesor = nombreAsesor;
        this.costoUnitario = costoUnitario;
        this.descripcionInsumo = descripcionInsumo;
        this.costoTotal = costoTotal;
    }

    public Integer getIdLiquidacion() {
        return idLiquidacion;
    }

    public void setIdLiquidacion(Integer idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNombreAsesor() {
        return nombreAsesor;
    }

    public void setNombreAsesor(String nombreAsesor) {
        this.nombreAsesor = nombreAsesor;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public String getDescripcionInsumo() {
        return descripcionInsumo;
    }

    public void setDescripcionInsumo(String descripcionInsumo) {
        this.descripcionInsumo = descripcionInsumo;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public FormaPago getFormaPagoIdFormaPago() {
        return formaPagoIdFormaPago;
    }

    public void setFormaPagoIdFormaPago(FormaPago formaPagoIdFormaPago) {
        this.formaPagoIdFormaPago = formaPagoIdFormaPago;
    }

    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLiquidacion != null ? idLiquidacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompra)) {
            return false;
        }
        OrdenCompra other = (OrdenCompra) object;
        if ((this.idLiquidacion == null && other.idLiquidacion != null) || (this.idLiquidacion != null && !this.idLiquidacion.equals(other.idLiquidacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.OrdenCompra[ idLiquidacion=" + idLiquidacion + " ]";
    }
    
}
