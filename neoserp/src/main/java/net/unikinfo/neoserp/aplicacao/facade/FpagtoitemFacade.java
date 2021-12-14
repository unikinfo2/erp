/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Fpagto;
import net.unikinfo.neoserp.aplicacao.model.Fpagtoitem;
import net.unikinfo.neoserp.aplicacao.repository.FpagtoitemRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class FpagtoitemFacade extends AbstractFacade {
	
    @Autowired
    private FpagtoitemRepository rp;
    
    

    public FpagtoitemFacade() {

    }
    
    public List<Fpagtoitem> getItemPorFpagto(Fpagto fpagto) {  
           return rp.findByFPagto(fpagto);  
      }        
}
