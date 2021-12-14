/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Planocontas;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class PlanocontasFacade extends AbstractFacade<Planocontas> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanocontasFacade() {
        super(Planocontas.class);
    }

    public List<Planocontas> getPlanocontasPorTipo(String pTipo1, String pTipo2) {  
           List<Planocontas> planocontas;
           
           planocontas = em.createNamedQuery("Planocontas.findInTipoConta")  
                     .setParameter("tipoConta1", pTipo1 )
                     .setParameter("tipoConta2", pTipo2 ).getResultList();  
           return planocontas;  
      }     
    
    public List<Planocontas> getPlanocontasPorEmpresa(Empresa empresa) {  
           return em.createNamedQuery("Planocontas.findByEmpresa")  
                     .setParameter("empresa", empresa ).getResultList();  
      }     

    public List<Planocontas> getPlanocontasPorTipoEmpresa(Empresa empresa, String pTipo) {  
           return em.createNamedQuery("Planocontas.findByTipoEmpresa")  
                     .setParameter("empresa", empresa )
                     .setParameter("tipoConta", pTipo ).getResultList();  
      }     
    
    
    public Planocontas getPlanocontasPorId(Long idConta) { 
        Planocontas retorno = null;
        try{
           retorno = (Planocontas) em.createNamedQuery("Planocontas.findByIdConta")  
                     .setParameter("idConta", idConta ).getSingleResult();  
        } catch (Exception e) {
            retorno = (Planocontas) null;
        }
        return retorno;
      }     
}
