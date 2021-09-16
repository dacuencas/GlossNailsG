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
@Table(name = "insumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumo.findAll", query = "SELECT i FROM Insumo i"),
    @NamedQuery(name = "Insumo.findByIdInsumo", query = "SELECT i FROM Insumo i WHERE i.idInsumo = :idInsumo"),
    @NamedQuery(name = "Insumo.findByNombre", query = "SELECT i FROM Insumo i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Insumo.findByMarca", query = "SELECT i FROM Insumo i WHERE i.marca = :marca"),
    @NamedQuery(name = "Insumo.findByCantidad", query = "SELECT i FROM Insumo i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Insumo.findByTotalInsumo", query = "SELECT i FROM Insumo i WHERE i.totalInsumo = :totalInsumo")})
public class Insumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_insumo")
    private Integer idInsumo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_insumo")
    private double totalInsumo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumoIdInsumo")
    private List<OrdenPago> ordenPagoList;

    public Insumo() {
    }

    public Insumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Insumo(Integer idInsumo, String nombre, String marca, double cantidad, double totalInsumo) {
        this.idInsumo = idInsumo;
        this.nombre = nombre;
        this.marca = marca;
        this.cantidad = cantidad;
        this.totalInsumo = totalInsumo;
    }

    public Integer getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalInsumo() {
        return totalInsumo;
    }

    public void setTotalInsumo(double totalInsumo) {
        this.totalInsumo = totalInsumo;
    }

    @XmlTransient
    public List<OrdenPago> getOrdenPagoList() {
        return ordenPagoList;
    }

    public void setOrdenPagoList(List<OrdenPago> ordenPagoList) {
        this.ordenPagoList = ordenPagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInsumo != null ? idInsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumo)) {
            return false;
        }
        Insumo other = (Insumo) object;
        if ((this.idInsumo == null && other.idInsumo != null) || (this.idInsumo != null && !this.idInsumo.equals(other.idInsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Insumo[ idInsumo=" + idInsumo + " ]";
    }
    
}
