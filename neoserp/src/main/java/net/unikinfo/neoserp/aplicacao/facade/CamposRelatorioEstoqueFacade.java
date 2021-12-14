/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.CamposRelatorioEstoque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bruno Gomes
 */
public class CamposRelatorioEstoqueFacade extends AbstractFacade<CamposRelatorioEstoque> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CamposRelatorioEstoqueFacade() {
        super(CamposRelatorioEstoque.class);
    }

}
