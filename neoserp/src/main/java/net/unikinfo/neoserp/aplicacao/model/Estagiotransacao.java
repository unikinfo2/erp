/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "estagiotransacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estagiotransacao.findAll", query = "SELECT e FROM Estagiotransacao e"),
    @NamedQuery(name = "Estagiotransacao.findByIdEstagioTransacao", query = "SELECT e FROM Estagiotransacao e WHERE e.idEstagioTransacao = :idEstagioTransacao"),
    @NamedQuery(name = "Estagiotransacao.findByNomeEstagio", query = "SELECT e FROM Estagiotransacao e WHERE e.nomeEstagio = :nomeEstagio")})
public class Estagiotransacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstagioTransacao")
    private Long idEstagioTransacao;
    //@Size(max = 30)
    @Column(name = "nomeEstagio")
    private String nomeEstagio;
    @OneToMany(mappedBy = "estagiotransacao")
    private List<Transacao> transacaoList;

    public Estagiotransacao() {
    }

    public Estagiotransacao(Long idEstagioTransacao) {
        this.idEstagioTransacao = idEstagioTransacao;
    }

    public Estagiotransacao(Long idEstagioTransacao, String nomeEstagio) {
        this.idEstagioTransacao = idEstagioTransacao;
        this.nomeEstagio        = nomeEstagio;
    }

    public Long getIdEstagioTransacao() {
        return idEstagioTransacao;
    }

    public void setIdEstagioTransacao(Long idEstagioTransacao) {
        this.idEstagioTransacao = idEstagioTransacao;
    }

    public String getNomeEstagio() {
        return nomeEstagio;
    }

    public void setNomeEstagio(String nomeEstagio) {
        this.nomeEstagio = nomeEstagio;
    }

    @XmlTransient
    public List<Transacao> getTransacaoList() {
        return transacaoList;
    }

    public void setTransacaoList(List<Transacao> transacaoList) {
        this.transacaoList = transacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstagioTransacao != null ? idEstagioTransacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estagiotransacao)) {
            return false;
        }
        Estagiotransacao other = (Estagiotransacao) object;
        if ((this.idEstagioTransacao == null && other.idEstagioTransacao != null) || (this.idEstagioTransacao != null && !this.idEstagioTransacao.equals(other.idEstagioTransacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idEstagioTransacao + "-" + nomeEstagio;
    }
    
}
