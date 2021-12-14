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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "tipotransacaonf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipotransacaonf.findAll", query = "SELECT t FROM Tipotransacaonf t"),
    @NamedQuery(name = "Tipotransacaonf.findByIdTipoTransacaoNF", query = "SELECT t FROM Tipotransacaonf t WHERE t.idTipoTransacaoNF = :idTipoTransacaoNF"),
    @NamedQuery(name = "Tipotransacaonf.findByDescricaoTipoTransacaoNf", query = "SELECT t FROM Tipotransacaonf t WHERE t.descricaoTipoTransacaoNf = :descricaoTipoTransacaoNf"),
    @NamedQuery(name = "Tipotransacaonf.findByIdEmpresa", query = "SELECT t FROM Tipotransacaonf t WHERE t.idEmpresa = :idEmpresa")})
public class Tipotransacaonf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoTransacaoNF")
    private Long idTipoTransacaoNF;
    //@Size(max = 50)
    @Column(name = "descricaoTipoTransacaoNf")
    private String descricaoTipoTransacaoNf;
    @Column(name = "idEmpresa")
    private BigInteger idEmpresa;

    public Tipotransacaonf() {
    }

    public Tipotransacaonf(Long idTipoTransacaoNF) {
        this.idTipoTransacaoNF = idTipoTransacaoNF;
    }

    public Long getIdTipoTransacaoNF() {
        return idTipoTransacaoNF;
    }

    public void setIdTipoTransacaoNF(Long idTipoTransacaoNF) {
        this.idTipoTransacaoNF = idTipoTransacaoNF;
    }

    public String getDescricaoTipoTransacaoNf() {
        return descricaoTipoTransacaoNf;
    }

    public void setDescricaoTipoTransacaoNf(String descricaoTipoTransacaoNf) {
        this.descricaoTipoTransacaoNf = descricaoTipoTransacaoNf;
    }

    public BigInteger getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(BigInteger idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTransacaoNF != null ? idTipoTransacaoNF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipotransacaonf)) {
            return false;
        }
        Tipotransacaonf other = (Tipotransacaonf) object;
        if ((this.idTipoTransacaoNF == null && other.idTipoTransacaoNF != null) || (this.idTipoTransacaoNF != null && !this.idTipoTransacaoNF.equals(other.idTipoTransacaoNF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricaoTipoTransacaoNf;
    }
    
}
