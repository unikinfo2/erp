/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Extrato;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class ExtratoFacade extends AbstractFacade<Extrato> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExtratoFacade() {
        super(Extrato.class);
    }
    
    public List<Extrato> pegaExtratoList() {
       return em.createNamedQuery("Extrato.findAll").getResultList();  
    }
    public List<Extrato> pegaExtratoPorEmpresa(Empresa empresa) {
       return em.createNamedQuery("Extrato.findByEmpresa")
               .setParameter("empresa", empresa).getResultList();  
    }
    
    
}
