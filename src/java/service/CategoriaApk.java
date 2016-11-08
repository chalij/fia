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
@Table(name = "categoria_apk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaApk.findAll", query = "SELECT c FROM CategoriaApk c"),
    @NamedQuery(name = "CategoriaApk.findByIdCategoriaApk", query = "SELECT c FROM CategoriaApk c WHERE c.idCategoriaApk = :idCategoriaApk"),
    @NamedQuery(name = "CategoriaApk.findByNombreCategoria", query = "SELECT c FROM CategoriaApk c WHERE c.nombreCategoria = :nombreCategoria"),
    @NamedQuery(name = "CategoriaApk.findByDescripcion", query = "SELECT c FROM CategoriaApk c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CategoriaApk.findByFechaAdicion", query = "SELECT c FROM CategoriaApk c WHERE c.fechaAdicion = :fechaAdicion"),
    @NamedQuery(name = "CategoriaApk.findByAdicionadoPor", query = "SELECT c FROM CategoriaApk c WHERE c.adicionadoPor = :adicionadoPor"),
    @NamedQuery(name = "CategoriaApk.findByFechaModificacion", query = "SELECT c FROM CategoriaApk c WHERE c.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "CategoriaApk.findByModificadoPor", query = "SELECT c FROM CategoriaApk c WHERE c.modificadoPor = :modificadoPor")})
public class CategoriaApk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ID_CATEGORIA_APK")
    private String idCategoriaApk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_CATEGORIA")
    private String nombreCategoria;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaApk")
    private Collection<ApkInfo> apkInfoCollection;

    public CategoriaApk() {
    }

    public CategoriaApk(String idCategoriaApk) {
        this.idCategoriaApk = idCategoriaApk;
    }

    public CategoriaApk(String idCategoriaApk, String nombreCategoria, String descripcion, Date fechaAdicion, String adicionadoPor, Date fechaModificacion) {
        this.idCategoriaApk = idCategoriaApk;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
        this.fechaAdicion = fechaAdicion;
        this.adicionadoPor = adicionadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public String getIdCategoriaApk() {
        return idCategoriaApk;
    }

    public void setIdCategoriaApk(String idCategoriaApk) {
        this.idCategoriaApk = idCategoriaApk;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
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
    public Collection<ApkInfo> getApkInfoCollection() {
        return apkInfoCollection;
    }

    public void setApkInfoCollection(Collection<ApkInfo> apkInfoCollection) {
        this.apkInfoCollection = apkInfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaApk != null ? idCategoriaApk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaApk)) {
            return false;
        }
        CategoriaApk other = (CategoriaApk) object;
        if ((this.idCategoriaApk == null && other.idCategoriaApk != null) || (this.idCategoriaApk != null && !this.idCategoriaApk.equals(other.idCategoriaApk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service.CategoriaApk[ idCategoriaApk=" + idCategoriaApk + " ]";
    }
    
}
