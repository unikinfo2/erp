/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "clientedoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteDoc.findAll", query = "SELECT c FROM ClienteDoc c order by c.clifor, c.dtDoc desc"),    
    @NamedQuery(name = "ClienteDoc.findByEmpresaSemData", query = "SELECT c FROM ClienteDoc c WHERE c.empresa = :empresa order by c.clifor,c.dtDoc desc"),
    @NamedQuery(name = "ClienteDoc.findByEmpresa", query = "SELECT c FROM ClienteDoc c WHERE c.empresa = :empresa and c.dtDoc between :dtInicio and :dtFinal order by c.clifor,c.dtDoc desc"),
    @NamedQuery(name = "ClienteDoc.findByEmpresaCliforRazao", query = "SELECT c FROM ClienteDoc c WHERE c.empresa = :empresa and c.clifor.razaoSocial like :clifor and c.dtDoc between :dtInicio and :dtFinal order by c.clifor,c.dtDoc desc"),
    @NamedQuery(name = "ClienteDoc.findByEmpresaCliforPrestacaocontas", query = "SELECT c FROM ClienteDoc c WHERE c.empresa = :empresa and c.clifor = :clifor and c.prestacaocontas=:prestacaocontas and c.dtDoc between :dtInicio and :dtFinal order by c.clifor,c.dtDoc desc"),
    @NamedQuery(name = "ClienteDoc.findByEmpresaClifor", query = "SELECT c FROM ClienteDoc c WHERE c.empresa = :empresa and c.clifor = :clifor and c.dtDoc between :dtInicio and :dtFinal order by c.clifor,c.dtDoc desc")})
public class ClienteDoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClienteDoc")
    private Long idClienteDoc;
    @Column(name = "descricaoDoc")
    private String descricaoDoc;
    @Column(name = "observacaoDoc")
    private String observacaoDoc;    
    @Column(name = "dtDoc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDoc;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "idCliFor", referencedColumnName = "idCliFor")
    @ManyToOne
    private Clifor clifor;
    @Column(name = "caminhoDoc")
    private String caminhoDoc;
    @Column(name = "prestacaocontas")
    private String prestacaocontas;
    @Column(name = "valorreembolso")
    private BigDecimal valorreembolso;
    @JoinColumn(name = "idProduto", referencedColumnName = "idProduto")
    @ManyToOne
    private Produto produto;
    
    public ClienteDoc(){        
    }
    
    public ClienteDoc(Long idClienteDoc) {
        this.idClienteDoc = idClienteDoc;
    }


    public Long getIdClienteDoc() {
        return idClienteDoc;
    }

    public void setIdClienteDoc(Long idClienteDoc) {
        this.idClienteDoc = idClienteDoc;
    }

    public String getDescricaoDoc() {
        return descricaoDoc;
    }

    public void setDescricaoDoc(String descricaoDoc) {
        this.descricaoDoc = descricaoDoc;
    }

    public String getObservacaoDoc() {
        return observacaoDoc;
    }

    public void setObservacaoDoc(String observacaoDoc) {
        this.observacaoDoc = observacaoDoc;
    }

    public Date getDtDoc() {
        return dtDoc;
    }

    public void setDtDoc(Date dtDoc) {
        this.dtDoc = dtDoc;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Clifor getClifor() {
        return clifor;
    }

    public void setClifor(Clifor clifor) {
        this.clifor = clifor;
    }

    public String getCaminhoDoc() {
        return caminhoDoc;
    }

    public void setCaminhoDoc(String caminhoDoc) {
        this.caminhoDoc = caminhoDoc;
    }

    public String getPrestacaocontas() {
        return prestacaocontas;
    }

    public void setPrestacaocontas(String prestacaocontas) {
        this.prestacaocontas = prestacaocontas;
    }

    public BigDecimal getValorreembolso() {
        return valorreembolso;
    }

    public void setValorreembolso(BigDecimal valorreembolso) {
        this.valorreembolso = valorreembolso;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteDoc != null ? idClienteDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteDoc)) {
            return false;
        }
        ClienteDoc other = (ClienteDoc) object;
        if ((this.idClienteDoc == null && other.idClienteDoc != null) || (this.idClienteDoc != null && !this.idClienteDoc.equals(other.idClienteDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idClienteDoc + "-" + descricaoDoc + ":" + clifor + ":" + empresa;
    }

}
