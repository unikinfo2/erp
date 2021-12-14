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
@Table(name = "dre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dre.findAll", query = "SELECT d FROM Dre d"),
    @NamedQuery(name = "Dre.findByIdDre", query = "SELECT d FROM Dre d WHERE d.idDre = :idDre"),
    @NamedQuery(name = "Dre.findByTipo", query = "SELECT d FROM Dre d WHERE d.tipo = :tipo")})
public class Dre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDre")
    private Long idDre;
    //@Size(max = 100)
    @Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor1")
    private BigDecimal valor1;
    @Column(name = "valor2")
    private BigDecimal valor2;
    @Column(name = "valor3")
    private BigDecimal valor3;
    @Column(name = "valor4")
    private BigDecimal valor4;
    @Column(name = "valor5")
    private BigDecimal valor5;
    @Column(name = "valor6")
    private BigDecimal valor6;
    @Column(name = "valor7")
    private BigDecimal valor7;
    @Column(name = "valor8")
    private BigDecimal valor8;
    @Column(name = "valor9")
    private BigDecimal valor9;
    @Column(name = "valor10")
    private BigDecimal valor10;
    @Column(name = "valor11")
    private BigDecimal valor11;
    @Column(name = "valor12")
    private BigDecimal valor12;
    @Column(name = "valor13")
    private BigDecimal valor13;
    @JoinColumn(name = "idColaborador", referencedColumnName = "idColaborador")
    @ManyToOne
    private Colaborador idColaborador;
    @JoinColumn(name = "idConta", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas conta;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa idEmpresa;

    public Dre() {
    }

    public Dre(Long idDre) {
        this.idDre = idDre;
    }

    public Long getIdDre() {
        return idDre;
    }

    public void setIdDre(Long idDre) {
        this.idDre = idDre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor1() {
        return valor1;
    }

    public void setValor1(BigDecimal valor1) {
        this.valor1 = valor1;
    }

    public BigDecimal getValor2() {
        return valor2;
    }

    public void setValor2(BigDecimal valor2) {
        this.valor2 = valor2;
    }

    public BigDecimal getValor3() {
        return valor3;
    }

    public void setValor3(BigDecimal valor3) {
        this.valor3 = valor3;
    }

    public BigDecimal getValor4() {
        return valor4;
    }

    public void setValor4(BigDecimal valor4) {
        this.valor4 = valor4;
    }

    public BigDecimal getValor5() {
        return valor5;
    }

    public void setValor5(BigDecimal valor5) {
        this.valor5 = valor5;
    }

    public BigDecimal getValor6() {
        return valor6;
    }

    public void setValor6(BigDecimal valor6) {
        this.valor6 = valor6;
    }

    public BigDecimal getValor7() {
        return valor7;
    }

    public void setValor7(BigDecimal valor7) {
        this.valor7 = valor7;
    }

    public BigDecimal getValor8() {
        return valor8;
    }

    public void setValor8(BigDecimal valor8) {
        this.valor8 = valor8;
    }

    public BigDecimal getValor9() {
        return valor9;
    }

    public void setValor9(BigDecimal valor9) {
        this.valor9 = valor9;
    }

    public BigDecimal getValor10() {
        return valor10;
    }

    public void setValor10(BigDecimal valor10) {
        this.valor10 = valor10;
    }

    public BigDecimal getValor11() {
        return valor11;
    }

    public void setValor11(BigDecimal valor11) {
        this.valor11 = valor11;
    }

    public BigDecimal getValor12() {
        return valor12;
    }

    public void setValor12(BigDecimal valor12) {
        this.valor12 = valor12;
    }

    public BigDecimal getValor13() {
        return valor13;
    }

    public void setValor13(BigDecimal valor13) {
        this.valor13 = valor13;
    }


    public Colaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Colaborador idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Planocontas getConta() {
        return conta;
    }

    public void setConta(Planocontas conta) {
        this.conta = conta;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDre != null ? idDre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dre)) {
            return false;
        }
        Dre other = (Dre) object;
        if ((this.idDre == null && other.idDre != null) || (this.idDre != null && !this.idDre.equals(other.idDre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.Dre[ idDre=" + idDre + " ]";
    }
    
}
