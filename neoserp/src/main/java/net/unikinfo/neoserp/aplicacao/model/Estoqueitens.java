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
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "estoqueitens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estoqueitens.findAll", query = "SELECT e FROM Estoqueitens e"),
    @NamedQuery(name = "Estoqueitens.findEstoqueEmpresa", query = "SELECT e FROM Estoqueitens e where e.idEstoque.idEmpresa = :empresa"),
    @NamedQuery(name = "Estoqueitens.findMax", query = "SELECT e FROM Estoqueitens e where e.idEstoque.idEmpresa = :idEmpresa and e.idProduto = :idProduto and e.idEstoqueItem in (select max(e2.idEstoqueItem) from Estoqueitens e2 where e2.idEstoque.idEmpresa = :idEmpresa and e2.idProduto = :idProduto)"),
    @NamedQuery(name = "Estoqueitens.findByIdEstoqueItem", query = "SELECT e FROM Estoqueitens e WHERE e.idEstoqueItem = :idEstoqueItem"),
    @NamedQuery(name = "Estoqueitens.findByProduto", query = "SELECT e FROM Estoqueitens e WHERE e.idProduto = :produto order by e.idEstoqueItem, e.dataMovimentacao"),
    @NamedQuery(name = "Estoqueitens.findBySaldoAtual", query = "SELECT e FROM Estoqueitens e WHERE e.idProduto = :produto and e.idEstoque = :estoque order by e.dataMovimentacao desc, e.idEstoqueItem desc"),
    @NamedQuery(name = "Estoqueitens.findByTpMovimentoEstoque", query = "SELECT e FROM Estoqueitens e WHERE e.tpMovimentoEstoque = :tpMovimentoEstoque"),
    @NamedQuery(name = "Estoqueitens.findByQuantidadeAjuste", query = "SELECT e FROM Estoqueitens e WHERE e.quantidadeAjuste = :quantidadeAjuste")})
public class Estoqueitens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstoqueItem")
    private Long idEstoqueItem;
    //@Size(max = 20)
    @Column(name = "tpMovimentoEstoque")
    private String tpMovimentoEstoque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeAjuste")
    private BigDecimal quantidadeAjuste;
    @JoinColumn(name = "idEstoque", referencedColumnName = "idEstoque")
    @ManyToOne(optional = false)
    private Estoque idEstoque;
    @JoinColumn(name = "idProduto", referencedColumnName = "idProduto")
    @ManyToOne(optional = false)
    private Produto idProduto;
    @Column(name = "dataMovimentacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMovimentacao;
    @JoinColumn(name = "idTransacaoItem", referencedColumnName = "idTransacaoItem")
    @ManyToOne
    private Transacaoitem idTransacaoItem;
    @Column(name = "saldoAnterior")
    private BigDecimal saldoAnterior;
    @Column(name = "saldoAtual")
    private BigDecimal saldoAtual;
    @Column(name = "motivoAjuste")
    private String motivoAjuste;

    public Estoqueitens() {
    }

    public Estoqueitens(Long idEstoqueItem) {
        this.idEstoqueItem = idEstoqueItem;
    }

    public Long getIdEstoqueItem() {
        return idEstoqueItem;
    }

    public void setIdEstoqueItem(Long idEstoqueItem) {
        this.idEstoqueItem = idEstoqueItem;
    }

    public String getTpMovimentoEstoque() {
        return tpMovimentoEstoque;
    }

    public void setTpMovimentoEstoque(String tpMovimentoEstoque) {
        this.tpMovimentoEstoque = tpMovimentoEstoque;
    }

    public BigDecimal getQuantidadeAjuste() {
        return quantidadeAjuste;
    }

    public void setQuantidadeAjuste(BigDecimal quantidadeAjuste) {
        this.quantidadeAjuste = quantidadeAjuste;
    }

    public Estoque getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Estoque idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Transacaoitem getIdTransacaoItem() {
        return idTransacaoItem;
    }

    public void setIdTransacaoItem(Transacaoitem idTransacaoItem) {
        this.idTransacaoItem = idTransacaoItem;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public BigDecimal getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(BigDecimal saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public BigDecimal getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(BigDecimal saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public String getMotivoAjuste() {
        return motivoAjuste;
    }

    public void setMotivoAjuste(String motivoAjuste) {
        this.motivoAjuste = motivoAjuste;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstoqueItem != null ? idEstoqueItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoqueitens)) {
            return false;
        }
        Estoqueitens other = (Estoqueitens) object;
        if ((this.idEstoqueItem == null && other.idEstoqueItem != null) || (this.idEstoqueItem != null && !this.idEstoqueItem.equals(other.idEstoqueItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Estoqueitens[ idEstoqueItem=" + idEstoqueItem + " ]";
    }

    public void setMotivoAjuste() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
