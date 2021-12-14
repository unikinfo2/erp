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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "paisibge")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paisibge.findAll", query = "SELECT p FROM Paisibge p"),
    @NamedQuery(name = "Paisibge.findByIdPais", query = "SELECT p FROM Paisibge p WHERE p.idPais = :idPais"),
    @NamedQuery(name = "Paisibge.findByNomePais", query = "SELECT p FROM Paisibge p WHERE p.nomePais = :nomePais")})
public class Paisibge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "idPais")
    private Long idPais;
    //@Size(max = 50)
    @Column(name = "nomePais")
    private String nomePais;
    //@Size(max = 45)
    @Column(name = "codPais4R")
    private String codPais4R;
    @OneToMany(mappedBy = "paisibge")
    private List<Clifor> cliforList;
    @OneToMany(mappedBy = "paisibge1")
    private List<Clifor> cliforList1;
    @OneToMany(mappedBy = "paisibge2")
    private List<Clifor> cliforList2;

    public Paisibge() {
    }

    public Paisibge(Long idPais) {
        this.idPais = idPais;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    @XmlTransient
    public List<Clifor> getCliforList() {
        return cliforList;
    }

    public void setCliforList(List<Clifor> cliforList) {
        this.cliforList = cliforList;
    }

    @XmlTransient
    public List<Clifor> getCliforList1() {
        return cliforList1;
    }

    public void setCliforList1(List<Clifor> cliforList1) {
        this.cliforList1 = cliforList1;
    }

    @XmlTransient
    public List<Clifor> getCliforList2() {
        return cliforList2;
    }

    public void setCliforList2(List<Clifor> cliforList2) {
        this.cliforList2 = cliforList2;
    }

    public String getCodPais4R() {
        return codPais4R;
    }

    public void setCodPais4R(String codPais4R) {
        this.codPais4R = codPais4R;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPais != null ? idPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paisibge)) {
            return false;
        }
        Paisibge other = (Paisibge) object;
        if ((this.idPais == null && other.idPais != null) || (this.idPais != null && !this.idPais.equals(other.idPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPais + "-" + nomePais;
    }

}
