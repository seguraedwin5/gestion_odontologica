/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
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
 * @author egsf
 */
@Entity
@Table(name = "consultorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultorio.findAll", query = "SELECT c FROM Consultorio c"),
    @NamedQuery(name = "Consultorio.findByIDconsultorio", query = "SELECT c FROM Consultorio c WHERE c.iDconsultorio = :iDconsultorio"),
    @NamedQuery(name = "Consultorio.findByPiso", query = "SELECT c FROM Consultorio c WHERE c.piso = :piso"),
    @NamedQuery(name = "Consultorio.findByDescripcion", query = "SELECT c FROM Consultorio c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Consultorio.findBySede", query = "SELECT c FROM Consultorio c WHERE c.sede = :sede")})
public class Consultorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_consultorio")
    private Integer iDconsultorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piso")
    private int piso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sede")
    private String sede;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDConsultorio")
    private Collection<Cita> citaCollection;

    public Consultorio() {
    }

    public Consultorio(Integer iDconsultorio) {
        this.iDconsultorio = iDconsultorio;
    }

    public Consultorio(Integer iDconsultorio, int piso, String descripcion, String sede) {
        this.iDconsultorio = iDconsultorio;
        this.piso = piso;
        this.descripcion = descripcion;
        this.sede = sede;
    }

    public Integer getIDconsultorio() {
        return iDconsultorio;
    }

    public void setIDconsultorio(Integer iDconsultorio) {
        this.iDconsultorio = iDconsultorio;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @XmlTransient
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDconsultorio != null ? iDconsultorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultorio)) {
            return false;
        }
        Consultorio other = (Consultorio) object;
        if ((this.iDconsultorio == null && other.iDconsultorio != null) || (this.iDconsultorio != null && !this.iDconsultorio.equals(other.iDconsultorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Consultorio[ iDconsultorio=" + iDconsultorio + " ]";
    }
    
}
