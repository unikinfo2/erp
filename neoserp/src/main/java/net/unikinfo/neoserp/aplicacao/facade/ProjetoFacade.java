/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Clifor;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
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
public class ProjetoFacade extends AbstractFacade<Projeto> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<Projeto> getProjetoPorEmpresa(Empresa empresa) {  
           return em.createNamedQuery("Projeto.findByEmpresa")  
                     .setParameter("empresa", empresa).getResultList();  
      }
    public List<Projeto> getProjetoPorClienteEmpresa(Empresa empresa, Clifor clifor) {  
           return em.createNamedQuery("Projeto.findByEmpresaClifor")  
                     .setParameter("empresa", empresa)
                     .setParameter("clifor", clifor).getResultList();  
      }
 


    public ProjetoFacade() {
        super(Projeto.class);
    }
    
}
