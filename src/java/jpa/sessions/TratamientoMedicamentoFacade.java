/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.TratamientoMedicamento;

/**
 *
 * @author egsf
 */
@Stateless
public class TratamientoMedicamentoFacade extends AbstractFacade<TratamientoMedicamento> {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TratamientoMedicamentoFacade() {
        super(TratamientoMedicamento.class);
    }
    
}
