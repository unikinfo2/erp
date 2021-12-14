/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Extratoparametro;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class ExtratoparametroFacade extends AbstractFacade<Extratoparametro> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExtratoparametroFacade() {
        super(Extratoparametro.class);
    }
    
    public List<Extratoparametro> pegaExtratoParametroList() {
       return em.createNamedQuery("Extratoparametro.findAll").getResultList();  
    }
    
    
}
