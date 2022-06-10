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
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
    @NamedQuery(name = "Medico.findByIdMedico", query = "SELECT m FROM Medico m WHERE m.idMedico = :idMedico"),
    @NamedQuery(name = "Medico.findByTipoDoc", query = "SELECT m FROM Medico m WHERE m.tipoDoc = :tipoDoc"),
    @NamedQuery(name = "Medico.findByNumDoc", query = "SELECT m FROM Medico m WHERE m.numDoc = :numDoc"),
    @NamedQuery(name = "Medico.findByNombresMedico", query = "SELECT m FROM Medico m WHERE m.nombresMedico = :nombresMedico"),
    @NamedQuery(name = "Medico.findByApellidosMedico", query = "SELECT m FROM Medico m WHERE m.apellidosMedico = :apellidosMedico"),
    @NamedQuery(name = "Medico.findByEspecialidadMedico", query = "SELECT m FROM Medico m WHERE m.especialidadMedico = :especialidadMedico"),
    @NamedQuery(name = "Medico.findByNumerolicenciaMedico", query = "SELECT m FROM Medico m WHERE m.numerolicenciaMedico = :numerolicenciaMedico"),
    @NamedQuery(name = "Medico.findByTelefono", query = "SELECT m FROM Medico m WHERE m.telefono = :telefono"),
    @NamedQuery(name = "Medico.findByCorreo", query = "SELECT m FROM Medico m WHERE m.correo = :correo"),
    @NamedQuery(name = "Medico.findByDireccion", query = "SELECT m FROM Medico m WHERE m.direccion = :direccion")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Medico")
    private Integer idMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Tipo_Doc")
    private String tipoDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Num_Doc")
    private String numDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Nombres_Medico")
    private String nombresMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Apellidos_Medico")
    private String apellidosMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Especialidad_Medico")
    private String especialidadMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Numero_licencia_Medico")
    private String numerolicenciaMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDMedico")
    private Collection<Cita> citaCollection;

    public Medico() {
    }

    public Medico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Medico(Integer idMedico, String tipoDoc, String numDoc, String nombresMedico, String apellidosMedico, String especialidadMedico, String numerolicenciaMedico, String telefono, String correo, String direccion) {
        this.idMedico = idMedico;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.nombresMedico = nombresMedico;
        this.apellidosMedico = apellidosMedico;
        this.especialidadMedico = especialidadMedico;
        this.numerolicenciaMedico = numerolicenciaMedico;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getNombresMedico() {
        return nombresMedico;
    }

    public void setNombresMedico(String nombresMedico) {
        this.nombresMedico = nombresMedico;
    }

    public String getApellidosMedico() {
        return apellidosMedico;
    }

    public void setApellidosMedico(String apellidosMedico) {
        this.apellidosMedico = apellidosMedico;
    }

    public String getEspecialidadMedico() {
        return especialidadMedico;
    }

    public void setEspecialidadMedico(String especialidadMedico) {
        this.especialidadMedico = especialidadMedico;
    }

    public String getNumerolicenciaMedico() {
        return numerolicenciaMedico;
    }

    public void setNumerolicenciaMedico(String numerolicenciaMedico) {
        this.numerolicenciaMedico = numerolicenciaMedico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        hash += (idMedico != null ? idMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.idMedico == null && other.idMedico != null) || (this.idMedico != null && !this.idMedico.equals(other.idMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Medico[ idMedico=" + idMedico + " ]";
    }
    
}
