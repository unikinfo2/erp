/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Carlos
 */
@Service
public class EmpresaFacade extends AbstractFacade<Empresa> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaFacade() {
        super(Empresa.class);
    }

    public List<Empresa> getEmpresaList() {  
           return em.createNamedQuery("Empresa.findAll")  
                     .getResultList();  
    }
    
    public Empresa getMaxEmpresa() {  
           return (Empresa) em.createNamedQuery("Empresa.findMax")  
                     .getSingleResult();  
      }     
    
    public Empresa getEmpresaPorId(Long idEmpresa) {  
           return (Empresa) em.createNamedQuery("Empresa.findByIdEmpresa")  
                     .setParameter("idEmpresa", idEmpresa).getSingleResult();  
      }     
    
}
