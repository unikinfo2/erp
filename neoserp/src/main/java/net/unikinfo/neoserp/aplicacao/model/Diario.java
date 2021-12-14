/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
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
@Table(name = "diario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diario.findAll",                query = "SELECT d FROM Diario d"),
    @NamedQuery(name = "Diario.findByIdDiario",         query = "SELECT d FROM Diario d WHERE d.idDiario = :idDiario"),
    @NamedQuery(name = "Diario.findByHistoricoDebito",  query = "SELECT d FROM Diario d WHERE d.historicoDebito = :historicoDebito"),
    @NamedQuery(name = "Diario.findByHistoricoCredito", query = "SELECT d FROM Diario d WHERE d.historicoCredito = :historicoCredito"),
    @NamedQuery(name = "Diario.findByDocumento",        query = "SELECT d FROM Diario d WHERE d.documento = :documento"),
    @NamedQuery(name = "Diario.findByDtLancamento",     query = "SELECT d FROM Diario d WHERE d.dtLancamento = :dtLancamento"),
    @NamedQuery(name = "Diario.findByDtDocumento",      query = "SELECT d FROM Diario d WHERE d.dtDocumento = :dtDocumento"),
    @NamedQuery(name = "Diario.findByPeriodo",          query = "SELECT d FROM Diario d WHERE d.empresa = :empresa and d.dtDocumento >= :dtDocumento1 and d.dtDocumento <= :dtDocumento2 order by d.dtLancamento, d.transacao asc"),
    @NamedQuery(name = "Diario.findByValorLancto",      query = "SELECT d FROM Diario d WHERE d.valorLancto = :valorLancto"),
    @NamedQuery(name = "Diario.findByIdDocumento",      query = "SELECT d FROM Diario d WHERE d.idDocumento = :idDocumento"),
    @NamedQuery(name = "Diario.findByEmpresa",          query = "SELECT d FROM Diario d WHERE d.empresa = :empresa")})
public class Diario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDiario")
    private Long idDiario;
    //@Size(max = 200)
    @Column(name = "historicoDebito")
    private String historicoDebito;
    //@Size(max = 200)
    @Column(name = "historicoCredito")
    private String historicoCredito;
    //@Size(max = 45)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "dtLancamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtLancamento;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "dtDocumento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDocumento;
    @Column(name = "valorLancto")
    private Long valorLancto;
    @Column(name = "idDocumento")
    private Integer idDocumento;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;

    @JoinColumn(name = "idContaDeb", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas planocontasDeb;
    @JoinColumn(name = "idContaCred", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas planocontasCred;
    @JoinColumn(name = "idTransacao", referencedColumnName = "idTransacao")
    @ManyToOne
    private Transacao transacao;
    @JoinColumn(name = "idTransacaoImposto", referencedColumnName = "idTransacaoImposto")
    @ManyToOne
    private Transacaoimposto transacaoimposto;

    public Diario() {
    }

    public Diario(Long idDiario) {
        this.idDiario = idDiario;
    }

    public Diario(Long idDiario, Date dtLancamento, Date dtDocumento) {
        this.idDiario = idDiario;
        this.dtLancamento = dtLancamento;
        this.dtDocumento = dtDocumento;
    }

    public Long getIdDiario() {
        return idDiario;
    }

    public void setIdDiario(Long idDiario) {
        this.idDiario = idDiario;
    }

    public String getHistoricoDebito() {
        return historicoDebito;
    }

    public void setHistoricoDebito(String historicoDebito) {
        this.historicoDebito = historicoDebito;
    }

    public String getHistoricoCredito() {
        return historicoCredito;
    }

    public void setHistoricoCredito(String historicoCredito) {
        this.historicoCredito = historicoCredito;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public Date getDtDocumento() {
        return dtDocumento;
    }

    public void setDtDocumento(Date dtDocumento) {
        this.dtDocumento = dtDocumento;
    }

    public Long getValorLancto() {
        return valorLancto;
    }

    public void setValorLancto(Long valorLancto) {
        this.valorLancto = valorLancto;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Planocontas getPlanocontasDeb() {
        return planocontasDeb;
    }

    public void setPlanocontasDeb(Planocontas planocontasDeb) {
        this.planocontasDeb = planocontasDeb;
    }

    public Planocontas getPlanocontasCred() {
        return planocontasCred;
    }

    public void setPlanocontasCred(Planocontas planocontasCred) {
        this.planocontasCred = planocontasCred;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public Transacaoimposto getTransacaoimposto() {
        return transacaoimposto;
    }

    public void setTransacaoimposto(Transacaoimposto transacaoimposto) {
        this.transacaoimposto = transacaoimposto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiario != null ? idDiario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diario)) {
            return false;
        }
        Diario other = (Diario) object;
        if ((this.idDiario == null && other.idDiario != null) || (this.idDiario != null && !this.idDiario.equals(other.idDiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+ idDiario+" - Transacao = "+this.transacao +"- Deb."+this.planocontasDeb+" - Cred."+this.planocontasCred+" Data."+this.dtLancamento+" Valor. "+this.valorLancto.toString();
    }
    
}
