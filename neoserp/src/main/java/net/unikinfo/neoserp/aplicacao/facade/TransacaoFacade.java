/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Clifor;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Planocontas;
import net.unikinfo.neoserp.aplicacao.model.Transacao;
import net.unikinfo.neoserp.aplicacao.model.Transacaodup;
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
public class TransacaoFacade extends AbstractFacade<Transacao> {

    @PersistenceContext(unitName = "UnikServicosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransacaoFacade() {
        super(Transacao.class);
    }

    public Transacao editar(Transacao entity) {
        return getEntityManager().merge(entity);
    }

    public List<Transacao> getTransacaoPorTipoEStatusPeriodo(Empresa empresa, String tpTransacao, String tpTransacao2, String pStatus, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByTipoTransacaoEStatusPeriodoVencto")
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao", tpTransacao)
                    .setParameter("tipoTransacao", tpTransacao2)
                    .setParameter("statusTransacao", pStatus)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorCliforTipoEStatusPeriodo(String clifor, Empresa empresa, String tpTransacao, String pStatus, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByTipoTransacaoCliforEStatusPeriodo")
                    .setParameter("empresa", empresa)
                    .setParameter("clifor", "%" + clifor + "%")
                    .setParameter("tipoTransacao", tpTransacao)
                    .setParameter("statusTransacao", pStatus)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getContaReceberPorEmpresaDup(Empresa empresa, Transacaodup dup, Transacao trorigem) {
        try {
            return em.createNamedQuery("Transacao.findByContaRecPorEmpresaEdup")
                    .setParameter("empresa", empresa)
                    .setParameter("dup", dup)
                    .setParameter("trorigem", trorigem).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorTipoEStatus(Empresa empresa, String tpTransacao, String pStatus) {
        try {
            return em.createNamedQuery("Transacao.findByTipoTransacaoEStatus")
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao", tpTransacao)
                    .setParameter("statusTransacao", pStatus).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorContaTipoStatusEmpresa(Planocontas conta, Empresa empresa, String tp1, String tp2, String pStatus1, String pStatus2, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByContaTipoTransacaoStatusEmpresa")
                    .setParameter("conta", conta)
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao1", tp1)
                    .setParameter("tipoTransacao2", tp2)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorTipoStatusEmpresa(Empresa empresa, String tp1, String tp2, String pStatus1, String pStatus2, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByTipoTransacaoStatusEmpresa")
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao1", tp1)
                    .setParameter("tipoTransacao2", tp2)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorContaDebitoEmpresa(Empresa empresa, String tp, String pStatus, Planocontas contadebito, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByTipoTransacaoStatusContaDebitoEmpresa")
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao", tp)
                    .setParameter("statusTransacao", pStatus)
                    .setParameter("contadebito", contadebito)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorCliforTipoStatusEmpresa(String clifor, Empresa empresa, String tp1, String tp2, String pStatus1, String pStatus2, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByCliforTipoTransacaoStatusEmpresa")
                    .setParameter("clifor", "%" + clifor + "%")
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao1", tp1)
                    .setParameter("tipoTransacao2", tp2)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorDoisTipoTresStatusEmpresa(Empresa empresa, String tp1, String tp2, String pStatus1, String pStatus2, String pStatus3) {
        try {
            return em.createNamedQuery("Transacao.findByTipoTransacaoStatusEmpresaRec")
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao1", tp1)
                    .setParameter("tipoTransacao2", tp2)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("statusTransacao3", pStatus3).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorTresTipoTresStatusEmpresa(Empresa empresa, String tp1, String tp2, String tp3, String pStatus1, String pStatus2, String pStatus3, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByTresTiposTransacaoStatusEmpresaRec")
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao1", tp1)
                    .setParameter("tipoTransacao2", tp2)
                    .setParameter("tipoTransacao3", tp3)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("statusTransacao3", pStatus3)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorContaTresTipoTresStatusEmpresa(Planocontas conta, Empresa empresa, String tp1, String tp2, String tp3, String pStatus1, String pStatus2, String pStatus3, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByContaTresTiposTransacaoStatusEmpresaRec")
                    .setParameter("conta", conta)
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao1", tp1)
                    .setParameter("tipoTransacao2", tp2)
                    .setParameter("tipoTransacao3", tp3)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("statusTransacao3", pStatus3)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorContaStatusEmpresa(Planocontas contaRec, Empresa empresa, String tp, String pStatus, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByContaStatusEmpresaRec")
                    .setParameter("contaRec", contaRec)
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao", tp)
                    .setParameter("statusTransacao", pStatus)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }

    }

    public List<Transacao> getTransacaoPorCliforTresTipoTresStatusEmpresa(String clifor, Empresa empresa, String tp1, String tp2, String tp3, String pStatus1, String pStatus2, String pStatus3, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByCliforTresTiposTransacaoStatusEmpresaRec")
                    .setParameter("clifor", "%" + clifor + "%")
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao1", tp1)
                    .setParameter("tipoTransacao2", tp2)
                    .setParameter("tipoTransacao3", tp3)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("statusTransacao3", pStatus3)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }

    }

    public List<Transacao> getTransacaoPorDoisTiposStatus(Empresa empresa, String tp1, String pStatus1, String pStatus2, Date pDt1, Date pDt2) {
        try {
            return em.createNamedQuery("Transacao.findByTipoTransacaoPorDoisTiposStatus")
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao", tp1)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("dtInicio", pDt1)
                    .setParameter("dtFim", pDt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorTresTiposStatus(Empresa empresa, String tipo, String tp1, String pStatus1, String pStatus2, String pStatus3, Date pDt1, Date pDt2) {
        try {
            return em.createNamedQuery("Transacao.findByTipoTransacaoPorTresTiposStatus" + tipo)
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao", tp1)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("statusTransacao3", pStatus3)
                    .setParameter("dtInicio", pDt1)
                    .setParameter("dtFim", pDt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorCliforTresTiposStatus(Empresa empresa, String clifor, String tp1, String pStatus1, String pStatus2, String pStatus3, Date pDt1, Date pDt2) {
        try {
            return em.createNamedQuery("Transacao.findByCliforTipoTransacaoPorTresTiposStatusCriacao")
                    .setParameter("empresa", empresa)
                    .setParameter("clifor", "%" + clifor + "%")
                    .setParameter("tipoTransacao", tp1)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("statusTransacao3", pStatus3)
                    .setParameter("dtInicio", pDt1)
                    .setParameter("dtFim", pDt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorCliforTresTiposStatus(String clifor, Empresa empresa, String tipo, String tp1, String pStatus1, String pStatus2, String pStatus3, Date pDt1, Date pDt2) {
        try {
            return em.createNamedQuery("Transacao.findByCliforTipoTransacaoPorTresTiposStatus" + tipo)
                    .setParameter("empresa", empresa)
                    .setParameter("clifor", "%" + clifor + "%")
                    .setParameter("tipoTransacao", tp1)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("statusTransacao3", pStatus3)
                    .setParameter("dtInicio", pDt1)
                    .setParameter("dtFim", pDt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorQuatroTiposStatus(Empresa empresa, String tp1, String tp2, String pStatus1, String pStatus2, String pStatus3, String pStatus4, Date pDt1, Date pDt2) {
        List<Transacao> lst = new ArrayList<Transacao>();
        try {
            lst = em.createNamedQuery("Transacao.findByTipoTransacaoPorQuatroTiposStatus")
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao", tp1)
                    .setParameter("tipoTransacao2", tp2)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("statusTransacao3", pStatus3)
                    .setParameter("statusTransacao4", pStatus4)
                    .setParameter("dt1", pDt1)
                    .setParameter("dt2", pDt2).getResultList();
        } catch (Exception e) {
            System.out.println("Erro na pesquisa: "+e.getMessage());
        }
        return lst;
    }

    public List<Transacao> getTransacaoPorCliforQuatroTiposStatus(String clifor, Empresa empresa, String tp1, String pStatus1, String pStatus2, String pStatus3, String pStatus4, Date pDt1, Date pDt2) {
        try {
            return em.createNamedQuery("Transacao.findByTipoTransacaoPorCliforQuatroTiposStatus")
                    .setParameter("clifor", "%" + clifor + "%")
                    .setParameter("empresa", empresa)
                    .setParameter("tipoTransacao", tp1)
                    .setParameter("statusTransacao1", pStatus1)
                    .setParameter("statusTransacao2", pStatus2)
                    .setParameter("statusTransacao3", pStatus3)
                    .setParameter("statusTransacao4", pStatus4)
                    .setParameter("dt1", pDt1)
                    .setParameter("dt2", pDt2).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorEmpresa(Empresa empresa) {
        try {
            return em.createNamedQuery("Transacao.findByEmpresa")
                    .setParameter("empresa", empresa).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorEmpresaEPeriodo(Empresa empresa, String tipo, Date dtInicio, Date dtFim) {
        try {
            return em.createNamedQuery("Transacao.findByEmpresaPerido" + tipo)
                    .setParameter("empresa", empresa)
                    .setParameter("dtInicio", dtInicio)
                    .setParameter("dtFim", dtFim).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorTipoEmpresaEPeriodo(Empresa empresa, String tipo, Date dtInicio, Date dtFim) {
        try {
            return em.createNamedQuery("Transacao.findByEmpresaPeriodo" + tipo)
                    .setParameter("dtInicio", dtInicio)
                    .setParameter("dtFim", dtFim)
                    .setParameter("empresa", empresa).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorEmpresaEPeriodo(Empresa empresa, Date dtInicio, Date dtFim) {
        try {
            return em.createNamedQuery("Transacao.findByEmpresaPeriodo")
                    .setParameter("dtInicio", dtInicio)
                    .setParameter("dtFim", dtFim)
                    .setParameter("empresa", empresa).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorTipo(Empresa empresa, String tpTransacao, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByTipoTransacao")
                    .setParameter("empresa", empresa)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2)
                    .setParameter("tipoTransacao", tpTransacao).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorCliforETipo(String clifor, Empresa empresa, String tpTransacao, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByCliforTipoTransacao")
                    .setParameter("clifor", "%" + clifor + "%")
                    .setParameter("empresa", empresa)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2)
                    .setParameter("tipoTransacao", tpTransacao).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorStatus(Empresa empresa, String tpStatus, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByTipoStatus")
                    .setParameter("empresa", empresa)
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2)
                    .setParameter("tipoStatus", tpStatus).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorStatusClifor(Empresa empresa, String clifor, String tpStatus, Date dt1, Date dt2) {
        try {
            return em.createNamedQuery("Transacao.findByTipoStatusClifor")
                    .setParameter("empresa", empresa)
                    .setParameter("clifor", "%" + clifor + "%")
                    .setParameter("dt1", dt1)
                    .setParameter("dt2", dt2)
                    .setParameter("tipoStatus", tpStatus).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorNumeroTransacao(Empresa empresa, String numeroTransacao) {
        try {
            return em.createNamedQuery("Transacao.findByNumeroTransacao")
                    .setParameter("empresa", empresa)
                    .setParameter("numeroTransacao", numeroTransacao).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public Transacao getTransacaoPorId(Long idTransacao) {
        try {
            return (Transacao) em.createNamedQuery("Transacao.findByIdTransacao")
                    .setParameter("idTransacao", idTransacao).getSingleResult();
        } catch (Exception e) {
            return new Transacao();
        }
    }

    public List<Transacao> getTransacaoPorTransacaoOrigem(Transacao transacao) {
        try {
            return em.createNamedQuery("Transacao.findByTransacaoOrigem")
                    .setParameter("transacao", transacao).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoIn(String transacoes, String cpoOrdem) {
        try {
            String sql = "SELECT t FROM Transacao t WHERE t.idTransacao in (" + transacoes + ") ORDER BY t." + cpoOrdem + " ASC";
            return em.createQuery(sql).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

    public List<Transacao> getTransacaoPorEmpresaECliente(Empresa empresa, Clifor clifor) {
        try {
            return em.createNamedQuery("Transacao.findByEmpresaECliente")
                    .setParameter("empresa", empresa)
                    .setParameter("clifor", clifor).getResultList();
        } catch (Exception e) {
            return new ArrayList<Transacao>();
        }
    }

}
