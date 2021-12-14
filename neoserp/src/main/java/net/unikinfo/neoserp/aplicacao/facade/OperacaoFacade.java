/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Operacao;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class OperacaoFacade extends AbstractFacade<Operacao> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<Operacao> getOperacaoPorEmpresa(Empresa empresa) {  
           return em.createNamedQuery("Operacao.findByEmpresa")  
                     .setParameter("empresa", empresa).getResultList();  
      }     

    public OperacaoFacade() {
        super(Operacao.class);
    }
    
}
