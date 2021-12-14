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
@Table(name = "relatoriofiltro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatoriofiltro.findAll", query = "SELECT r FROM Relatoriofiltro r"),
    @NamedQuery(name = "Relatoriofiltro.findByRelatorio", query = "SELECT r FROM Relatoriofiltro r WHERE r.relatorio = :relatorio"),
    @NamedQuery(name = "Relatoriofiltro.findByIdRelatorioFiltro", query = "SELECT r FROM Relatoriofiltro r WHERE r.idRelatorioFiltro = :idRelatorioFiltro"),
    @NamedQuery(name = "Relatoriofiltro.findByCampoRelatorio", query = "SELECT r FROM Relatoriofiltro r WHERE r.campoRelatorio = :campoRelatorio"),
    @NamedQuery(name = "Relatoriofiltro.findByCondicaoRelatorio", query = "SELECT r FROM Relatoriofiltro r WHERE r.condicaoRelatorio = :condicaoRelatorio"),
    @NamedQuery(name = "Relatoriofiltro.findByConteudoRelatorio", query = "SELECT r FROM Relatoriofiltro r WHERE r.conteudoRelatorio = :conteudoRelatorio")})
public class Relatoriofiltro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRelatorioFiltro")
    private Long idRelatorioFiltro;
    @Column(name = "campoRelatorio")
    private String campoRelatorio;
    @Column(name = "condicaoRelatorio")
    private String condicaoRelatorio;
    @Column(name = "conteudoRelatorio")
    private String conteudoRelatorio;
    @JoinColumn(name = "idRelatorio", referencedColumnName = "idRelatorio")
    @ManyToOne(optional = false)
    private Relatorio relatorio;

    public Relatoriofiltro() {
    }

    public Relatoriofiltro(Long idRelatorioFiltro) {
        this.idRelatorioFiltro = idRelatorioFiltro;
    }

    public Long getIdRelatorioFiltro() {
        return idRelatorioFiltro;
    }

    public void setIdRelatorioFiltro(Long idRelatorioFiltro) {
        this.idRelatorioFiltro = idRelatorioFiltro;
    }

    public String getCampoRelatorio() {
        return campoRelatorio;
    }

    public void setCampoRelatorio(String campoRelatorio) {
        this.campoRelatorio = campoRelatorio;
    }

    public String getCondicaoRelatorio() {
        return condicaoRelatorio;
    }

    public void setCondicaoRelatorio(String condicaoRelatorio) {
        this.condicaoRelatorio = condicaoRelatorio;
    }

    public String getConteudoRelatorio() {
        return conteudoRelatorio;
    }

    public void setConteudoRelatorio(String conteudoRelatorio) {
        this.conteudoRelatorio = conteudoRelatorio;
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
        hash += (idRelatorioFiltro != null ? idRelatorioFiltro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatoriofiltro)) {
            return false;
        }
        Relatoriofiltro other = (Relatoriofiltro) object;
        if ((this.idRelatorioFiltro == null && other.idRelatorioFiltro != null) || (this.idRelatorioFiltro != null && !this.idRelatorioFiltro.equals(other.idRelatorioFiltro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return campoRelatorio;
    }
    
}
