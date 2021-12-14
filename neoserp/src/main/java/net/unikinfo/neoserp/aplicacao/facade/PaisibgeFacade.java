/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Paisibge;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class PaisibgeFacade extends AbstractFacade<Paisibge> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisibgeFacade() {
        super(Paisibge.class);
    }
    
    public List<Paisibge> listaPaisibge() {
        try {
           return em.createNamedQuery("Paisibge.findAll").getResultList();
        } catch (Exception e) {
           return new ArrayList();
        }
    }

    public List<Paisibge> listaPaisibgePorNome(String nome) {
        try {
           return em.createNamedQuery("Paisibge.findByNomePais").
                   setParameter("nomePais", nome).getResultList();
        } catch (Exception e) {
           return new ArrayList();
        }
    }    
    
}
