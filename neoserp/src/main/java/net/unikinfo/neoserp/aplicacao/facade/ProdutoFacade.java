/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Produto;
import net.unikinfo.neoserp.aplicacao.repository.ProdutoRepository;

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
public class ProdutoFacade extends AbstractFacade {
	
    @Autowired
    private ProdutoRepository rp;

    public List<Produto> getProdutoPorEmpresa(Empresa empresa) {  
           return rp.findAllByEmpresa(empresa);  
    }
    
    public List<Produto> getProdutoPorDescricaoEEmpresa(String descricao, Empresa empresa) {  
           return rp.findByDescricao(empresa, descricao);  
    }
    
    public List<Produto> getProdutoPorEmpresaMatriz(Empresa matriz) {  
           return rp.findByEmpresaMatriz(matriz);  
    }     
    
    public Produto getProdutoPorCodBarras(String codigoBarras, Empresa empresa) {
        try {
        	List<Produto> lst = rp.findByCodigoBarras(empresa, codigoBarras);
            return lst.get(0);
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Produto> getProdutoPorCodAuxiliar(String codigoAux) {  
        try{
        	return rp.findByCodigoAux(codigoAux);              
        }catch(Exception e){
            return new ArrayList<>();
        }   
      }
    
    public ProdutoFacade() {
    	
    }
    
}
