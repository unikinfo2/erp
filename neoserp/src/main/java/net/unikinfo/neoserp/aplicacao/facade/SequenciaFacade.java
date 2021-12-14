/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Sequencia;
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
public class SequenciaFacade extends AbstractFacade<Sequencia> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SequenciaFacade() {
        super(Sequencia.class);
    }

    public List<Sequencia> SequenciaFindAll() {
        List<Sequencia> resultSeq = new ArrayList<Sequencia>();
        try {
            resultSeq = em.createNamedQuery("Sequencia.findAll").getResultList();
        } catch (Exception e) {
            resultSeq = new ArrayList<Sequencia>();
        }
        return resultSeq;
    }

    public List<Sequencia> SequenciaEmpresa(Empresa empresa) {
        List<Sequencia> resultSeq = new ArrayList<Sequencia>();
        try {
            resultSeq = em.createNamedQuery("Sequencia.findByEmpresa")
                    .setParameter("empresa", empresa).getResultList();
        } catch (Exception e) {
            resultSeq = new ArrayList<Sequencia>();
        }
        return resultSeq;
    }    
    
    public Sequencia SequenciaPorNome(Empresa pEmp, String pTp) {
        List<Sequencia> retorno = new ArrayList<Sequencia>();;
        try {
            retorno = em.createNamedQuery("Sequencia.findByNomesequenciaEmpresa")
                    .setParameter("nomesequencia", pTp)
                    .setParameter("empresa", pEmp)
                    .getResultList();
            if(retorno.size() > 0){
                return retorno.get(0);
            } else {
                return new Sequencia();
            }
        } catch (Exception ex) {
            return new Sequencia();
        }
    }

}
