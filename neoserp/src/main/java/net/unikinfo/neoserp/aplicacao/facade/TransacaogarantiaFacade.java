/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Transacao;
import net.unikinfo.neoserp.aplicacao.model.Transacaogarantia;
import net.unikinfo.neoserp.aplicacao.repository.TransacaogarantiaRepository;

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
public class TransacaogarantiaFacade extends AbstractFacade {
	
	@Autowired
	private TransacaogarantiaRepository rp;
	
    public TransacaogarantiaFacade() {
        
    }

    public List<Transacaogarantia> TransacaogarantiaPorTransacao(Transacao transacao) {        
        try {
            System.out.println("return facade -->> "+rp.findByTransacao(transacao));
            return rp.findByTransacao(transacao);
        } catch (Exception e) {
            return new ArrayList<Transacaogarantia>();
        }        
    }
}
