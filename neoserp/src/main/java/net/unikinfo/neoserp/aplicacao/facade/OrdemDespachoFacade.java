/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Extrato;
import net.unikinfo.neoserp.aplicacao.model.OrdemDespacho;
import net.unikinfo.neoserp.aplicacao.model.Transacao;
import net.unikinfo.neoserp.aplicacao.model.Transportadora;
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
public class OrdemDespachoFacade extends AbstractFacade<OrdemDespacho> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdemDespachoFacade() {
        super(OrdemDespacho.class);
    }

    public List<OrdemDespacho> pegaODList() {
        return em.createNamedQuery("OrdemDespacho.findAll").getResultList();
    }

    public OrdemDespacho listaOdPorPedido(Transacao transacao) {
        try {
            return (OrdemDespacho) em.createNamedQuery("OrdemDespacho.findOrdemDespachoPorPedido")
                    .setParameter("transacao", transacao).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<OrdemDespacho> listaOdPorPedido2(Transacao transacao) {
        try {
            return em.createNamedQuery("OrdemDespacho.findOrdemDespachoPorPedido")
                    .setParameter("transacao", transacao).getResultList();
        } catch (Exception e) {
            return new ArrayList<OrdemDespacho>();
        }
    }
    
    public List<OrdemDespacho> listaOdPorTransportadora(Transportadora transp) {
        try {
            return em.createNamedQuery("OrdemDespacho.findOrdemDespachoPorTransportadora")
                    .setParameter("transp", transp).getResultList();
        } catch (Exception e) {
            return new ArrayList();
        }
    }
}
