/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "representante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Representante.findAll", query = "SELECT r FROM Representante r"),
    @NamedQuery(name = "Representante.findByIdRepre", query = "SELECT r FROM Representante r WHERE r.idRepre = :idRepre"),
    @NamedQuery(name = "Representante.findByEmpresa", query = "SELECT r FROM Representante r WHERE r.empresa = :empresa"),
    @NamedQuery(name = "Representante.findByComissaoRepre", query = "SELECT r FROM Representante r WHERE r.comissaoRepre = :comissaoRepre"),
    @NamedQuery(name = "Representante.findByObsRepre", query = "SELECT r FROM Representante r WHERE r.obsRepre = :obsRepre"),
    @NamedQuery(name = "Representante.findByComissaoGerente", query = "SELECT r FROM Representante r WHERE r.comissaoGerente = :comissaoGerente"),
    @NamedQuery(name = "Representante.findByAtivoRepre", query = "SELECT r FROM Representante r WHERE r.ativoRepre = :ativoRepre"),
    @NamedQuery(name = "Representante.findByEnderecoRepre", query = "SELECT r FROM Representante r WHERE r.enderecoRepre = :enderecoRepre"),
    @NamedQuery(name = "Representante.findByCidadeRepre", query = "SELECT r FROM Representante r WHERE r.cidadeRepre = :cidadeRepre"),
    @NamedQuery(name = "Representante.findByBairroRepre", query = "SELECT r FROM Representante r WHERE r.bairroRepre = :bairroRepre"),
    @NamedQuery(name = "Representante.findByCepRepre", query = "SELECT r FROM Representante r WHERE r.cepRepre = :cepRepre"),
    @NamedQuery(name = "Representante.findByNumeroRepre", query = "SELECT r FROM Representante r WHERE r.numeroRepre = :numeroRepre"),
    @NamedQuery(name = "Representante.findByEmailRepre", query = "SELECT r FROM Representante r WHERE r.emailRepre = :emailRepre"),
    @NamedQuery(name = "Representante.findByTelefoneRepre", query = "SELECT r FROM Representante r WHERE r.telefoneRepre = :telefoneRepre"),
    @NamedQuery(name = "Representante.findByNomeRepre", query = "SELECT r FROM Representante r WHERE r.nomeRepre = :nomeRepre"),
    @NamedQuery(name = "Representante.findByApelidoRepre", query = "SELECT r FROM Representante r WHERE r.apelidoRepre = :apelidoRepre")})
public class Representante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRepre")
    private Long idRepre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "comissaoRepre")
    private BigDecimal comissaoRepre;
    //@Size(max = 250)
    @Column(name = "obsRepre")
    private String obsRepre;
    @Column(name = "comissaoGerente")
    private BigDecimal comissaoGerente;
    //@Size(max = 1)
    @Column(name = "ativoRepre")
    private String ativoRepre;
    //@Size(max = 60)
    @Column(name = "enderecoRepre")
    private String enderecoRepre;
    //@Size(max = 20)
    @Column(name = "cidadeRepre")
    private String cidadeRepre;
    //@Size(max = 50)
    @Column(name = "bairroRepre")
    private String bairroRepre;
    //@Size(max = 8)
    @Column(name = "cepRepre")
    private String cepRepre;
    //@Size(max = 10)
    @Column(name = "numeroRepre")
    private String numeroRepre;
    //@Size(max = 100)
    @Column(name = "emailRepre")
    private String emailRepre;
    //@Size(max = 15)
    @Column(name = "telefoneRepre")
    private String telefoneRepre;
    //@Size(max = 100)
    @Column(name = "nomeRepre")
    private String nomeRepre;
    //@Size(max = 40)
    @Column(name = "apelidoRepre")
    private String apelidoRepre;
    @OneToMany(mappedBy = "representante")
    private List<Transacao> transacaoList;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "UFRepre", referencedColumnName = "uf")
    @ManyToOne
    private Estado estado;
    @JoinColumn(name = "idCliFor", referencedColumnName = "idCliFor")
    @ManyToOne
    private Clifor clifor;
    @JoinColumn(name = "idContaDebito", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas contaDebito;
    @JoinColumn(name = "idContaCredito", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas contaCredito;

    public Representante() {
    }

    public Representante(Long idRepre) {
        this.idRepre = idRepre;
    }

    public Long getIdRepre() {
        return idRepre;
    }

    public void setIdRepre(Long idRepre) {
        this.idRepre = idRepre;
    }

    public BigDecimal getComissaoRepre() {
        return comissaoRepre;
    }

    public void setComissaoRepre(BigDecimal comissaoRepre) {
        this.comissaoRepre = comissaoRepre;
    }

    public String getObsRepre() {
        return obsRepre;
    }

    public void setObsRepre(String obsRepre) {
        this.obsRepre = obsRepre;
    }

    public BigDecimal getComissaoGerente() {
        return comissaoGerente;
    }

    public void setComissaoGerente(BigDecimal comissaoGerente) {
        this.comissaoGerente = comissaoGerente;
    }

    public String getAtivoRepre() {
        return ativoRepre;
    }

    public void setAtivoRepre(String ativoRepre) {
        this.ativoRepre = ativoRepre;
    }

    public String getEnderecoRepre() {
        return enderecoRepre;
    }

    public void setEnderecoRepre(String enderecoRepre) {
        this.enderecoRepre = enderecoRepre;
    }

    public String getCidadeRepre() {
        return cidadeRepre;
    }

    public void setCidadeRepre(String cidadeRepre) {
        this.cidadeRepre = cidadeRepre;
    }

    public String getBairroRepre() {
        return bairroRepre;
    }

    public void setBairroRepre(String bairroRepre) {
        this.bairroRepre = bairroRepre;
    }

    public String getCepRepre() {
        return cepRepre;
    }

    public void setCepRepre(String cepRepre) {
        this.cepRepre = cepRepre;
    }

    public String getNumeroRepre() {
        return numeroRepre;
    }

    public void setNumeroRepre(String numeroRepre) {
        this.numeroRepre = numeroRepre;
    }

    public String getEmailRepre() {
        return emailRepre;
    }

    public void setEmailRepre(String emailRepre) {
        this.emailRepre = emailRepre;
    }

    public String getTelefoneRepre() {
        return telefoneRepre;
    }

    public void setTelefoneRepre(String telefoneRepre) {
        this.telefoneRepre = telefoneRepre;
    }

    public String getNomeRepre() {
        return nomeRepre;
    }

    public void setNomeRepre(String nomeRepre) {
        this.nomeRepre = nomeRepre;
    }

    public String getApelidoRepre() {
        return apelidoRepre;
    }

    public void setApelidoRepre(String apelidoRepre) {
        this.apelidoRepre = apelidoRepre;
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

    public Clifor getClifor() {
        return clifor;
    }

    public void setClifor(Clifor clifor) {
        this.clifor = clifor;
    }

    public Planocontas getContaDebito() {
        return contaDebito;
    }

    public void setContaDebito(Planocontas contaDebito) {
        this.contaDebito = contaDebito;
    }

    public Planocontas getContaCredito() {
        return contaCredito;
    }

    public void setContaCredito(Planocontas contaCredito) {
        this.contaCredito = contaCredito;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepre != null ? idRepre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Representante)) {
            return false;
        }
        Representante other = (Representante) object;
        if ((this.idRepre == null && other.idRepre != null) || (this.idRepre != null && !this.idRepre.equals(other.idRepre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idRepre +":"+ apelidoRepre + "-" + nomeRepre;
    }
    
}
