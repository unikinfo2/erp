package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Transacaoitem;
import net.unikinfo.neoserp.aplicacao.model.Transacaoitemimposto;
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
public class TransacaoitemimpostoFacade extends AbstractFacade<Transacaoitemimposto> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransacaoitemimpostoFacade() {
        super(Transacaoitemimposto.class);
    }


    public List<Transacaoitemimposto> getTransacaoitemimpostoPorTransacaoItem(Transacaoitem trItem) {  
        List<Transacaoitemimposto> resultado;
        try {
           resultado =  em.createNamedQuery("Transacaoitemimposto.findByTransacaoItem")  
                    .setParameter("transacaoItem", trItem)
                    .getResultList();  
        } catch(Exception e) {
           resultado = new ArrayList<Transacaoitemimposto>();
        }
        return resultado;
    }
}
