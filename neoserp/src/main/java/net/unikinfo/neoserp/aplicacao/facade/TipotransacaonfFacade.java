/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Tipotransacaonf;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class TipotransacaonfFacade extends AbstractFacade<Tipotransacaonf> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipotransacaonfFacade() {
        super(Tipotransacaonf.class);
    }

    public List<Tipotransacaonf> ListTipoTransacaoNfPorEmpresa(BigInteger idEmpresa) {
        try {
            return em.createNamedQuery("Tipotransacaonf.findByIdEmpresa").
                    setParameter("idEmpresa", idEmpresa).getResultList();
        } catch (Exception e) {            
            return new ArrayList<Tipotransacaonf>();
        }
    }
}
