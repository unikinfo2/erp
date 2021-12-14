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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "customfield")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customfield.findAll", query = "SELECT c FROM Customfield c where c.empresa = :empresa"),
        @NamedQuery(name = "Customfield.findByNomeCustomField", query = "SELECT c FROM Customfield c WHERE c.nomeCustomField = :nomeCustomField"),
    @NamedQuery(name = "Customfield.findByTipoCustomField", query = "SELECT c FROM Customfield c WHERE c.tipoCustomField = :tipoCustomField"),
    @NamedQuery(name = "Customfield.findByNomeClasse", query = "SELECT c FROM Customfield c WHERE c.nomeClasse = :nomeClasse and c.empresa = :empresa"),
    @NamedQuery(name = "Customfield.findByNomeClasseNome", query = "SELECT c FROM Customfield c WHERE c.nomeClasse = :nomeClasse and c.nomeCustomField = :nomeCustomField and c.empresa = :empresa"),
    @NamedQuery(name = "Customfield.findByTamanhoCustomField", query = "SELECT c FROM Customfield c WHERE c.tamanhoCustomField = :tamanhoCustomField")})
public class Customfield implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCustomField")
    private Long idCustomField;
    //@Size(max = 30)
    @Column(name = "nomeCustomField")
    private String nomeCustomField;
    //@Size(max = 10)
    @Column(name = "tipoCustomField")
    private String tipoCustomField;
    @Column(name = "tamanhoCustomField")
    private Integer tamanhoCustomField;
    //@Size(max = 50)
    @Column(name = "nomeClasse")
    private String nomeClasse;    
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;

    public Customfield() {
    }

    public Customfield(Long idCustomField) {
        this.idCustomField = idCustomField;
    }

    public Long getIdCustomField() {
        return idCustomField;
    }

    public void setIdCustomField(Long idCustomField) {
        this.idCustomField = idCustomField;
    }

    public String getNomeCustomField() {
        return nomeCustomField;
    }

    public void setNomeCustomField(String nomeCustomField) {
        this.nomeCustomField = nomeCustomField;
    }

    public String getTipoCustomField() {
        return tipoCustomField;
    }

    public void setTipoCustomField(String tipoCustomField) {
        this.tipoCustomField = tipoCustomField;
    }

    public Integer getTamanhoCustomField() {
        return tamanhoCustomField;
    }

    public void setTamanhoCustomField(Integer tamanhoCustomField) {
        this.tamanhoCustomField = tamanhoCustomField;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomField != null ? idCustomField.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customfield)) {
            return false;
        }
        Customfield other = (Customfield) object;
        if ((this.idCustomField == null && other.idCustomField != null) || (this.idCustomField != null && !this.idCustomField.equals(other.idCustomField))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Customfield[ idCustomField=" + idCustomField + " ]";
    }
    
}
