/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Relatorio;
import net.unikinfo.neoserp.aplicacao.model.Relatoriofiltro;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class RelatoriofiltroFacade extends AbstractFacade<Relatoriofiltro> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RelatoriofiltroFacade() {
        super(Relatoriofiltro.class);
    }
    
    public List<Relatoriofiltro> getRelatoriofiltroPorRelatorio(Relatorio relatorio) {  
           return em.createNamedQuery("Relatoriofiltro.findByRelatorio")  
                     .setParameter("relatorio", relatorio).getResultList();  
      }     
    
}
