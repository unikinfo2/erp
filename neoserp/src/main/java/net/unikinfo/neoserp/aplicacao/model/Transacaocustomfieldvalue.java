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
@Table(name = "transacaocustomfieldvalue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacaocustomfieldvalue.findAll", query = "SELECT t FROM Transacaocustomfieldvalue t"),
    @NamedQuery(name = "Transacaocustomfieldvalue.findByCustomField", query = "SELECT t FROM Transacaocustomfieldvalue t WHERE t.customfield = :customfield"),
    @NamedQuery(name = "Transacaocustomfieldvalue.findByIdENomeClasse", query = "SELECT t FROM Transacaocustomfieldvalue t WHERE t.idObjeto = :idObjeto AND t.customfield.nomeClasse = :nomeClasse"),
    @NamedQuery(name = "Transacaocustomfieldvalue.findByIdENomeClasseCustofield", query = "SELECT t FROM Transacaocustomfieldvalue t WHERE t.idObjeto = :idObjeto AND t.customfield = :customfield"),
    @NamedQuery(name = "Transacaocustomfieldvalue.findByIdTransacaoCustomField", query = "SELECT t FROM Transacaocustomfieldvalue t WHERE t.idCustomFieldValue = :idTransacaoCustomField"),
    @NamedQuery(name = "Transacaocustomfieldvalue.findByValorNumericoCF", query = "SELECT t FROM Transacaocustomfieldvalue t WHERE t.valorNumericoCF = :valorNumericoCF"),
    @NamedQuery(name = "Transacaocustomfieldvalue.findByValorAlfaCF", query = "SELECT t FROM Transacaocustomfieldvalue t WHERE t.valorAlfaCF = :valorAlfaCF"),
    @NamedQuery(name = "Transacaocustomfieldvalue.findByValorDataCF", query = "SELECT t FROM Transacaocustomfieldvalue t WHERE t.valorDataCF = :valorDataCF")})
public class Transacaocustomfieldvalue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCustomFieldValue")
    private Long idCustomFieldValue;
    @Column(name = "valorNumericoCF")
    private BigDecimal valorNumericoCF;
    //@Size(max = 250)
    @Column(name = "valorAlfaCF")
    private String valorAlfaCF;
    @Column(name = "valorDataCF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date valorDataCF;
    @JoinColumn(name = "idCustomField", referencedColumnName = "idCustomField")
    @ManyToOne
    private Customfield customfield;
    @Column(name = "idObjeto")
    private Long idObjeto;

    public Transacaocustomfieldvalue() {
    }

    public Transacaocustomfieldvalue(Long idCustomFieldValue) {
        this.idCustomFieldValue = idCustomFieldValue;
    }

    public Transacaocustomfieldvalue(Long idCustomFieldValue, Date valorDataCF) {
        this.idCustomFieldValue = idCustomFieldValue;
        this.valorDataCF = valorDataCF;
    }

    public Long getIdTransacaoCustomField() {
        return idCustomFieldValue;
    }

    public void setIdTransacaoCustomField(Long idTransacaoCustomField) {
        this.idCustomFieldValue = idTransacaoCustomField;
    }

    public BigDecimal getValorNumericoCF() {
        return valorNumericoCF;
    }

    public void setValorNumericoCF(BigDecimal valorNumericoCF) {
        this.valorNumericoCF = valorNumericoCF;
    }

    public String getValorAlfaCF() {
        return valorAlfaCF;
    }

    public void setValorAlfaCF(String valorAlfaCF) {
        this.valorAlfaCF = valorAlfaCF;
    }

    public Date getValorDataCF() {
        return valorDataCF;
    }

    public void setValorDataCF(Date valorDataCF) {
        this.valorDataCF = valorDataCF;
    }

    public Customfield getCustomfield() {
        return customfield;
    }

    public void setCustomfield(Customfield customfield) {
        this.customfield = customfield;
    }

    public Long getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Long idObjeto) {
        this.idObjeto = idObjeto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomFieldValue != null ? idCustomFieldValue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacaocustomfieldvalue)) {
            return false;
        }
        Transacaocustomfieldvalue other = (Transacaocustomfieldvalue) object;
        if ((this.idCustomFieldValue == null && other.idCustomFieldValue != null) || (this.idCustomFieldValue != null && !this.idCustomFieldValue.equals(other.idCustomFieldValue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ idTransacaoCustomField=" + idCustomFieldValue + " ]";
    }

}
