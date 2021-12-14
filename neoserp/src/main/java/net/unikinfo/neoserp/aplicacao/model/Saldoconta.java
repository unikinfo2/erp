/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "saldoconta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saldoconta.findAll", query = "SELECT s FROM Saldoconta s"),
    @NamedQuery(name = "Saldoconta.findByEmpresa", query = "SELECT s FROM Saldoconta s WHERE s.empresa = :empresa"),
    @NamedQuery(name = "Saldoconta.findByEmpresaAnoMes", query = "SELECT s FROM Saldoconta s WHERE s.empresa = :empresa and s.anomesSaldo = :anomesSaldo"),
    @NamedQuery(name = "Saldoconta.findByEmpresaAnoMesConta", query = "SELECT s FROM Saldoconta s WHERE s.empresa = :empresa and s.anomesSaldo = :anomesSaldo and s.contasaldo = :contasaldo"),
    @NamedQuery(name = "Saldoconta.findByIdSaldoConta", query = "SELECT s FROM Saldoconta s WHERE s.idSaldoConta = :idSaldoConta"),
    @NamedQuery(name = "Saldoconta.findByAnomesSaldo", query = "SELECT s FROM Saldoconta s WHERE s.anomesSaldo = :anomesSaldo"),
    @NamedQuery(name = "Saldoconta.findBySaldoAnterior", query = "SELECT s FROM Saldoconta s WHERE s.saldoAnterior = :saldoAnterior"),
    @NamedQuery(name = "Saldoconta.findByTpSaldoAnterior", query = "SELECT s FROM Saldoconta s WHERE s.tpSaldoAnterior = :tpSaldoAnterior"),
    @NamedQuery(name = "Saldoconta.findByValorDebito", query = "SELECT s FROM Saldoconta s WHERE s.valorDebito = :valorDebito"),
    @NamedQuery(name = "Saldoconta.findByValorCredito", query = "SELECT s FROM Saldoconta s WHERE s.valorCredito = :valorCredito"),
    @NamedQuery(name = "Saldoconta.findBySaldoFinal", query = "SELECT s FROM Saldoconta s WHERE s.saldoFinal = :saldoFinal"),
    @NamedQuery(name = "Saldoconta.findByTpSaldoFinal", query = "SELECT s FROM Saldoconta s WHERE s.tpSaldoFinal = :tpSaldoFinal")})
public class Saldoconta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSaldoConta")
    private Long idSaldoConta;
    //@Size(max = 6)
    @Column(name = "anomesSaldo")
    private String anomesSaldo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldoAnterior")
    private BigDecimal saldoAnterior;
    //@Size(max = 1)
    @Column(name = "tpSaldoAnterior")
    private String tpSaldoAnterior;
    @Column(name = "valorDebito")
    private BigDecimal valorDebito;
    @Column(name = "valorCredito")
    private BigDecimal valorCredito;
    @Column(name = "SaldoFinal")
    private BigDecimal saldoFinal;
    //@Size(max = 1)
    @Column(name = "tpSaldoFinal")
    private String tpSaldoFinal;
    @JoinColumn(name = "idContaSaldo", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas contasaldo;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    //private Planocontas contaPrincipal;

    public Saldoconta() {
    }

    public Saldoconta(Long idSaldoConta) {
        this.idSaldoConta = idSaldoConta;
    }

    public Long getIdSaldoConta() {
        return idSaldoConta;
    }

    public void setIdSaldoConta(Long idSaldoConta) {
        this.idSaldoConta = idSaldoConta;
    }

    //public Planocontas getContaPrincipal() {
    //    return contasaldo.getPlanocontas();
    //}
    
    public String getAnomesSaldo() {
        return anomesSaldo;
    }

    public void setAnomesSaldo(String anomesSaldo) {
        this.anomesSaldo = anomesSaldo;
    }

    public BigDecimal getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(BigDecimal saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public String getTpSaldoAnterior() {
        return tpSaldoAnterior;
    }

    public void setTpSaldoAnterior(String tpSaldoAnterior) {
        this.tpSaldoAnterior = tpSaldoAnterior;
    }

    public BigDecimal getValorDebito() {
        return valorDebito;
    }

    public void setValorDebito(BigDecimal valorDebito) {
        this.valorDebito = valorDebito;
    }

    public BigDecimal getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(BigDecimal valorCredito) {
        this.valorCredito = valorCredito;
    }

    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(BigDecimal saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public String getTpSaldoFinal() {
        return tpSaldoFinal;
    }

    public void setTpSaldoFinal(String tpSaldoFinal) {
        this.tpSaldoFinal = tpSaldoFinal;
    }

    public Planocontas getContasaldo() {
        return contasaldo;
    }

    public void setContasaldo(Planocontas Contasaldo) {
        this.contasaldo = Contasaldo;
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
        hash += (idSaldoConta != null ? idSaldoConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saldoconta)) {
            return false;
        }
        Saldoconta other = (Saldoconta) object;
        if ((this.idSaldoConta == null && other.idSaldoConta != null) || (this.idSaldoConta != null && !this.idSaldoConta.equals(other.idSaldoConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Saldoconta[ idSaldoConta=" + idSaldoConta + " ]";
    }
    
}
