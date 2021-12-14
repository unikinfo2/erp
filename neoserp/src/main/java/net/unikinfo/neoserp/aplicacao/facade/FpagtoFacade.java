/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Fpagto;
import net.unikinfo.neoserp.aplicacao.model.Produto;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class FpagtoFacade extends AbstractFacade<Fpagto> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FpagtoFacade() {
        super(Fpagto.class);
    }

    public List<Fpagto> pegaFpagtoList() {
        return em.createNamedQuery("Fpagto.findAll").getResultList();
    }

    public List<Fpagto> pegaFpagtoPorDescList(String descricao) {
        return em.createNamedQuery("Fpagto.findByDescricao").
                setParameter("descricao", descricao).getResultList();
    }
    
    public List<Fpagto> pegaFpagtoPorEmpresa(Long idEmpresa) {
        return em.createNamedQuery("Fpagto.findByIdEmpresa").
                setParameter("idEmpresa", idEmpresa).getResultList();
    }
}
