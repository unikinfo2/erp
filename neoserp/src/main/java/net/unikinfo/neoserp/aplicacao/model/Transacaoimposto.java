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
@Table(name = "transacaoimposto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacaoimposto.findAll", query = "SELECT t FROM Transacaoimposto t"),
    @NamedQuery(name = "Transacaoimposto.findByIdTransacaoImposto", query = "SELECT t FROM Transacaoimposto t WHERE t.idTransacaoImposto = :idTransacaoImposto"),
    @NamedQuery(name = "Transacaoimposto.findByTransacao", query = "SELECT t FROM Transacaoimposto t WHERE t.transacao = :transacao"),
    @NamedQuery(name = "Transacaoimposto.findByBaseCalculoImposto", query = "SELECT t FROM Transacaoimposto t WHERE t.baseCalculoImposto = :baseCalculoImposto"),
    @NamedQuery(name = "Transacaoimposto.findByAliqImposto", query = "SELECT t FROM Transacaoimposto t WHERE t.aliqImposto = :aliqImposto"),
    @NamedQuery(name = "Transacaoimposto.findByValorImposto", query = "SELECT t FROM Transacaoimposto t WHERE t.valorImposto = :valorImposto")})
public class Transacaoimposto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransacaoImposto")
    private Long idTransacaoImposto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "baseCalculoImposto")
    private BigDecimal baseCalculoImposto;
    @Column(name = "aliqImposto")
    private BigDecimal aliqImposto;
    @Column(name = "valorImposto")
    private BigDecimal valorImposto;
    //@OneToMany(mappedBy = "transacaoimposto")
    //private List<Diario> diarioList;
    @JoinColumn(name = "idTipoImposto", referencedColumnName = "idTipoImposto")
    @ManyToOne
    private Tipoimposto tipoimposto;
    @JoinColumn(name = "idTransacao", referencedColumnName = "idTransacao")
    @ManyToOne(optional = false)
    private Transacao transacao;
    @JoinColumn(name = "idContaDebito", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas planocontas;
    @JoinColumn(name = "idContaCredito", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas planocontas1;
    @JoinColumn(name = "idCliFor", referencedColumnName = "idCliFor")
    @ManyToOne
    private Clifor clifor;

    public Transacaoimposto() {
    }

    public Transacaoimposto(Long idTransacaoImposto) {
        this.idTransacaoImposto = idTransacaoImposto;
    }

    public Long getIdTransacaoImposto() {
        return idTransacaoImposto;
    }

    public void setIdTransacaoImposto(Long idTransacaoImposto) {
        this.idTransacaoImposto = idTransacaoImposto;
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

    /*@XmlTransient
    public List<Diario> getDiarioList() {
        return diarioList;
    }

    public void setDiarioList(List<Diario> diarioList) {
        this.diarioList = diarioList;
    }*/

    public Tipoimposto getTipoimposto() {
        return tipoimposto;
    }

    public void setTipoimposto(Tipoimposto tipoimposto) {
        this.tipoimposto = tipoimposto;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public Planocontas getPlanocontas() {
        return planocontas;
    }

    public void setPlanocontas(Planocontas planocontas) {
        this.planocontas = planocontas;
    }

    public Planocontas getPlanocontas1() {
        return planocontas1;
    }

    public void setPlanocontas1(Planocontas planocontas1) {
        this.planocontas1 = planocontas1;
    }

    public Clifor getClifor() {
        return clifor;
    }

    public void setClifor(Clifor clifor) {
        this.clifor = clifor;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransacaoImposto != null ? idTransacaoImposto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacaoimposto)) {
            return false;
        }
        Transacaoimposto other = (Transacaoimposto) object;
        if ((this.idTransacaoImposto == null && other.idTransacaoImposto != null) || (this.idTransacaoImposto != null && !this.idTransacaoImposto.equals(other.idTransacaoImposto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Transacaoimposto[ idTransacaoImposto=" + idTransacaoImposto + " ]";
    }
    
}
