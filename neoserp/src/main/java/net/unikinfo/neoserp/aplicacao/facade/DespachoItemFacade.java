/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.OrdemDespacho;
import net.unikinfo.neoserp.aplicacao.model.OrdemDespachoItem;
import net.unikinfo.neoserp.aplicacao.model.Transacao;

/**
 *
 * @author Carlos
 */
@Service
public class DespachoItemFacade extends AbstractFacade {

    @Autowired
    private DespachoItemRepository rp;

    public DespachoItemFacade() {
    	
    }

    public List<OrdemDespachoItem> pegaODList() {
        return rp.findAll();
    }

    public List<OrdemDespachoItem> getODItemPorPedido(Transacao transacao) {
        try {
            return rp.findByPedido(transacao);
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    public List<OrdemDespachoItem> getODItemPorOrdemDespacho(OrdemDespacho ordemDespacho, Empresa empresa) {
        try {
            return rp.findByOrdemDespacho(ordemDespacho, empresa);
        } catch (Exception e) {
            return new ArrayList();
        }
    }
}
