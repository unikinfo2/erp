/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "estoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estoque.findAll", query = "SELECT e FROM Estoque e"),
    @NamedQuery(name = "Estoque.findByIdEstoque", query = "SELECT e FROM Estoque e WHERE e.idEstoque = :idEstoque"),
    @NamedQuery(name = "Estoque.findByIdEmpresa", query = "SELECT e FROM Estoque e WHERE e.idEmpresa = :empresa"),
    @NamedQuery(name = "Estoque.findByIdEmpresaMatriz", query = "SELECT e FROM Estoque e WHERE e.idEmpresa = :matriz"),
    @NamedQuery(name = "Estoque.findByNomeEstoque", query = "SELECT e FROM Estoque e WHERE e.nomeEstoque = :nomeEstoque"),
    @NamedQuery(name = "Estoque.findByEnderecoEstoque", query = "SELECT e FROM Estoque e WHERE e.enderecoEstoque = :enderecoEstoque"),
    @NamedQuery(name = "Estoque.findByComplEstoque", query = "SELECT e FROM Estoque e WHERE e.complEstoque = :complEstoque"),
    @NamedQuery(name = "Estoque.findByNumeroEstoque", query = "SELECT e FROM Estoque e WHERE e.numeroEstoque = :numeroEstoque"),
    @NamedQuery(name = "Estoque.findByCepEstoque", query = "SELECT e FROM Estoque e WHERE e.cepEstoque = :cepEstoque"),
    @NamedQuery(name = "Estoque.findByCidadeEstoque", query = "SELECT e FROM Estoque e WHERE e.cidadeEstoque = :cidadeEstoque"),
    @NamedQuery(name = "Estoque.findByEmailEstoque", query = "SELECT e FROM Estoque e WHERE e.emailEstoque = :emailEstoque"),
    @NamedQuery(name = "Estoque.findByFone1Estoque", query = "SELECT e FROM Estoque e WHERE e.fone1Estoque = :fone1Estoque"),
    @NamedQuery(name = "Estoque.findByFone2Estoque", query = "SELECT e FROM Estoque e WHERE e.fone2Estoque = :fone2Estoque"),
    @NamedQuery(name = "Estoque.findByFone3Estoque", query = "SELECT e FROM Estoque e WHERE e.fone3Estoque = :fone3Estoque"),
    @NamedQuery(name = "Estoque.findByFone4Estoque", query = "SELECT e FROM Estoque e WHERE e.fone4Estoque = :fone4Estoque"),
    @NamedQuery(name = "Estoque.findByFaxEstoque", query = "SELECT e FROM Estoque e WHERE e.faxEstoque = :faxEstoque"),
    @NamedQuery(name = "Estoque.findByCodigoAuxEstoque", query = "SELECT e FROM Estoque e WHERE e.codigoAuxEstoque = :codigoAuxEstoque")})
public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstoque")
    private Long idEstoque;
    //@Size(max = 70)
    @Column(name = "nomeEstoque")
    private String nomeEstoque;
    //@Size(max = 60)
    @Column(name = "enderecoEstoque")
    private String enderecoEstoque;
    //@Size(max = 30)
    @Column(name = "complEstoque")
    private String complEstoque;
    //@Size(max = 8)
    @Column(name = "numeroEstoque")
    private String numeroEstoque;
    //@Size(max = 9)
    @Column(name = "cepEstoque")
    private String cepEstoque;
    //@Size(max = 20)
    @Column(name = "cidadeEstoque")
    private String cidadeEstoque;
    //@Size(max = 50)
    @Column(name = "emailEstoque")
    private String emailEstoque;
    //@Size(max = 15)
    @Column(name = "fone1Estoque")
    private String fone1Estoque;
    //@Size(max = 15)
    @Column(name = "fone2Estoque")
    private String fone2Estoque;
    //@Size(max = 15)
    @Column(name = "fone3Estoque")
    private String fone3Estoque;
    //@Size(max = 15)
    @Column(name = "fone4Estoque")
    private String fone4Estoque;
    //@Size(max = 15)
    @Column(name = "faxEstoque")
    private String faxEstoque;
    //@Size(max = 20)
    @Column(name = "codigoAuxEstoque")
    private String codigoAuxEstoque;
    @JoinColumn(name = "UFEstoque", referencedColumnName = "uf")
    @ManyToOne
    private Estado uFEstoque;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstoque")
    private List<Estoqueitens> estoqueitensList;

    public Estoque() {
    }

    public Estoque(Long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public String getNomeEstoque() {
        return nomeEstoque;
    }

    public void setNomeEstoque(String nomeEstoque) {
        this.nomeEstoque = nomeEstoque;
    }

    public String getEnderecoEstoque() {
        return enderecoEstoque;
    }

    public void setEnderecoEstoque(String enderecoEstoque) {
        this.enderecoEstoque = enderecoEstoque;
    }

    public String getComplEstoque() {
        return complEstoque;
    }

    public void setComplEstoque(String complEstoque) {
        this.complEstoque = complEstoque;
    }

    public String getNumeroEstoque() {
        return numeroEstoque;
    }

    public void setNumeroEstoque(String numeroEstoque) {
        this.numeroEstoque = numeroEstoque;
    }

    public String getCepEstoque() {
        return cepEstoque;
    }

    public void setCepEstoque(String cepEstoque) {
        this.cepEstoque = cepEstoque;
    }

    public String getCidadeEstoque() {
        return cidadeEstoque;
    }

    public void setCidadeEstoque(String cidadeEstoque) {
        this.cidadeEstoque = cidadeEstoque;
    }

    public String getEmailEstoque() {
        return emailEstoque;
    }

    public void setEmailEstoque(String emailEstoque) {
        this.emailEstoque = emailEstoque;
    }

    public String getFone1Estoque() {
        return fone1Estoque;
    }

    public void setFone1Estoque(String fone1Estoque) {
        this.fone1Estoque = fone1Estoque;
    }

    public String getFone2Estoque() {
        return fone2Estoque;
    }

    public void setFone2Estoque(String fone2Estoque) {
        this.fone2Estoque = fone2Estoque;
    }

    public String getFone3Estoque() {
        return fone3Estoque;
    }

    public void setFone3Estoque(String fone3Estoque) {
        this.fone3Estoque = fone3Estoque;
    }

    public String getFone4Estoque() {
        return fone4Estoque;
    }

    public void setFone4Estoque(String fone4Estoque) {
        this.fone4Estoque = fone4Estoque;
    }

    public String getFaxEstoque() {
        return faxEstoque;
    }

    public void setFaxEstoque(String faxEstoque) {
        this.faxEstoque = faxEstoque;
    }

    public String getCodigoAuxEstoque() {
        return codigoAuxEstoque;
    }

    public void setCodigoAuxEstoque(String codigoAuxEstoque) {
        this.codigoAuxEstoque = codigoAuxEstoque;
    }

    public Estado getUFEstoque() {
        return uFEstoque;
    }

    public void setUFEstoque(Estado uFEstoque) {
        this.uFEstoque = uFEstoque;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @XmlTransient
    public List<Estoqueitens> getEstoqueitensList() {
        return estoqueitensList;
    }

    public void setEstoqueitensList(List<Estoqueitens> estoqueitensList) {
        this.estoqueitensList = estoqueitensList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstoque != null ? idEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.idEstoque == null && other.idEstoque != null) || (this.idEstoque != null && !this.idEstoque.equals(other.idEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idEstoque + " - " + nomeEstoque;
    }
    
}
