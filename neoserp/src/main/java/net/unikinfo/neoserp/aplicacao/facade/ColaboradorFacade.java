/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Colaborador;
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
public class ColaboradorFacade extends AbstractFacade<Colaborador> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<Colaborador> getColaboradorPorEmpresa(Empresa empresa) {
        List<Colaborador> ret;
        try{
           ret = em.createNamedQuery("Colaborador.findByEmpresa")  
                     .setParameter("empresa", empresa)
                     //.setParameter("ativo", "S")
                     .getResultList();  
        } catch(Exception e){
           ret = new ArrayList<Colaborador>();
        }
        return ret;
      }

    public List<Colaborador> getColaboradorPorUsuario(String nomeUsuario) {  
        try{
           return em.createNamedQuery("Colaborador.findByNomeUsuario")  
                     .setParameter("nomeUsuario", nomeUsuario)                     
                     .getResultList();  
        } catch(Exception e){
           return new ArrayList<Colaborador>();
        }
      }        
    
    public ColaboradorFacade() {
        super(Colaborador.class);
    }
    
}
