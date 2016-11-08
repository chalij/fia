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
@Table(name = "grupo_desarrollo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoDesarrollo.findAll", query = "SELECT g FROM GrupoDesarrollo g"),
    @NamedQuery(name = "GrupoDesarrollo.findByIdGrupoDesa", query = "SELECT g FROM GrupoDesarrollo g WHERE g.idGrupoDesa = :idGrupoDesa"),
    @NamedQuery(name = "GrupoDesarrollo.findByNombreGrupo", query = "SELECT g FROM GrupoDesarrollo g WHERE g.nombreGrupo = :nombreGrupo"),
    @NamedQuery(name = "GrupoDesarrollo.findByDescripcion", query = "SELECT g FROM GrupoDesarrollo g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GrupoDesarrollo.findByFechaAdicion", query = "SELECT g FROM GrupoDesarrollo g WHERE g.fechaAdicion = :fechaAdicion"),
    @NamedQuery(name = "GrupoDesarrollo.findByAdicionadoPor", query = "SELECT g FROM GrupoDesarrollo g WHERE g.adicionadoPor = :adicionadoPor"),
    @NamedQuery(name = "GrupoDesarrollo.findByFechaModificacion", query = "SELECT g FROM GrupoDesarrollo g WHERE g.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "GrupoDesarrollo.findByModificadoPor", query = "SELECT g FROM GrupoDesarrollo g WHERE g.modificadoPor = :modificadoPor")})
public class GrupoDesarrollo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_GRUPO_DESA")
    private String idGrupoDesa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_GRUPO")
    private String nombreGrupo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupoDesa")
    private Collection<GrupoDesarrolloHistorial> grupoDesarrolloHistorialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoDesarrollo")
    private Collection<EquipoDesarrollo> equipoDesarrolloCollection;

    public GrupoDesarrollo() {
    }

    public GrupoDesarrollo(String idGrupoDesa) {
        this.idGrupoDesa = idGrupoDesa;
    }

    public GrupoDesarrollo(String idGrupoDesa, String nombreGrupo, String descripcion, Date fechaAdicion, String adicionadoPor, Date fechaModificacion) {
        this.idGrupoDesa = idGrupoDesa;
        this.nombreGrupo = nombreGrupo;
        this.descripcion = descripcion;
        this.fechaAdicion = fechaAdicion;
        this.adicionadoPor = adicionadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public String getIdGrupoDesa() {
        return idGrupoDesa;
    }

    public void setIdGrupoDesa(String idGrupoDesa) {
        this.idGrupoDesa = idGrupoDesa;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
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

    @XmlTransient
    public Collection<EquipoDesarrollo> getEquipoDesarrolloCollection() {
        return equipoDesarrolloCollection;
    }

    public void setEquipoDesarrolloCollection(Collection<EquipoDesarrollo> equipoDesarrolloCollection) {
        this.equipoDesarrolloCollection = equipoDesarrolloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupoDesa != null ? idGrupoDesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoDesarrollo)) {
            return false;
        }
        GrupoDesarrollo other = (GrupoDesarrollo) object;
        if ((this.idGrupoDesa == null && other.idGrupoDesa != null) || (this.idGrupoDesa != null && !this.idGrupoDesa.equals(other.idGrupoDesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service.GrupoDesarrollo[ idGrupoDesa=" + idGrupoDesa + " ]";
    }
    
}
