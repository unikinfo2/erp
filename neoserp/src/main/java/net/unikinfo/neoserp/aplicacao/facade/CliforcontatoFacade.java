/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Clifor;
import net.unikinfo.neoserp.aplicacao.model.Cliforcontato;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class CliforcontatoFacade extends AbstractFacade<Cliforcontato> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CliforcontatoFacade() {
        super(Cliforcontato.class);
    }
    public List<Cliforcontato> getCliforcontatoPorClifor(Clifor clifor) {  
           return em.createNamedQuery("Cliforcontato.findByClifor")  
                     .setParameter("clifor", clifor).getResultList();  
      }    
}
