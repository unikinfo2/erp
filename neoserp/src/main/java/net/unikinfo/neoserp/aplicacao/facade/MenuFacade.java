/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Colaborador;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Menu;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class MenuFacade extends AbstractFacade<Menu> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menu.class);
    }

    public List<Menu> getMenuPorMenuPrincipal(Menu menuPrincipal) {  
           return em.createNamedQuery("Menu.findByMenuPrincipal")  
                     .setParameter("menuPrincipal", menuPrincipal ).getResultList();  
      }     
    
    public List<Menu> getMenuPorModulo(String modulo) {  
           return em.createNamedQuery("Menu.findByModulo")  
                     .setParameter("modulo", modulo)
                     .getResultList();  
      }
    
    public List<Menu> getMenuPorModulo(String modulo, Colaborador colaborador) {  
           return em.createNamedQuery("Menu.findByModulo2")  
                     .setParameter("modulo", modulo)
                     .setParameter("colaborador", colaborador)
                     .getResultList();  
      }
    
    public Menu getMenuPorNomeOpcao(String nomeOpcao) {  
        try{
           return (Menu) em.createNamedQuery("Menu.findByNomeOpcao")  
                     .setParameter("nomeOpcao", nomeOpcao)
                     .getSingleResult();
        } catch(Exception e) {
            return null;
        }
           
      }
    
    public Menu getMenuPorId(Integer pId) {  
        try{
           return (Menu) em.createNamedQuery("Menu.findByIdMenu")  
                     .setParameter("idMenu", pId)
                     .getSingleResult();
        } catch(Exception e) {
            return null;
        }
           
      }
    
}
