/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author egsf
 */
@Entity
@Table(name = "tratamiento_medicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TratamientoMedicamento.findAll", query = "SELECT t FROM TratamientoMedicamento t"),
    @NamedQuery(name = "TratamientoMedicamento.findByIDtratamientomedicamento", query = "SELECT t FROM TratamientoMedicamento t WHERE t.iDtratamientomedicamento = :iDtratamientomedicamento"),
    @NamedQuery(name = "TratamientoMedicamento.findByDosis", query = "SELECT t FROM TratamientoMedicamento t WHERE t.dosis = :dosis"),
    @NamedQuery(name = "TratamientoMedicamento.findByNodias", query = "SELECT t FROM TratamientoMedicamento t WHERE t.nodias = :nodias")})
public class TratamientoMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_tratamiento_medicamento")
    private Integer iDtratamientomedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dosis")
    private String dosis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "No_dias")
    private int nodias;
    @JoinColumn(name = "ID_medicamento", referencedColumnName = "ID_medicamentos")
    @ManyToOne(optional = false)
    private Medicamentos iDmedicamento;
    @JoinColumn(name = "ID_tratamiento", referencedColumnName = "ID_tratamiento")
    @ManyToOne(optional = false)
    private Tratamiento iDtratamiento;

    public TratamientoMedicamento() {
    }

    public TratamientoMedicamento(Integer iDtratamientomedicamento) {
        this.iDtratamientomedicamento = iDtratamientomedicamento;
    }

    public TratamientoMedicamento(Integer iDtratamientomedicamento, String dosis, int nodias) {
        this.iDtratamientomedicamento = iDtratamientomedicamento;
        this.dosis = dosis;
        this.nodias = nodias;
    }

    public Integer getIDtratamientomedicamento() {
        return iDtratamientomedicamento;
    }

    public void setIDtratamientomedicamento(Integer iDtratamientomedicamento) {
        this.iDtratamientomedicamento = iDtratamientomedicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public int getNodias() {
        return nodias;
    }

    public void setNodias(int nodias) {
        this.nodias = nodias;
    }

    public Medicamentos getIDmedicamento() {
        return iDmedicamento;
    }

    public void setIDmedicamento(Medicamentos iDmedicamento) {
        this.iDmedicamento = iDmedicamento;
    }

    public Tratamiento getIDtratamiento() {
        return iDtratamiento;
    }

    public void setIDtratamiento(Tratamiento iDtratamiento) {
        this.iDtratamiento = iDtratamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDtratamientomedicamento != null ? iDtratamientomedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TratamientoMedicamento)) {
            return false;
        }
        TratamientoMedicamento other = (TratamientoMedicamento) object;
        if ((this.iDtratamientomedicamento == null && other.iDtratamientomedicamento != null) || (this.iDtratamientomedicamento != null && !this.iDtratamientomedicamento.equals(other.iDtratamientomedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TratamientoMedicamento[ iDtratamientomedicamento=" + iDtratamientomedicamento + " ]";
    }
    
}
