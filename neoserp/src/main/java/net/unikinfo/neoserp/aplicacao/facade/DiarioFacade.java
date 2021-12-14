/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.controller.Funcoes;
import net.unikinfo.neoserp.aplicacao.model.Diario;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.repository.DiarioRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class DiarioFacade extends AbstractFacade {
	
    private Funcoes funcoes;
    
    @Autowired
    private DiarioRepository rp;

    public DiarioFacade() {
    	
    }

    public List<Diario> getDiarioPorMesAno(Empresa empresa, int mes, int ano) {  
        funcoes = new Funcoes();
        Date dt1 = funcoes.getDataInicioFim(mes,ano, true); /*Primeiro dia do Mes*/
        Date dt2 = funcoes.getDataInicioFim(mes,ano, false); /*Ultimo dia do Mes*/
        return rp.findByPeriodo(empresa, dt1, dt2);  
      }     
    
    
}
