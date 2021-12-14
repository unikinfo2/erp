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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "tabelasimples")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabelasimples.findAll", query = "SELECT t FROM Tabelasimples t"),
    @NamedQuery(name = "Tabelasimples.findByCodTabsimples", query = "SELECT t FROM Tabelasimples t WHERE t.codTabsimples = :codTabsimples"),
    @NamedQuery(name = "Tabelasimples.findByReceita1Tabsimples", query = "SELECT t FROM Tabelasimples t WHERE t.receita1Tabsimples = :receita1Tabsimples"),
    @NamedQuery(name = "Tabelasimples.findByReceita2Tabsimples", query = "SELECT t FROM Tabelasimples t WHERE t.receita2Tabsimples = :receita2Tabsimples"),
    @NamedQuery(name = "Tabelasimples.findByAliqSimples", query = "SELECT t FROM Tabelasimples t WHERE t.aliqSimples = :aliqSimples"),
    @NamedQuery(name = "Tabelasimples.findByAliqIrpj", query = "SELECT t FROM Tabelasimples t WHERE t.aliqIrpj = :aliqIrpj"),
    @NamedQuery(name = "Tabelasimples.findByAliqCsll", query = "SELECT t FROM Tabelasimples t WHERE t.aliqCsll = :aliqCsll"),
    @NamedQuery(name = "Tabelasimples.findByAliqCofins", query = "SELECT t FROM Tabelasimples t WHERE t.aliqCofins = :aliqCofins"),
    @NamedQuery(name = "Tabelasimples.findByAliqPis", query = "SELECT t FROM Tabelasimples t WHERE t.aliqPis = :aliqPis"),
    @NamedQuery(name = "Tabelasimples.findByAliqCpp", query = "SELECT t FROM Tabelasimples t WHERE t.aliqCpp = :aliqCpp"),
    @NamedQuery(name = "Tabelasimples.findByAliqIcms", query = "SELECT t FROM Tabelasimples t WHERE t.aliqIcms = :aliqIcms"),
    @NamedQuery(name = "Tabelasimples.findByAliqIpi", query = "SELECT t FROM Tabelasimples t WHERE t.aliqIpi = :aliqIpi")})
public class Tabelasimples implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_TABSIMPLES")
    private Long codTabsimples;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RECEITA1_TABSIMPLES")
    private BigDecimal receita1Tabsimples;
    @Column(name = "RECEITA2_TABSIMPLES")
    private BigDecimal receita2Tabsimples;
    @Column(name = "ALIQ_SIMPLES")
    private BigDecimal aliqSimples;
    @Column(name = "ALIQ_IRPJ")
    private BigDecimal aliqIrpj;
    @Column(name = "ALIQ_CSLL")
    private BigDecimal aliqCsll;
    @Column(name = "ALIQ_COFINS")
    private BigDecimal aliqCofins;
    @Column(name = "ALIQ_PIS")
    private BigDecimal aliqPis;
    @Column(name = "ALIQ_CPP")
    private BigDecimal aliqCpp;
    @Column(name = "ALIQ_ICMS")
    private BigDecimal aliqIcms;
    @Column(name = "ALIQ_IPI")
    private BigDecimal aliqIpi;

    public Tabelasimples() {
    }

    public Tabelasimples(Long codTabsimples) {
        this.codTabsimples = codTabsimples;
    }

    public Long getCodTabsimples() {
        return codTabsimples;
    }

    public void setCodTabsimples(Long codTabsimples) {
        this.codTabsimples = codTabsimples;
    }

    public BigDecimal getReceita1Tabsimples() {
        return receita1Tabsimples;
    }

    public void setReceita1Tabsimples(BigDecimal receita1Tabsimples) {
        this.receita1Tabsimples = receita1Tabsimples;
    }

    public BigDecimal getReceita2Tabsimples() {
        return receita2Tabsimples;
    }

    public void setReceita2Tabsimples(BigDecimal receita2Tabsimples) {
        this.receita2Tabsimples = receita2Tabsimples;
    }

    public BigDecimal getAliqSimples() {
        return aliqSimples;
    }

    public void setAliqSimples(BigDecimal aliqSimples) {
        this.aliqSimples = aliqSimples;
    }

    public BigDecimal getAliqIrpj() {
        return aliqIrpj;
    }

    public void setAliqIrpj(BigDecimal aliqIrpj) {
        this.aliqIrpj = aliqIrpj;
    }

    public BigDecimal getAliqCsll() {
        return aliqCsll;
    }

    public void setAliqCsll(BigDecimal aliqCsll) {
        this.aliqCsll = aliqCsll;
    }

    public BigDecimal getAliqCofins() {
        return aliqCofins;
    }

    public void setAliqCofins(BigDecimal aliqCofins) {
        this.aliqCofins = aliqCofins;
    }

    public BigDecimal getAliqPis() {
        return aliqPis;
    }

    public void setAliqPis(BigDecimal aliqPis) {
        this.aliqPis = aliqPis;
    }

    public BigDecimal getAliqCpp() {
        return aliqCpp;
    }

    public void setAliqCpp(BigDecimal aliqCpp) {
        this.aliqCpp = aliqCpp;
    }

    public BigDecimal getAliqIcms() {
        return aliqIcms;
    }

    public void setAliqIcms(BigDecimal aliqIcms) {
        this.aliqIcms = aliqIcms;
    }

    public BigDecimal getAliqIpi() {
        return aliqIpi;
    }

    public void setAliqIpi(BigDecimal aliqIpi) {
        this.aliqIpi = aliqIpi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTabsimples != null ? codTabsimples.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabelasimples)) {
            return false;
        }
        Tabelasimples other = (Tabelasimples) object;
        if ((this.codTabsimples == null && other.codTabsimples != null) || (this.codTabsimples != null && !this.codTabsimples.equals(other.codTabsimples))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Tabelasimples[ codTabsimples=" + codTabsimples + " ]";
    }
    
}
