/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.ClienteDoc;
import net.unikinfo.neoserp.aplicacao.model.Clifor;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Projeto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class ClientedocFacade extends AbstractFacade<ClienteDoc> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientedocFacade() {
        super(ClienteDoc.class);
    }

    public List<ClienteDoc> getClienteDocPorEmpresa(Empresa empresa) {
        try {
            return em.createNamedQuery("ClienteDoc.findByEmpresaSemData")
                    .setParameter("empresa", empresa).getResultList();
        } catch (Exception e) {
            return new ArrayList<ClienteDoc>();
        }
    }

    public List<ClienteDoc> getClienteDocPorClienteEmpresa(Empresa empresa, String clifor, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("ClienteDoc.findByEmpresaCliforRazao")
                    .setParameter("empresa", empresa)
                    .setParameter("dtInicio", dt1)
                    .setParameter("dtFinal", dt2)
                    .setParameter("clifor", "%" + clifor + "%").getResultList();
        } catch (Exception e) {
            return new ArrayList<ClienteDoc>();
        }
    }

    public List<ClienteDoc> getClienteDocPorEmpresa(Empresa empresa, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("ClienteDoc.findByEmpresa")
                    .setParameter("empresa", empresa)
                    .setParameter("dtInicio", dt1)
                    .setParameter("dtFinal", dt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<ClienteDoc>();
        }
    }

    public List<ClienteDoc> getClienteDocPorClienteEmpresaPeriodo(Empresa empresa, Clifor clifor, Date dtInicio, Date dtFinal) {
        try {
            return em.createNamedQuery("ClienteDoc.findByEmpresaClifor")
                    .setParameter("empresa", empresa)
                    .setParameter("clifor", clifor)
                    .setParameter("dtInicio", dtInicio)
                    .setParameter("dtFinal", dtFinal)
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<ClienteDoc>();
        }
    }

    public List<ClienteDoc> getClienteDocPorPrestacaocontas(Empresa empresa, Clifor clifor, Date dtInicio, Date dtFinal) {
        try {
            return em.createNamedQuery("ClienteDoc.findByEmpresaCliforPrestacaocontas")
                    .setParameter("empresa", empresa)
                    .setParameter("clifor", clifor)
                    .setParameter("dtInicio", dtInicio)
                    .setParameter("dtFinal", dtFinal)
                    .setParameter("prestacaocontas", "S")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<ClienteDoc>();
        }
    }
}
