/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Configdre;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.repository.ConfigdreRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos
 */
@Service
public class ConfigdreFacade extends AbstractFacade {
	
    @Autowired
    private ConfigdreRepository rp;

    public ConfigdreFacade() {
    	
    }
    
    public List<Configdre> getConfigdrePorEmpresa(Empresa empresa) {  
           return rp.findByEmpresa(empresa);  
      }     

}
