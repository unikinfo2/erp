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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByUf", query = "SELECT e FROM Estado e WHERE e.uf = :uf"),
    @NamedQuery(name = "Estado.findByNomeUf", query = "SELECT e FROM Estado e WHERE e.nomeUf = :nomeUf"),
    @NamedQuery(name = "Estado.findAllUf", query = "SELECT e FROM Estado e WHERE e.uf is not null"),
    @NamedQuery(name = "Estado.findByAliqSt", query = "SELECT e FROM Estado e WHERE e.aliqSt = :aliqSt")})
public class Estado implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "uf")
    private String uf;
    @Column(name = "nomeUf")
    private String nomeUf;
    @Column(name = "aliqSt")
    private BigDecimal aliqSt;
    @Column(name = "aliqInterestadual")
    private BigDecimal aliqInterestadual;
    @Column(name = "aliqDentroEstado")
    private BigDecimal aliqDentroEstado;
    @Column(name = "aliqImportado1")
    private BigDecimal aliqImportado1;
    @Column(name = "aliqImportado2")
    private BigDecimal aliqImportado2;
    @Column(name = "aliqFCP")
    private BigDecimal aliqFCP;
    
    @Column(name = "codigoUF")
    private String codigoUF;
    

    public Estado() {
    }

    public Estado(String uf) {
        this.uf = uf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNomeUf() {
        return nomeUf;
    }

    public void setNomeUf(String nomeUf) {
        this.nomeUf = nomeUf;
    }

    public BigDecimal getAliqSt() {
        return aliqSt;
    }

    public void setAliqSt(BigDecimal aliqSt) {
        this.aliqSt = aliqSt;
    }

    public String getCodigoUF() {
        return codigoUF;
    }

    public void setCodigoUF(String codigoUF) {
        this.codigoUF = codigoUF;
    }

    public BigDecimal getAliqFCP() {
        return aliqFCP;
    }

    public void setAliqFCP(BigDecimal aliqFCP) {
        this.aliqFCP = aliqFCP;
    }

    
/*    @XmlTransient
    public List<Transportadora> getTransportadoraList() {
        return transportadoraList;
    }

    public void setTransportadoraList(List<Transportadora> transportadoraList) {
        this.transportadoraList = transportadoraList;
    }

    @XmlTransient
    public List<Representante> getRepresentanteList() {
        return representanteList;
    }

    public void setRepresentanteList(List<Representante> representanteList) {
        this.representanteList = representanteList;
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

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    } */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uf != null ? uf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.uf == null && other.uf != null) || (this.uf != null && !this.uf.equals(other.uf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return uf + "-" + nomeUf;
    }

    public BigDecimal getAliqInterestadual() {
        return aliqInterestadual;
    }

    public void setAliqInterestadual(BigDecimal aliqInterestadual) {
        this.aliqInterestadual = aliqInterestadual;
    }

    public BigDecimal getAliqDentroEstado() {
        return aliqDentroEstado;
    }

    public void setAliqDentroEstado(BigDecimal aliqDentroEstado) {
        this.aliqDentroEstado = aliqDentroEstado;
    }

    public BigDecimal getAliqImportado1() {
        return aliqImportado1;
    }

    public void setAliqImportado1(BigDecimal aliqImportado1) {
        this.aliqImportado1 = aliqImportado1;
    }

    public BigDecimal getAliqImportado2() {
        return aliqImportado2;
    }

    public void setAliqImportado2(BigDecimal aliqImportado2) {
        this.aliqImportado2 = aliqImportado2;
    }
    
}
