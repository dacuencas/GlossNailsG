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
@Table(name = "tipo_identificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIdentificacion.findAll", query = "SELECT t FROM TipoIdentificacion t"),
    @NamedQuery(name = "TipoIdentificacion.findByIdIdentificaci\u00f3n", query = "SELECT t FROM TipoIdentificacion t WHERE t.idIdentificaci\u00f3n = :idIdentificaci\u00f3n"),
    @NamedQuery(name = "TipoIdentificacion.findByTipoIdentificacion", query = "SELECT t FROM TipoIdentificacion t WHERE t.tipoIdentificacion = :tipoIdentificacion")})
public class TipoIdentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_identificaci\u00f3n")
    private Integer idIdentificación;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoIdentificacionIdIdentificaci\u00f3n")
    private List<Usuario> usuarioList;

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(Integer idIdentificación) {
        this.idIdentificación = idIdentificación;
    }

    public TipoIdentificacion(Integer idIdentificación, String tipoIdentificacion) {
        this.idIdentificación = idIdentificación;
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Integer getIdIdentificación() {
        return idIdentificación;
    }

    public void setIdIdentificación(Integer idIdentificación) {
        this.idIdentificación = idIdentificación;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIdentificación != null ? idIdentificación.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIdentificacion)) {
            return false;
        }
        TipoIdentificacion other = (TipoIdentificacion) object;
        if ((this.idIdentificación == null && other.idIdentificación != null) || (this.idIdentificación != null && !this.idIdentificación.equals(other.idIdentificación))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipoIdentificacion;
    }
    
}
