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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "centrocusto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centrocusto.findAll", query = "SELECT c FROM Centrocusto c"),
    @NamedQuery(name = "Centrocusto.findByIdCentroCusto", query = "SELECT c FROM Centrocusto c WHERE c.idCentroCusto = :idCentroCusto"),
    @NamedQuery(name = "Centrocusto.findByEmpresa", query = "SELECT c FROM Centrocusto c WHERE c.empresa = :empresa order by c.centrocustoPai, c.nomeCentroCusto"),
    @NamedQuery(name = "Centrocusto.findByNomeCentroCusto", query = "SELECT c FROM Centrocusto c WHERE c.nomeCentroCusto = :nomeCentroCusto")})
public class Centrocusto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCentroCusto")
    private Long idCentroCusto;
    @Column(name = "nomeCentroCusto")
    private String nomeCentroCusto;
    @OneToMany(mappedBy = "centrocustoPai")
    private List<Centrocusto> centrocustoList;
    @JoinColumn(name = "idCentroCustoPai", referencedColumnName = "idCentroCusto")
    @ManyToOne
    private Centrocusto centrocustoPai;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;

    public Centrocusto() {
    }

    public Centrocusto(Long idCentroCusto) {
        this.idCentroCusto = idCentroCusto;
    }

    public Long getIdCentroCusto() {
        return idCentroCusto;
    }

    public void setIdCentroCusto(Long idCentroCusto) {
        this.idCentroCusto = idCentroCusto;
    }

    public String getNomeCentroCusto() {
        return nomeCentroCusto;
    }

    public void setNomeCentroCusto(String nomeCentroCusto) {
        this.nomeCentroCusto = nomeCentroCusto;
    }

    @XmlTransient
    public List<Centrocusto> getCentrocustoList() {
        return centrocustoList;
    }

    public void setCentrocustoList(List<Centrocusto> centrocustoList) {
        this.centrocustoList = centrocustoList;
    }

    public Centrocusto getCentrocustoPai() {
        return centrocustoPai;
    }

    public void setCentrocustoPai(Centrocusto centrocustoPai) {
        this.centrocustoPai = centrocustoPai;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentroCusto != null ? idCentroCusto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centrocusto)) {
            return false;
        }
        Centrocusto other = (Centrocusto) object;
        if ((this.idCentroCusto == null && other.idCentroCusto != null) || (this.idCentroCusto != null && !this.idCentroCusto.equals(other.idCentroCusto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idCentroCusto + "-" + nomeCentroCusto;
    }

}
