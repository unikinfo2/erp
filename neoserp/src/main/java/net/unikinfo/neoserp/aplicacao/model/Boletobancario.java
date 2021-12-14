/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "boleto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boletobancario.findAll", query = "SELECT b FROM Boletobancario b"),
    @NamedQuery(name = "Boletobancario.findByIdBoleto", query = "SELECT b FROM Boletobancario b WHERE b.idBoleto = :idBoleto"),
    @NamedQuery(name = "Boletobancario.findByEmpresa", query = "SELECT b FROM Boletobancario b WHERE b.empresa = :empresa order by b.dtDocumento desc"),
    @NamedQuery(name = "Boletobancario.findByEmpresa2", query = "SELECT b FROM Boletobancario b WHERE b.empresa = :empresa ORDER BY b.dtDocumento DESC"),
    @NamedQuery(name = "Boletobancario.findByCodigoBanco", query = "SELECT b FROM Boletobancario b WHERE b.codigoBanco = :codigoBanco"),
    @NamedQuery(name = "Boletobancario.findByNumeroBoleto", query = "SELECT b FROM Boletobancario b WHERE b.numeroBoleto = :numeroBoleto"),
    @NamedQuery(name = "Boletobancario.findByAgencia", query = "SELECT b FROM Boletobancario b WHERE b.agencia = :agencia"),
    @NamedQuery(name = "Boletobancario.findByDtVencimento", query = "SELECT b FROM Boletobancario b WHERE b.dtVencimento = :dtVencimento"),
    @NamedQuery(name = "Boletobancario.findByDtProcessamento", query = "SELECT b FROM Boletobancario b WHERE b.dtProcessamento = :dtProcessamento"),
    @NamedQuery(name = "Boletobancario.findByDtDocumento", query = "SELECT b FROM Boletobancario b WHERE b.dtDocumento = :dtDocumento"),
    @NamedQuery(name = "Boletobancario.findByCarteira", query = "SELECT b FROM Boletobancario b WHERE b.carteira = :carteira"),
    @NamedQuery(name = "Boletobancario.findByNumeroDocumento", query = "SELECT b FROM Boletobancario b WHERE b.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Boletobancario.findByEspecieDocumento", query = "SELECT b FROM Boletobancario b WHERE b.especieDocumento = :especieDocumento"),
    @NamedQuery(name = "Boletobancario.findByEspecie", query = "SELECT b FROM Boletobancario b WHERE b.especie = :especie"),
    @NamedQuery(name = "Boletobancario.findByValorBoleto", query = "SELECT b FROM Boletobancario b WHERE b.valorBoleto = :valorBoleto"),
    @NamedQuery(name = "Boletobancario.findByTarifaCobranca", query = "SELECT b FROM Boletobancario b WHERE b.tarifaCobranca = :tarifaCobranca"),
    @NamedQuery(name = "Boletobancario.findByOutrasDespesas", query = "SELECT b FROM Boletobancario b WHERE b.outrasDespesas = :outrasDespesas"),
    @NamedQuery(name = "Boletobancario.findByJurosDescontoCartorio", query = "SELECT b FROM Boletobancario b WHERE b.jurosDescontoCartorio = :jurosDescontoCartorio"),
    @NamedQuery(name = "Boletobancario.findByMultaCobrada", query = "SELECT b FROM Boletobancario b WHERE b.multaCobrada = :multaCobrada"),
    @NamedQuery(name = "Boletobancario.findByAbatimento", query = "SELECT b FROM Boletobancario b WHERE b.abatimento = :abatimento"),
    @NamedQuery(name = "Boletobancario.findByValorCobrado", query = "SELECT b FROM Boletobancario b WHERE b.valorCobrado = :valorCobrado"),
    @NamedQuery(name = "Boletobancario.findByJurosMora", query = "SELECT b FROM Boletobancario b WHERE b.jurosMora = :jurosMora"),
    @NamedQuery(name = "Boletobancario.findByOutrosCreditos", query = "SELECT b FROM Boletobancario b WHERE b.outrosCreditos = :outrosCreditos"),
    @NamedQuery(name = "Boletobancario.findByNossoNumero", query = "SELECT b FROM Boletobancario b WHERE b.nossoNumero = :nossoNumero"),
    @NamedQuery(name = "Boletobancario.findByNossoNumeroCedenteEmp", query = "SELECT b FROM Boletobancario b WHERE b.nossoNumero = :nossoNumero AND b.cedentebancario = :cedentebancario AND b.empresa = :empresa"),
    @NamedQuery(name = "Boletobancario.findByDtPagamento", query = "SELECT b FROM Boletobancario b WHERE b.dtPagamento = :dtPagamento"),
    @NamedQuery(name = "Boletobancario.findByTransportado", query = "SELECT b FROM Boletobancario b WHERE b.transportado = :transportado"),
    @NamedQuery(name = "Boletobancario.findByDescontoBoleto", query = "SELECT b FROM Boletobancario b WHERE b.descontoBoleto = :descontoBoleto"),
    @NamedQuery(name = "Boletobancario.findByInstruncaoBoleto", query = "SELECT b FROM Boletobancario b WHERE b.instrucaoBoleto = :instrucaoBoleto"),
    @NamedQuery(name = "Boletobancario.findByPorcentagemMulta", query = "SELECT b FROM Boletobancario b WHERE b.porcentagemMulta = :porcentagemMulta"),
    @NamedQuery(name = "Boletobancario.findByPorcentagemJurosDiario", query = "SELECT b FROM Boletobancario b WHERE b.porcentagemJurosDiario = :porcentagemJurosDiario"),
    @NamedQuery(name = "Boletobancario.findByNumeroPagamento", query = "SELECT b FROM Boletobancario b WHERE b.numeroPagamento = :numeroPagamento"),
    @NamedQuery(name = "Boletobancario.findByImprimirInstrucoes", query = "SELECT b FROM Boletobancario b WHERE b.imprimirInstrucoes = :imprimirInstrucoes"),
    @NamedQuery(name = "Boletobancario.findByDtDesconto", query = "SELECT b FROM Boletobancario b WHERE b.dtDesconto = :dtDesconto"),
    @NamedQuery(name = "Boletobancario.findByLinkNfse", query = "SELECT b FROM Boletobancario b WHERE b.linkNfse = :linkNfse"),
    @NamedQuery(name = "Boletobancario.findByEmailBoleto", query = "SELECT b FROM Boletobancario b WHERE b.emailBoleto = :emailBoleto"),
    @NamedQuery(name = "Boletobancario.findByReducaoValor", query = "SELECT b FROM Boletobancario b WHERE b.reducaoValor = :reducaoValor"),
    @NamedQuery(name = "Boletobancario.findByHistoricoReducao", query = "SELECT b FROM Boletobancario b WHERE b.historicoReducao = :historicoReducao"),
    @NamedQuery(name = "Boletobancario.findByUltimaRemessa", query = "SELECT b FROM Boletobancario b WHERE b.ultimaRemessa = :ultimaRemessa"),

    @NamedQuery(name = "Boletobancario.findByEmpresaPeriodoCriacaoBoletobancario", query = "SELECT b FROM Boletobancario b WHERE b.empresa = :empresa and b.dtDocumento between :dtInicio and :dtFim ORDER BY b.dtDocumento DESC"),
    @NamedQuery(name = "Boletobancario.findByCliforEmpresaPeriodoCriacaoBoletobancario", query = "SELECT b FROM Boletobancario b WHERE (b.clifor.razaoSocial like :clifor or b.clifor.cpfCnpj like :clifor) and b.empresa = :empresa and b.dtDocumento between :dtInicio and :dtFim ORDER BY b.dtDocumento DESC"),
    @NamedQuery(name = "Boletobancario.findByEmpresaPeriodoVencimentoBoletobancarioVencto", query = "SELECT b FROM Boletobancario b WHERE b.empresa = :empresa and b.dtVencimento between :dtInicio and :dtFim ORDER BY b.dtVencimento DESC"),
    @NamedQuery(name = "Boletobancario.findByEmpresaPeriodoVencimentoBoletobancarioEmissao", query = "SELECT b FROM Boletobancario b WHERE b.empresa = :empresa and b.dtDocumento between :dtInicio and :dtFim ORDER BY b.dtVencimento DESC"),
    @NamedQuery(name = "Boletobancario.findByEmpresaPeriodoVencimentoBoletobancario", query = "SELECT b FROM Boletobancario b WHERE b.empresa = :empresa and b.dtVencimento between :dtInicio and :dtFim ORDER BY b.dtVencimento DESC"),
    @NamedQuery(name = "Boletobancario.findByCliforEmpresaPeriodoVencimentoBoletobancario", query = "SELECT b FROM Boletobancario b WHERE (b.clifor.razaoSocial like :clifor or b.clifor.cpfCnpj like :clifor) and b.empresa = :empresa and b.dtVencimento between :dtInicio and :dtFim ORDER BY b.dtVencimento DESC"),
    @NamedQuery(name = "Boletobancario.findByCliforEmpresaPeriodoVencimentoBoletobancarioVencto", query = "SELECT b FROM Boletobancario b WHERE (b.clifor.razaoSocial like :clifor or b.clifor.cpfCnpj like :clifor) and b.empresa = :empresa and b.dtVencimento between :dtInicio and :dtFim ORDER BY b.dtVencimento DESC"),
    @NamedQuery(name = "Boletobancario.findByCliforEmpresaPeriodoVencimentoBoletobancarioEmissao", query = "SELECT b FROM Boletobancario b WHERE (b.clifor.razaoSocial like :clifor or b.clifor.cpfCnpj like :clifor) and b.empresa = :empresa and b.dtDocumento between :dtInicio and :dtFim ORDER BY b.dtVencimento DESC"),
    @NamedQuery(name = "Boletobancario.findByTransacaodupSemDtPagto", query = "SELECT b FROM Boletobancario b WHERE b.transacaodup=:transacaodup"),
    @NamedQuery(name = "Boletobancario.findByTransacaodup", query = "SELECT b FROM Boletobancario b WHERE b.transacaodup=:transacaodup and b.dtPagamento is not null ORDER BY b.dtVencimento DESC")})

public class Boletobancario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBoleto")
    private Long idBoleto;
    @Column(name = "codigoBanco")
    private BigInteger codigoBanco;
    @Column(name = "numeroBoleto")
    private BigInteger numeroBoleto;
    //@Size(max = 50)
    @Column(name = "agencia")
    private String agencia;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "dtVencimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtVencimento;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "dtProcessamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtProcessamento;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "dtDocumento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDocumento;
    @Column(name = "carteira")
    private BigInteger carteira;
    //@Size(max = 30)
    @Column(name = "numeroDocumento")
    private String numeroDocumento;
    //@Size(max = 30)
    @Column(name = "especieDocumento")
    private String especieDocumento;
    @Column(name = "especie")
    private Character especie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorBoleto")
    private BigDecimal valorBoleto;
    @Column(name = "tarifaCobranca")
    private BigDecimal tarifaCobranca;
    @Column(name = "outrasDespesas")
    private BigDecimal outrasDespesas;
    @Column(name = "jurosDescontoCartorio")
    private BigDecimal jurosDescontoCartorio;
    @Column(name = "multaCobrada")
    private BigDecimal multaCobrada;
    @Column(name = "abatimento")
    private BigDecimal abatimento;
    @Column(name = "valorCobrado")
    private BigDecimal valorCobrado;
    @Column(name = "jurosMora")
    private BigDecimal jurosMora;
    @Column(name = "outrosCreditos")
    private BigDecimal outrosCreditos;
    //@Size(max = 30)
    @Column(name = "nossoNumero")
    private String nossoNumero;
    @Basic(optional = false)
    @Column(name = "dtPagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPagamento;
    //@Size(max = 1)
    @Column(name = "transportado")
    private String transportado;
    @Column(name = "descontoBoleto")
    private BigDecimal descontoBoleto;
    //@Size(max = 200)
    @Column(name = "instrucaoBoleto")
    private String instrucaoBoleto;
    //@Size(max = 200)
    @Column(name = "instrucaoBoleto2")
    private String instrucaoBoleto2;
    @Column(name = "porcentagemMulta")
    private BigDecimal porcentagemMulta;
    @Column(name = "porcentagemJurosDiario")
    private BigDecimal porcentagemJurosDiario;
    @Column(name = "numeroPagamento")
    private BigInteger numeroPagamento;
    //@Size(max = 1)
    @Column(name = "imprimirInstrucoes")
    private String imprimirInstrucoes;
    //@Basic(optional = false)
    @Column(name = "dtDesconto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDesconto;
    //@Size(max = 200)
    @Column(name = "linkNfse")
    private String linkNfse;
    //@Size(max = 500)
    @Column(name = "emailBoleto")
    private String emailBoleto;
    @Column(name = "reducaoValor")
    private BigDecimal reducaoValor;
    //@Size(max = 250)
    @Column(name = "historicoReducao")
    private String historicoReducao;
    //@Size(max = 100)
    @Column(name = "ultimaRemessa")
    private String ultimaRemessa;
    @JoinColumn(name = "idCedente", referencedColumnName = "idCedente")
    @ManyToOne
    private Cedentebancario cedentebancario;
    @JoinColumn(name = "idCliFor", referencedColumnName = "idCliFor")
    @ManyToOne
    private Clifor clifor;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "idDup", referencedColumnName = "idDup")
    @ManyToOne
    private Transacaodup transacaodup;

    public Boletobancario() {
    }

    public Boletobancario(Long idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Boletobancario(Long idBoleto, Date dtVencimento, Date dtProcessamento, Date dtDocumento, Date dtPagamento, Date dtDesconto) {
        this.idBoleto = idBoleto;
        this.dtVencimento = dtVencimento;
        this.dtProcessamento = dtProcessamento;
        this.dtDocumento = dtDocumento;
        this.dtPagamento = dtPagamento;
        this.dtDesconto = dtDesconto;
    }

    public Long getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Long idBoleto) {
        this.idBoleto = idBoleto;
    }

    public BigInteger getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(BigInteger codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public BigInteger getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(BigInteger numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Date getDtProcessamento() {
        return dtProcessamento;
    }

    public void setDtProcessamento(Date dtProcessamento) {
        this.dtProcessamento = dtProcessamento;
    }

    public Date getDtDocumento() {
        return dtDocumento;
    }

    public void setDtDocumento(Date dtDocumento) {
        this.dtDocumento = dtDocumento;
    }

    public BigInteger getCarteira() {
        return carteira;
    }

    public void setCarteira(BigInteger carteira) {
        this.carteira = carteira;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEspecieDocumento() {
        return especieDocumento;
    }

    public void setEspecieDocumento(String especieDocumento) {
        this.especieDocumento = especieDocumento;
    }

    public Character getEspecie() {
        return especie;
    }

    public void setEspecie(Character especie) {
        this.especie = especie;
    }

    public BigDecimal getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(BigDecimal valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

    public BigDecimal getTarifaCobranca() {
        return tarifaCobranca;
    }

    public void setTarifaCobranca(BigDecimal tarifaCobranca) {
        this.tarifaCobranca = tarifaCobranca;
    }

    public BigDecimal getOutrasDespesas() {
        return outrasDespesas;
    }

    public void setOutrasDespesas(BigDecimal outrasDespesas) {
        this.outrasDespesas = outrasDespesas;
    }

    public BigDecimal getJurosDescontoCartorio() {
        return jurosDescontoCartorio;
    }

    public void setJurosDescontoCartorio(BigDecimal jurosDescontoCartorio) {
        this.jurosDescontoCartorio = jurosDescontoCartorio;
    }

    public BigDecimal getMultaCobrada() {
        return multaCobrada;
    }

    public void setMultaCobrada(BigDecimal multaCobrada) {
        this.multaCobrada = multaCobrada;
    }

    public BigDecimal getAbatimento() {
        return abatimento;
    }

    public void setAbatimento(BigDecimal abatimento) {
        this.abatimento = abatimento;
    }

    public BigDecimal getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(BigDecimal valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public BigDecimal getJurosMora() {
        return jurosMora;
    }

    public void setJurosMora(BigDecimal jurosMora) {
        this.jurosMora = jurosMora;
    }

    public BigDecimal getOutrosCreditos() {
        return outrosCreditos;
    }

    public void setOutrosCreditos(BigDecimal outrosCreditos) {
        this.outrosCreditos = outrosCreditos;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public String getTransportado() {
        return transportado;
    }

    public void setTransportado(String transportado) {
        this.transportado = transportado;
    }

    public BigDecimal getDescontoBoleto() {
        return descontoBoleto;
    }

    public void setDescontoBoleto(BigDecimal descontoBoleto) {
        this.descontoBoleto = descontoBoleto;
    }

    public String getInstrucaoBoleto() {
        return instrucaoBoleto;
    }

    public void setInstrucaoBoleto(String instrucaoBoleto) {
        this.instrucaoBoleto = instrucaoBoleto;
    }

    public BigDecimal getPorcentagemMulta() {
        return porcentagemMulta;
    }

    public void setPorcentagemMulta(BigDecimal porcentagemMulta) {
        this.porcentagemMulta = porcentagemMulta;
    }

    public BigDecimal getPorcentagemJurosDiario() {
        return porcentagemJurosDiario;
    }

    public void setPorcentagemJurosDiario(BigDecimal porcentagemJurosDiario) {
        this.porcentagemJurosDiario = porcentagemJurosDiario;
    }

    public BigInteger getNumeroPagamento() {
        return numeroPagamento;
    }

    public void setNumeroPagamento(BigInteger numeroPagamento) {
        this.numeroPagamento = numeroPagamento;
    }

    public String getImprimirInstrucoes() {
        return imprimirInstrucoes;
    }

    public void setImprimirInstrucoes(String imprimirInstrucoes) {
        this.imprimirInstrucoes = imprimirInstrucoes;
    }

    public Date getDtDesconto() {
        return dtDesconto;
    }

    public void setDtDesconto(Date dtDesconto) {
        this.dtDesconto = dtDesconto;
    }

    public String getLinkNfse() {
        return linkNfse;
    }

    public void setLinkNfse(String linkNfse) {
        this.linkNfse = linkNfse;
    }

    public String getEmailBoleto() {
        return emailBoleto;
    }

    public void setEmailBoleto(String emailBoleto) {
        this.emailBoleto = emailBoleto;
    }

    public BigDecimal getReducaoValor() {
        return reducaoValor;
    }

    public void setReducaoValor(BigDecimal reducaoValor) {
        this.reducaoValor = reducaoValor;
    }

    public String getHistoricoReducao() {
        return historicoReducao;
    }

    public void setHistoricoReducao(String historicoReducao) {
        this.historicoReducao = historicoReducao;
    }

    public String getUltimaRemessa() {
        return ultimaRemessa;
    }

    public void setUltimaRemessa(String ultimaRemessa) {
        this.ultimaRemessa = ultimaRemessa;
    }

    public Cedentebancario getCedentebancario() {
        return cedentebancario;
    }

    public void setCedentebancario(Cedentebancario cedentebancario) {
        this.cedentebancario = cedentebancario;
    }

    public Clifor getClifor() {
        return clifor;
    }

    public void setClifor(Clifor clifor) {
        this.clifor = clifor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Transacaodup getTransacaodup() {
        return transacaodup;
    }

    public void setTransacaodup(Transacaodup transacaodup) {
        this.transacaodup = transacaodup;
    }

    public String getInstrucaoBoleto2() {
        return instrucaoBoleto2;
    }

    public void setInstrucaoBoleto2(String instrucaoBoleto2) {
        this.instrucaoBoleto2 = instrucaoBoleto2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoleto != null ? idBoleto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boletobancario)) {
            return false;
        }
        Boletobancario other = (Boletobancario) object;
        if ((this.idBoleto == null && other.idBoleto != null) || (this.idBoleto != null && !this.idBoleto.equals(other.idBoleto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idBoleto + "-" + nossoNumero + "-" + dtVencimento;
    }

}
