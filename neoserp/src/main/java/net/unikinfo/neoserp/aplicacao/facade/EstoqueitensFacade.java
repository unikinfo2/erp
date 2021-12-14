/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Estoque;
import net.unikinfo.neoserp.aplicacao.model.Estoqueitens;
import net.unikinfo.neoserp.aplicacao.model.Produto;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class EstoqueitensFacade extends AbstractFacade<Estoqueitens> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstoqueitensFacade() {
        super(Estoqueitens.class);
    }
    
    public List<Estoque> getEstoqueItens() {
        return em.createNamedQuery("Estoqueitens.findAll").getResultList();
    }
    
    public List<Estoque> getEstoquePorProduto(Produto produto) {
        return em.createNamedQuery("Estoqueitens.findByProduto")
                .setParameter("produto", produto).getResultList();
    }

    public List<Estoque> getEstoqueItensPorEmpresa(Empresa empresa) {
        return em.createNamedQuery("Estoqueitens.findEstoqueEmpresa")
                .setParameter("empresa", empresa).getResultList();
    }
    
    
    public BigDecimal getSaldoAtual(Produto produto, Estoque estoque) {
        try {            
            List<Estoqueitens> lst = em.createNamedQuery("Estoqueitens.findBySaldoAtual")
                    .setParameter("produto", produto)
                    .setParameter("estoque", estoque).getResultList();
            return lst.get(0).getSaldoAtual();
        } catch (Exception e) {            
            return new BigDecimal("0");
        }

    }

}
