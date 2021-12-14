/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Relatorio;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class RelatorioFacade extends AbstractFacade<Relatorio> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<Relatorio> getRelatorioPorEmpresa(Empresa empresa) {  
           return em.createNamedQuery("Relatorio.findByEmpresa")  
                     .setParameter("empresa", empresa).getResultList();  
      }     

    public RelatorioFacade() {
        super(Relatorio.class);
    }
    
}
