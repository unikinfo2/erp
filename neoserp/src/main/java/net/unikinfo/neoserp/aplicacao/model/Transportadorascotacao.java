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
@Table(name = "transportadorascotacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportadorascotacao.findAll", query = "SELECT t FROM Transportadorascotacao t"),
    @NamedQuery(name = "Transportadorascotacao.findByIdTransportadorasCotacao", query = "SELECT t FROM Transportadorascotacao t WHERE t.idTransportadorasCotacao = :idTransportadorasCotacao"),
    @NamedQuery(name = "Transportadorascotacao.findByOrdemDespacho", query = "SELECT t FROM Transportadorascotacao t WHERE t.idOrdemDespacho = :ordemdespacho"),
    @NamedQuery(name = "Transportadorascotacao.findByIdTransp", query = "SELECT t FROM Transportadorascotacao t WHERE t.idTransp = :idTransp"),
    @NamedQuery(name = "Transportadorascotacao.findByAprovada", query = "SELECT t FROM Transportadorascotacao t WHERE t.aprovada = :aprovada"),
    @NamedQuery(name = "Transportadorascotacao.findByPrazoDias", query = "SELECT t FROM Transportadorascotacao t WHERE t.prazoDias = :prazoDias"),
    @NamedQuery(name = "Transportadorascotacao.findByPrecoCubado", query = "SELECT t FROM Transportadorascotacao t WHERE t.precoCubado = :precoCubado")})
public class Transportadorascotacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransportadorasCotacao")
    private Long idTransportadorasCotacao;
    //@Basic(optional = false)
    //@NotNull
    //@Column(name = "idTransp")
    @ManyToOne(optional = false)
    @JoinColumn(name = "idTransp", referencedColumnName = "idTransp")
    private Transportadora idTransp;
    //@Size(max = 1)
    @Column(name = "aprovada")
    private String aprovada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prazoDias")
    private BigDecimal prazoDias;
    @Column(name = "precoCubado")
    private BigDecimal precoCubado;
    @JoinColumn(name = "idOrdemDespacho", referencedColumnName = "idOrdemDespacho")
    @ManyToOne(optional = false)
    private OrdemDespacho idOrdemDespacho;
    @Column(name = "pessoaContato")
    private String pessoaContato;

    public Transportadorascotacao() {
    }

    public Transportadorascotacao(Long idTransportadorasCotacao) {
        this.idTransportadorasCotacao = idTransportadorasCotacao;
    }

    public Transportadorascotacao(Long idTransportadorasCotacao, Transportadora idTransp) {
        this.idTransportadorasCotacao = idTransportadorasCotacao;
        this.idTransp = idTransp;
    }

    public Long getIdTransportadorasCotacao() {
        return idTransportadorasCotacao;
    }

    public void setIdTransportadorasCotacao(Long idTransportadorasCotacao) {
        this.idTransportadorasCotacao = idTransportadorasCotacao;
    }

    public Transportadora getIdTransp() {
        return idTransp;
    }

    public void setIdTransp(Transportadora idTransp) {
        this.idTransp = idTransp;
    }

    public String getAprovada() {
        return aprovada;
    }

    public void setAprovada(String aprovada) {
        this.aprovada = aprovada;
    }

    public BigDecimal getPrazoDias() {
        return prazoDias;
    }

    public void setPrazoDias(BigDecimal prazoDias) {
        this.prazoDias = prazoDias;
    }

    public BigDecimal getPrecoCubado() {
        return precoCubado;
    }

    public void setPrecoCubado(BigDecimal precoCubado) {
        this.precoCubado = precoCubado;
    }

    public OrdemDespacho getIdOrdemDespacho() {
        return idOrdemDespacho;
    }

    public void setIdOrdemDespacho(OrdemDespacho idOrdemDespacho) {
        this.idOrdemDespacho = idOrdemDespacho;
    }

    public String getPessoaContato() {
        return pessoaContato;
    }

    public void setPessoaContato(String pessoaContato) {
        this.pessoaContato = pessoaContato;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransportadorasCotacao != null ? idTransportadorasCotacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportadorascotacao)) {
            return false;
        }
        Transportadorascotacao other = (Transportadorascotacao) object;
        if ((this.idTransportadorasCotacao == null && other.idTransportadorasCotacao != null) || (this.idTransportadorasCotacao != null && !this.idTransportadorasCotacao.equals(other.idTransportadorasCotacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idTransportadorasCotacao+"";
    }
    
}
