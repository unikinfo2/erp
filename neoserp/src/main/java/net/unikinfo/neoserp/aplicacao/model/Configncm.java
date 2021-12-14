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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "configncm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configncm.findAll", query = "SELECT c FROM Configncm c"),
    @NamedQuery(name = "Configncm.findByNcm", query = "SELECT c FROM Configncm c WHERE c.ncm = :ncm"),
    @NamedQuery(name = "Configncm.findByDescricaoNcm", query = "SELECT c FROM Configncm c WHERE c.descricaoNcm = :descricaoNcm"),
    @NamedQuery(name = "Configncm.findByAliqIpi", query = "SELECT c FROM Configncm c WHERE c.aliqIpi = :aliqIpi"),
    @NamedQuery(name = "Configncm.findByAliqLeiTransparencia", query = "SELECT c FROM Configncm c WHERE c.aliqLeiTransparencia = :aliqLeiTransparencia"),
    @NamedQuery(name = "Configncm.findByCest", query = "SELECT c FROM Configncm c WHERE c.cest = :cest")})
public class Configncm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNcm")
    private Long idNcm;
    //@NotNull
    //@Size(max = 8)
    @Column(name = "ncm")
    private String ncm;

    //@Size(max = 50)
    @Column(name = "descricaoNcm")
    private String descricaoNcm;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "aliqIpi")
    private BigDecimal aliqIpi;
    @Column(name = "aliqLeiTransparencia")
    private BigDecimal aliqLeiTransparencia;
    //@Size(max = 7)
    @Column(name = "cest")
    private String cest;

    public Configncm() {
    }

    public Configncm(Long idNcm) {
        this.idNcm = idNcm;
    }    
    
    public Long getIdNcm() {
        return idNcm;
    }

    public void setIdNcm(Long idNcm) {
        this.idNcm = idNcm;
    }
    
    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getDescricaoNcm() {
        return descricaoNcm;
    }

    public void setDescricaoNcm(String descricaoNcm) {
        this.descricaoNcm = descricaoNcm;
    }

    public BigDecimal getAliqIpi() {
        return aliqIpi;
    }

    public void setAliqIpi(BigDecimal aliqIpi) {
        this.aliqIpi = aliqIpi;
    }

    public BigDecimal getAliqLeiTransparencia() {
        return aliqLeiTransparencia;
    }

    public void setAliqLeiTransparencia(BigDecimal aliqLeiTransparencia) {
        this.aliqLeiTransparencia = aliqLeiTransparencia;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNcm != null ? idNcm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configncm)) {
            return false;
        }
        Configncm other = (Configncm) object;
        if ((this.idNcm == null && other.idNcm != null) || (this.idNcm != null && !this.idNcm.equals(other.idNcm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idNcm + "-" + descricaoNcm;
    }
    
}
