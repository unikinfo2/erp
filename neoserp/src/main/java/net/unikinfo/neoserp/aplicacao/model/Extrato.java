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
@Table(name = "extrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extrato.findAll", query = "SELECT e FROM Extrato e"),
    @NamedQuery(name = "Extrato.findByEmpresa", query = "SELECT e FROM Extrato e WHERE e.empresa = :empresa order by e.dataMovto desc"),
    @NamedQuery(name = "Extrato.findByIdExtrato", query = "SELECT e FROM Extrato e WHERE e.idExtrato = :idExtrato"),
    @NamedQuery(name = "Extrato.findByDataMovto", query = "SELECT e FROM Extrato e WHERE e.dataMovto = :dataMovto"),
    @NamedQuery(name = "Extrato.findByHistoricoMovto", query = "SELECT e FROM Extrato e WHERE e.historicoMovto = :historicoMovto"),
    @NamedQuery(name = "Extrato.findByValorLancto", query = "SELECT e FROM Extrato e WHERE e.valorLancto = :valorLancto"),
    @NamedQuery(name = "Extrato.findByStatusExtrato", query = "SELECT e FROM Extrato e WHERE e.statusExtrato = :statusExtrato")})
public class Extrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idExtrato")
    private Long idExtrato;
    @Column(name = "data_movto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMovto;
    //@Size(max = 250)
    @Column(name = "historico_movto")
    private String historicoMovto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_lancto")
    private BigDecimal valorLancto;
    //@Size(max = 15)
    @Column(name = "statusExtrato")
    private String statusExtrato;
    @JoinColumn(name = "idExtratoParamentro", referencedColumnName = "idExtratoParamentro")
    @ManyToOne
    private Extratoparametro idExtratoParamentro;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    
    
    public Extrato() {
    }

    public Extrato(Long idExtrato) {
        this.idExtrato = idExtrato;
    }

    public Long getIdExtrato() {
        return idExtrato;
    }

    public void setIdExtrato(Long idExtrato) {
        this.idExtrato = idExtrato;
    }

    public Date getDataMovto() {
        return dataMovto;
    }

    public void setDataMovto(Date dataMovto) {
        this.dataMovto = dataMovto;
    }

    public String getHistoricoMovto() {
        return historicoMovto;
    }

    public void setHistoricoMovto(String historicoMovto) {
        this.historicoMovto = historicoMovto;
    }

    public BigDecimal getValorLancto() {
        return valorLancto;
    }

    public void setValorLancto(BigDecimal valorLancto) {
        this.valorLancto = valorLancto;
    }

    public String getStatusExtrato() {
        return statusExtrato;
    }

    public void setStatusExtrato(String statusExtrato) {
        this.statusExtrato = statusExtrato;
    }

    public Extratoparametro getIdExtratoParamentro() {
        return idExtratoParamentro;
    }

    public void setIdExtratoParamentro(Extratoparametro idExtratoParamentro) {
        this.idExtratoParamentro = idExtratoParamentro;
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
        hash += (idExtrato != null ? idExtrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extrato)) {
            return false;
        }
        Extrato other = (Extrato) object;
        if ((this.idExtrato == null && other.idExtrato != null) || (this.idExtrato != null && !this.idExtrato.equals(other.idExtrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Extrato[ idExtrato=" + idExtrato + " ]";
    }
    
}
