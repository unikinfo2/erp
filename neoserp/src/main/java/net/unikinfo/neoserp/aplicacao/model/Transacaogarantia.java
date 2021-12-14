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
@Table(name = "transacaogarantia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacaogarantia.findAll", query = "SELECT t FROM Transacaogarantia t"),
    @NamedQuery(name = "Transacaogarantia.findByTransacao", query = "SELECT t FROM Transacaogarantia t WHERE t.transacao = :transacao")})
public class Transacaogarantia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransacaoGarantia")
    private Long idTransacaoGarantia;
    @Column(name = "relatoTecnico")
    private String relatoTecnico;
    @Column(name = "solicitacaoCliente")
    private String solicitacaoCliente;        
    @Column(name = "dtOcorrencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtOcorrencia;
    @Column(name = "dtFechamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFechamento;
    @JoinColumn(name = "idTransacao", referencedColumnName = "idTransacao")
    @ManyToOne(optional = false)
    private Transacao transacao;

    public Transacaogarantia() {
    }

    public Long getIdTransacaoGarantia() {
        return idTransacaoGarantia;
    }

    public void setIdTransacaoGarantia(Long idTransacaoGarantia) {
        this.idTransacaoGarantia = idTransacaoGarantia;
    }

    public String getRelatoTecnico() {
        return relatoTecnico;
    }

    public void setRelatoTecnico(String relatoTecnico) {
        this.relatoTecnico = relatoTecnico;
    }

    public String getSolicitacaoCliente() {
        return solicitacaoCliente;
    }

    public void setSolicitacaoCliente(String solicitacaoCliente) {
        this.solicitacaoCliente = solicitacaoCliente;
    }

    public Date getDtOcorrencia() {
        return dtOcorrencia;
    }

    public void setDtOcorrencia(Date dtOcorrencia) {
        this.dtOcorrencia = dtOcorrencia;
    }

    public Date getDtFechamento() {
        return dtFechamento;
    }

    public void setDtFechamento(Date dtFechamento) {
        this.dtFechamento = dtFechamento;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransacaoGarantia != null ? idTransacaoGarantia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacaogarantia)) {
            return false;
        }
        Transacaogarantia other = (Transacaogarantia) object;
        if ((this.idTransacaoGarantia == null && other.idTransacaoGarantia != null) || (this.idTransacaoGarantia != null && !this.idTransacaoGarantia.equals(other.idTransacaoGarantia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "["+idTransacaoGarantia+"]";
    }
    
}
