/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "transacaoitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacaoitem.findAll", query = "SELECT t FROM Transacaoitem t"),
    @NamedQuery(name = "Transacaoitem.findByTransacao", query = "SELECT t FROM Transacaoitem t WHERE t.transacao = :transacao"),
    @NamedQuery(name = "Transacaoitem.findByIdTransacaoItem", query = "SELECT t FROM Transacaoitem t WHERE t.idTransacaoItem = :idTransacaoItem"),
    @NamedQuery(name = "Transacaoitem.findByQuantidadeItem", query = "SELECT t FROM Transacaoitem t WHERE t.quantidadeItem = :quantidadeItem"),
    @NamedQuery(name = "Transacaoitem.findByEmpresaTpEStatus", query = "SELECT t FROM Transacaoitem t WHERE t.transacao.empresa = :empresa and t.transacao.statusTransacao in (:st1, :st2) and t.transacao.tipoTransacao in (:tp1, :tp2) and ((t.quantidadeItem > t.quantidadeRecebida) or (t.quantidadeRecebida is null)) order by t.transacao.dataVencimento desc"),
    @NamedQuery(name = "Transacaoitem.findByEmpresaClienteTipoStatus", query = "SELECT t FROM Transacaoitem t WHERE t.transacao.empresa = :empresa and t.transacao.statusTransacao = :status and t.transacao.tipoTransacao = :tipo and t.transacao.transacao.clifor = :clifor order by t.transacao.dataVencimento desc"),
    @NamedQuery(name = "Transacaoitem.findByEmpresaTpTresStatus", query = "SELECT t FROM Transacaoitem t WHERE t.transacao.empresa = :empresa and t.transacao.statusTransacao in (:st1, :st2, :st3) and t.transacao.tipoTransacao in (:tp1, :tp2) and ((t.quantidadeItem > t.quantidadeRecebida) or (t.quantidadeRecebida is null)) order by t.transacao.dataVencimento desc"),
    @NamedQuery(name = "Transacaoitem.findByValorUnitarioItem", query = "SELECT t FROM Transacaoitem t WHERE t.valorUnitarioItem = :valorUnitarioItem"),
    @NamedQuery(name = "Transacaoitem.findByTotalItem", query = "SELECT t FROM Transacaoitem t WHERE t.totalItem = :totalItem"),
    @NamedQuery(name = "Transacaoitem.findByRetencaoItem", query = "SELECT t FROM Transacaoitem t WHERE t.retencaoItem = :retencaoItem"),
    @NamedQuery(name = "Transacaoitem.findByDescricaoItem", query = "SELECT t FROM Transacaoitem t WHERE t.descricaoItem = :descricaoItem"),
    @NamedQuery(name = "Transacaoitem.findByDescontoItem", query = "SELECT t FROM Transacaoitem t WHERE t.descontoItem = :descontoItem")})
public class Transacaoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransacaoItem")
    private Long idTransacaoItem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeItem")
    private BigDecimal quantidadeItem;
    @Column(name = "quantidadeRecebida")
    private BigDecimal quantidadeRecebida;
    @Column(name = "valorUnitarioItem")
    private BigDecimal valorUnitarioItem;
    @Column(name = "totalItem")
    private BigDecimal totalItem;
    @Column(name = "retencaoItem")
    private BigDecimal retencaoItem;
    @Column(name = "descricaoItem")
    private String descricaoItem;
    @Column(name = "descontoItem")
    private BigDecimal descontoItem;
    @JoinColumn(name = "idTransacao", referencedColumnName = "idTransacao")
    @ManyToOne
    private Transacao transacao;
    @JoinColumn(name = "idProduto", referencedColumnName = "idProduto")
    @ManyToOne
    private Produto produto;
    @JoinColumn(name = "idEstoque", referencedColumnName = "idEstoque")
    @ManyToOne
    private Estoque estoque;
    @Column(name = "quantidadeFaturada")
    private BigDecimal quantidadeFaturada;
    @Column(name = "dtFinalGarantia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFinalGarantia;    

    public Transacaoitem() {
    }

    public Transacaoitem(Long idTransacaoItem) {
        this.idTransacaoItem = idTransacaoItem;
    }

    public Transacaoitem(Long idTransacaoItem, String descricaoItem) {
        this.idTransacaoItem = idTransacaoItem;
        this.descricaoItem = descricaoItem;
    }

    public Long getIdTransacaoItem() {
        return idTransacaoItem;
    }

    public void setIdTransacaoItem(Long idTransacaoItem) {
        this.idTransacaoItem = idTransacaoItem;
    }

    public BigDecimal getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(BigDecimal quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    public BigDecimal getValorUnitarioItem() {
        return valorUnitarioItem;
    }

    public void setValorUnitarioItem(BigDecimal valorUnitarioItem) {
        this.valorUnitarioItem = valorUnitarioItem;
    }

    public BigDecimal getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(BigDecimal totalItem) {
        this.totalItem = totalItem;
    }

    public BigDecimal getRetencaoItem() {
        return retencaoItem;
    }

    public void setRetencaoItem(BigDecimal retencaoItem) {
        this.retencaoItem = retencaoItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public BigDecimal getDescontoItem() {
        return descontoItem;
    }

    public void setDescontoItem(BigDecimal descontoItem) {
        this.descontoItem = descontoItem;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public BigDecimal getQuantidadeRecebida() {
        return quantidadeRecebida;
    }

    public void setQuantidadeRecebida(BigDecimal quantidadeRecebida) {
        this.quantidadeRecebida = quantidadeRecebida;
    }

    public BigDecimal getQuantidadeFaturada() {
        return quantidadeFaturada;
    }

    public void setQuantidadeFaturada(BigDecimal quantidadeFaturada) {
        this.quantidadeFaturada = quantidadeFaturada;
    }

    public Date getDtFinalGarantia() {
        return dtFinalGarantia;
    }

    public void setDtFinalGarantia(Date dtFinalGarantia) {
        this.dtFinalGarantia = dtFinalGarantia;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransacaoItem != null ? idTransacaoItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacaoitem)) {
            return false;
        }
        Transacaoitem other = (Transacaoitem) object;
        if ((this.idTransacaoItem == null && other.idTransacaoItem != null) || (this.idTransacaoItem != null && !this.idTransacaoItem.equals(other.idTransacaoItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Transacaoitem[ idTransacaoItem=" + idTransacaoItem + " ]";
    }

    
    
}
