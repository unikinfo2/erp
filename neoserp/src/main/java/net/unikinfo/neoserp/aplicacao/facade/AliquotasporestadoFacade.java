package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Aliquotasporestado;
import net.unikinfo.neoserp.aplicacao.model.Estado;
import net.unikinfo.neoserp.aplicacao.repository.AliquotasporestadoRepository;

import java.util.ArrayList;
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
public class AliquotasporestadoFacade extends AbstractFacade {
    @Autowired
    private AliquotasporestadoRepository repository;
    

    public AliquotasporestadoFacade() {
    }
    
    public List<Aliquotasporestado> getAliquotasporestadoNcmUF(String ncm, Estado uf) {  
        List<Aliquotasporestado> resultado = new ArrayList<Aliquotasporestado>();
        try {
           resultado = repository.findByUfNcm(uf.getUf(), ncm);
        } catch(Exception e) {
        }
        return resultado;
    }
       
}
