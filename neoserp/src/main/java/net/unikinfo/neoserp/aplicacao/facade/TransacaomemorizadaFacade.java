/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Transacao;
import net.unikinfo.neoserp.aplicacao.model.Transacaomemorizada;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author uniki
 */
@Service
public class TransacaomemorizadaFacade extends AbstractFacade<Transacaomemorizada> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransacaomemorizadaFacade() {
        super(Transacaomemorizada.class);
    }

    public List<Transacaomemorizada> getTransacaomemorizadaPorTr(Transacao trans) {
        if (trans != null) {
            try {
                return em.createNamedQuery("Transacaomemorizada.findByIdTransacao")
                        .setParameter("idTransacao", trans).getResultList();
            } catch (Exception e) {
                return new ArrayList<Transacaomemorizada>();
            }
        } else {
            return new ArrayList<Transacaomemorizada>();
        }
    }

    public List<Transacaomemorizada> getTransacaomemorizadaPorEmpresa(Empresa emp) {
        try {
            return em.createNamedQuery("Transacaomemorizada.findByIdEmpresa")
                    .setParameter("idEmpresa", emp).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacaomemorizada>();
        }
    }
}
