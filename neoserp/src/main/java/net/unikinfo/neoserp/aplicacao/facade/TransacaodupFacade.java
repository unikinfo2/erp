/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Transacao;
import net.unikinfo.neoserp.aplicacao.model.Transacaodup;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class TransacaodupFacade extends AbstractFacade<Transacaodup> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransacaodupFacade() {
        super(Transacaodup.class);
    }

    public List<Transacaodup> getTransacaodupPorEmpresa(Empresa empresa) {
        return em.createNamedQuery("Transacaodup.findByEmpresa")
                .setParameter("empresa", empresa).getResultList();
    }

    public List<Transacaodup> getTransacaodupPorEmpresaTipoRecto(Empresa empresa, String tipoRec, String chqUsado, String tp1, String tp2, String statusTransacao1, String statusTransacao2, Date dt1, Date dt2) {
        return em.createNamedQuery("Transacaodup.findByEmpresaTipoRecto")
                .setParameter("empresa", empresa)
                .setParameter("tipoRec", tipoRec)
                .setParameter("chqUsado", chqUsado)
                .setParameter("tp1", tp1)
                .setParameter("tp2", tp2)
                .setParameter("statusTransacao1", statusTransacao1)
                .setParameter("statusTransacao2", statusTransacao2)
                .setParameter("dt1", dt1)
                .setParameter("dt2", dt2).getResultList();
    }

    public List<Transacaodup> getTransacaodupPorEmpresaPeriodo(Empresa empresa, String tp, Date dt1, Date dt2) {
        return em.createNamedQuery("Transacaodup.findByEmpresaPeriodoVencto")
                .setParameter("empresa", empresa)
                .setParameter("dt1", dt1)
                .setParameter("dt2", dt2).getResultList();

    }

    public List<Transacaodup> getTransacaodupPorCliforEmpresaPeriodo(String clifor, Empresa empresa, String tp, Date dt1, Date dt2) {
        return em.createNamedQuery("Transacaodup.findByCliforEmpresaPeriodoVencto")
                .setParameter("clifor", "%" + clifor + "%")
                .setParameter("empresa", empresa)
                .setParameter("dt1", dt1)
                .setParameter("dt2", dt2).getResultList();
    }

    public List<Transacaodup> getTransacaoDupPorTransacao(Transacao transacao) {
        List<Transacaodup> transDup;
        transDup = em.createNamedQuery("Transacaodup.findByTransacao")
                .setParameter("transacao", transacao).getResultList();
        return transDup;
    }

    public List<Transacaodup> getTransacaoDupPorTransacaoEvencto(Transacao transacao, Date dtVencto) {
        System.out.println("transacao = " + transacao);
        System.out.println("dtVencto = " + dtVencto);
        List<Transacaodup> transDup;
        transDup = em.createNamedQuery("Transacaodup.findByTransacaoEvencto")
                .setParameter("transacao", transacao)
                .setParameter("dtVencto", dtVencto).getResultList();
        System.out.println("result = " + transDup);
        return transDup;
    }
}
