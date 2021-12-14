/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "ordemdespachoitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdemDespachoItem.findAll", query = "SELECT e FROM OrdemDespachoItem e"),
    @NamedQuery(name = "OrdemDespachoItem.findByPedido", query = "SELECT d FROM OrdemDespachoItem d WHERE d.idOrdemDespacho.transacao = :transacao"),
    @NamedQuery(name = "OrdemDespachoItem.findByOrdemDespacho", query = "SELECT d FROM OrdemDespachoItem d WHERE d.idOrdemDespacho = :ordemDespacho and d.idOrdemDespacho.transacao.empresa = :empresa")})

public class OrdemDespachoItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDespachoItem")
    private Long idDespachoItem;
    //@Size(max = 250)
    @Column(name = "volume")
    private String volume;
    //@Size(max = 250)
    @Column(name = "dim1")
    private String dim1;
    //@Size(max = 250)
    @Column(name = "dim2")
    private String dim2;
    //@Size(max = 250)
    @Column(name = "dim3") 
    private String dim3;
    @Column(name = "peso")
    private BigDecimal peso;
    @Column(name = "pesoCubado")
    private BigDecimal pesoCubado;
    @JoinColumn(name = "idOrdemDespacho", referencedColumnName = "idOrdemDespacho")
    @ManyToOne
    private OrdemDespacho idOrdemDespacho;
    
    public OrdemDespachoItem() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDespachoItem != null ? idDespachoItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemDespachoItem)) {
            return false;
        }
        OrdemDespachoItem other = (OrdemDespachoItem) object;
        if ((this.idDespachoItem == null && other.idDespachoItem != null) || (this.idDespachoItem != null && !this.idDespachoItem.equals(other.idDespachoItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.DespachoItem[ idDespachoItem=" + idDespachoItem + " ]";
    }

    public Long getIdDespachoItem() {
        return idDespachoItem;
    }

    public void setIdDespachoItem(Long idDespachoItem) {
        this.idDespachoItem = idDespachoItem;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getDim1() {
        return dim1;
    }

    public void setDim1(String dim1) {
        this.dim1 = dim1;
    }

    public String getDim2() {
        return dim2;
    }

    public void setDim2(String dim2) {
        this.dim2 = dim2;
    }

    public String getDim3() {
        return dim3;
    }

    public void setDim3(String dim3) {
        this.dim3 = dim3;
    }

    public OrdemDespacho getIdOrdemDespacho() {
        return idOrdemDespacho;
    }

    public void setIdOrdemDespacho(OrdemDespacho idOrdemDespacho) {
        this.idOrdemDespacho = idOrdemDespacho;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getPesoCubado() {
        return pesoCubado;
    }

    public void setPesoCubado(BigDecimal pesoCubado) {
        this.pesoCubado = pesoCubado;
    }

}
