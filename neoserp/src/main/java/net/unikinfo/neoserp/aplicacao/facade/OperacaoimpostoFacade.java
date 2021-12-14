/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Operacao;
import net.unikinfo.neoserp.aplicacao.model.Operacaoimposto;
import net.unikinfo.neoserp.aplicacao.model.Clifor;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class OperacaoimpostoFacade extends AbstractFacade<Operacaoimposto> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperacaoimpostoFacade() {
        super(Operacaoimposto.class);
    }
    public List<Operacaoimposto> getOperacaoImpostoPorOperacao(Operacao operacao) {  
           return em.createNamedQuery("Operacaoimposto.findByOperacao")  
                     .setParameter("operacao", operacao).getResultList();  
      }    

}
