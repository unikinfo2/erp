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
@Table(name = "fpagtoitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fpagtoitem.findAll", query = "SELECT f FROM Fpagtoitem f"),
    @NamedQuery(name = "Fpagtoitem.findByIdFPagtoItem", query = "SELECT f FROM Fpagtoitem f WHERE f.idFPagtoItem = :idFPagtoItem"),
    @NamedQuery(name = "Fpagtoitem.findByFPagto", query = "SELECT f FROM Fpagtoitem f WHERE f.fpagto = :fpagto"),
    @NamedQuery(name = "Fpagtoitem.findByQtdeDias", query = "SELECT f FROM Fpagtoitem f WHERE f.qtdeDias = :qtdeDias"),
    @NamedQuery(name = "Fpagtoitem.findByPercentualParc", query = "SELECT f FROM Fpagtoitem f WHERE f.percentualParc = :percentualParc")})
public class Fpagtoitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFPagtoItem")
    private Long idFPagtoItem;
    @Column(name = "qtdeDias")
    private Integer qtdeDias;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentualParc")
    private BigDecimal percentualParc;
    @JoinColumn(name = "idFPagto", referencedColumnName = "idFPagto")
    @ManyToOne(optional = false)
    private Fpagto fpagto;

    public Fpagtoitem() {
    }

    public Fpagtoitem(Long idFPagtoItem) {
        this.idFPagtoItem = idFPagtoItem;
    }

    public Long getIdFPagtoItem() {
        return idFPagtoItem;
    }

    public void setIdFPagtoItem(Long idFPagtoItem) {
        this.idFPagtoItem = idFPagtoItem;
    }

    public Integer getQtdeDias() {
        return qtdeDias;
    }

    public void setQtdeDias(Integer qtdeDias) {
        this.qtdeDias = qtdeDias;
    }

    public BigDecimal getPercentualParc() {
        return percentualParc;
    }

    public void setPercentualParc(BigDecimal percentualParc) {
        this.percentualParc = percentualParc;
    }

    public Fpagto getFpagto() {
        return fpagto;
    }

    public void setFpagto(Fpagto fpagto) {
        this.fpagto = fpagto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFPagtoItem != null ? idFPagtoItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fpagtoitem)) {
            return false;
        }
        Fpagtoitem other = (Fpagtoitem) object;
        if ((this.idFPagtoItem == null && other.idFPagtoItem != null) || (this.idFPagtoItem != null && !this.idFPagtoItem.equals(other.idFPagtoItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "["+idFPagtoItem+"]";
    }
    
}
