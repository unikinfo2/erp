/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Estado;
import net.unikinfo.neoserp.aplicacao.repository.EstadoRepository;

import java.util.ArrayList;
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
public class EstadoFacade extends AbstractFacade {
	
    @Autowired
    private EstadoRepository rp;

    public List<Estado> getEstadoporUf() {
        try {
           return rp.findAll();
        } catch (Exception e) {
            return new ArrayList<Estado>();
        }
      }     
    
    public Estado getEstadoporNomeUf(String uf) {
        try {
           return rp.findByUf(uf);
        } catch (Exception e) {
            return null;
        }
      }       

    public EstadoFacade() {

    }
    
}
