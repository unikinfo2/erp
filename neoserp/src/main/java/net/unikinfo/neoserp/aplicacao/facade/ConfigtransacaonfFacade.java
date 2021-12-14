package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Configtransacaonf;
import net.unikinfo.neoserp.aplicacao.model.Tipotransacaonf;
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
public class ConfigtransacaonfFacade extends AbstractFacade<Configtransacaonf> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfigtransacaonfFacade() {
        super(Configtransacaonf.class);
    }
    
    public List <Configtransacaonf> ListaConfigTransacaoNf() {  
           return  em.createNamedQuery("Configtransacaonf.findAll").getResultList();  
    } 
    
    public Configtransacaonf getConfigTransacaoNf(String ncm, Tipotransacaonf tipotransacaonf) {  
        Configtransacaonf resultado = new Configtransacaonf();
        try {
           resultado = (Configtransacaonf) em.createNamedQuery("Configtransacaonf.findByNcmTipo")  
                    .setParameter("ncm", ncm)
                    .setParameter("tipoTransacaoNF", tipotransacaonf)
                    .getResultList().get(0);  
        } catch(Exception e) {
        }
        return resultado;
    }
       
}
