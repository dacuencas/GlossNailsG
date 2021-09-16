/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Frederick Bosa S
 */
@Entity
@Table(name = "orden_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenPago.findAll", query = "SELECT o FROM OrdenPago o"),
    @NamedQuery(name = "OrdenPago.findByIdOrden", query = "SELECT o FROM OrdenPago o WHERE o.idOrden = :idOrden"),
    @NamedQuery(name = "OrdenPago.findByFechaOrden", query = "SELECT o FROM OrdenPago o WHERE o.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "OrdenPago.findByNit", query = "SELECT o FROM OrdenPago o WHERE o.nit = :nit"),
    @NamedQuery(name = "OrdenPago.findByValorTotal", query = "SELECT o FROM OrdenPago o WHERE o.valorTotal = :valorTotal"),
    @NamedQuery(name = "OrdenPago.findByProveedorNit", query = "SELECT o FROM OrdenPago o WHERE o.proveedorNit = :proveedorNit"),
    @NamedQuery(name = "OrdenPago.findByRazonSocial", query = "SELECT o FROM OrdenPago o WHERE o.razonSocial = :razonSocial")})
public class OrdenPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden")
    private Integer idOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_orden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nit")
    private int nit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private float valorTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proveedor_nit")
    private int proveedorNit;
    @Size(max = 45)
    @Column(name = "razon_social")
    private String razonSocial;
    @JoinColumn(name = "insumo_id_insumo", referencedColumnName = "id_insumo")
    @ManyToOne(optional = false)
    private Insumo insumoIdInsumo;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIdUsuario;

    public OrdenPago() {
    }

    public OrdenPago(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public OrdenPago(Integer idOrden, Date fechaOrden, int nit, float valorTotal, int proveedorNit) {
        this.idOrden = idOrden;
        this.fechaOrden = fechaOrden;
        this.nit = nit;
        this.valorTotal = valorTotal;
        this.proveedorNit = proveedorNit;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getProveedorNit() {
        return proveedorNit;
    }

    public void setProveedorNit(int proveedorNit) {
        this.proveedorNit = proveedorNit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Insumo getInsumoIdInsumo() {
        return insumoIdInsumo;
    }

    public void setInsumoIdInsumo(Insumo insumoIdInsumo) {
        this.insumoIdInsumo = insumoIdInsumo;
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
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenPago)) {
            return false;
        }
        OrdenPago other = (OrdenPago) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.OrdenPago[ idOrden=" + idOrden + " ]";
    }
    
}
