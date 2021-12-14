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
@Table(name = "transacaoconta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacaoconta.findAll", query = "SELECT t FROM Transacaoconta t"),
    @NamedQuery(name = "Transacaoconta.findByIdTransacaoConta", query = "SELECT t FROM Transacaoconta t WHERE t.idTransacaoConta = :idTransacaoConta"),
    @NamedQuery(name = "Transacaoconta.findByTransacao", query = "SELECT t FROM Transacaoconta t WHERE t.transacao = :transacao"),    
    @NamedQuery(name = "Transacaoconta.findByValorLancto", query = "SELECT t FROM Transacaoconta t WHERE t.valorLancto = :valorLancto"),
    @NamedQuery(name = "Transacaoconta.findByHistoricoLancto", query = "SELECT t FROM Transacaoconta t WHERE t.historicoLancto = :historicoLancto")})
public class Transacaoconta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransacaoConta")
    private Long idTransacaoConta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorLancto")
    private BigDecimal valorLancto;    
    @Column(name = "historicoLancto")
    private String historicoLancto;
    @JoinColumn(name = "idTransacao", referencedColumnName = "idTransacao")
    @ManyToOne
    private Transacao transacao;
    @JoinColumn(name = "idConta", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas conta;

    public Transacaoconta() {
    }

    public Transacaoconta(Long idTransacaoConta) {
        this.idTransacaoConta = idTransacaoConta;
    }

    public Transacaoconta(Long idTransacaoConta, String historicoLancto) {
        this.idTransacaoConta = idTransacaoConta;
        this.historicoLancto = historicoLancto;
    }

    public Long getIdTransacaoConta() {
        return idTransacaoConta;
    }

    public void setIdTransacaoConta(Long idTransacaoConta) {
        this.idTransacaoConta = idTransacaoConta;
    }

    public BigDecimal getValorLancto() {
        return valorLancto;
    }

    public void setValorLancto(BigDecimal valorLancto) {
        this.valorLancto = valorLancto;
    }

    public String getHistoricoLancto() {
        return historicoLancto;
    }

    public void setHistoricoLancto(String historicoLancto) {
        this.historicoLancto = historicoLancto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransacaoConta != null ? idTransacaoConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacaoconta)) {
            return false;
        }
        Transacaoconta other = (Transacaoconta) object;
        if ((this.idTransacaoConta == null && other.idTransacaoConta != null) || (this.idTransacaoConta != null && !this.idTransacaoConta.equals(other.idTransacaoConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Transacaoconta[ idTransacaoConta=" + idTransacaoConta + " ]";
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public Planocontas getConta() {
        return conta;
    }

    public void setConta(Planocontas conta) {
        this.conta = conta;
    }
    
}
