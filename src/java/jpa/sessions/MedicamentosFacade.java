/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Medicamentos;

/**
 *
 * @author egsf
 */
@Stateless
public class MedicamentosFacade extends AbstractFacade<Medicamentos> {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicamentosFacade() {
        super(Medicamentos.class);
    }
    
}
