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
@Table(name = "unidademedida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidademedida.findAll", query = "SELECT u FROM Unidademedida u"),
    @NamedQuery(name = "Unidademedida.findByCodUniMed", query = "SELECT u FROM Unidademedida u WHERE u.codUniMed = :codUniMed"),
    @NamedQuery(name = "Unidademedida.findByDescUniMed", query = "SELECT u FROM Unidademedida u WHERE u.descUniMed = :descUniMed"),
    @NamedQuery(name = "Unidademedida.findByFatorUniMed", query = "SELECT u FROM Unidademedida u WHERE u.fatorUniMed = :fatorUniMed")})
public class Unidademedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codunimed", length = 6, nullable = false)
    private String codUniMed;
    @Column(name = "descunimed", length = 40)
    private String descUniMed;
    @Column(name = "fatorunimed")
    private BigDecimal fatorUniMed;

    public Unidademedida() {
    }

    public Unidademedida(String codUniMed) {
        this.codUniMed = codUniMed;
    }

    public String getCodUniMed() {
        return codUniMed;
    }

    public void setCodUniMed(String codUniMed) {
        this.codUniMed = codUniMed;
    }

    public String getDescUniMed() {
        return descUniMed;
    }

    public void setDescUniMed(String descUniMed) {
        this.descUniMed = descUniMed;
    }

    public BigDecimal getFatorUniMed() {
        return fatorUniMed;
    }

    public void setFatorUniMed(BigDecimal fatorUniMed) {
        this.fatorUniMed = fatorUniMed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUniMed != null ? codUniMed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidademedida)) {
            return false;
        }
        Unidademedida other = (Unidademedida) object;
        if ((this.codUniMed == null && other.codUniMed != null) || (this.codUniMed != null && !this.codUniMed.equals(other.codUniMed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codUniMed + "-" + descUniMed;
    }
    
}
