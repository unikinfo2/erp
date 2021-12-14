/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Cedentebancario;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos
 */
@Service
public class CedentebancarioFacade extends AbstractFacade<Cedentebancario> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<Cedentebancario> getCedentePorEmpresa(Empresa empresa) {  
           return em.createNamedQuery("Cedentebancario.findByEmpresa")  
                     .setParameter("empresa", empresa).getResultList();  
      }     

    public CedentebancarioFacade() {
        super(Cedentebancario.class);
    }
    
}
