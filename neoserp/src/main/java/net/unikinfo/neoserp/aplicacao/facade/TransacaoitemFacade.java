/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Clifor;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Transacao;
import net.unikinfo.neoserp.aplicacao.model.Transacaoitem;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class TransacaoitemFacade extends AbstractFacade<Transacaoitem> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransacaoitemFacade() {
        super(Transacaoitem.class);
    }

    public List<Transacaoitem> getTransacaodupPorDoisStatusDoisTipos(Empresa empresa, String st1, String st2, String tp1, String tp2) {
        return em.createNamedQuery("Transacaoitem.findByEmpresaTpEStatus")
                .setParameter("empresa", empresa)
                .setParameter("st1", st1)
                .setParameter("st2", st2)
                .setParameter("tp1", tp1)
                .setParameter("tp2", tp2).getResultList();
    }

    public List<Transacaoitem> getTransacaodupPorTresStatusDoisTipos(Empresa empresa, String st1, String st2, String st3, String tp1, String tp2) {
        return em.createNamedQuery("Transacaoitem.findByEmpresaTpTresStatus")
                .setParameter("empresa", empresa)
                .setParameter("st1", st1)
                .setParameter("st2", st2)
                .setParameter("st3", st3)
                .setParameter("tp1", tp1)
                .setParameter("tp2", tp2).getResultList();
    }

    public List<Transacaoitem> getTransacaodupPorStatusTipoEmpresaClifor(Empresa empresa, Clifor clifor, String status, String tipo) {
        return em.createNamedQuery("Transacaoitem.findByEmpresaClienteTipoStatus")
                .setParameter("empresa", empresa)
                .setParameter("status", status)
                .setParameter("tipo", tipo)
                .setParameter("clifor", clifor).getResultList();
    }

    public List<Transacaoitem> getTransacaoItensPorTransacao(Transacao transacao) {
        List<Transacaoitem> transIt;
        transIt = em.createNamedQuery("Transacaoitem.findByTransacao")
                .setParameter("transacao", transacao).getResultList();
        return transIt;
    }
}
