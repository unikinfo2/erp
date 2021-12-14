/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Transacao;
import net.unikinfo.neoserp.aplicacao.model.Transacaodup;
import net.unikinfo.neoserp.aplicacao.model.Transacaoimposto;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class TransacaoimpostoFacade extends AbstractFacade<Transacaoimposto> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransacaoimpostoFacade() {
        super(Transacaoimposto.class);
    }

    public void edit(Transacaodup trDup) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Transacaoimposto> getTransacaoImpostoPorTransacao(Transacao transacao) {  
           List<Transacaoimposto> transImposto;  
           transImposto = em.createNamedQuery("Transacaoimposto.findByTransacao")  
                     .setParameter("transacao", transacao).getResultList();  
           return transImposto;  
      }     
    
}
