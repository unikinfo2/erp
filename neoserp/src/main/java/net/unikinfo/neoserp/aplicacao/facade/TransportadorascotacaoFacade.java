/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.OrdemDespacho;
import net.unikinfo.neoserp.aplicacao.model.Transacao;
import net.unikinfo.neoserp.aplicacao.model.Transportadora;
import net.unikinfo.neoserp.aplicacao.model.Transportadorascotacao;
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
public class TransportadorascotacaoFacade extends AbstractFacade<Transportadorascotacao> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransportadorascotacaoFacade() {
        super(Transportadorascotacao.class);
    }

    public List<Transportadorascotacao> listaTransportadoraPorOd(OrdemDespacho ordemdespacho) {
        try {
            return em.createNamedQuery("Transportadorascotacao.findByOrdemDespacho")
                    .setParameter("ordemdespacho", ordemdespacho).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transportadorascotacao>();
        }
    }

}
