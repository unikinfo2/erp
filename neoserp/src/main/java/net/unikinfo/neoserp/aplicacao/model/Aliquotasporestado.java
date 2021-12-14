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
@Table(name = "aliquotasporestado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aliquotasporestado.findAll", query = "SELECT a FROM Aliquotasporestado a"),
    @NamedQuery(name = "Aliquotasporestado.findByIdAliquotaEstado", query = "SELECT a FROM Aliquotasporestado a WHERE a.idAliquotaEstado = :idAliquotaEstado"),
    @NamedQuery(name = "Aliquotasporestado.findByNcm", query = "SELECT a FROM Aliquotasporestado a WHERE a.ncm = :ncm"),
    @NamedQuery(name = "Aliquotasporestado.findByUf", query = "SELECT a FROM Aliquotasporestado a WHERE a.uf = :uf"),
    @NamedQuery(name = "Aliquotasporestado.findByUfNcm", query = "SELECT a FROM Aliquotasporestado a WHERE a.uf = :uf and a.ncm = :ncm"),
    @NamedQuery(name = "Aliquotasporestado.findByMva", query = "SELECT a FROM Aliquotasporestado a WHERE a.mva = :mva"),
    @NamedQuery(name = "Aliquotasporestado.findByReducaoBaseIcms", query = "SELECT a FROM Aliquotasporestado a WHERE a.reducaoBaseIcms = :reducaoBaseIcms")})
public class Aliquotasporestado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAliquotaEstado")
    private Long idAliquotaEstado;
    @Basic(optional = false)
    @Column(name = "ncm", length = 8, nullable = false)
    private String ncm;
    @JoinColumn(name = "uf", referencedColumnName = "uf")
    @ManyToOne
    private Estado uf;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mva")
    private BigDecimal mva;
    @Column(name = "reducaoBaseIcms")
    private BigDecimal reducaoBaseIcms;
    @Column(name = "mvaProdutoImportado")
    private BigDecimal mvaProdutoImportado;

    public Aliquotasporestado() {
    }

    public Aliquotasporestado(Long idAliquotaEstado) {
        this.idAliquotaEstado = idAliquotaEstado;
    }

    public Aliquotasporestado(Long idAliquotaEstado, String ncm, Estado uf) {
        this.idAliquotaEstado = idAliquotaEstado;
        this.ncm = ncm;
        this.uf = uf;
    }

    public Long getIdAliquotaEstado() {
        return idAliquotaEstado;
    }

    public void setIdAliquotaEstado(Long idAliquotaEstado) {
        this.idAliquotaEstado = idAliquotaEstado;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public Estado getUf() {
        return uf;
    }

    public void setUf(Estado uf) {
        this.uf = uf;
    }

    public BigDecimal getMva() {
        return mva;
    }

    public void setMva(BigDecimal mva) {
        this.mva = mva;
    }

    public BigDecimal getReducaoBaseIcms() {
        return reducaoBaseIcms;
    }

    public void setReducaoBaseIcms(BigDecimal reducaoBaseIcms) {
        this.reducaoBaseIcms = reducaoBaseIcms;
    }

    public BigDecimal getMvaProdutoImportado() {
        return mvaProdutoImportado;
    }

    public void setMvaProdutoImportado(BigDecimal mvaProdutoImportado) {
        this.mvaProdutoImportado = mvaProdutoImportado;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAliquotaEstado != null ? idAliquotaEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aliquotasporestado)) {
            return false;
        }
        Aliquotasporestado other = (Aliquotasporestado) object;
        if ((this.idAliquotaEstado == null && other.idAliquotaEstado != null) || (this.idAliquotaEstado != null && !this.idAliquotaEstado.equals(other.idAliquotaEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return uf + "-" + ncm;
    }
    
}
