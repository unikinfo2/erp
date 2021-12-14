/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Clifor;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.OrdemDespacho;
import net.unikinfo.neoserp.aplicacao.model.Produto;
import net.unikinfo.neoserp.aplicacao.model.Produtosdespachados;
import net.unikinfo.neoserp.aplicacao.model.Projeto;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class ProdutosdespachoFacade extends AbstractFacade<Produtosdespachados> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Produtosdespachados> getProdutosPorOD(OrdemDespacho ordemdespacho) {
        return em.createNamedQuery("Produtosdespachados.findByIdOrdemDespacho")
                .setParameter("ordemdespacho", ordemdespacho).getResultList();
    }

    public Produtosdespachados getProdutosPorProdutoeOD(Produto produto, OrdemDespacho ordemdespacho) {
        try {
            return (Produtosdespachados) em.createNamedQuery("Produtosdespachados.findByIdProdutosEordemDespacho")
                    .setParameter("produto", produto)
                    .setParameter("ordemdespacho", ordemdespacho).getSingleResult();
        } catch (Exception e) {
            System.out.println("produto = " + produto);
            System.out.println("ordemdespacho = " + ordemdespacho);
            return null;
        }
    }

    public ProdutosdespachoFacade() {
        super(Produtosdespachados.class);
    }

}
