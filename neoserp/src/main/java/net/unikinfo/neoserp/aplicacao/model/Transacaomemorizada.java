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
 * @author uniki
 */
@Entity
@Table(name = "transacaomemorizada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacaomemorizada.findAll", query = "SELECT t FROM Transacaomemorizada t"),
    @NamedQuery(name = "Transacaomemorizada.findByIdTransacaoMemorizacao", query = "SELECT t FROM Transacaomemorizada t WHERE t.idTransacaoMemorizacao = :idTransacaoMemorizacao"),
    @NamedQuery(name = "Transacaomemorizada.findByIdEmpresa", query = "SELECT t FROM Transacaomemorizada t WHERE t.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Transacaomemorizada.findByIdTransacao", query = "SELECT t FROM Transacaomemorizada t WHERE t.idTransacao = :idTransacao"),
    @NamedQuery(name = "Transacaomemorizada.findByDescricaoMemorizacao", query = "SELECT t FROM Transacaomemorizada t WHERE t.descricaoMemorizacao = :descricaoMemorizacao"),
    @NamedQuery(name = "Transacaomemorizada.findByGrupoMemorizacao", query = "SELECT t FROM Transacaomemorizada t WHERE t.grupoMemorizacao = :grupoMemorizacao"),
    @NamedQuery(name = "Transacaomemorizada.findByDtMemorizacao", query = "SELECT t FROM Transacaomemorizada t WHERE t.dtMemorizacao = :dtMemorizacao"),
    @NamedQuery(name = "Transacaomemorizada.findByDtUltimaGeracao", query = "SELECT t FROM Transacaomemorizada t WHERE t.dtUltimaGeracao = :dtUltimaGeracao")})
public class Transacaomemorizada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransacaoMemorizacao")
    private Long idTransacaoMemorizacao;
    //@Size(max = 60)
    @Column(name = "descricaoMemorizacao")
    private String descricaoMemorizacao;
    //@Size(max = 50)
    @Column(name = "grupoMemorizacao")
    private String grupoMemorizacao;
    @Column(name = "dtMemorizacao")
    @Temporal(TemporalType.DATE)
    private Date dtMemorizacao;
    @Column(name = "dtUltimaGeracao")
    @Temporal(TemporalType.DATE)
    private Date dtUltimaGeracao;
    @JoinColumn(name = "idTransacao", referencedColumnName = "idTransacao")
    @ManyToOne
    private Transacao idTransacao;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa idEmpresa;

    public Transacaomemorizada() {
    }

    public Transacaomemorizada(Long idTransacaoMemorizacao) {
        this.idTransacaoMemorizacao = idTransacaoMemorizacao;
    }

    public Long getIdTransacaoMemorizacao() {
        return idTransacaoMemorizacao;
    }

    public void setIdTransacaoMemorizacao(Long idTransacaoMemorizacao) {
        this.idTransacaoMemorizacao = idTransacaoMemorizacao;
    }

    public String getDescricaoMemorizacao() {
        return descricaoMemorizacao;
    }

    public void setDescricaoMemorizacao(String descricaoMemorizacao) {
        this.descricaoMemorizacao = descricaoMemorizacao;
    }

    public String getGrupoMemorizacao() {
        return grupoMemorizacao;
    }

    public void setGrupoMemorizacao(String grupoMemorizacao) {
        this.grupoMemorizacao = grupoMemorizacao;
    }

    public Date getDtMemorizacao() {
        return dtMemorizacao;
    }

    public void setDtMemorizacao(Date dtMemorizacao) {
        this.dtMemorizacao = dtMemorizacao;
    }

    public Date getDtUltimaGeracao() {
        return dtUltimaGeracao;
    }

    public void setDtUltimaGeracao(Date dtUltimaGeracao) {
        this.dtUltimaGeracao = dtUltimaGeracao;
    }

    public Transacao getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Transacao idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransacaoMemorizacao != null ? idTransacaoMemorizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacaomemorizada)) {
            return false;
        }
        Transacaomemorizada other = (Transacaomemorizada) object;
        if ((this.idTransacaoMemorizacao == null && other.idTransacaoMemorizacao != null) || (this.idTransacaoMemorizacao != null && !this.idTransacaoMemorizacao.equals(other.idTransacaoMemorizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Transacaomemorizada[ idTransacaoMemorizacao=" + idTransacaoMemorizacao + " ]";
    }
    
}
