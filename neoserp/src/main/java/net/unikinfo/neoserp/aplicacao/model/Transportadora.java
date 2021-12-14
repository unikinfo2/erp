/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
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
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "transportadora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportadora.findAll", query = "SELECT t FROM Transportadora t"),
    @NamedQuery(name = "Transportadora.findByIdTransp", query = "SELECT t FROM Transportadora t WHERE t.idTransp = :idTransp"),
    @NamedQuery(name = "Transportadora.findByEmpresa", query = "SELECT t FROM Transportadora t WHERE t.empresa = :empresa"),
    @NamedQuery(name = "Transportadora.findByAtivaTransp", query = "SELECT t FROM Transportadora t WHERE t.ativaTransp = :ativaTransp"),
    @NamedQuery(name = "Transportadora.findByObsTransp", query = "SELECT t FROM Transportadora t WHERE t.obsTransp = :obsTransp"),
    @NamedQuery(name = "Transportadora.findByEnderecoTrans", query = "SELECT t FROM Transportadora t WHERE t.enderecoTrans = :enderecoTrans"),
    @NamedQuery(name = "Transportadora.findByCidadeTrans", query = "SELECT t FROM Transportadora t WHERE t.cidadeTrans = :cidadeTrans"),
    @NamedQuery(name = "Transportadora.findByBairroTrans", query = "SELECT t FROM Transportadora t WHERE t.bairroTrans = :bairroTrans"),
    @NamedQuery(name = "Transportadora.findByCepTrans", query = "SELECT t FROM Transportadora t WHERE t.cepTrans = :cepTrans"),
    @NamedQuery(name = "Transportadora.findByNumeroTransp", query = "SELECT t FROM Transportadora t WHERE t.numeroTransp = :numeroTransp"),
    @NamedQuery(name = "Transportadora.findByEmailTrans", query = "SELECT t FROM Transportadora t WHERE t.emailTrans = :emailTrans"),
    @NamedQuery(name = "Transportadora.findByTelefoneTrans", query = "SELECT t FROM Transportadora t WHERE t.telefoneTrans = :telefoneTrans"),
    @NamedQuery(name = "Transportadora.findByNomeTransp", query = "SELECT t FROM Transportadora t WHERE t.nomeTransp = :nomeTransp"),
    @NamedQuery(name = "Transportadora.findByApelidoTransp", query = "SELECT t FROM Transportadora t WHERE t.apelidoTransp = :apelidoTransp")})
public class Transportadora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransp")
    private Long idTransp;
    //@Size(max = 1)
    @Column(name = "ativaTransp")
    private String ativaTransp;
    //@Size(max = 250)
    @Column(name = "obsTransp")
    private String obsTransp;
    //@Size(max = 60)
    @Column(name = "enderecoTrans")
    private String enderecoTrans;
    //@Size(max = 20)
    @Column(name = "cidadeTrans")
    private String cidadeTrans;
    //@Size(max = 50)
    @Column(name = "bairroTrans")
    private String bairroTrans;
    //@Size(max = 8)
    @Column(name = "cepTrans")
    private String cepTrans;
    //@Size(max = 10)
    @Column(name = "numeroTransp")
    private String numeroTransp;
    //@Size(max = 100)
    @Column(name = "emailTrans")
    private String emailTrans;
    //@Size(max = 15)
    @Column(name = "telefoneTrans")
    private String telefoneTrans;
    //@Size(max = 100)
    @Column(name = "nomeTransp")
    private String nomeTransp;
    //@Size(max = 40)
    @Column(name = "apelidoTransp")
    private String apelidoTransp;
    @OneToMany(mappedBy = "transportadora")
    private List<Transacao> transacaoList;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "UFTrans", referencedColumnName = "uf")
    @ManyToOne
    private Estado estado;
    @OneToMany(mappedBy = "transportadora")
    private List<Clifor> cliforList;

    public Transportadora() {
    }

    public Transportadora(Long idTransp) {
        this.idTransp = idTransp;
    }

    public Long getIdTransp() {
        return idTransp;
    }

    public void setIdTransp(Long idTransp) {
        this.idTransp = idTransp;
    }

    public String getAtivaTransp() {
        return ativaTransp;
    }

    public void setAtivaTransp(String ativaTransp) {
        this.ativaTransp = ativaTransp;
    }

    public String getObsTransp() {
        return obsTransp;
    }

    public void setObsTransp(String obsTransp) {
        this.obsTransp = obsTransp;
    }

    public String getEnderecoTrans() {
        return enderecoTrans;
    }

    public void setEnderecoTrans(String enderecoTrans) {
        this.enderecoTrans = enderecoTrans;
    }

    public String getCidadeTrans() {
        return cidadeTrans;
    }

    public void setCidadeTrans(String cidadeTrans) {
        this.cidadeTrans = cidadeTrans;
    }

    public String getBairroTrans() {
        return bairroTrans;
    }

    public void setBairroTrans(String bairroTrans) {
        this.bairroTrans = bairroTrans;
    }

    public String getCepTrans() {
        return cepTrans;
    }

    public void setCepTrans(String cepTrans) {
        this.cepTrans = cepTrans;
    }

    public String getNumeroTransp() {
        return numeroTransp;
    }

    public void setNumeroTransp(String numeroTransp) {
        this.numeroTransp = numeroTransp;
    }

    public String getEmailTrans() {
        return emailTrans;
    }

    public void setEmailTrans(String emailTrans) {
        this.emailTrans = emailTrans;
    }

    public String getTelefoneTrans() {
        return telefoneTrans;
    }

    public void setTelefoneTrans(String telefoneTrans) {
        this.telefoneTrans = telefoneTrans;
    }

    public String getNomeTransp() {
        return nomeTransp;
    }

    public void setNomeTransp(String nomeTransp) {
        this.nomeTransp = nomeTransp;
    }

    public String getApelidoTransp() {
        return apelidoTransp;
    }

    public void setApelidoTransp(String apelidoTransp) {
        this.apelidoTransp = apelidoTransp;
    }

    @XmlTransient
    public List<Transacao> getTransacaoList() {
        return transacaoList;
    }

    public void setTransacaoList(List<Transacao> transacaoList) {
        this.transacaoList = transacaoList;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Clifor> getCliforList() {
        return cliforList;
    }

    public void setCliforList(List<Clifor> cliforList) {
        this.cliforList = cliforList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransp != null ? idTransp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportadora)) {
            return false;
        }
        Transportadora other = (Transportadora) object;
        if ((this.idTransp == null && other.idTransp != null) || (this.idTransp != null && !this.idTransp.equals(other.idTransp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idTransp + "-" + nomeTransp;
    }

}
