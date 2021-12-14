package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Configncm;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos
 */
@Service
public class ConfigncmFacade extends AbstractFacade<Configncm> {
    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfigncmFacade() {
        super(Configncm.class);
    }

    public List<Configncm> getListaNcm() {
        return em.createNamedQuery("Configncm.findAll")
                .getResultList();
    }

    public Configncm getConfigncmPorNcm(String ncm) {
        Configncm resultado = new Configncm();
        try {
            resultado = (Configncm) em.createNamedQuery("Configncm.findByNcm")
                    .setParameter("ncm", ncm).getSingleResult();
        } catch (Exception e) {
        }
        return resultado;
    }

}
