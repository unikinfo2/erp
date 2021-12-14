/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Transportadora;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class TransportadoraFacade extends AbstractFacade<Transportadora> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<Transportadora> getTransportadoraPorEmpresa(Empresa empresa) {  
           return em.createNamedQuery("Transportadora.findByEmpresa")  
                     .setParameter("empresa", empresa).getResultList();  
      }     

    public TransportadoraFacade() {
        super(Transportadora.class);
    }
    
}
