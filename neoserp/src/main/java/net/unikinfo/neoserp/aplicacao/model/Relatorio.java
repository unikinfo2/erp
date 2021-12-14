/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "relatorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatorio.findAll", query = "SELECT r FROM Relatorio r"),
    @NamedQuery(name = "Relatorio.findByEmpresa", query = "SELECT r FROM Relatorio r WHERE r.empresa = :empresa"),
    @NamedQuery(name = "Relatorio.findByIdrelatorio", query = "SELECT r FROM Relatorio r WHERE r.idRelatorio = :idRelatorio"),
    @NamedQuery(name = "Relatorio.findByCampoGrupo", query = "SELECT r FROM Relatorio r WHERE r.campoGrupo = :campoGrupo"),
    @NamedQuery(name = "Relatorio.findByCampoOrdem", query = "SELECT r FROM Relatorio r WHERE r.campoOrdem = :campoOrdem"),
    @NamedQuery(name = "Relatorio.findByCampoTotalizar", query = "SELECT r FROM Relatorio r WHERE r.campoTotalizar = :campoTotalizar"),
    @NamedQuery(name = "Relatorio.findByNomeRelatorio", query = "SELECT r FROM Relatorio r WHERE r.nomeRelatorio = :nomeRelatorio"),
    @NamedQuery(name = "Relatorio.findByOrientacaoRelatorio", query = "SELECT r FROM Relatorio r WHERE r.orientacaoRelatorio = :orientacaoRelatorio")})
public class Relatorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRelatorio")
    private Long idRelatorio;
    @Column(name = "campoGrupo")
    private String campoGrupo;
    @Column(name = "campoOrdem")
    private String campoOrdem;
    @Column(name = "campoTotalizar")
    private String campoTotalizar;
    @Column(name = "nomeRelatorio")
    private String nomeRelatorio;
    @Column(name = "orientacaoRelatorio")
    private String orientacaoRelatorio;
    @Column(name = "dataInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @Column(name = "dataFinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFinal;
    @Column(name = "imprimeItens")
    private String imprimeItens;
    @Column(name = "imprimeImpostos")
    private String imprimeImpostos;
    @Column(name = "imprimeContas")
    private String imprimeContas;

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "relatorio")
     private List<Relatoriocampo> relatoriocampoList;
    
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "relatorio")
     private List<Relatoriofiltro> relatoriofiltroList;
     */
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;

    public Relatorio() {
    }

    public Relatorio(Long idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public Long getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(Long idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public String getCampoGrupo() {
        return campoGrupo;
    }

    public void setCampoGrupo(String campoGrupo) {
        this.campoGrupo = campoGrupo;
    }

    public String getCampoOrdem() {
        return campoOrdem;
    }

    public void setCampoOrdem(String campoOrdem) {
        this.campoOrdem = campoOrdem;
    }

    public String getCampoTotalizar() {
        return campoTotalizar;
    }

    public void setCampoTotalizar(String campoTotalizar) {
        this.campoTotalizar = campoTotalizar;
    }

    public String getNomeRelatorio() {
        return nomeRelatorio;
    }

    public void setNomeRelatorio(String nomeRelatorio) {
        this.nomeRelatorio = nomeRelatorio;
    }

    public String getOrientacaoRelatorio() {
        return orientacaoRelatorio;
    }

    public void setOrientacaoRelatorio(String orientacaoRelatorio) {
        this.orientacaoRelatorio = orientacaoRelatorio;
    }

    public String getImprimeItens() {
        return imprimeItens;
    }

    public void setImprimeItens(String imprimeItens) {
        this.imprimeItens = imprimeItens;
    }

    public String getImprimeImpostos() {
        return imprimeImpostos;
    }

    public void setImprimeImpostos(String imprimeImpostos) {
        this.imprimeImpostos = imprimeImpostos;
    }

    public String getImprimeContas() {
        return imprimeContas;
    }

    public void setImprimeContas(String imprimeContas) {
        this.imprimeContas = imprimeContas;
    }
    

    /*@XmlTransient
     public List<Relatoriocampo> getRelatoriocampoList() {
     return relatoriocampoList;
     }

     public void setRelatoriocampoList(List<Relatoriocampo> relatoriocampoList) {
     this.relatoriocampoList = relatoriocampoList;
     }

     @XmlTransient
     public List<Relatoriofiltro> getRelatoriofiltroList() {
     return relatoriofiltroList;
     }

     public void setRelatoriofiltroList(List<Relatoriofiltro> relatoriofiltroList) {
     this.relatoriofiltroList = relatoriofiltroList;
     }*/
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelatorio != null ? idRelatorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatorio)) {
            return false;
        }
        Relatorio other = (Relatorio) object;
        if ((this.idRelatorio == null && other.idRelatorio != null) || (this.idRelatorio != null && !this.idRelatorio.equals(other.idRelatorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idRelatorio + "-" + nomeRelatorio;
    }

}
