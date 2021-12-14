/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "sequencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sequencia.findAll", query = "SELECT s FROM Sequencia s"),
    @NamedQuery(name = "Sequencia.findByIdsequencia", query = "SELECT s FROM Sequencia s WHERE s.idsequencia = :idsequencia"),
    @NamedQuery(name = "Sequencia.findByNomesequencia", query = "SELECT s FROM Sequencia s WHERE s.nomesequencia = :nomesequencia"),
    @NamedQuery(name = "Sequencia.findByEmpresa", query = "SELECT s FROM Sequencia s WHERE s.empresa = :empresa"),
    @NamedQuery(name = "Sequencia.findByNomesequenciaEmpresa", query = "SELECT s FROM Sequencia s WHERE s.nomesequencia = :nomesequencia and s.empresa = :empresa"),
    @NamedQuery(name = "Sequencia.findByValorsequencia", query = "SELECT s FROM Sequencia s WHERE s.valorsequencia = :valorsequencia"),
    @NamedQuery(name = "Sequencia.findByPrefixosequencia", query = "SELECT s FROM Sequencia s WHERE s.prefixosequencia = :prefixosequencia")})
public class Sequencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsequencia")
    private Integer idsequencia;
    //@Size(max = 45)
    @Column(name = "nomesequencia")
    private String nomesequencia;
    @Column(name = "valorsequencia")
    private BigInteger valorsequencia;
    //@Size(max = 10)
    @Column(name = "prefixosequencia")
    private String prefixosequencia;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    

    public Sequencia() {
    }

    public Sequencia(Integer idsequencia) {
        this.idsequencia = idsequencia;
    }

    public Integer getIdsequencia() {
        return idsequencia;
    }

    public void setIdsequencia(Integer idsequencia) {
        this.idsequencia = idsequencia;
    }

    public String getNomesequencia() {
        return nomesequencia;
    }

    public void setNomesequencia(String nomesequencia) {
        this.nomesequencia = nomesequencia;
    }

    public BigInteger getValorsequencia() {
        return valorsequencia;
    }

    public void setValorsequencia(BigInteger valorsequencia) {
        this.valorsequencia = valorsequencia;
    }

    public String getPrefixosequencia() {
        return prefixosequencia;
    }

    public void setPrefixosequencia(String prefixosequencia) {
        this.prefixosequencia = prefixosequencia;
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
        hash += (idsequencia != null ? idsequencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sequencia)) {
            return false;
        }
        Sequencia other = (Sequencia) object;
        if ((this.idsequencia == null && other.idsequencia != null) || (this.idsequencia != null && !this.idsequencia.equals(other.idsequencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Sequencia[ idsequencia=" + idsequencia + " ]";
    }
    
}
