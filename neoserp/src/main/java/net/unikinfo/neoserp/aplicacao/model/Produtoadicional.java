/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
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
 * @author carlos
 */
@Entity
@Table(name = "produtoadicional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtoadicional.findAll", query = "SELECT p FROM Produtoadicional p"),
    @NamedQuery(name = "Produtoadicional.findByProdutoOrigem", query = "SELECT p FROM Produtoadicional p WHERE p.idProdutoOrigem = :idProdutoOrigem"),
    @NamedQuery(name = "Produtoadicional.findByIdAdicional", query = "SELECT p FROM Produtoadicional p WHERE p.idAdicional = :idAdicional")})
public class Produtoadicional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAdicional")
    private Long idAdicional;
    @JoinColumn(name = "idProdutoOrigem", referencedColumnName = "idProduto")
    @ManyToOne
    private Produto idProdutoOrigem;
    @JoinColumn(name = "idProdutoAdicionavel", referencedColumnName = "idProduto")
    @ManyToOne
    private Produto idProdutoAdicionavel;
    
    public Produtoadicional() {
    }

    public Produtoadicional(Long idAdicional) {
        this.idAdicional = idAdicional;
    }

    public Long getIdAdicional() {
        return idAdicional;
    }

    public void setIdAdicional(Long idAdicional) {
        this.idAdicional = idAdicional;
    }

    public Produto getIdProdutoOrigem() {
        return idProdutoOrigem;
    }

    public void setIdProdutoOrigem(Produto idProdutoOrigem) {
        this.idProdutoOrigem = idProdutoOrigem;
    }

    public Produto getIdProdutoAdicionavel() {
        return idProdutoAdicionavel;
    }

    public void setIdProdutoAdicionavel(Produto idProdutoAdicionavel) {
        this.idProdutoAdicionavel = idProdutoAdicionavel;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdicional != null ? idAdicional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtoadicional)) {
            return false;
        }
        Produtoadicional other = (Produtoadicional) object;
        if ((this.idAdicional == null && other.idAdicional != null) || (this.idAdicional != null && !this.idAdicional.equals(other.idAdicional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produtoadicional[ idAdicional=" + idAdicional + " ]";
    }
    
}
