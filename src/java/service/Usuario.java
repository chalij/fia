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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCarnet", query = "SELECT u FROM Usuario u WHERE u.carnet = :carnet"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido"),
    @NamedQuery(name = "Usuario.findByMovil", query = "SELECT u FROM Usuario u WHERE u.movil = :movil"),
    @NamedQuery(name = "Usuario.findByCasa", query = "SELECT u FROM Usuario u WHERE u.casa = :casa"),
    @NamedQuery(name = "Usuario.findByOficina", query = "SELECT u FROM Usuario u WHERE u.oficina = :oficina"),
    @NamedQuery(name = "Usuario.findBySocialFacebook", query = "SELECT u FROM Usuario u WHERE u.socialFacebook = :socialFacebook"),
    @NamedQuery(name = "Usuario.findBySocialTwitter", query = "SELECT u FROM Usuario u WHERE u.socialTwitter = :socialTwitter"),
    @NamedQuery(name = "Usuario.findByGithub", query = "SELECT u FROM Usuario u WHERE u.github = :github"),
    @NamedQuery(name = "Usuario.findByFechaAdicion", query = "SELECT u FROM Usuario u WHERE u.fechaAdicion = :fechaAdicion"),
    @NamedQuery(name = "Usuario.findByAdicionadoPor", query = "SELECT u FROM Usuario u WHERE u.adicionadoPor = :adicionadoPor"),
    @NamedQuery(name = "Usuario.findByFechaModificacion", query = "SELECT u FROM Usuario u WHERE u.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Usuario.findByModificadoPor", query = "SELECT u FROM Usuario u WHERE u.modificadoPor = :modificadoPor")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "CARNET")
    private String carnet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MOVIL")
    private String movil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CASA")
    private String casa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "OFICINA")
    private String oficina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SOCIAL_FACEBOOK")
    private String socialFacebook;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SOCIAL_TWITTER")
    private String socialTwitter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "GITHUB")
    private String github;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<EquipoDesarrollo> equipoDesarrolloCollection;

    public Usuario() {
    }

    public Usuario(String carnet) {
        this.carnet = carnet;
    }

    public Usuario(String carnet, String nombre, String apellido, String movil, String casa, String oficina, String socialFacebook, String socialTwitter, String github, Date fechaAdicion, String adicionadoPor, Date fechaModificacion) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.movil = movil;
        this.casa = casa;
        this.oficina = oficina;
        this.socialFacebook = socialFacebook;
        this.socialTwitter = socialTwitter;
        this.github = github;
        this.fechaAdicion = fechaAdicion;
        this.adicionadoPor = adicionadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getSocialFacebook() {
        return socialFacebook;
    }

    public void setSocialFacebook(String socialFacebook) {
        this.socialFacebook = socialFacebook;
    }

    public String getSocialTwitter() {
        return socialTwitter;
    }

    public void setSocialTwitter(String socialTwitter) {
        this.socialTwitter = socialTwitter;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
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
    public Collection<EquipoDesarrollo> getEquipoDesarrolloCollection() {
        return equipoDesarrolloCollection;
    }

    public void setEquipoDesarrolloCollection(Collection<EquipoDesarrollo> equipoDesarrolloCollection) {
        this.equipoDesarrolloCollection = equipoDesarrolloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carnet != null ? carnet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.carnet == null && other.carnet != null) || (this.carnet != null && !this.carnet.equals(other.carnet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service.Usuario[ carnet=" + carnet + " ]";
    }
    
}
