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
@Table(name = "transacaoitemimposto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacaoitemimposto.findAll", query = "SELECT t FROM Transacaoitemimposto t"),
    @NamedQuery(name = "Transacaoitemimposto.findByIdTransacaoItemImposto", query = "SELECT t FROM Transacaoitemimposto t WHERE t.idTransacaoItemImposto = :idTransacaoItemImposto"),
    @NamedQuery(name = "Transacaoitemimposto.findByTransacaoItem", query = "SELECT t FROM Transacaoitemimposto t WHERE t.transacaoItem = :transacaoItem"),
    @NamedQuery(name = "Transacaoitemimposto.findByBaseCalculoImposto", query = "SELECT t FROM Transacaoitemimposto t WHERE t.baseCalculoImposto = :baseCalculoImposto"),
    @NamedQuery(name = "Transacaoitemimposto.findByAliqImposto", query = "SELECT t FROM Transacaoitemimposto t WHERE t.aliqImposto = :aliqImposto"),
    @NamedQuery(name = "Transacaoitemimposto.findByValorImposto", query = "SELECT t FROM Transacaoitemimposto t WHERE t.valorImposto = :valorImposto"),
    @NamedQuery(name = "Transacaoitemimposto.findByCstItemImposto", query = "SELECT t FROM Transacaoitemimposto t WHERE t.cstItemImposto = :cstItemImposto")})
public class Transacaoitemimposto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //@NotNull
    @Column(name = "idTransacaoItemImposto")
    private Long idTransacaoItemImposto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "baseCalculoImposto")
    private BigDecimal baseCalculoImposto;
    @Column(name = "aliqImposto")
    private BigDecimal aliqImposto;
    @Column(name = "valorImposto")
    private BigDecimal valorImposto;
    //@Size(max = 4)
    @Column(name = "cstItemImposto")
    private String cstItemImposto;

    @JoinColumn(name = "idTipoimposto", referencedColumnName = "idTipoimposto")
    @ManyToOne
    private Tipoimposto tipoImposto;
    
    @JoinColumn(name = "idTransacaoItem", referencedColumnName = "idTransacaoItem")
    @ManyToOne
    private Transacaoitem transacaoItem;
    
    @JoinColumn(name = "idContaDebito", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas contaDebito;
    
    @JoinColumn(name = "idContaCredito", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas contaCredito;
    
    @JoinColumn(name = "idClifor", referencedColumnName = "idClifor")
    @ManyToOne
    private Clifor cliFor;
    
    @JoinColumn(name = "idTransacao", referencedColumnName = "idTransacao")
    @ManyToOne
    private Transacao transacao;
    

    public Transacaoitemimposto() {
    }

    public Transacaoitemimposto(Long idTransacaoItemImposto) {
        this.idTransacaoItemImposto = idTransacaoItemImposto;
    }

    public Long getIdTransacaoItemImposto() {
        return idTransacaoItemImposto;
    }

    public void setIdTransacaoItemImposto(Long idTransacaoItemImposto) {
        this.idTransacaoItemImposto = idTransacaoItemImposto;
    }

    public BigDecimal getBaseCalculoImposto() {
        return baseCalculoImposto;
    }

    public void setBaseCalculoImposto(BigDecimal baseCalculoImposto) {
        this.baseCalculoImposto = baseCalculoImposto;
    }

    public BigDecimal getAliqImposto() {
        return aliqImposto;
    }

    public void setAliqImposto(BigDecimal aliqImposto) {
        this.aliqImposto = aliqImposto;
    }

    public BigDecimal getValorImposto() {
        return valorImposto;
    }

    public void setValorImposto(BigDecimal valorImposto) {
        this.valorImposto = valorImposto;
    }

    public String getCstItemImposto() {
        return cstItemImposto;
    }

    public void setCstItemImposto(String cstItemImposto) {
        this.cstItemImposto = cstItemImposto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransacaoItemImposto != null ? idTransacaoItemImposto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacaoitemimposto)) {
            return false;
        }
        Transacaoitemimposto other = (Transacaoitemimposto) object;
        if ((this.idTransacaoItemImposto == null && other.idTransacaoItemImposto != null) || (this.idTransacaoItemImposto != null && !this.idTransacaoItemImposto.equals(other.idTransacaoItemImposto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Transacaoitemimposto[ idTransacaoItemImposto=" + idTransacaoItemImposto + " ]";
    }

    public Tipoimposto getTipoImposto() {
        return tipoImposto;
    }

    public void setTipoImposto(Tipoimposto tipoImposto) {
        this.tipoImposto = tipoImposto;
    }

    public Transacaoitem getTransacaoItem() {
        return transacaoItem;
    }

    public void setTransacaoItem(Transacaoitem transacaoItem) {
        this.transacaoItem = transacaoItem;
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

    public Clifor getCliFor() {
        return cliFor;
    }

    public void setCliFor(Clifor cliFor) {
        this.cliFor = cliFor;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }
    
}
