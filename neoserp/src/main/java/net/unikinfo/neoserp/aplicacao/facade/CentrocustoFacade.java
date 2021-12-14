/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Centrocusto;
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
public class CentrocustoFacade extends AbstractFacade<Centrocusto> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CentrocustoFacade() {
        super(Centrocusto.class);
    }
    
    public List<Centrocusto> getCentrocustoPorEmpresa(Empresa empresa) {  
           return em.createNamedQuery("Centrocusto.findByEmpresa")  
                     .setParameter("empresa", empresa ).getResultList();  
      }     
    
}
