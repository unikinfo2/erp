/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Clifor;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class CliforFacade extends AbstractFacade<Clifor> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CliforFacade() {
        super(Clifor.class);
    }

    public List<Clifor> getCliforPorEmpresa(Empresa empresa) {
        return em.createNamedQuery("Clifor.findByEmpresa")
                .setParameter("empresa", empresa).getResultList();
    }

    public List<Clifor> getCliforPorEmpresaMatriz(Empresa matriz) {
        return em.createNamedQuery("Clifor.findByEmpresaMatriz")
                .setParameter("matriz", matriz).getResultList();
    }

    public List<Clifor> getCliforPorEmpresaFiltrado(Empresa empresa, String clienteFornecedor, String razaoCpfcnpj) {
        System.out.println("clienteFornecedor: "+clienteFornecedor);
        System.out.println("razaoCpfcnpj: "+razaoCpfcnpj);
        System.out.println("empresa: "+empresa);
        return em.createNamedQuery("Clifor.findByEmpresaFiltrado")
                .setParameter("empresa", empresa)
                .setParameter("clienteFornecedor1", clienteFornecedor)
                .setParameter("clienteFornecedor2", "A")
                .setParameter("razaoCpfcnpj", "%" + razaoCpfcnpj + "%").getResultList();
    }

    public List<Clifor> getCliforPorEmpresaMatrizFiltrado(Empresa matriz, String clienteFornecedor, String razaoCpfcnpj) {
        return em.createNamedQuery("Clifor.findByEmpresaMatrizFiltrado")
                .setParameter("matriz", matriz)
                .setParameter("clienteFornecedor1", clienteFornecedor)
                .setParameter("clienteFornecedor2", "A")
                .setParameter("razaoCpfcnpj", "%" + razaoCpfcnpj + "%").getResultList();
    }

    public List<Clifor> getCliforPorEmpresaFiltradoMensalidade(Empresa empresa, String clienteFornecedor, String razaoCpfcnpj) {
        List<Clifor> ret;
        try {
            ret = em.createNamedQuery("Clifor.findByEmpresaFiltradoMensalidade")
                    .setParameter("empresa", empresa)
                    .setParameter("clienteFornecedor1", clienteFornecedor)
                    .setParameter("clienteFornecedor2", "A")
                    .setParameter("razaoCpfcnpj", "%" + razaoCpfcnpj + "%").getResultList();
        } catch (Exception e) {
            ret = new ArrayList<Clifor>();
        }
        return ret;
    }

    public List<Clifor> getCliforPorEmpresaMatrizFiltradoMensalidade(Empresa matriz, String clienteFornecedor, String razaoCpfcnpj) {
        List<Clifor> ret;
        try {
            ret = em.createNamedQuery("Clifor.findByEmpresaMatrizFiltradoMensalidade")
                    .setParameter("matriz", matriz).
                    setParameter("clienteFornecedor", clienteFornecedor).
                    setParameter("razaoCpfcnpj", "%" + razaoCpfcnpj + "%").getResultList();
        } catch (Exception e) {
            ret = new ArrayList<Clifor>();
        }
        return ret;
    }

    public List<Clifor> getCliforPorId(Long idCliFor) {
        return em.createNamedQuery("Clifor.findByIdCliFor")
                .setParameter("idCliFor", idCliFor).getResultList();
    }

    public List<Clifor> getCliforPorEmpresaClifor(Empresa empresa, String clientefornecedor) {
        return em.createNamedQuery("Clifor.findByEmpresaClifor")
                .setParameter("empresa", empresa)
                .setParameter("clienteFornecedor1", clientefornecedor)
                .setParameter("clienteFornecedor2", "A")
                .getResultList();
    }

    public List<Clifor> getCliforPorRazaoSocialCliforEmpresa(Empresa empresa, String razaoSocial) {
        return em.createNamedQuery("Clifor.findByRazaoSocial")
                .setParameter("empresa", empresa)
                .setParameter("razaoSocial", razaoSocial).getResultList();
    }
    
 public List<Clifor> getCliforPorCliforGrupo(Empresa emp, Clifor cliforGrupo) {
        List<Clifor> ret;
        try {
            ret = em.createNamedQuery("Clifor.findByCliforGrupo")
                    .setParameter("empresa", emp).
                    setParameter("cliforGrupo", cliforGrupo).getResultList();
        } catch (Exception e) {
            ret = new ArrayList<Clifor>();
        }
        return ret;
    }    
}
