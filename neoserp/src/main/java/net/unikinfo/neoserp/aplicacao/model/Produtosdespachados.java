/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "produtosdespachados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtosdespachados.findAll", query = "SELECT p FROM Produtosdespachados p"),
    @NamedQuery(name = "Produtosdespachados.findByIdOrdemDespacho", query = "SELECT p FROM Produtosdespachados p WHERE p.ordemdespacho = :ordemdespacho"),
    @NamedQuery(name = "Produtosdespachados.findByIdProdutosDespachados", query = "SELECT p FROM Produtosdespachados p WHERE p.idProdutosDespachados = :idProdutosDespachados"),
    @NamedQuery(name = "Produtosdespachados.findByIdProdutosEordemDespacho", query = "SELECT p FROM Produtosdespachados p WHERE p.produto = :produto and p.ordemdespacho = :ordemdespacho"),
    @NamedQuery(name = "Produtosdespachados.findByQuantidadeDespacho", query = "SELECT p FROM Produtosdespachados p WHERE p.quantidadeDespacho = :quantidadeDespacho")})
    
public class Produtosdespachados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProdutosDespachados")
    private Long idProdutosDespachados;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeDespacho")
    private BigDecimal quantidadeDespacho;
    @JoinColumn(name = "idOrdemDespacho", referencedColumnName = "idOrdemDespacho")
    @ManyToOne(optional = false)
    private OrdemDespacho ordemdespacho;
    @JoinColumn(name = "idProduto", referencedColumnName = "idProduto")
    @ManyToOne(optional = false)
    private Produto produto;

    public Produtosdespachados() {
    }

    public Produtosdespachados(Long idProdutosDespachados) {
        this.idProdutosDespachados = idProdutosDespachados;
    }

    public Long getIdProdutosDespachados() {
        return idProdutosDespachados;
    }

    public void setIdProdutosDespachados(Long idProdutosDespachados) {
        this.idProdutosDespachados = idProdutosDespachados;
    }

    public BigDecimal getQuantidadeDespacho() {
        return quantidadeDespacho;
    }

    public void setQuantidadeDespacho(BigDecimal quantidadeDespacho) {
        this.quantidadeDespacho = quantidadeDespacho;
    }

    public OrdemDespacho getIdOrdemDespacho() {
        return ordemdespacho;
    }

    public void setIdOrdemDespacho(OrdemDespacho idOrdemDespacho) {
        this.ordemdespacho = idOrdemDespacho;
    }

    public Produto getIdProduto() {
        return produto;
    }

    public void setIdProduto(Produto idProduto) {
        this.produto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdutosDespachados != null ? idProdutosDespachados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtosdespachados)) {
            return false;
        }
        Produtosdespachados other = (Produtosdespachados) object;
        if ((this.idProdutosDespachados == null && other.idProdutosDespachados != null) || (this.idProdutosDespachados != null && !this.idProdutosDespachados.equals(other.idProdutosDespachados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Produtosdespachados[ idProdutosDespachados=" + idProdutosDespachados + " ]";
    }
    
}
