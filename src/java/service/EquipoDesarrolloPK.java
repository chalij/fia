/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author chali
 */
@Embeddable
public class EquipoDesarrolloPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ID_EQUIPO")
    private String idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_GRUPO_DESA")
    private String idGrupoDesa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "USER_CARNET")
    private String userCarnet;

    public EquipoDesarrolloPK() {
    }

    public EquipoDesarrolloPK(String idEquipo, String idGrupoDesa, String userCarnet) {
        this.idEquipo = idEquipo;
        this.idGrupoDesa = idGrupoDesa;
        this.userCarnet = userCarnet;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getIdGrupoDesa() {
        return idGrupoDesa;
    }

    public void setIdGrupoDesa(String idGrupoDesa) {
        this.idGrupoDesa = idGrupoDesa;
    }

    public String getUserCarnet() {
        return userCarnet;
    }

    public void setUserCarnet(String userCarnet) {
        this.userCarnet = userCarnet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        hash += (idGrupoDesa != null ? idGrupoDesa.hashCode() : 0);
        hash += (userCarnet != null ? userCarnet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoDesarrolloPK)) {
            return false;
        }
        EquipoDesarrolloPK other = (EquipoDesarrolloPK) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        if ((this.idGrupoDesa == null && other.idGrupoDesa != null) || (this.idGrupoDesa != null && !this.idGrupoDesa.equals(other.idGrupoDesa))) {
            return false;
        }
        if ((this.userCarnet == null && other.userCarnet != null) || (this.userCarnet != null && !this.userCarnet.equals(other.userCarnet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service.EquipoDesarrolloPK[ idEquipo=" + idEquipo + ", idGrupoDesa=" + idGrupoDesa + ", userCarnet=" + userCarnet + " ]";
    }
    
}
