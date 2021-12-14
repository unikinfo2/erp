/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "transacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacao.findAll", query = "SELECT t FROM Transacao t"),
    @NamedQuery(name = "Transacao.findByEmpresa", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa order by t.dataCriacao desc "),

    @NamedQuery(name = "Transacao.findByEmpresaPeriodoCriacao", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.dataCriacao between :dtInicio and :dtFim"),
    @NamedQuery(name = "Transacao.findByEmpresaPeriodoAlteracao", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.dataUltimaAlteracao between :dtInicio and :dtFim"),
    @NamedQuery(name = "Transacao.findByEmpresaPeriodoVencimento", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.dataVencimento between :dtInicio and :dtFim"),

    @NamedQuery(name = "Transacao.findByIdTransacao", query = "SELECT t FROM Transacao t WHERE t.idTransacao = :idTransacao"),
    @NamedQuery(name = "Transacao.findByTransacaoOrigem", query = "SELECT t FROM Transacao t WHERE t.transacao = :transacao"),
    @NamedQuery(name = "Transacao.findByStatusTransacao", query = "SELECT t FROM Transacao t WHERE t.statusTransacao = :statusTransacao"),
    @NamedQuery(name = "Transacao.findByDataCriacao", query = "SELECT t FROM Transacao t WHERE t.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "Transacao.findByDataUltimaAlteracao", query = "SELECT t FROM Transacao t WHERE t.dataUltimaAlteracao = :dataUltimaAlteracao"),
    @NamedQuery(name = "Transacao.findByDataVencimento", query = "SELECT t FROM Transacao t WHERE t.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "Transacao.findByValorTransacao", query = "SELECT t FROM Transacao t WHERE t.valorTransacao = :valorTransacao"),
    @NamedQuery(name = "Transacao.findByTipoTransacao", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and t.dataCriacao between :dt1 and :dt2 order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByCliforTipoTransacao", query = "SELECT t FROM Transacao t WHERE (t.clifor.razaoSocial like :clifor or t.clifor.cpfCnpj like :clifor) and t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and t.dataCriacao between :dt1 and :dt2 order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByTipoStatus", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.statusTransacao = :tipoStatus and t.dataCriacao between :dt1 and :dt2 order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByTipoStatusClifor", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and (t.clifor.razaoSocial like :clifor or t.clifor.cpfCnpj like :clifor) and t.statusTransacao = :tipoStatus and t.dataCriacao between :dt1 and :dt2 order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByTipoTransacaoEStatus", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and t.statusTransacao = :statusTransacao"),
    @NamedQuery(name = "Transacao.findByTipoTransacaoEStatusPeriodoCriacao", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and t.statusTransacao = :statusTransacao and t.dataCriacao between :dt1 and :dt2"),
    @NamedQuery(name = "Transacao.findByTipoTransacaoEStatusPeriodoVencto", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and t.statusTransacao = :statusTransacao and t.dataVencimento between :dt1 and :dt2"),
    @NamedQuery(name = "Transacao.findByTipoTransacaoCliforEStatusPeriodo", query = "SELECT t FROM Transacao t WHERE (t.clifor.razaoSocial like :clifor or t.clifor.cpfCnpj like :clifor) and t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and t.statusTransacao = :statusTransacao and t.dataVencimento between :dt1 and :dt2"),
    @NamedQuery(name = "Transacao.findByCliforTipoTransacaoStatusEmpresa", query = "SELECT t FROM Transacao t WHERE (t.clifor.razaoSocial like :clifor or t.clifor.cpfCnpj like :clifor) and t.empresa = :empresa and t.tipoTransacao in (:tipoTransacao1, :tipoTransacao2) and t.statusTransacao in (:statusTransacao1, :statusTransacao2) and t.dataCriacao between :dt1 and :dt2 order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByContaTipoTransacaoStatusEmpresa", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.contaDebito = :conta and t.tipoTransacao in (:tipoTransacao1, :tipoTransacao2) and t.statusTransacao in (:statusTransacao1, :statusTransacao2) and t.dataCriacao between :dt1 and :dt2 order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByTipoTransacaoStatusEmpresa", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao in (:tipoTransacao1, :tipoTransacao2) and t.statusTransacao in (:statusTransacao1, :statusTransacao2) and t.dataCriacao between :dt1 and :dt2 order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByTipoTransacaoStatusContaDebitoEmpresa", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and t.statusTransacao = :statusTransacao and t.contaDebito = :contadebito and t.dataVencimento between :dt1 and :dt2 order by t.dataVencimento desc "),
    @NamedQuery(name = "Transacao.findByTipoTransacaoStatusEmpresaRec", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao in (:tipoTransacao1, :tipoTransacao2) and t.statusTransacao in (:statusTransacao1, :statusTransacao2, :statusTransacao3) order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByContaTresTiposTransacaoStatusEmpresaRec", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.contaDebito = :conta and t.tipoTransacao in (:tipoTransacao1, :tipoTransacao2, :tipoTransacao3) and t.statusTransacao in (:statusTransacao1, :statusTransacao2, :statusTransacao3) and t.dataCriacao between :dt1 and :dt2 order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByTresTiposTransacaoStatusEmpresaRec", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao in (:tipoTransacao1, :tipoTransacao2, :tipoTransacao3) and t.statusTransacao in (:statusTransacao1, :statusTransacao2, :statusTransacao3) and t.dataCriacao between :dt1 and :dt2 order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByCliforTresTiposTransacaoStatusEmpresaRec", query = "SELECT t FROM Transacao t WHERE (t.clifor.razaoSocial like :clifor or t.clifor.cpfCnpj like :clifor) and t.empresa = :empresa and t.tipoTransacao in (:tipoTransacao1, :tipoTransacao2, :tipoTransacao3) and t.statusTransacao in (:statusTransacao1, :statusTransacao2, :statusTransacao3) and t.dataCriacao between :dt1 and :dt2 order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByContaStatusEmpresaRec", query = "SELECT t FROM Transacao t WHERE t.contaDebito = :contaRec and t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and t.statusTransacao = :statusTransacao and t.dataVencimento between :dt1 and :dt2 order by t.dataVencimento desc "),
    @NamedQuery(name = "Transacao.findByTipoTransacaoPorDoisTiposStatus", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and  t.statusTransacao in (:statusTransacao1, :statusTransacao2) and t.dataCriacao between :dtInicio and :dtFim order by t.dataCriacao desc "),

    @NamedQuery(name = "Transacao.findByTipoTransacaoPorTresTiposStatusCriacao", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and  t.statusTransacao in (:statusTransacao1, :statusTransacao2, :statusTransacao3) and t.dataCriacao between :dtInicio and :dtFim order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByCliforTipoTransacaoPorTresTiposStatusCriacao", query = "SELECT t FROM Transacao t WHERE (t.clifor.razaoSocial like :clifor or t.clifor.cpfCnpj like :clifor) and t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and  t.statusTransacao in (:statusTransacao1, :statusTransacao2, :statusTransacao3) and t.dataCriacao between :dtInicio and :dtFim order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByTipoTransacaoPorTresTiposStatusAlteracao", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and  t.statusTransacao in (:statusTransacao1, :statusTransacao2, :statusTransacao3) and t.dataUltimaAlteracao between :dtInicio and :dtFim order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByTipoTransacaoPorTresTiposStatusVencimento", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and  t.statusTransacao in (:statusTransacao1, :statusTransacao2, :statusTransacao3) and t.dataVencimento between :dtInicio and :dtFim order by t.dataCriacao desc "),

    @NamedQuery(name = "Transacao.findByTipoTransacaoPorQuatroTiposStatus", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.tipoTransacao in (:tipoTransacao, :tipoTransacao2) and  t.statusTransacao in (:statusTransacao1, :statusTransacao2, :statusTransacao3, :statusTransacao4) and t.dataCriacao between :dt1 and :dt2 order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByTipoTransacaoPorCliforQuatroTiposStatus", query = "SELECT t FROM Transacao t WHERE (t.clifor.razaoSocial like :clifor or t.clifor.cpfCnpj like :clifor) and t.empresa = :empresa and t.tipoTransacao = :tipoTransacao and  t.statusTransacao in (:statusTransacao1, :statusTransacao2, :statusTransacao3, :statusTransacao4) and t.dataCriacao between :dt1 and :dt2 order by t.dataCriacao desc "),
    @NamedQuery(name = "Transacao.findByValorDesconto", query = "SELECT t FROM Transacao t WHERE t.valorDesconto = :valorDesconto"),
    @NamedQuery(name = "Transacao.findByNumeroTransacao", query = "SELECT t FROM Transacao t WHERE t.numeroTransacao = :numeroTransacao and t.empresa = :empresa"),
    @NamedQuery(name = "Transacao.findByCentrocusto", query = "SELECT t FROM Transacao t WHERE t.centrocusto = :centrocusto"),
    @NamedQuery(name = "Transacao.findByObservacaoTransacao", query = "SELECT t FROM Transacao t WHERE t.observacaoTransacao = :observacaoTransacao"),
    @NamedQuery(name = "Transacao.findByEmpresaECliente", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.clifor = :clifor"),
    @NamedQuery(name = "Transacao.findByContaRecPorEmpresaEdup", query = "SELECT t FROM Transacao t WHERE t.empresa = :empresa and t.duplicata = :dup and t.transacao = :trorigem")})
public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransacao")
    private Long idTransacao;

    @Column(name = "statusTransacao")
    private String statusTransacao;
    @Column(name = "TipoEmissaoNF")
    private String tipoEmissaoNF;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "dataCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "dataUltimaAlteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVencimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorTransacao")
    private BigDecimal valorTransacao;
    @Column(name = "tipoTransacao")
    private String tipoTransacao;
    @Column(name = "valorDesconto")
    private BigDecimal valorDesconto;
    @Column(name = "numeroTransacao")
    private String numeroTransacao;
    @Column(name = "observacaoTransacao")
    private String observacaoTransacao;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "idCliFor", referencedColumnName = "idCliFor")
    @ManyToOne
    private Clifor clifor;
    @Column(name = "numeroNF")
    private String numeroNF;
    @JoinColumn(name = "idProjeto", referencedColumnName = "idProjeto")
    @ManyToOne
    private Projeto projeto;
    @JoinColumn(name = "idTransp", referencedColumnName = "idTransp")
    @ManyToOne
    private Transportadora transportadora;
    @JoinColumn(name = "idRepre", referencedColumnName = "idRepre")
    @ManyToOne
    private Representante representante;
    @JoinColumn(name = "idFPagto", referencedColumnName = "idFPagto")
    @ManyToOne
    private Fpagto fpagto;
    //@OneToMany(mappedBy = "transacao")
    //private List<Transacao> transacaoList;
    @JoinColumn(name = "idTransacaoOrigem", referencedColumnName = "idTransacao")
    @ManyToOne
    private Transacao transacao;
    @JoinColumn(name = "idEstagioTransacao", referencedColumnName = "idEstagioTransacao")
    @ManyToOne
    private Estagiotransacao estagiotransacao;
    @JoinColumn(name = "codigoOperacao", referencedColumnName = "codigoOperacao")
    @ManyToOne
    private Operacao operacao;
    @Column(name = "valorPago")
    private BigDecimal valorPago;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "transacao")
    //private List<Transacaocustomfieldvalue> transacaocustomfieldvalueList;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "transacao")
    //private List<Diario> diarioList;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "transacao")
    //private List<Transacaoitem> transacaoitemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transacao")
    private List<Transacaodup> transacaodupList;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "transacao")
    //private List<Transacaoimposto> transacaoimpostoList;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "transacao")
    //private List<Transacaoconta> transacaocontaList;

    @JoinColumn(name = "idContaDebito", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas contaDebito;

    @JoinColumn(name = "idContaCredito", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas contaCredito;

    @Column(name = "valorRetencao")
    private BigDecimal valorRetencao;

    @JoinColumn(name = "idCentroCusto", referencedColumnName = "idCentroCusto")
    @ManyToOne
    private Centrocusto centrocusto;
    @Column(name = "pdfNota")
    private String pdfNota;
    @JoinColumn(name = "idDup", referencedColumnName = "idDup")
    @ManyToOne
    private Transacaodup duplicata;
    @Column(name = "contasReceberGerado")
    private String contasReceberGerado;

    public Transacao() {
    }

    public Transacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Transacao(Long idTransacao, Date dataCriacao, Date dataUltimaAlteracao, Date dataVencimento) {
        this.idTransacao = idTransacao;
        this.dataCriacao = dataCriacao;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
        this.dataVencimento = dataVencimento;
    }

    public String getTipoEmissaoNF() {
        return tipoEmissaoNF;
    }

    public void setTipoEmissaoNF(String tipoEmissaoNF) {
        this.tipoEmissaoNF = tipoEmissaoNF;
    }

    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getStatusTransacao() {
        return statusTransacao;
    }

    public void setStatusTransacao(String statusTransacao) {
        this.statusTransacao = statusTransacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(BigDecimal valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getNumeroTransacao() {
        return numeroTransacao;
    }

    public void setNumeroTransacao(String numeroTransacao) {
        this.numeroTransacao = numeroTransacao;
    }

    public String getObservacaoTransacao() {
        return observacaoTransacao;
    }

    public void setObservacaoTransacao(String observacaoTransacao) {
        this.observacaoTransacao = observacaoTransacao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Clifor getClifor() {
        return clifor;
    }

    public void setClifor(Clifor clifor) {
        this.clifor = clifor;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public Fpagto getFpagto() {
        return fpagto;
    }

    public void setFpagto(Fpagto fpagto) {
        this.fpagto = fpagto;
    }

    /*@XmlTransient
     public List<Transacao> getTransacaoList() {
     return transacaoList;
     }

     public void setTransacaoList(List<Transacao> transacaoList) {
     this.transacaoList = transacaoList;
     }*/
    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public Estagiotransacao getEstagiotransacao() {
        return estagiotransacao;
    }

    public void setEstagiotransacao(Estagiotransacao estagiotransacao) {
        this.estagiotransacao = estagiotransacao;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Planocontas getContaDebito() {
        return contaDebito;
    }

    public void setContaDebito(Planocontas contaDebito) {
        this.contaDebito = contaDebito;
    }

    public Planocontas getContaCredito() {
        return contaCredito;
    }

    public void setContaCredito(Planocontas contaCredito) {
        this.contaCredito = contaCredito;
    }

    public BigDecimal getValorRetencao() {
        return valorRetencao;
    }

    public void setValorRetencao(BigDecimal valorRetencao) {
        this.valorRetencao = valorRetencao;
    }

    public Centrocusto getCentrocusto() {
        return centrocusto;
    }

    public void setCentrocusto(Centrocusto centrocusto) {
        this.centrocusto = centrocusto;
    }

    public String getPdfNota() {
        System.out.println("pdf da Nota = " + pdfNota);
        return pdfNota;
    }

    public void setPdfNota(String pdfNota) {
        this.pdfNota = pdfNota;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }


    /*@XmlTransient
     public List<Transacaocustomfieldvalue> getTransacaocustomfieldvalueList() {
     return transacaocustomfieldvalueList;
     }

     public void setTransacaocustomfieldvalueList(List<Transacaocustomfieldvalue> transacaocustomfieldvalueList) {
     this.transacaocustomfieldvalueList = transacaocustomfieldvalueList;
     }*/

    /*public List<Diario> getDiarioList() {
     return diarioList;
     }

     public void setDiarioList(List<Diario> diarioList) {
     this.diarioList = diarioList;
     }*/

    /*@XmlTransient
     public List<Transacaoimposto> getTransacaoimpostoList() {
     return transacaoimpostoList;
     }

     public void setTransacaoimpostoList(List<Transacaoimposto> transacaoimpostoList) {
     this.transacaoimpostoList = transacaoimpostoList;
     }*/

    /*@XmlTransient
     public List<Transacaoitem> getTransacaoitemList() {
     return transacaoitemList;
     }

     public void setTransacaoitemList(List<Transacaoitem> transacaoitemList) {
     this.transacaoitemList = transacaoitemList;
     }

     @XmlTransient
     public List<Transacaoconta> getTransacaocontaList() {
     return transacaocontaList;
     }

     public void setTransacaocontaList(List<Transacaoconta> transacaocontaList) {
     this.transacaocontaList = transacaocontaList;
     }*/
    @XmlTransient
    public List<Transacaodup> getTransacaodupList() {
        return transacaodupList;
    }

    public void setTransacaodupList(List<Transacaodup> transacaodupList) {
        this.transacaodupList = transacaodupList;
    }
    /*
     @XmlTransient
     public List<Transacaoconta> getTransacaocontaList() {
     return transacaocontaList;
     }*/
    /*
     public void setTransacaocontaList(List<Transacaoconta> transacaocontaList) {
     this.transacaocontaList = transacaocontaList;
     }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransacao != null ? idTransacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacao)) {
            return false;
        }
        Transacao other = (Transacao) object;
        if ((this.idTransacao == null && other.idTransacao != null) || (this.idTransacao != null && !this.idTransacao.equals(other.idTransacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idTransacao + "-" + numeroTransacao + "-" + estagiotransacao;
    }

    public String getNumeroNF() {
        return numeroNF;
    }

    public void setNumeroNF(String numeroNF) {
        this.numeroNF = numeroNF;
    }

    public Transacaodup getDuplicata() {
        return duplicata;
    }

    public void setDuplicata(Transacaodup duplicata) {
        this.duplicata = duplicata;
    }

    public String getContasReceberGerado() {
        return contasReceberGerado;
    }

    public void setContasReceberGerado(String contasReceberGerado) {
        this.contasReceberGerado = contasReceberGerado;
    }

}
