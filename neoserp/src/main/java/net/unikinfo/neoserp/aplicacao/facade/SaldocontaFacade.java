/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Planocontas;
import net.unikinfo.neoserp.aplicacao.model.Saldoconta;
import java.math.BigDecimal;
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
public class SaldocontaFacade extends AbstractFacade<Saldoconta> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SaldocontaFacade() {
        super(Saldoconta.class);
    }

    public List<Saldoconta> getSaldocontaEmpresaAnoMes(Empresa empresa, String anoMes) {
        try {
            return em.createNamedQuery("Saldoconta.findByEmpresaAnoMes")
                    .setParameter("empresa", empresa)
                    .setParameter("anomesSaldo", anoMes)
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<Saldoconta>();
        }
    }

    public List<Saldoconta> getSaldocontaEmpresa(Empresa empresa) {
        try {
            return em.createNamedQuery("Saldoconta.findByEmpresa")
                    .setParameter("empresa", empresa).getResultList();
        } catch (Exception e) {
            return new ArrayList<Saldoconta>();
        }
    }
    
    public Saldoconta getSaldocontaEmpresaAnoMesConta(Empresa empresa, String anoMes, Planocontas conta) {
        try {
            return (Saldoconta) em.createNamedQuery("Saldoconta.findByEmpresaAnoMesConta")
                    .setParameter("empresa", empresa)
                    .setParameter("anomesSaldo", anoMes)
                    .setParameter("contasaldo", conta)
                    .getSingleResult();
        } catch (Exception e) {
            Saldoconta sldCta = new Saldoconta();
            sldCta.setEmpresa(empresa);
            sldCta.setAnomesSaldo(anoMes);
            sldCta.setContasaldo(conta);
            sldCta.setSaldoAnterior(BigDecimal.ZERO);
            sldCta.setSaldoFinal(BigDecimal.ZERO);
            sldCta.setValorCredito(BigDecimal.ZERO);
            sldCta.setValorDebito(BigDecimal.ZERO);
            return sldCta;
        }
    }

}
