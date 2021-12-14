/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Estoque;
import net.unikinfo.neoserp.aplicacao.model.Produto;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class EstoqueFacade extends AbstractFacade<Estoque> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstoqueFacade() {
        super(Estoque.class);
    }
    
    public List<Estoque> getEstoquePorEmpresa(Empresa empresa) {  
           return em.createNamedQuery("Estoque.findByIdEmpresa")  
                     .setParameter("empresa", empresa).getResultList();  
      } 
    public List<Estoque> getEstoquePorEmpresaMatriz(Empresa matriz) {  
           return em.createNamedQuery("Estoque.findByIdEmpresaMatriz")  
                     .setParameter("matriz", matriz).getResultList();  
      } 
    
}
