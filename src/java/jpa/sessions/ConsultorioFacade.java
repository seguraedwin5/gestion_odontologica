/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Consultorio;

/**
 *
 * @author egsf
 */
@Stateless
public class ConsultorioFacade extends AbstractFacade<Consultorio> {

    @PersistenceContext(unitName = "gestionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultorioFacade() {
        super(Consultorio.class);
    }
    
}
