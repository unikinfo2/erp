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
@Table(name = "configdre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configdre.findAll", query = "SELECT c FROM Configdre c"),
    @NamedQuery(name = "Configdre.findByEmpresa", query = "SELECT c FROM Configdre c WHERE c.empresa = :empresa"),
    @NamedQuery(name = "Configdre.findByIdDRE", query = "SELECT c FROM Configdre c WHERE c.idDRE = :idDRE"),
    @NamedQuery(name = "Configdre.findByTituloDRE", query = "SELECT c FROM Configdre c WHERE c.tituloDRE = :tituloDRE"),
    @NamedQuery(name = "Configdre.findByTipoImpressaoDRE", query = "SELECT c FROM Configdre c WHERE c.tipoImpressaoDRE = :tipoImpressaoDRE"),
    @NamedQuery(name = "Configdre.findByValorDRE", query = "SELECT c FROM Configdre c WHERE c.valorDRE = :valorDRE"),
    @NamedQuery(name = "Configdre.findByFormulaDRE", query = "SELECT c FROM Configdre c WHERE c.formulaDRE = :formulaDRE"),
    @NamedQuery(name = "Configdre.findByIdContasDRE", query = "SELECT c FROM Configdre c WHERE c.idContasDRE = :idContasDRE")})
public class Configdre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDRE")
    private Long idDRE;
    //@Size(max = 100)
    @Column(name = "tituloDRE")
    private String tituloDRE;
    //@Size(max = 10)
    @Column(name = "tipoImpressaoDRE")
    private String tipoImpressaoDRE;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorDRE")
    private BigDecimal valorDRE;
    //@Size(max = 100)
    @Column(name = "formulaDRE")
    private String formulaDRE;
    //@Size(max = 400)
    @Column(name = "idContasDRE")
    private String idContasDRE;

    @JoinColumn(name = "idContaInicioDRE", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas containicioDRE;
    
    @JoinColumn(name = "idContaFimDRE", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas contafimDRE;

    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    
    public Configdre() {
    }

    public Configdre(Long idDRE) {
        this.idDRE = idDRE;
    }

    public Long getIdDRE() {
        return idDRE;
    }

    public void setIdDRE(Long idDRE) {
        this.idDRE = idDRE;
    }

    public String getTituloDRE() {
        return tituloDRE;
    }

    public void setTituloDRE(String tituloDRE) {
        this.tituloDRE = tituloDRE;
    }

    public String getTipoImpressaoDRE() {
        return tipoImpressaoDRE;
    }

    public void setTipoImpressaoDRE(String tipoImpressaoDRE) {
        this.tipoImpressaoDRE = tipoImpressaoDRE;
    }

    public BigDecimal getValorDRE() {
        return valorDRE;
    }

    public void setValorDRE(BigDecimal valorDRE) {
        this.valorDRE = valorDRE;
    }

    public String getFormulaDRE() {
        return formulaDRE;
    }

    public void setFormulaDRE(String formulaDRE) {
        this.formulaDRE = formulaDRE;
    }

    public String getIdContasDRE() {
        return idContasDRE;
    }

    public void setIdContasDRE(String idContasDRE) {
        this.idContasDRE = idContasDRE;
    }

    public Planocontas getContainicioDRE() {
        return containicioDRE;
    }

    public void setContainicioDRE(Planocontas contaInicioDRE) {
        this.containicioDRE = contaInicioDRE;
    }

    public Planocontas getContafimDRE() {
        return contafimDRE;
    }

    public void setContafimDRE(Planocontas contafimDRE) {
        this.contafimDRE = contafimDRE;
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
        hash += (idDRE != null ? idDRE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configdre)) {
            return false;
        }
        Configdre other = (Configdre) object;
        if ((this.idDRE == null && other.idDRE != null) || (this.idDRE != null && !this.idDRE.equals(other.idDRE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Configdre[ idDRE=" + idDRE + " ]";
    }
    
}
