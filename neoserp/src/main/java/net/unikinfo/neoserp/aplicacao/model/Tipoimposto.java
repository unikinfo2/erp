/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "tipoimposto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoimposto.findAll", query = "SELECT t FROM Tipoimposto t"),
    @NamedQuery(name = "Tipoimposto.findByIdTipoImposto", query = "SELECT t FROM Tipoimposto t WHERE t.idTipoImposto = :idTipoImposto"),
    @NamedQuery(name = "Tipoimposto.findByNomeTipoImposto", query = "SELECT t FROM Tipoimposto t WHERE t.nomeTipoImposto = :nomeTipoImposto order by t.ordemCalculo"),
    @NamedQuery(name = "Tipoimposto.findByCalcularImpostoAPartirDe", query = "SELECT t FROM Tipoimposto t WHERE t.calcularImpostoAPartirDe = :calcularImpostoAPartirDe"),
    @NamedQuery(name = "Tipoimposto.findByReterNaoReter", query = "SELECT t FROM Tipoimposto t WHERE t.reterNaoReter = :reterNaoReter")})
public class Tipoimposto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoImposto")
    private Long idTipoImposto;
    //@Size(max = 30)
    @Column(name = "nomeTipoImposto")
    private String nomeTipoImposto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "calcularImpostoAPartirDe")
    private BigDecimal calcularImpostoAPartirDe;
    //@Size(max = 10)
    @Column(name = "reterNaoReter")
    private String reterNaoReter;
    @Column(name = "ordemCalculo")
    private Integer ordemCalculo;

    public Tipoimposto() {
    }

    public Tipoimposto(Long idTipoImposto) {
        this.idTipoImposto = idTipoImposto;
    }

    public Long getIdTipoImposto() {
        return idTipoImposto;
    }

    public void setIdTipoImposto(Long idTipoImposto) {
        this.idTipoImposto = idTipoImposto;
    }

    public String getNomeTipoImposto() {
        return nomeTipoImposto;
    }

    public void setNomeTipoImposto(String nomeTipoImposto) {
        this.nomeTipoImposto = nomeTipoImposto;
    }

    public BigDecimal getCalcularImpostoAPartirDe() {
        return calcularImpostoAPartirDe;
    }

    public void setCalcularImpostoAPartirDe(BigDecimal calcularImpostoAPartirDe) {
        this.calcularImpostoAPartirDe = calcularImpostoAPartirDe;
    }

    public String getReterNaoReter() {
        return reterNaoReter;
    }

    public void setReterNaoReter(String reterNaoReter) {
        this.reterNaoReter = reterNaoReter;
    }

    public Integer getOrdemCalculo() {
        return ordemCalculo;
    }

    public void setOrdemCalculo(Integer ordemCalculo) {
        this.ordemCalculo = ordemCalculo;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoImposto != null ? idTipoImposto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoimposto)) {
            return false;
        }
        Tipoimposto other = (Tipoimposto) object;
        if ((this.idTipoImposto == null && other.idTipoImposto != null) || (this.idTipoImposto != null && !this.idTipoImposto.equals(other.idTipoImposto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idTipoImposto + "-" + nomeTipoImposto + ':' + reterNaoReter;
    }
    
}
