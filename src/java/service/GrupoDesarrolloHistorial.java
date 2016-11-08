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
 * @author chali
 */
@Entity
@Table(name = "grupo_desarrollo_historial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoDesarrolloHistorial.findAll", query = "SELECT g FROM GrupoDesarrolloHistorial g"),
    @NamedQuery(name = "GrupoDesarrolloHistorial.findByIdHistorial", query = "SELECT g FROM GrupoDesarrolloHistorial g WHERE g.idHistorial = :idHistorial"),
    @NamedQuery(name = "GrupoDesarrolloHistorial.findByComentario", query = "SELECT g FROM GrupoDesarrolloHistorial g WHERE g.comentario = :comentario"),
    @NamedQuery(name = "GrupoDesarrolloHistorial.findByFechaAdicion", query = "SELECT g FROM GrupoDesarrolloHistorial g WHERE g.fechaAdicion = :fechaAdicion"),
    @NamedQuery(name = "GrupoDesarrolloHistorial.findByAdicionadoPor", query = "SELECT g FROM GrupoDesarrolloHistorial g WHERE g.adicionadoPor = :adicionadoPor"),
    @NamedQuery(name = "GrupoDesarrolloHistorial.findByFechaModificacion", query = "SELECT g FROM GrupoDesarrolloHistorial g WHERE g.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "GrupoDesarrolloHistorial.findByModificadoPor", query = "SELECT g FROM GrupoDesarrolloHistorial g WHERE g.modificadoPor = :modificadoPor")})
public class GrupoDesarrolloHistorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ID_HISTORIAL")
    private String idHistorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "COMENTARIO")
    private String comentario;
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
    @JoinColumn(name = "ID_APK", referencedColumnName = "ID_APK")
    @ManyToOne(optional = false)
    private ApkInfo idApk;
    @JoinColumn(name = "ID_GRUPO_DESA", referencedColumnName = "ID_GRUPO_DESA")
    @ManyToOne(optional = false)
    private GrupoDesarrollo idGrupoDesa;

    public GrupoDesarrolloHistorial() {
    }

    public GrupoDesarrolloHistorial(String idHistorial) {
        this.idHistorial = idHistorial;
    }

    public GrupoDesarrolloHistorial(String idHistorial, String comentario, Date fechaAdicion, String adicionadoPor, Date fechaModificacion) {
        this.idHistorial = idHistorial;
        this.comentario = comentario;
        this.fechaAdicion = fechaAdicion;
        this.adicionadoPor = adicionadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public String getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(String idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public ApkInfo getIdApk() {
        return idApk;
    }

    public void setIdApk(ApkInfo idApk) {
        this.idApk = idApk;
    }

    public GrupoDesarrollo getIdGrupoDesa() {
        return idGrupoDesa;
    }

    public void setIdGrupoDesa(GrupoDesarrollo idGrupoDesa) {
        this.idGrupoDesa = idGrupoDesa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorial != null ? idHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoDesarrolloHistorial)) {
            return false;
        }
        GrupoDesarrolloHistorial other = (GrupoDesarrolloHistorial) object;
        if ((this.idHistorial == null && other.idHistorial != null) || (this.idHistorial != null && !this.idHistorial.equals(other.idHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service.GrupoDesarrolloHistorial[ idHistorial=" + idHistorial + " ]";
    }
    
}
