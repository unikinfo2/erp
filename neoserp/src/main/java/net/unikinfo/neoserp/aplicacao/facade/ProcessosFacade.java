/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Clifor;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Processos;
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
public class ProcessosFacade extends AbstractFacade<Processos> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<Processos> getProcessosPorEmpresa(Empresa empresa) {  
        return em.createNamedQuery("Processos.findByEmpresa")  
                     .setParameter("empresa", empresa).getResultList();  
      } 
    public List<Processos> getProcessosPorid(Long idProcesso) {  
        return em.createNamedQuery("Processos.findByIdProcesso")  
                     .setParameter("idProcesso", idProcesso).getResultList();  
      } 


    public ProcessosFacade() {
        super(Processos.class);
    }
    
}
