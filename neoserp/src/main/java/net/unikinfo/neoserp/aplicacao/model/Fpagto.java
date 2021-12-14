/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "fpagto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fpagto.findAll", query = "SELECT f FROM Fpagto f"),
    @NamedQuery(name = "Fpagto.findByIdFPagto", query = "SELECT f FROM Fpagto f WHERE f.idFPagto = :idFPagto"),
    @NamedQuery(name = "Fpagto.findByDescricao", query = "SELECT f FROM Fpagto f WHERE f.descricao = :descricao"),
    @NamedQuery(name = "Fpagto.findByDupApartir", query = "SELECT f FROM Fpagto f WHERE f.dupApartir = :dupApartir")})
public class Fpagto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFPagto")
    private Long idFPagto;
    //@Size(max = 40)
    @Column(name = "descricao")
    private String descricao;
    //@Size(max = 1)
    @Column(name = "dupApartir")
    private String dupApartir;
    @OneToMany(mappedBy = "fpagto")
    private List<Transacao> transacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fpagto")
    private List<Fpagtoitem> fpagtoitemList;

    public Fpagto() {
    }

    public Fpagto(Long idFPagto) {
        this.idFPagto = idFPagto;
    }

    public Long getIdFPagto() {
        return idFPagto;
    }

    public void setIdFPagto(Long idFPagto) {
        this.idFPagto = idFPagto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDupApartir() {
        return dupApartir;
    }

    public void setDupApartir(String dupApartir) {
        this.dupApartir = dupApartir;
    }

    @XmlTransient
    public List<Transacao> getTransacaoList() {
        return transacaoList;
    }

    public void setTransacaoList(List<Transacao> transacaoList) {
        this.transacaoList = transacaoList;
    }

    @XmlTransient
    public List<Fpagtoitem> getFpagtoitemList() {
        return fpagtoitemList;
    }

    public void setFpagtoitemList(List<Fpagtoitem> fpagtoitemList) {
        this.fpagtoitemList = fpagtoitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFPagto != null ? idFPagto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fpagto)) {
            return false;
        }
        Fpagto other = (Fpagto) object;
        if ((this.idFPagto == null && other.idFPagto != null) || (this.idFPagto != null && !this.idFPagto.equals(other.idFPagto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idFPagto + "-" + descricao;
    }
    
}
