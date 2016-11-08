/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chali
 */
@Entity
@Table(name = "apk_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApkInfo.findAll", query = "SELECT a FROM ApkInfo a"),
    @NamedQuery(name = "ApkInfo.findByIdApk", query = "SELECT a FROM ApkInfo a WHERE a.idApk = :idApk"),
    @NamedQuery(name = "ApkInfo.findByNombreApk", query = "SELECT a FROM ApkInfo a WHERE a.nombreApk = :nombreApk"),
    @NamedQuery(name = "ApkInfo.findByDescripcion", query = "SELECT a FROM ApkInfo a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "ApkInfo.findByFechaAdicion", query = "SELECT a FROM ApkInfo a WHERE a.fechaAdicion = :fechaAdicion"),
    @NamedQuery(name = "ApkInfo.findByAdicionadoPor", query = "SELECT a FROM ApkInfo a WHERE a.adicionadoPor = :adicionadoPor"),
    @NamedQuery(name = "ApkInfo.findByFechaModificacion", query = "SELECT a FROM ApkInfo a WHERE a.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "ApkInfo.findByModificadoPor", query = "SELECT a FROM ApkInfo a WHERE a.modificadoPor = :modificadoPor")})
public class ApkInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_APK")
    private String idApk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "NOMBRE_APK")
    private String nombreApk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApk")
    private Collection<GrupoDesarrolloHistorial> grupoDesarrolloHistorialCollection;
    @JoinColumn(name = "ID_CATEGORIA_APK", referencedColumnName = "ID_CATEGORIA_APK")
    @ManyToOne(optional = false)
    private CategoriaApk idCategoriaApk;

    public ApkInfo() {
    }

    public ApkInfo(String idApk) {
        this.idApk = idApk;
    }

    public ApkInfo(String idApk, String nombreApk, String descripcion, Date fechaAdicion, String adicionadoPor, Date fechaModificacion) {
        this.idApk = idApk;
        this.nombreApk = nombreApk;
        this.descripcion = descripcion;
        this.fechaAdicion = fechaAdicion;
        this.adicionadoPor = adicionadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public String getIdApk() {
        return idApk;
    }

    public void setIdApk(String idApk) {
        this.idApk = idApk;
    }

    public String getNombreApk() {
        return nombreApk;
    }

    public void setNombreApk(String nombreApk) {
        this.nombreApk = nombreApk;
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

    @XmlTransient
    public Collection<GrupoDesarrolloHistorial> getGrupoDesarrolloHistorialCollection() {
        return grupoDesarrolloHistorialCollection;
    }

    public void setGrupoDesarrolloHistorialCollection(Collection<GrupoDesarrolloHistorial> grupoDesarrolloHistorialCollection) {
        this.grupoDesarrolloHistorialCollection = grupoDesarrolloHistorialCollection;
    }

    public CategoriaApk getIdCategoriaApk() {
        return idCategoriaApk;
    }

    public void setIdCategoriaApk(CategoriaApk idCategoriaApk) {
        this.idCategoriaApk = idCategoriaApk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApk != null ? idApk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApkInfo)) {
            return false;
        }
        ApkInfo other = (ApkInfo) object;
        if ((this.idApk == null && other.idApk != null) || (this.idApk != null && !this.idApk.equals(other.idApk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service.ApkInfo[ idApk=" + idApk + " ]";
    }
    
}
