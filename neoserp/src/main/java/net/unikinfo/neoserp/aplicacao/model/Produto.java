/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produto.findByEmpresa", query = "SELECT p FROM Produto p WHERE p.empresa = :empresa"),
    @NamedQuery(name = "Produto.findByEmpresaMatriz", query = "SELECT p FROM Produto p WHERE p.empresa = :matriz"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao and p.empresa = :empresa"),
    @NamedQuery(name = "Produto.findByCodigoAux", query = "SELECT p FROM Produto p WHERE p.codigoAux = :codigoAux"),
    @NamedQuery(name = "Produto.findByComplDescricao", query = "SELECT p FROM Produto p WHERE p.complDescricao = :complDescricao"),
    @NamedQuery(name = "Produto.findByTpProduto", query = "SELECT p FROM Produto p WHERE p.tpProduto = :tpProduto"),
    @NamedQuery(name = "Produto.findByDestinacao", query = "SELECT p FROM Produto p WHERE p.destinacao = :destinacao"),
    @NamedQuery(name = "Produto.findByPesoBruto", query = "SELECT p FROM Produto p WHERE p.pesoBruto = :pesoBruto"),
    @NamedQuery(name = "Produto.findByMarkup", query = "SELECT p FROM Produto p WHERE p.markup = :markup"),
    @NamedQuery(name = "Produto.findByQuantidadeAtual", query = "SELECT p FROM Produto p WHERE p.quantidadeAtual = :quantidadeAtual"),
    @NamedQuery(name = "Produto.findByPrecoCusto", query = "SELECT p FROM Produto p WHERE p.precoCusto = :precoCusto"),
    @NamedQuery(name = "Produto.findByPrecoVenda", query = "SELECT p FROM Produto p WHERE p.precoVenda = :precoVenda"),
    @NamedQuery(name = "Produto.findByTpItem", query = "SELECT p FROM Produto p WHERE p.tpItem = :tpItem"),
    @NamedQuery(name = "Produto.findByPesa", query = "SELECT p FROM Produto p WHERE p.pesa = :pesa"),
    @NamedQuery(name = "Produto.findByCustoMedio", query = "SELECT p FROM Produto p WHERE p.custoMedio = :custoMedio"),
    @NamedQuery(name = "Produto.findByPrecoMedio", query = "SELECT p FROM Produto p WHERE p.precoMedio = :precoMedio"),
    @NamedQuery(name = "Produto.findByEstoqueMinimo", query = "SELECT p FROM Produto p WHERE p.estoqueMinimo = :estoqueMinimo"),
    @NamedQuery(name = "Produto.findByEstoqueMaximo", query = "SELECT p FROM Produto p WHERE p.estoqueMaximo = :estoqueMaximo"),
    @NamedQuery(name = "Produto.findByPesoLiquido", query = "SELECT p FROM Produto p WHERE p.pesoLiquido = :pesoLiquido"),
    @NamedQuery(name = "Produto.findByCodigoBarras", query = "SELECT p FROM Produto p WHERE p.empresa = :empresa and p.codigoBarras = :codigoBarras"),
    @NamedQuery(name = "Produto.findByDescricao2", query = "SELECT p FROM Produto p WHERE p.descricao2 = :descricao2"),
    @NamedQuery(name = "Produto.findByDescricao3", query = "SELECT p FROM Produto p WHERE p.descricao3 = :descricao3"),
    @NamedQuery(name = "Produto.findByForcarCB", query = "SELECT p FROM Produto p WHERE p.forcarCB = :forcarCB")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduto")
    private Long idProduto;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "codigoAux")
    private String codigoAux;
    @Column(name = "complDescricao")
    private String complDescricao;
    @Column(name = "tpProduto")
    private String tpProduto;
    @Column(name = "destinacao")
    private String destinacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pesoBruto")
    private BigDecimal pesoBruto;
    @Column(name = "markup")
    private BigDecimal markup;
    @Column(name = "quantidadeAtual")
    private BigDecimal quantidadeAtual;
    @Column(name = "precoCusto")
    private BigDecimal precoCusto;
    @Column(name = "precoVenda")
    private BigDecimal precoVenda;
    @Column(name = "tpItem")
    private String tpItem;
    @Column(name = "pesa")
    private String pesa;
    @Column(name = "custoMedio")
    private BigDecimal custoMedio;
    @Column(name = "precoMedio")
    private BigDecimal precoMedio;
    @Column(name = "estoqueMinimo")
    private BigDecimal estoqueMinimo;
    @Column(name = "estoqueMaximo")
    private BigDecimal estoqueMaximo;
    @Column(name = "pesoLiquido")
    private BigDecimal pesoLiquido;
    @Column(name = "codigoBarras")
    private String codigoBarras;
    @Column(name = "descricao2")
    private String descricao2;
    @Column(name = "descricao3")
    private String descricao3;
    @Column(name = "forcarCB")
    private String forcarCB;
    @OneToMany(mappedBy = "produto")
    private List<Transacaoitem> transacaoitemList;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "codUniMed", referencedColumnName = "codUniMed")
    @ManyToOne
    private Unidademedida unidademedida;
    @OneToMany(mappedBy = "idProduto")
    private List<Estoqueitens> estoqueitensList;
    @OneToMany(mappedBy = "idProdutoOrigem")
    private List<Produtoadicional> produtoadicionalList;
    
    @Column(name = "ncm")
    private String ncm;
    @Column(name = "origem")
    private String origem;
    @Column(name = "fabricacaoPropria")
    private String fabricacaoPropria;
    @Column(name = "qtdDiasGarantia")
    private Integer qtdDiasGarantia;
    @Column(name = "caminhoImagem")
    private String caminhoImagem;
    @JoinColumn(name = "grupoProduto", referencedColumnName = "idProduto")
    @ManyToOne
    private Produto grupoProduto;
    @Column(name = "descricaoCompleta")
    private String descricaoCompleta;

    public Produto() {
    }

    public Produto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Long idProduto, String descricao2) {
        this.idProduto = idProduto;
        this.descricao2 = descricao2;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoAux() {
        return codigoAux;
    }

    public void setCodigoAux(String codigoAux) {
        this.codigoAux = codigoAux;
    }

    public String getComplDescricao() {
        return complDescricao;
    }

    public void setComplDescricao(String complDescricao) {
        this.complDescricao = complDescricao;
    }

    public String getTpProduto() {
        return tpProduto;
    }

    public void setTpProduto(String tpProduto) {
        this.tpProduto = tpProduto;
    }

    public String getDestinacao() {
        return destinacao;
    }

    public void setDestinacao(String destinacao) {
        this.destinacao = destinacao;
    }

    public BigDecimal getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(BigDecimal pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public BigDecimal getMarkup() {
        return markup;
    }

    public void setMarkup(BigDecimal markup) {
        this.markup = markup;
    }

    public BigDecimal getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(BigDecimal quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getTpItem() {
        return tpItem;
    }

    public void setTpItem(String tpItem) {
        this.tpItem = tpItem;
    }

    public String getPesa() {
        return pesa;
    }

    public void setPesa(String pesa) {
        this.pesa = pesa;
    }

    public BigDecimal getCustoMedio() {
        return custoMedio;
    }

    public void setCustoMedio(BigDecimal custoMedio) {
        this.custoMedio = custoMedio;
    }

    public BigDecimal getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(BigDecimal precoMedio) {
        this.precoMedio = precoMedio;
    }

    public BigDecimal getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(BigDecimal estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public BigDecimal getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(BigDecimal estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public BigDecimal getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(BigDecimal pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getDescricao2() {
        return descricao2;
    }

    public void setDescricao2(String descricao2) {
        this.descricao2 = descricao2;
    }

    public String getDescricao3() {
        return descricao3;
    }

    public void setDescricao3(String descricao3) {
        this.descricao3 = descricao3;
    }

    public String getForcarCB() {
        return forcarCB;
    }

    public void setForcarCB(String forcarCB) {
        this.forcarCB = forcarCB;
    }

    public Integer getQtdDiasGarantia() {
        return qtdDiasGarantia;
    }

    public void setQtdDiasGarantia(Integer qtdDiasGarantia) {
        this.qtdDiasGarantia = qtdDiasGarantia;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Produto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(Produto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    @XmlTransient
    public List<Transacaoitem> getTransacaoitemList() {
        return transacaoitemList;
    }

    public void setTransacaoitemList(List<Transacaoitem> transacaoitemList) {
        this.transacaoitemList = transacaoitemList;
    }

    @XmlTransient
    public List<Estoqueitens> getEstoqueitensList() {
        return estoqueitensList;
    }

    public void setEstoqueitensList(List<Estoqueitens> estoqueitensList) {
        this.estoqueitensList = estoqueitensList;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Unidademedida getUnidademedida() {
        return unidademedida;
    }

    public void setUnidademedida(Unidademedida unidademedida) {
        this.unidademedida = unidademedida;
    }

    public String getDescricaoCompleta() {
        String retorno = this.descricao;
        try {
            if ((this.descricao != null) || (this.grupoProduto != null)) {
                retorno = this.grupoProduto.getDescricao() + ":" + this.descricao;
                if (this.grupoProduto.grupoProduto != null) {
                    retorno = this.grupoProduto.grupoProduto.getDescricao() + ":" + retorno;
                    if (this.grupoProduto.grupoProduto.grupoProduto != null) {
                        retorno = this.grupoProduto.grupoProduto.grupoProduto.getDescricao() + ":" + retorno;
                    }
                }
            }
        } catch (Exception e) {
        }
        descricaoCompleta = retorno;        
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public List<Produtoadicional> getProdutoadicionalList() {
        return produtoadicionalList;
    }

    public void setProdutoadicionalList(List<Produtoadicional> produtoadicionalList) {
        this.produtoadicionalList = produtoadicionalList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (codigoAux != null) {
            return  idProduto + " - " + codigoAux + " - " + descricao;
        } else {
            return idProduto + " - " + descricao;
        }
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getFabricacaoPropria() {
        return fabricacaoPropria;
    }

    public void setFabricacaoPropria(String fabricacaoPropria) {
        this.fabricacaoPropria = fabricacaoPropria;
    }

}
