/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Boletobancario;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Transacaodup;
import net.unikinfo.neoserp.aplicacao.repository.BoletobancarioRepository;
import net.unikinfo.neoserp.aplicacao.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos
 */
@Service
public class BoletobancarioFacade extends AbstractFacade {

    @Autowired
    private BoletobancarioRepository rp;

    public BoletobancarioFacade() {
    }

    public List<Boletobancario> getBoletoPorEmpresa(Empresa empresa) {
        List<Boletobancario> listaBoleto;
        listaBoleto = rp.findByEmpresa(empresa);
        return listaBoleto;
    }

    public List<Boletobancario> getBoletoPorEmpresa2(Empresa empresa) {
        return rp.findByEmpresa(empresa);
    }

    public List<Boletobancario> getBoletoPorEmpresaEPeriodo(Empresa empresa, String tipo, Date dtInicio, Date dtFim) {
        return rp.findByEmpresaPeriodoVencimentoBoletobancarioEmissao( empresa, dtInicio, dtFim);
    }

    public List<Boletobancario> getBoletoPorEmpresaEPeriodoTipo(Empresa empresa, String tipo, Date dtInicio, Date dtFim) {
        System.out.println("Boletobancario.findByEmpresaPeriodoVencimentoBoletobancario" + tipo);
        return rp.findByEmpresaPeriodoVencimentoBoletobancarioEmissao(empresa, dtInicio, dtFim);
        //" + tipo)
    }

    public List<Boletobancario> getBoletoPorCliforEmpresaEPeriodoTipo(String clifor, Empresa empresa, String tipo, Date dtInicio, Date dtFim) {
        System.out.println("Boletobancario.findByCliforEmpresaPeriodoVencimentoBoletobancario" + tipo);
        if(clifor.trim().isEmpty()){
            return rp.findByEmpresaPeriodoVencimentoBoletobancarioEmissao(empresa, dtInicio, dtFim); //" + tipo)
        } else {
            return rp.findByCliforEmpresaPeriodoVencimentoBoletobancario("%"+clifor+"%", empresa, dtInicio, dtFim); // + tipo)
        }
    }

    public List<Boletobancario> getBoletosPorDuplicata(Transacaodup trDup) {
        List<Boletobancario> result;
        try {
            result = rp.findByTransacaodup(trDup);
        } catch (Exception e) {
            result = new ArrayList<Boletobancario>();
        }
        return result;
    }
    
    public List<Boletobancario> getBoletosPorDuplicataSemDtPagto(Transacaodup trDup) {
        List<Boletobancario> result;
        try {
            result = rp.findByTransacaodupSemDtPagto(trDup);
        } catch (Exception e) {
            result = new ArrayList<Boletobancario>();
        }        
        return result;
    }        

}
