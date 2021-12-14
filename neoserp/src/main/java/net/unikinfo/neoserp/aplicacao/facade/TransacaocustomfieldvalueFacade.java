/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Customfield;
import net.unikinfo.neoserp.aplicacao.model.Transacaocustomfieldvalue;
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
public class TransacaocustomfieldvalueFacade extends AbstractFacade<Transacaocustomfieldvalue> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransacaocustomfieldvalueFacade() {
        super(Transacaocustomfieldvalue.class);
    }

    public List<Transacaocustomfieldvalue> getcfValuePorId(Long idObjeto, String nomeClasse) {
        List<Transacaocustomfieldvalue> vRst;
        try {
            vRst = em.createNamedQuery("Transacaocustomfieldvalue.findByIdENomeClasse")
                    .setParameter("idObjeto", idObjeto)
                    .setParameter("nomeClasse", nomeClasse).getResultList();

        } catch (Exception e) {
            vRst = new ArrayList<Transacaocustomfieldvalue>();
        }
        return vRst;
    }

    public List<Transacaocustomfieldvalue> getCustomFieldValuePorIdObjetoNomeClasseField(Long idObjeto, Customfield cf) {
        List<Transacaocustomfieldvalue> vRst = new ArrayList<Transacaocustomfieldvalue>();
        try {
            
            vRst = em.createNamedQuery("Transacaocustomfieldvalue.findByIdENomeClasseCustofield")
                    .setParameter("idObjeto", idObjeto)
                    .setParameter("customfield", cf)
                    .getResultList();

        } catch (Exception e) {
            vRst = new ArrayList<Transacaocustomfieldvalue>();
        }
        return vRst;
    }

    public List<Transacaocustomfieldvalue> cfValuePorCustomField(Customfield customfield) {
        return em.createNamedQuery("Transacaocustomfieldvalue.findByCustomField")
                .setParameter("customfield", customfield).getResultList();
    }
}
