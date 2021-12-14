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
@Table(name = "configtransacaonf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configtransacaonf.findAll", query = "SELECT c FROM Configtransacaonf c"),
    @NamedQuery(name = "Configtransacaonf.findByIdConfigTransacaoNF", query = "SELECT c FROM Configtransacaonf c WHERE c.idConfigTransacaoNF = :idConfigTransacaoNF"),
    @NamedQuery(name = "Configtransacaonf.findByIdTipoTransacaoNF", query = "SELECT c FROM Configtransacaonf c WHERE c.tipoTransacaoNF = :tipoTransacaoNF"),
    @NamedQuery(name = "Configtransacaonf.findByNcm", query = "SELECT c FROM Configtransacaonf c WHERE c.ncm = :ncm"),
    @NamedQuery(name = "Configtransacaonf.findByNcmTipo", query = "SELECT c FROM Configtransacaonf c WHERE c.ncm = :ncm and c.tipoTransacaoNF = :tipoTransacaoNF"),
    @NamedQuery(name = "Configtransacaonf.findByCstNormal", query = "SELECT c FROM Configtransacaonf c WHERE c.cstNormal = :cstNormal"),
    @NamedQuery(name = "Configtransacaonf.findByCstReducaoBase", query = "SELECT c FROM Configtransacaonf c WHERE c.cstReducaoBase = :cstReducaoBase"),
    @NamedQuery(name = "Configtransacaonf.findByCstST", query = "SELECT c FROM Configtransacaonf c WHERE c.cstST = :cstST"),
    @NamedQuery(name = "Configtransacaonf.findByCstSTRB", query = "SELECT c FROM Configtransacaonf c WHERE c.cstSTRB = :cstSTRB"),
    @NamedQuery(name = "Configtransacaonf.findByCstIpi", query = "SELECT c FROM Configtransacaonf c WHERE c.cstIpi = :cstIpi"),
    @NamedQuery(name = "Configtransacaonf.findByCstPis", query = "SELECT c FROM Configtransacaonf c WHERE c.cstPis = :cstPis"),
    @NamedQuery(name = "Configtransacaonf.findByCstCofins", query = "SELECT c FROM Configtransacaonf c WHERE c.cstCofins = :cstCofins"),
    @NamedQuery(name = "Configtransacaonf.findByCstCsll", query = "SELECT c FROM Configtransacaonf c WHERE c.cstCsll = :cstCsll"),
    @NamedQuery(name = "Configtransacaonf.findByCfopEstado", query = "SELECT c FROM Configtransacaonf c WHERE c.cfopEstado = :cfopEstado"),
    @NamedQuery(name = "Configtransacaonf.findByCfopEstadoST", query = "SELECT c FROM Configtransacaonf c WHERE c.cfopEstadoST = :cfopEstadoST"),
    @NamedQuery(name = "Configtransacaonf.findByCfopForaEstado", query = "SELECT c FROM Configtransacaonf c WHERE c.cfopForaEstado = :cfopForaEstado"),
    @NamedQuery(name = "Configtransacaonf.findByCfopForaEstadoST", query = "SELECT c FROM Configtransacaonf c WHERE c.cfopForaEstadoST = :cfopForaEstadoST"),
    @NamedQuery(name = "Configtransacaonf.findByCfopExterior", query = "SELECT c FROM Configtransacaonf c WHERE c.cfopExterior = :cfopExterior"),
    @NamedQuery(name = "Configtransacaonf.findByCfopEstadoProducao", query = "SELECT c FROM Configtransacaonf c WHERE c.cfopEstadoProducao = :cfopEstadoProducao"),
    @NamedQuery(name = "Configtransacaonf.findByCfopEstadoConsumo", query = "SELECT c FROM Configtransacaonf c WHERE c.cfopEstadoConsumo = :cfopEstadoConsumo"),
    @NamedQuery(name = "Configtransacaonf.findByCfopForaEstadoProducao", query = "SELECT c FROM Configtransacaonf c WHERE c.cfopForaEstadoProducao = :cfopForaEstadoProducao"),
    @NamedQuery(name = "Configtransacaonf.findByCfopForaEstadoConsumo", query = "SELECT c FROM Configtransacaonf c WHERE c.cfopForaEstadoConsumo = :cfopForaEstadoConsumo"),
    @NamedQuery(name = "Configtransacaonf.findByCfopEstadoConsumoPP", query = "SELECT c FROM Configtransacaonf c WHERE c.cfopEstadoConsumoPP = :cfopEstadoConsumoPP"),
    @NamedQuery(name = "Configtransacaonf.findByCfopForaEstadoConsumoPP", query = "SELECT c FROM Configtransacaonf c WHERE c.cfopForaEstadoConsumoPP = :cfopForaEstadoConsumoPP")})
public class Configtransacaonf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConfigTransacaoNF")
    private Long idConfigTransacaoNF;

    @JoinColumn(name = "idTipoTransacaoNF", referencedColumnName = "idTipoTransacaoNF")
    @ManyToOne
    private Tipotransacaonf tipoTransacaoNF;

    //@Size(max = 8)
    @Basic(optional = false)
    //@NotNull
    @Column(name = "ncm")
    private String ncm;

    //@Size(max = 4)
    @Column(name = "cstNormal")
    private String cstNormal;
    //@Size(max = 4)
    @Column(name = "cstReducaoBase")
    private String cstReducaoBase;
    //@Size(max = 4)
    @Column(name = "cstST")
    private String cstST;
    //@Size(max = 4)
    @Column(name = "cstSTRB")
    private String cstSTRB;
    //@Size(max = 4)
    @Column(name = "cstIpi")
    private String cstIpi;
    //@Size(max = 4)
    @Column(name = "cstPis")
    private String cstPis;
    //@Size(max = 4)
    @Column(name = "cstCofins")
    private String cstCofins;
    //@Size(max = 4)
    @Column(name = "cstCsll")
    private String cstCsll;
    //@Size(max = 6)
    @Column(name = "cfopEstado")
    private String cfopEstado;
    //@Size(max = 6)
    @Column(name = "cfopEstadoST")
    private String cfopEstadoST;
    //@Size(max = 6)
    @Column(name = "cfopForaEstado")
    private String cfopForaEstado;
    //@Size(max = 6)
    @Column(name = "cfopForaEstadoST")
    private String cfopForaEstadoST;
    //@Size(max = 6)
    @Column(name = "cfopExterior")
    private String cfopExterior;
    //@Size(max = 6)
    @Column(name = "cfopEstadoProducao")
    private String cfopEstadoProducao;
    //@Size(max = 6)
    @Column(name = "cfopEstadoConsumo")
    private String cfopEstadoConsumo;
    //@Size(max = 6)
    @Column(name = "cfopForaEstadoProducao")
    private String cfopForaEstadoProducao;
    //@Size(max = 6)
    @Column(name = "cfopForaEstadoConsumo")
    private String cfopForaEstadoConsumo;
    //@Size(max = 6)
    @Column(name = "cfopEstadoConsumoPP")
    private String cfopEstadoConsumoPP;
    //@Size(max = 6)
    @Column(name = "cfopForaEstadoConsumoPP")
    private String cfopForaEstadoConsumoPP;

    public Configtransacaonf() {
    }

    public Configtransacaonf(Long idConfigTransacaoNF) {
        this.idConfigTransacaoNF = idConfigTransacaoNF;
    }

    public Configtransacaonf(Long idConfigTransacaoNF, Tipotransacaonf tipoTransacaoNF, String ncm) {
        this.idConfigTransacaoNF = idConfigTransacaoNF;
        this.tipoTransacaoNF = tipoTransacaoNF;
        this.ncm = ncm;
    }

    public Long getIdConfigTransacaoNF() {
        return idConfigTransacaoNF;
    }

    public void setIdConfigTransacaoNF(Long idConfigTransacaoNF) {
        this.idConfigTransacaoNF = idConfigTransacaoNF;
    }

    public Tipotransacaonf getTipoTransacaoNF() {
        return tipoTransacaoNF;
    }

    public void setTipoTransacaoNF(Tipotransacaonf tipoTransacaoNF) {
        this.tipoTransacaoNF = tipoTransacaoNF;
    }

    public void setIdTipoTransacaoNF(Tipotransacaonf tipoTransacaoNF) {
        this.tipoTransacaoNF = tipoTransacaoNF;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getCstNormal() {
        return cstNormal;
    }

    public void setCstNormal(String cstNormal) {
        this.cstNormal = cstNormal;
    }

    public String getCstReducaoBase() {
        return cstReducaoBase;
    }

    public void setCstReducaoBase(String cstReducaoBase) {
        this.cstReducaoBase = cstReducaoBase;
    }

    public String getCstST() {
        return cstST;
    }

    public void setCstST(String cstST) {
        this.cstST = cstST;
    }

    public String getCstSTRB() {
        return cstSTRB;
    }

    public void setCstSTRB(String cstSTRB) {
        this.cstSTRB = cstSTRB;
    }

    public String getCstIpi() {
        return cstIpi;
    }

    public void setCstIpi(String cstIpi) {
        this.cstIpi = cstIpi;
    }

    public String getCstPis() {
        return cstPis;
    }

    public void setCstPis(String cstPis) {
        this.cstPis = cstPis;
    }

    public String getCstCofins() {
        return cstCofins;
    }

    public void setCstCofins(String cstCofins) {
        this.cstCofins = cstCofins;
    }

    public String getCstCsll() {
        return cstCsll;
    }

    public void setCstCsll(String cstCsll) {
        this.cstCsll = cstCsll;
    }

    public String getCfopEstado() {
        return cfopEstado;
    }

    public void setCfopEstado(String cfopEstado) {
        this.cfopEstado = cfopEstado;
    }

    public String getCfopEstadoST() {
        return cfopEstadoST;
    }

    public void setCfopEstadoST(String cfopEstadoST) {
        this.cfopEstadoST = cfopEstadoST;
    }

    public String getCfopForaEstado() {
        return cfopForaEstado;
    }

    public void setCfopForaEstado(String cfopForaEstado) {
        this.cfopForaEstado = cfopForaEstado;
    }

    public String getCfopForaEstadoST() {
        return cfopForaEstadoST;
    }

    public void setCfopForaEstadoST(String cfopForaEstadoST) {
        this.cfopForaEstadoST = cfopForaEstadoST;
    }

    public String getCfopExterior() {
        return cfopExterior;
    }

    public void setCfopExterior(String cfopExterior) {
        this.cfopExterior = cfopExterior;
    }

    public String getCfopEstadoProducao() {
        return cfopEstadoProducao;
    }

    public void setCfopEstadoProducao(String cfopEstadoProducao) {
        this.cfopEstadoProducao = cfopEstadoProducao;
    }

    public String getCfopEstadoConsumo() {
        return cfopEstadoConsumo;
    }

    public void setCfopEstadoConsumo(String cfopEstadoConsumo) {
        this.cfopEstadoConsumo = cfopEstadoConsumo;
    }

    public String getCfopForaEstadoProducao() {
        return cfopForaEstadoProducao;
    }

    public void setCfopForaEstadoProducao(String cfopForaEstadoProducao) {
        this.cfopForaEstadoProducao = cfopForaEstadoProducao;
    }

    public String getCfopForaEstadoConsumo() {
        return cfopForaEstadoConsumo;
    }

    public void setCfopForaEstadoConsumo(String cfopForaEstadoConsumo) {
        this.cfopForaEstadoConsumo = cfopForaEstadoConsumo;
    }

    public String getCfopEstadoConsumoPP() {
        return cfopEstadoConsumoPP;
    }

    public void setCfopEstadoConsumoPP(String cfopEstadoConsumoPP) {
        this.cfopEstadoConsumoPP = cfopEstadoConsumoPP;
    }

    public String getCfopForaEstadoConsumoPP() {
        return cfopForaEstadoConsumoPP;
    }

    public void setCfopForaEstadoConsumoPP(String cfopForaEstadoConsumoPP) {
        this.cfopForaEstadoConsumoPP = cfopForaEstadoConsumoPP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConfigTransacaoNF != null ? idConfigTransacaoNF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configtransacaonf)) {
            return false;
        }
        Configtransacaonf other = (Configtransacaonf) object;
        if ((this.idConfigTransacaoNF == null && other.idConfigTransacaoNF != null) || (this.idConfigTransacaoNF != null && !this.idConfigTransacaoNF.equals(other.idConfigTransacaoNF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idConfigTransacaoNF + "-" + ncm;
    }

}
