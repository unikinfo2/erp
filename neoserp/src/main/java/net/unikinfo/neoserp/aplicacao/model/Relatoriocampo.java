/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
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
@Table(name = "relatoriocampo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatoriocampo.findAll", query = "SELECT r FROM Relatoriocampo r"),
    @NamedQuery(name = "Relatoriocampo.findByRelatorio", query = "SELECT r FROM Relatoriocampo r WHERE r.relatorio = :relatorio"),
    @NamedQuery(name = "Relatoriocampo.findByIdRelatorioCampo", query = "SELECT r FROM Relatoriocampo r WHERE r.idRelatorioCampo = :idRelatorioCampo"),
    @NamedQuery(name = "Relatoriocampo.findByCampoRelatorio", query = "SELECT r FROM Relatoriocampo r WHERE r.campoRelatorio = :campoRelatorio"),
    @NamedQuery(name = "Relatoriocampo.findByTamanhoCampo", query = "SELECT r FROM Relatoriocampo r WHERE r.tamanhoCampo = :tamanhoCampo")})
public class Relatoriocampo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRelatorioCampo")
    private Long idRelatorioCampo;
    
    @Column(name = "campoRelatorio")
    private String campoRelatorio;
    
    @Column(name = "tamanhoCampo")
    private Integer tamanhoCampo;
    
    @JoinColumn(name = "idRelatorio", referencedColumnName = "idRelatorio")
    @ManyToOne(optional = false)
    private Relatorio relatorio;

    public Relatoriocampo() {
    }

    public Relatoriocampo(Long idRelatorioCampo) {
        this.idRelatorioCampo = idRelatorioCampo;
    }

    public Long getIdRelatorioCampo() {
        return idRelatorioCampo;
    }

    public void setIdRelatorioCampo(Long idRelatorioCampo) {
        this.idRelatorioCampo = idRelatorioCampo;
    }

    public String getCampoRelatorio() {
        return campoRelatorio;
    }

    public void setCampoRelatorio(String campoRelatorio) {
        this.campoRelatorio = campoRelatorio;
    }

    public Integer getTamanhoCampo() {
        return tamanhoCampo;
    }

    public void setTamanhoCampo(Integer tamanhoCampo) {
        this.tamanhoCampo = tamanhoCampo;
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelatorioCampo != null ? idRelatorioCampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatoriocampo)) {
            return false;
        }
        Relatoriocampo other = (Relatoriocampo) object;
        if ((this.idRelatorioCampo == null && other.idRelatorioCampo != null) || (this.idRelatorioCampo != null && !this.idRelatorioCampo.equals(other.idRelatorioCampo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prjteste.Relatoriocampo[ idRelatorioCampo=" + idRelatorioCampo + " ]";
    }

}
