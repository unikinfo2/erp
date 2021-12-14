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
@Table(name = "municipioibge")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipioibge.findAll", query = "SELECT m FROM Municipioibge m"),
    @NamedQuery(name = "Municipioibge.findByIdMunicipio", query = "SELECT m FROM Municipioibge m WHERE m.idMunicipio = :idMunicipio"),
    @NamedQuery(name = "Municipioibge.findByNomeMunicipio", query = "SELECT m FROM Municipioibge m WHERE m.nomeMunicipio = :nomeMunicipio"),
    @NamedQuery(name = "Municipioibge.findByUfMunicipio", query = "SELECT m FROM Municipioibge m WHERE m.ufMunicipio = :ufMunicipio")})
public class Municipioibge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "idMunicipio")
    private Long idMunicipio;
    //@Size(max = 50)
    @Column(name = "nomeMunicipio")
    private String nomeMunicipio;
    //@Size(max = 2)
    @Column(name = "ufMunicipio")
    private String ufMunicipio;
    @OneToMany(mappedBy = "municipioibge")
    private List<Clifor> cliforList;
    @OneToMany(mappedBy = "municipioibge1")
    private List<Clifor> cliforList1;
    @OneToMany(mappedBy = "municipioibge2")
    private List<Clifor> cliforList2;

    public Municipioibge() {
    }

    public Municipioibge(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public String getUfMunicipio() {
        return ufMunicipio;
    }

    public void setUfMunicipio(String ufMunicipio) {
        this.ufMunicipio = ufMunicipio;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipioibge)) {
            return false;
        }
        Municipioibge other = (Municipioibge) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ufMunicipio + "-" + nomeMunicipio;
    }
    
}
