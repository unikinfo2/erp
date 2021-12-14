/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Colaborador;
import net.unikinfo.neoserp.aplicacao.model.Menu;
import net.unikinfo.neoserp.aplicacao.model.Menucolaborador;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class MenucolaboradorFacade extends AbstractFacade<Menucolaborador> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenucolaboradorFacade() {
        super(Menucolaborador.class);
    }
    
    public List<Menucolaborador> getMenucolaboradorPorMenu(Menu menu) {  
           return em.createNamedQuery("Menucolaborador.findByMenu")  
                     .setParameter("menu", menu ).getResultList();  
      }         
    
    public List<Menucolaborador> getMenucolaboradorPorColaborador(Colaborador colaborador) {  
           return em.createNamedQuery("Menucolaborador.findByColaborador")  
                     .setParameter("colaborador", colaborador ).getResultList();  
      }     

    public Menucolaborador getMenucolaboradorPorMenuColaborador(Menu menu, Colaborador colaborador) {  
        try{
           return (Menucolaborador) em.createNamedQuery("Menucolaborador.findByMenuColaborador")  
                     .setParameter("menu", menu )
                     .setParameter("colaborador", colaborador ).getSingleResult();  
        } catch (Exception e) {
            return null;
                }
      }     
    public Menucolaborador getMenucolaboradorPorIdMenuColaborador(Long menuColaborador) {  
        try{
           return (Menucolaborador) em.createNamedQuery("Menucolaborador.findByIdMenuColaborador")  
                     .setParameter("idMenuColaborador", menuColaborador ).getSingleResult();  
        } catch (Exception e) {
            return null;
                }
      }     


        
}
