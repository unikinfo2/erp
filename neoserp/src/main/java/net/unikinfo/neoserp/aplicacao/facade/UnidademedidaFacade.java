/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Unidademedida;
import net.unikinfo.neoserp.aplicacao.repository.UnidademedidaRepository;

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
public class UnidademedidaFacade extends AbstractFacade {
    @Autowired
    private UnidademedidaRepository rp;


    public UnidademedidaFacade() {

    }

    public List<Unidademedida> getListaUnidademedida() {
        return rp.findAll();
    }
    public Unidademedida getListaUnidademedidaPorCod(String codUniMed) {
        return rp.findByCodUniMed(codUniMed);
    }   
}
