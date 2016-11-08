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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "equipo_desarrollo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoDesarrollo.findAll", query = "SELECT e FROM EquipoDesarrollo e"),
    @NamedQuery(name = "EquipoDesarrollo.findByIdEquipo", query = "SELECT e FROM EquipoDesarrollo e WHERE e.equipoDesarrolloPK.idEquipo = :idEquipo"),
    @NamedQuery(name = "EquipoDesarrollo.findByIdGrupoDesa", query = "SELECT e FROM EquipoDesarrollo e WHERE e.equipoDesarrolloPK.idGrupoDesa = :idGrupoDesa"),
    @NamedQuery(name = "EquipoDesarrollo.findByUserCarnet", query = "SELECT e FROM EquipoDesarrollo e WHERE e.equipoDesarrolloPK.userCarnet = :userCarnet"),
    @NamedQuery(name = "EquipoDesarrollo.findByPosicion", query = "SELECT e FROM EquipoDesarrollo e WHERE e.posicion = :posicion"),
    @NamedQuery(name = "EquipoDesarrollo.findByFechaAdicion", query = "SELECT e FROM EquipoDesarrollo e WHERE e.fechaAdicion = :fechaAdicion"),
    @NamedQuery(name = "EquipoDesarrollo.findByAdicionadoPor", query = "SELECT e FROM EquipoDesarrollo e WHERE e.adicionadoPor = :adicionadoPor"),
    @NamedQuery(name = "EquipoDesarrollo.findByFechaModificacion", query = "SELECT e FROM EquipoDesarrollo e WHERE e.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "EquipoDesarrollo.findByModificadoPor", query = "SELECT e FROM EquipoDesarrollo e WHERE e.modificadoPor = :modificadoPor")})
public class EquipoDesarrollo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipoDesarrolloPK equipoDesarrolloPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "POSICION")
    private String posicion;
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
    @JoinColumn(name = "USER_CARNET", referencedColumnName = "CARNET", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "ID_GRUPO_DESA", referencedColumnName = "ID_GRUPO_DESA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GrupoDesarrollo grupoDesarrollo;

    public EquipoDesarrollo() {
    }

    public EquipoDesarrollo(EquipoDesarrolloPK equipoDesarrolloPK) {
        this.equipoDesarrolloPK = equipoDesarrolloPK;
    }

    public EquipoDesarrollo(EquipoDesarrolloPK equipoDesarrolloPK, String posicion, Date fechaAdicion, String adicionadoPor, Date fechaModificacion) {
        this.equipoDesarrolloPK = equipoDesarrolloPK;
        this.posicion = posicion;
        this.fechaAdicion = fechaAdicion;
        this.adicionadoPor = adicionadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public EquipoDesarrollo(String idEquipo, String idGrupoDesa, String userCarnet) {
        this.equipoDesarrolloPK = new EquipoDesarrolloPK(idEquipo, idGrupoDesa, userCarnet);
    }

    public EquipoDesarrolloPK getEquipoDesarrolloPK() {
        return equipoDesarrolloPK;
    }

    public void setEquipoDesarrolloPK(EquipoDesarrolloPK equipoDesarrolloPK) {
        this.equipoDesarrolloPK = equipoDesarrolloPK;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public GrupoDesarrollo getGrupoDesarrollo() {
        return grupoDesarrollo;
    }

    public void setGrupoDesarrollo(GrupoDesarrollo grupoDesarrollo) {
        this.grupoDesarrollo = grupoDesarrollo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipoDesarrolloPK != null ? equipoDesarrolloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoDesarrollo)) {
            return false;
        }
        EquipoDesarrollo other = (EquipoDesarrollo) object;
        if ((this.equipoDesarrolloPK == null && other.equipoDesarrolloPK != null) || (this.equipoDesarrolloPK != null && !this.equipoDesarrolloPK.equals(other.equipoDesarrolloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service.EquipoDesarrollo[ equipoDesarrolloPK=" + equipoDesarrolloPK + " ]";
    }
    
}
