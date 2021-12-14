/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Tipoimposto;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class TipoimpostoFacade extends AbstractFacade<Tipoimposto> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoimpostoFacade() {
        super(Tipoimposto.class);
    }
    
    public List<Tipoimposto> ListTipoimposto() {
        return em.createNamedQuery("Tipoimposto.findAll").getResultList();
    }

    public Tipoimposto getTipoImpostoPorNome(String nome) {  
        Tipoimposto resultado = new Tipoimposto();
        try {
           resultado = (Tipoimposto) em.createNamedQuery("Tipoimposto.findByNomeTipoImposto")  
                     .setParameter("nomeTipoImposto", nome).getSingleResult();  
        } catch(Exception e) {
        }
        return resultado;
    }
    
}
