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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Frederick Bosa S
 */
@Entity
@Table(name = "forma_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaPago.findAll", query = "SELECT f FROM FormaPago f"),
    @NamedQuery(name = "FormaPago.findByIdFormaPago", query = "SELECT f FROM FormaPago f WHERE f.idFormaPago = :idFormaPago"),
    @NamedQuery(name = "FormaPago.findByEfectivo", query = "SELECT f FROM FormaPago f WHERE f.efectivo = :efectivo"),
    @NamedQuery(name = "FormaPago.findByTransaccion", query = "SELECT f FROM FormaPago f WHERE f.transaccion = :transaccion")})
public class FormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_forma_pago")
    private Integer idFormaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "efectivo")
    private Float efectivo;
    @Size(max = 45)
    @Column(name = "transaccion")
    private String transaccion;
    @JoinColumn(name = "banco_id_banco", referencedColumnName = "id_banco")
    @ManyToOne(optional = false)
    private Banco bancoIdBanco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPagoIdFormaPago")
    private List<OrdenCompra> ordenCompraList;

    public FormaPago() {
    }

    public FormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public Float getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(Float efectivo) {
        this.efectivo = efectivo;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public Banco getBancoIdBanco() {
        return bancoIdBanco;
    }

    public void setBancoIdBanco(Banco bancoIdBanco) {
        this.bancoIdBanco = bancoIdBanco;
    }

    @XmlTransient
    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormaPago != null ? idFormaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if ((this.idFormaPago == null && other.idFormaPago != null) || (this.idFormaPago != null && !this.idFormaPago.equals(other.idFormaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.FormaPago[ idFormaPago=" + idFormaPago + " ]";
    }
    
}
