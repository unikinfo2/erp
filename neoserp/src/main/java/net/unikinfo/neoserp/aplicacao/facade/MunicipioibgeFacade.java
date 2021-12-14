/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Municipioibge;
import net.unikinfo.neoserp.aplicacao.model.Planocontas;
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
public class MunicipioibgeFacade extends AbstractFacade<Municipioibge> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipioibgeFacade() {
        super(Municipioibge.class);
    }

    public List<Municipioibge> listaMunicipioibge() {
        try {
           return em.createNamedQuery("Municipioibge.findAll").getResultList();
        } catch (Exception e) {
           return new ArrayList();
        }
    }     
    
}
