/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author chali
 */
@Entity
@Table(name = "tipo_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t"),
    @NamedQuery(name = "TipoUsuario.findByIdTipoUsuario", query = "SELECT t FROM TipoUsuario t WHERE t.idTipoUsuario = :idTipoUsuario"),
    @NamedQuery(name = "TipoUsuario.findByTipoUsuario", query = "SELECT t FROM TipoUsuario t WHERE t.tipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "TipoUsuario.findByDescripcion", query = "SELECT t FROM TipoUsuario t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoUsuario.findByFechaAdicion", query = "SELECT t FROM TipoUsuario t WHERE t.fechaAdicion = :fechaAdicion"),
    @NamedQuery(name = "TipoUsuario.findByAdicionadoPor", query = "SELECT t FROM TipoUsuario t WHERE t.adicionadoPor = :adicionadoPor"),
    @NamedQuery(name = "TipoUsuario.findByFechaModificacion", query = "SELECT t FROM TipoUsuario t WHERE t.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "TipoUsuario.findByModificadoPor", query = "SELECT t FROM TipoUsuario t WHERE t.modificadoPor = :modificadoPor")})
public class TipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ID_TIPO_USUARIO")
    private String idTipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TIPO_USUARIO")
    private String tipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ADICIONADO_POR")
    private String adicionadoPor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Size(max = 100)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;

    public TipoUsuario() {
    }

    public TipoUsuario(String idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public TipoUsuario(String idTipoUsuario, String tipoUsuario, String descripcion, Date fechaAdicion, String adicionadoPor, Date fechaModificacion) {
        this.idTipoUsuario = idTipoUsuario;
        this.tipoUsuario = tipoUsuario;
        this.descripcion = descripcion;
        this.fechaAdicion = fechaAdicion;
        this.adicionadoPor = adicionadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public String getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(String idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(Date fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public String getAdicionadoPor() {
        return adicionadoPor;
    }

    public void setAdicionadoPor(String adicionadoPor) {
        this.adicionadoPor = adicionadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoUsuario != null ? idTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.idTipoUsuario == null && other.idTipoUsuario != null) || (this.idTipoUsuario != null && !this.idTipoUsuario.equals(other.idTipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service.TipoUsuario[ idTipoUsuario=" + idTipoUsuario + " ]";
    }
    
}
