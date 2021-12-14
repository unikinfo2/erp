/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "clifor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clifor.findAll", query = "SELECT c FROM Clifor c"),
    @NamedQuery(name = "Clifor.findByIdCliFor", query = "SELECT c FROM Clifor c WHERE c.idCliFor = :idCliFor"),
    @NamedQuery(name = "Clifor.findByEmpresa", query = "SELECT c FROM Clifor c WHERE c.empresa = :empresa"),
    @NamedQuery(name = "Clifor.findByEmpresaMatriz", query = "SELECT c FROM Clifor c WHERE c.empresa = :matriz"),

    @NamedQuery(name = "Clifor.findByCliforGrupo", query = "SELECT c FROM Clifor c WHERE c.empresa = :empresa and c.cliforGrupo = :cliforGrupo"),

    @NamedQuery(name = "Clifor.findByEmpresaFiltrado", query = "SELECT c FROM Clifor c WHERE c.empresa = :empresa and c.clienteFornecedor in (:clienteFornecedor1,:clienteFornecedor2) and (c.razaoSocial like :razaoCpfcnpj or c.cpfCnpj like :razaoCpfcnpj)"),
    @NamedQuery(name = "Clifor.findByEmpresaMatrizFiltrado", query = "SELECT c FROM Clifor c WHERE c.empresa = :matriz and c.clienteFornecedor in (:clienteFornecedor1,:clienteFornecedor2) and (c.razaoSocial like :razaoCpfcnpj or c.cpfCnpj like :razaoCpfcnpj)"),
    
    @NamedQuery(name = "Clifor.findByEmpresaFiltradoMensalidade", query = "SELECT c FROM Clifor c WHERE c.empresa = :empresa and c.clienteFornecedor in (:clienteFornecedor1,:clienteFornecedor2) and c.geraMensalidade='S' and c.ativoInativo='A' and (c.razaoSocial like :razaoCpfcnpj or c.cpfCnpj like :razaoCpfcnpj)"),
    @NamedQuery(name = "Clifor.findByEmpresaMatrizFiltradoMensalidade", query = "SELECT c FROM Clifor c WHERE c.empresa = :matriz and c.clienteFornecedor = :clienteFornecedor and c.geraMensalidade='S' and c.ativoInativo='A' and (c.razaoSocial like :razaoCpfcnpj or c.cpfCnpj like :razaoCpfcnpj)"),
    @NamedQuery(name = "Clifor.findByEmpresaClifor", query = "SELECT c FROM Clifor c WHERE c.empresa = :empresa and c.clienteFornecedor in (:clienteFornecedor1,:clienteFornecedor2)"),
    @NamedQuery(name = "Clifor.findByCodAuxiliar", query = "SELECT c FROM Clifor c WHERE c.codAuxiliar = :codAuxiliar"),
    @NamedQuery(name = "Clifor.findByRazaoSocial", query = "SELECT c FROM Clifor c WHERE c.razaoSocial = :razaoSocial and c.empresa = :empresa"),
    @NamedQuery(name = "Clifor.findByNomeFantasia", query = "SELECT c FROM Clifor c WHERE c.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Clifor.findByTipoPessoa", query = "SELECT c FROM Clifor c WHERE c.tipoPessoa = :tipoPessoa"),
    @NamedQuery(name = "Clifor.findByClienteFornecedor", query = "SELECT c FROM Clifor c WHERE c.clienteFornecedor = :clienteFornecedor"),
    @NamedQuery(name = "Clifor.findByCpfCnpj", query = "SELECT c FROM Clifor c WHERE c.cpfCnpj = :cpfCnpj"),
    @NamedQuery(name = "Clifor.findByInscricaoEstadual", query = "SELECT c FROM Clifor c WHERE c.inscricaoEstadual = :inscricaoEstadual"),
    @NamedQuery(name = "Clifor.findByInscricaoMunicipal", query = "SELECT c FROM Clifor c WHERE c.inscricaoMunicipal = :inscricaoMunicipal"),
    @NamedQuery(name = "Clifor.findByCodigoSuframa", query = "SELECT c FROM Clifor c WHERE c.codigoSuframa = :codigoSuframa"),
    @NamedQuery(name = "Clifor.findByEndereco", query = "SELECT c FROM Clifor c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "Clifor.findByComplemento", query = "SELECT c FROM Clifor c WHERE c.complemento = :complemento"),
    @NamedQuery(name = "Clifor.findByBairro", query = "SELECT c FROM Clifor c WHERE c.bairro = :bairro"),
    @NamedQuery(name = "Clifor.findByCidade", query = "SELECT c FROM Clifor c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "Clifor.findByCep", query = "SELECT c FROM Clifor c WHERE c.cep = :cep"),
    @NamedQuery(name = "Clifor.findByEnderecoNumero", query = "SELECT c FROM Clifor c WHERE c.enderecoNumero = :enderecoNumero"),
    @NamedQuery(name = "Clifor.findByEnderecoCob", query = "SELECT c FROM Clifor c WHERE c.enderecoCob = :enderecoCob"),
    @NamedQuery(name = "Clifor.findByComplementoCob", query = "SELECT c FROM Clifor c WHERE c.complementoCob = :complementoCob"),
    @NamedQuery(name = "Clifor.findByBairroCob", query = "SELECT c FROM Clifor c WHERE c.bairroCob = :bairroCob"),
    @NamedQuery(name = "Clifor.findByCidadeCob", query = "SELECT c FROM Clifor c WHERE c.cidadeCob = :cidadeCob"),
    @NamedQuery(name = "Clifor.findByCepCob", query = "SELECT c FROM Clifor c WHERE c.cepCob = :cepCob"),
    @NamedQuery(name = "Clifor.findByEnderecoEnt", query = "SELECT c FROM Clifor c WHERE c.enderecoEnt = :enderecoEnt"),
    @NamedQuery(name = "Clifor.findByComplementoEnt", query = "SELECT c FROM Clifor c WHERE c.complementoEnt = :complementoEnt"),
    @NamedQuery(name = "Clifor.findByBairroEnt", query = "SELECT c FROM Clifor c WHERE c.bairroEnt = :bairroEnt"),
    @NamedQuery(name = "Clifor.findByCidadeEnt", query = "SELECT c FROM Clifor c WHERE c.cidadeEnt = :cidadeEnt"),
    @NamedQuery(name = "Clifor.findByCepEnt", query = "SELECT c FROM Clifor c WHERE c.cepEnt = :cepEnt"),
    @NamedQuery(name = "Clifor.findByTelefone", query = "SELECT c FROM Clifor c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "Clifor.findByGeraMensalidade", query = "SELECT c FROM Clifor c WHERE c.geraMensalidade = :geraMensalidade"),
    @NamedQuery(name = "Clifor.findByObservacao", query = "SELECT c FROM Clifor c WHERE c.observacao = :observacao"),
    @NamedQuery(name = "Clifor.findByEmailNf", query = "SELECT c FROM Clifor c WHERE c.emailNf = :emailNf"),
    @NamedQuery(name = "Clifor.findByEmailBoleto", query = "SELECT c FROM Clifor c WHERE c.emailBoleto = :emailBoleto"),
    @NamedQuery(name = "Clifor.findByFaturarAPartirDe", query = "SELECT c FROM Clifor c WHERE c.faturarAPartirDe = :faturarAPartirDe"),
    @NamedQuery(name = "Clifor.findByFaturarAte", query = "SELECT c FROM Clifor c WHERE c.faturarAte = :faturarAte"),
    @NamedQuery(name = "Clifor.findByDiaMensalidade", query = "SELECT c FROM Clifor c WHERE c.diaMensalidade = :diaMensalidade"),
    @NamedQuery(name = "Clifor.findByValorMensalidade", query = "SELECT c FROM Clifor c WHERE c.valorMensalidade = :valorMensalidade"),
    @NamedQuery(name = "Clifor.findByNomeResponsavel1", query = "SELECT c FROM Clifor c WHERE c.nomeResponsavel1 = :nomeResponsavel1"),
    @NamedQuery(name = "Clifor.findByNomeResponsavel2", query = "SELECT c FROM Clifor c WHERE c.nomeResponsavel2 = :nomeResponsavel2"),
    @NamedQuery(name = "Clifor.findByDataAbertura", query = "SELECT c FROM Clifor c WHERE c.dataAbertura = :dataAbertura"),
    @NamedQuery(name = "Clifor.findByClienteDesde", query = "SELECT c FROM Clifor c WHERE c.clienteDesde = :clienteDesde"),
    @NamedQuery(name = "Clifor.findByObservacaoNotaFiscal", query = "SELECT c FROM Clifor c WHERE c.observacaoNotaFiscal = :observacaoNotaFiscal"),
    @NamedQuery(name = "Clifor.findByCalculaPis", query = "SELECT c FROM Clifor c WHERE c.calculaPis = :calculaPis"),
    @NamedQuery(name = "Clifor.findByCalculaCofins", query = "SELECT c FROM Clifor c WHERE c.calculaCofins = :calculaCofins"),
    @NamedQuery(name = "Clifor.findByCalculaCsll", query = "SELECT c FROM Clifor c WHERE c.calculaCsll = :calculaCsll"),
    @NamedQuery(name = "Clifor.findByAtivoInativo", query = "SELECT c FROM Clifor c WHERE c.ativoInativo = :ativoInativo"),
    @NamedQuery(name = "Clifor.findByReterImpostos", query = "SELECT c FROM Clifor c WHERE c.reterImpostos = :reterImpostos"),
    @NamedQuery(name = "Clifor.findByIndiceReajuste", query = "SELECT c FROM Clifor c WHERE c.indiceReajuste = :indiceReajuste")})
public class Clifor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliFor")
    private Long idCliFor;
    @Column(name = "codAuxiliar")
    private String codAuxiliar;
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Column(name = "tipoPessoa")
    private String tipoPessoa;
    @Column(name = "clienteFornecedor")
    private String clienteFornecedor;
    @Column(name = "cpfCnpj")
    private String cpfCnpj;
    @Column(name = "inscricaoEstadual")
    private String inscricaoEstadual;
    @Column(name = "inscricaoMunicipal")
    private String inscricaoMunicipal;
    @Column(name = "codigoSuframa")
    private String codigoSuframa;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "cep")
    private String cep;
    @Column(name = "enderecoNumero")
    private String enderecoNumero;
    @Column(name = "enderecoCob")
    private String enderecoCob;
    @Column(name = "complementoCob")
    private String complementoCob;
    @Column(name = "bairroCob")
    private String bairroCob;
    @Column(name = "cidadeCob")
    private String cidadeCob;
    @Column(name = "cepCob")
    private String cepCob;
    @Column(name = "enderecoEnt")
    private String enderecoEnt;
    @Column(name = "complementoEnt")
    private String complementoEnt;
    @Column(name = "bairroEnt")
    private String bairroEnt;
    @Column(name = "cidadeEnt")
    private String cidadeEnt;
    @Column(name = "cepEnt")
    private String cepEnt;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "celular")
    private String celular;
    @Column(name = "geraMensalidade")
    private String geraMensalidade;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "emailNf")
    private String emailNf;
    @Column(name = "emailBoleto")
    private String emailBoleto;
    @Column(name = "faturarAPartirDe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date faturarAPartirDe;
    @Column(name = "faturarAte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date faturarAte;
    @Column(name = "diaMensalidade")
    private Integer diaMensalidade;
    @Column(name = "valorMensalidade")
    private BigDecimal valorMensalidade;
    @Column(name = "valorAnteriorMensalidade")
    private BigDecimal valorAnteriorMensalidade;
    @Column(name = "nomeResponsavel1")
    private String nomeResponsavel1;
    @Column(name = "nomeResponsavel2")
    private String nomeResponsavel2;
    @Column(name = "dataAbertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAbertura;
    @Column(name = "clienteDesde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date clienteDesde;
    @Column(name = "observacaoNotaFiscal")
    private String observacaoNotaFiscal;
    @Column(name = "calculaPis")
    private String calculaPis;
    @Column(name = "calculaCofins")
    private String calculaCofins;
    @Column(name = "calculaCsll")
    private String calculaCsll;
    @Column(name = "ativoInativo")
    private String ativoInativo;
    @Column(name = "reterImpostos")
    private String reterImpostos;
    @Column(name = "forcarCalcImpostos")
    private String forcarCalcImpostos;
    @Column(name = "paginaGuia")
    private String paginaGuia;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "indiceReajuste")
    private BigDecimal indiceReajuste;

    //@OneToMany(mappedBy = "clifor")
    //private List<Transacao> transacaoList;
    //@OneToMany(mappedBy = "clifor")
    //private List<Boletobancario> boletoList;
    //@OneToMany(mappedBy = "clifor")
    //private List<Projeto> projetoList;
    //@OneToMany(mappedBy = "clifor")
    //private List<Cliforcontato> cliforcontatoList;
    @JoinColumn(name = "idTransp", referencedColumnName = "idTransp")
    @ManyToOne
    private Transportadora transportadora;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "uf", referencedColumnName = "uf")
    @ManyToOne
    private Estado estado;
    @JoinColumn(name = "UFCob", referencedColumnName = "uf")
    @ManyToOne
    private Estado estado1;
    @JoinColumn(name = "UFEnt", referencedColumnName = "uf")
    @ManyToOne
    private Estado estado2;
    @JoinColumn(name = "idMunicipio", referencedColumnName = "idMunicipio")
    @ManyToOne
    private Municipioibge municipioibge;
    @JoinColumn(name = "idMunicipioCob", referencedColumnName = "idMunicipio")
    @ManyToOne
    private Municipioibge municipioibge1;
    @JoinColumn(name = "idMunicipioEnt", referencedColumnName = "idMunicipio")
    @ManyToOne
    private Municipioibge municipioibge2;
    @JoinColumn(name = "idPais", referencedColumnName = "idPais")
    @ManyToOne
    private Paisibge paisibge;
    @JoinColumn(name = "idPaisCob", referencedColumnName = "idPais")
    @ManyToOne
    private Paisibge paisibge1;
    @JoinColumn(name = "idPaisEnt", referencedColumnName = "idPais")
    @ManyToOne
    private Paisibge paisibge2;
    @Column(name = "regimeClifor")
    private String regimeClifor;

    @Column(name = "tipoDesconto")
    private String tipoDesconto;
    @Column(name = "valorDesconto")
    private BigDecimal valorDesconto;
    
    @JoinColumn(name = "idCliforGrupo", referencedColumnName = "idClifor")
    @ManyToOne
    private Clifor cliforGrupo;

    @JoinColumn(name = "idContaControle", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas idContaControle;
    
    public Clifor() {
    }

    public Clifor(Long idCliFor) {
        this.idCliFor = idCliFor;
    }

    public Clifor(Long idCliFor, Date faturarAPartirDe, Date faturarAte, Date dataAbertura, Date clienteDesde) {
        this.idCliFor = idCliFor;
        this.faturarAPartirDe = faturarAPartirDe;
        this.faturarAte = faturarAte;
        this.dataAbertura = dataAbertura;
        this.clienteDesde = clienteDesde;
    }

    public Long getIdCliFor() {
        return idCliFor;
    }

    public void setIdCliFor(Long idCliFor) {
        this.idCliFor = idCliFor;
    }

    public String getCodAuxiliar() {
        return codAuxiliar;
    }

    public void setCodAuxiliar(String codAuxiliar) {
        this.codAuxiliar = codAuxiliar;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public BigDecimal getValorAnteriorMensalidade() {
        return valorAnteriorMensalidade;
    }

    public void setValorAnteriorMensalidade(BigDecimal valorAnteriorMensalidade) {
        this.valorAnteriorMensalidade = valorAnteriorMensalidade;
    }

    public String getClienteFornecedor() {
        return clienteFornecedor;
    }

    public void setClienteFornecedor(String clienteFornecedor) {
        this.clienteFornecedor = clienteFornecedor;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getCodigoSuframa() {
        return codigoSuframa;
    }

    public void setCodigoSuframa(String codigoSuframa) {
        this.codigoSuframa = codigoSuframa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoCob() {
        return enderecoCob;
    }

    public void setEnderecoCob(String enderecoCob) {
        this.enderecoCob = enderecoCob;
    }

    public String getComplementoCob() {
        return complementoCob;
    }

    public void setComplementoCob(String complementoCob) {
        this.complementoCob = complementoCob;
    }

    public String getBairroCob() {
        return bairroCob;
    }

    public void setBairroCob(String bairroCob) {
        this.bairroCob = bairroCob;
    }

    public String getCidadeCob() {
        return cidadeCob;
    }

    public void setCidadeCob(String cidadeCob) {
        this.cidadeCob = cidadeCob;
    }

    public String getCepCob() {
        return cepCob;
    }

    public void setCepCob(String cepCob) {
        this.cepCob = cepCob;
    }

    public String getEnderecoEnt() {
        return enderecoEnt;
    }

    public void setEnderecoEnt(String enderecoEnt) {
        this.enderecoEnt = enderecoEnt;
    }

    public String getComplementoEnt() {
        return complementoEnt;
    }

    public void setComplementoEnt(String complementoEnt) {
        this.complementoEnt = complementoEnt;
    }

    public String getBairroEnt() {
        return bairroEnt;
    }

    public void setBairroEnt(String bairroEnt) {
        this.bairroEnt = bairroEnt;
    }

    public String getCidadeEnt() {
        return cidadeEnt;
    }

    public void setCidadeEnt(String cidadeEnt) {
        this.cidadeEnt = cidadeEnt;
    }

    public String getCepEnt() {
        return cepEnt;
    }

    public void setCepEnt(String cepEnt) {
        this.cepEnt = cepEnt;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGeraMensalidade() {
        return geraMensalidade;
    }

    public void setGeraMensalidade(String geraMensalidade) {
        this.geraMensalidade = geraMensalidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEmailNf() {
        return emailNf;
    }

    public void setEmailNf(String emailNf) {
        this.emailNf = emailNf;
    }

    public String getEmailBoleto() {
        return emailBoleto;
    }

    public void setEmailBoleto(String emailBoleto) {
        this.emailBoleto = emailBoleto;
    }

    public Date getFaturarAPartirDe() {
        return faturarAPartirDe;
    }

    public void setFaturarAPartirDe(Date faturarAPartirDe) {
        this.faturarAPartirDe = faturarAPartirDe;
    }

    public Date getFaturarAte() {
        return faturarAte;
    }

    public void setFaturarAte(Date faturarAte) {
        this.faturarAte = faturarAte;
    }

    public Integer getDiaMensalidade() {
        if (diaMensalidade == null) {
            diaMensalidade = 1;
        }
        return diaMensalidade;
    }

    public void setDiaMensalidade(Integer diaMensalidade) {
        this.diaMensalidade = diaMensalidade;
    }

    public BigDecimal getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(BigDecimal valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    public String getNomeResponsavel1() {
        return nomeResponsavel1;
    }

    public void setNomeResponsavel1(String nomeResponsavel1) {
        this.nomeResponsavel1 = nomeResponsavel1;
    }

    public String getNomeResponsavel2() {
        return nomeResponsavel2;
    }

    public void setNomeResponsavel2(String nomeResponsavel2) {
        this.nomeResponsavel2 = nomeResponsavel2;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getClienteDesde() {
        return clienteDesde;
    }

    public void setClienteDesde(Date clienteDesde) {
        this.clienteDesde = clienteDesde;
    }

    public String getObservacaoNotaFiscal() {
        return observacaoNotaFiscal;
    }

    public void setObservacaoNotaFiscal(String observacaoNotaFiscal) {
        this.observacaoNotaFiscal = observacaoNotaFiscal;
    }

    public String getCalculaPis() {
        return calculaPis;
    }

    public void setCalculaPis(String calculaPis) {
        this.calculaPis = calculaPis;
    }

    public String getCalculaCofins() {
        return calculaCofins;
    }

    public void setCalculaCofins(String calculaCofins) {
        this.calculaCofins = calculaCofins;
    }

    public String getCalculaCsll() {
        return calculaCsll;
    }

    public void setCalculaCsll(String calculaCsll) {
        this.calculaCsll = calculaCsll;
    }

    public String getAtivoInativo() {
        return ativoInativo;
    }

    public void setAtivoInativo(String ativoInativo) {
        this.ativoInativo = ativoInativo;
    }

    public String getReterImpostos() {
        return reterImpostos;
    }

    public void setReterImpostos(String reterImpostos) {
        this.reterImpostos = reterImpostos;
    }

    public BigDecimal getIndiceReajuste() {
        return indiceReajuste;
    }

    public void setIndiceReajuste(BigDecimal indiceReajuste) {
        this.indiceReajuste = indiceReajuste;
    }

    public String getPaginaGuia() {
        return paginaGuia;
    }

    public void setPaginaGuia(String paginaGuia) {
        this.paginaGuia = paginaGuia;
    }


    /*@XmlTransient
     public List<Transacao> getTransacaoList() {
     return transacaoList;
     }

     public void setTransacaoList(List<Transacao> transacaoList) {
     this.transacaoList = transacaoList;
     }

     @XmlTransient
     public List<Boletobancario> getBoletoList() {
     return boletoList;
     }

     public void setBoletoList(List<Boletobancario> boletoList) {
     this.boletoList = boletoList;
     }

     @XmlTransient
     public List<Projeto> getProjetoList() {
     return projetoList;
     }

     public void setProjetoList(List<Projeto> projetoList) {
     this.projetoList = projetoList;
     }

     @XmlTransient
     public List<Cliforcontato> getCliforcontatoList() {
     return cliforcontatoList;
     }

     public void setCliforcontatoList(List<Cliforcontato> cliforcontatoList) {
     this.cliforcontatoList = cliforcontatoList;
     }*/
    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado1() {
        return estado1;
    }

    public void setEstado1(Estado estado1) {
        this.estado1 = estado1;
    }

    public Estado getEstado2() {
        return estado2;
    }

    public void setEstado2(Estado estado2) {
        this.estado2 = estado2;
    }

    public Municipioibge getMunicipioibge() {
        return municipioibge;
    }

    public void setMunicipioibge(Municipioibge municipioibge) {
        this.municipioibge = municipioibge;
    }

    public Municipioibge getMunicipioibge1() {
        return municipioibge1;
    }

    public void setMunicipioibge1(Municipioibge municipioibge1) {
        this.municipioibge1 = municipioibge1;
    }

    public Municipioibge getMunicipioibge2() {
        return municipioibge2;
    }

    public void setMunicipioibge2(Municipioibge municipioibge2) {
        this.municipioibge2 = municipioibge2;
    }

    public Paisibge getPaisibge() {
        return paisibge;
    }

    public void setPaisibge(Paisibge paisibge) {
        this.paisibge = paisibge;
    }

    public Paisibge getPaisibge1() {
        return paisibge1;
    }

    public void setPaisibge1(Paisibge paisibge1) {
        this.paisibge1 = paisibge1;
    }

    public Paisibge getPaisibge2() {
        return paisibge2;
    }

    public void setPaisibge2(Paisibge paisibge2) {
        this.paisibge2 = paisibge2;
    }

    public String getForcarCalcImpostos() {
        return forcarCalcImpostos;
    }

    public void setForcarCalcImpostos(String forcarCalcImpostos) {
        this.forcarCalcImpostos = forcarCalcImpostos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRegimeClifor() {
        return regimeClifor;
    }

    public void setRegimeClifor(String regimeClifor) {
        this.regimeClifor = regimeClifor;
    }

    public String getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(String tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Clifor getCliforGrupo() {
        return cliforGrupo;
    }

    public void setCliforGrupo(Clifor cliforGrupo) {
        this.cliforGrupo = cliforGrupo;
    }

    public Planocontas getIdContaControle() {
        return idContaControle;
    }

    public void setIdContaControle(Planocontas idContaControle) {
        this.idContaControle = idContaControle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliFor != null ? idCliFor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clifor)) {
            return false;
        }
        Clifor other = (Clifor) object;
        if ((this.idCliFor == null && other.idCliFor != null) || (this.idCliFor != null && !this.idCliFor.equals(other.idCliFor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0000");
        return df.format(idCliFor) + "-" + razaoSocial;
    }

}
