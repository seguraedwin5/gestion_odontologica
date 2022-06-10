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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author egsf
 */
@Entity
@Table(name = "tratamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratamiento.findAll", query = "SELECT t FROM Tratamiento t"),
    @NamedQuery(name = "Tratamiento.findByIDtratamiento", query = "SELECT t FROM Tratamiento t WHERE t.iDtratamiento = :iDtratamiento"),
    @NamedQuery(name = "Tratamiento.findByFecha", query = "SELECT t FROM Tratamiento t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "Tratamiento.findByDuracion", query = "SELECT t FROM Tratamiento t WHERE t.duracion = :duracion"),
    @NamedQuery(name = "Tratamiento.findByPasos", query = "SELECT t FROM Tratamiento t WHERE t.pasos = :pasos")})
public class Tratamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_tratamiento")
    private Integer iDtratamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "diagnostico")
    private String diagnostico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "duracion")
    private String duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pasos")
    private String pasos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "especificacion")
    private String especificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDtratamiento")
    private Collection<TratamientoMedicamento> tratamientoMedicamentoCollection;
    @JoinColumn(name = "IDCita", referencedColumnName = "ID_cita")
    @ManyToOne(optional = false)
    private Cita iDCita;

    public Tratamiento() {
    }

    public Tratamiento(Integer iDtratamiento) {
        this.iDtratamiento = iDtratamiento;
    }

    public Tratamiento(Integer iDtratamiento, Date fecha, String diagnostico, String duracion, String pasos, String especificacion) {
        this.iDtratamiento = iDtratamiento;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.duracion = duracion;
        this.pasos = pasos;
        this.especificacion = especificacion;
    }

    public Integer getIDtratamiento() {
        return iDtratamiento;
    }

    public void setIDtratamiento(Integer iDtratamiento) {
        this.iDtratamiento = iDtratamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    @XmlTransient
    public Collection<TratamientoMedicamento> getTratamientoMedicamentoCollection() {
        return tratamientoMedicamentoCollection;
    }

    public void setTratamientoMedicamentoCollection(Collection<TratamientoMedicamento> tratamientoMedicamentoCollection) {
        this.tratamientoMedicamentoCollection = tratamientoMedicamentoCollection;
    }

    public Cita getIDCita() {
        return iDCita;
    }

    public void setIDCita(Cita iDCita) {
        this.iDCita = iDCita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDtratamiento != null ? iDtratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamiento)) {
            return false;
        }
        Tratamiento other = (Tratamiento) object;
        if ((this.iDtratamiento == null && other.iDtratamiento != null) || (this.iDtratamiento != null && !this.iDtratamiento.equals(other.iDtratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tratamiento: " + iDtratamiento + " " + especificacion;
    }
    
}
