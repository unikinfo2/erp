/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Transacao;
import net.unikinfo.neoserp.aplicacao.model.Transacaoconta;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class TransacaocontaFacade extends AbstractFacade<Transacaoconta> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransacaocontaFacade() {
        super(Transacaoconta.class);
    }

    public List<Transacaoconta> getTransacaoContaPorTransacao(Transacao transacao) {
        List<Transacaoconta> transCt;
        try {
            transCt = em.createNamedQuery("Transacaoconta.findByTransacao")
                    .setParameter("transacao", transacao).getResultList();
        } catch (Exception e) {
            transCt = new ArrayList<Transacaoconta>();
        }
        return transCt;
    }

}
