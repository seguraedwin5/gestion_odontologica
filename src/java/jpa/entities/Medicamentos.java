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
@Table(name = "medicamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamentos.findAll", query = "SELECT m FROM Medicamentos m"),
    @NamedQuery(name = "Medicamentos.findByIDmedicamentos", query = "SELECT m FROM Medicamentos m WHERE m.iDmedicamentos = :iDmedicamentos"),
    @NamedQuery(name = "Medicamentos.findByNombre", query = "SELECT m FROM Medicamentos m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Medicamentos.findByEspecificaciones", query = "SELECT m FROM Medicamentos m WHERE m.especificaciones = :especificaciones"),
    @NamedQuery(name = "Medicamentos.findByViaDeAdministracion", query = "SELECT m FROM Medicamentos m WHERE m.viaDeAdministracion = :viaDeAdministracion")})
public class Medicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_medicamentos")
    private Integer iDmedicamentos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "especificaciones")
    private String especificaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "via_de_administracion")
    private String viaDeAdministracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDmedicamento")
    private Collection<TratamientoMedicamento> tratamientoMedicamentoCollection;

    public Medicamentos() {
    }

    public Medicamentos(Integer iDmedicamentos) {
        this.iDmedicamentos = iDmedicamentos;
    }

    public Medicamentos(Integer iDmedicamentos, String nombre, String especificaciones, String viaDeAdministracion) {
        this.iDmedicamentos = iDmedicamentos;
        this.nombre = nombre;
        this.especificaciones = especificaciones;
        this.viaDeAdministracion = viaDeAdministracion;
    }

    public Integer getIDmedicamentos() {
        return iDmedicamentos;
    }

    public void setIDmedicamentos(Integer iDmedicamentos) {
        this.iDmedicamentos = iDmedicamentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public String getViaDeAdministracion() {
        return viaDeAdministracion;
    }

    public void setViaDeAdministracion(String viaDeAdministracion) {
        this.viaDeAdministracion = viaDeAdministracion;
    }

    @XmlTransient
    public Collection<TratamientoMedicamento> getTratamientoMedicamentoCollection() {
        return tratamientoMedicamentoCollection;
    }

    public void setTratamientoMedicamentoCollection(Collection<TratamientoMedicamento> tratamientoMedicamentoCollection) {
        this.tratamientoMedicamentoCollection = tratamientoMedicamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDmedicamentos != null ? iDmedicamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamentos)) {
            return false;
        }
        Medicamentos other = (Medicamentos) object;
        if ((this.iDmedicamentos == null && other.iDmedicamentos != null) || (this.iDmedicamentos != null && !this.iDmedicamentos.equals(other.iDmedicamentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medicamento: " + iDmedicamentos + " " + nombre;
    }
    
}
