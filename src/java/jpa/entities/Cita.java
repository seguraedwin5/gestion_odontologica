/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author egsf
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByIDcita", query = "SELECT c FROM Cita c WHERE c.iDcita = :iDcita"),
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByHora", query = "SELECT c FROM Cita c WHERE c.hora = :hora")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_cita")
    private Integer iDcita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "IDConsultorio", referencedColumnName = "ID_consultorio")
    @ManyToOne(optional = false)
    private Consultorio iDConsultorio;
    @JoinColumn(name = "IDMedico", referencedColumnName = "Id_Medico")
    @ManyToOne(optional = false)
    private Medico iDMedico;
    @JoinColumn(name = "IDPaciente", referencedColumnName = "ID_paciente")
    @ManyToOne(optional = false)
    private Paciente iDPaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDCita")
    private Collection<Tratamiento> tratamientoCollection;

    public Cita() {
    }

    public Cita(Integer iDcita) {
        this.iDcita = iDcita;
    }

    public Cita(Integer iDcita, Date fecha, Date hora) {
        this.iDcita = iDcita;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Integer getIDcita() {
        return iDcita;
    }

    public void setIDcita(Integer iDcita) {
        this.iDcita = iDcita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Consultorio getIDConsultorio() {
        return iDConsultorio;
    }

    public void setIDConsultorio(Consultorio iDConsultorio) {
        this.iDConsultorio = iDConsultorio;
    }

    public Medico getIDMedico() {
        return iDMedico;
    }

    public void setIDMedico(Medico iDMedico) {
        this.iDMedico = iDMedico;
    }

    public Paciente getIDPaciente() {
        return iDPaciente;
    }

    public void setIDPaciente(Paciente iDPaciente) {
        this.iDPaciente = iDPaciente;
    }

    @XmlTransient
    public Collection<Tratamiento> getTratamientoCollection() {
        return tratamientoCollection;
    }

    public void setTratamientoCollection(Collection<Tratamiento> tratamientoCollection) {
        this.tratamientoCollection = tratamientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDcita != null ? iDcita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.iDcita == null && other.iDcita != null) || (this.iDcita != null && !this.iDcita.equals(other.iDcita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cita: " + iDcita ;
    }
    
}
