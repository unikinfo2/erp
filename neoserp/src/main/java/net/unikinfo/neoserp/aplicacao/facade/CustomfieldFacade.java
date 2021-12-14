/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Customfield;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
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
public class CustomfieldFacade extends AbstractFacade<Customfield> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomfieldFacade() {
        super(Customfield.class);
    }

    public List<Customfield> pegaCustomFieldList(Empresa empresa) {
        List<Customfield> vRst;
        try {
            vRst = em.createNamedQuery("Customfield.findAll")
                    .setParameter("empresa", empresa)
                    .getResultList();
        }catch(Exception e){
            vRst = new ArrayList<Customfield>();
        }
        return vRst;
    }

    public List<Customfield> customFieldPorNomeClasse(String nomeClasse, Empresa empresa) {
        List<Customfield> vRst;
        try {
            vRst = em.createNamedQuery("Customfield.findByNomeClasse")
                    .setParameter("nomeClasse", nomeClasse)
                    .setParameter("empresa", empresa)
                    .getResultList();
        }catch(Exception e){
            vRst = new ArrayList<Customfield>();
        }
        return vRst;
    }

    public Customfield customFieldPorNomeClasseNome(String nomeClasse, String nomeField, Empresa empresa) {
        List<Customfield> vRst;
        try {
            vRst = em.createNamedQuery("Customfield.findByNomeClasseNome")
                    .setParameter("nomeClasse", nomeClasse)
                    .setParameter("nomeCustomField", nomeClasse)
                    .setParameter("empresa", empresa)
                    .getResultList();
            return vRst.get(0);
        }catch(Exception e){
            return null;
        }
    }
    
}
