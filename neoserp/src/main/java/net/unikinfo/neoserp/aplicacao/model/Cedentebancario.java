/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "cedente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cedentebancario.findAll", query = "SELECT c FROM Cedentebancario c"),
    @NamedQuery(name = "Cedentebancario.findByIdCedente", query = "SELECT c FROM Cedentebancario c WHERE c.idCedente = :idCedente"),
    @NamedQuery(name = "Cedentebancario.findByEmpresa", query = "SELECT c FROM Cedentebancario c WHERE c.empresa = :empresa"),
    @NamedQuery(name = "Cedentebancario.findByCarteira", query = "SELECT c FROM Cedentebancario c WHERE c.carteira = :carteira"),
    @NamedQuery(name = "Cedentebancario.findByInstrucao", query = "SELECT c FROM Cedentebancario c WHERE c.instrucao = :instrucao"),
    @NamedQuery(name = "Cedentebancario.findByUltimoNumero", query = "SELECT c FROM Cedentebancario c WHERE c.ultimoNumero = :ultimoNumero"),
    @NamedQuery(name = "Cedentebancario.findByBanco", query = "SELECT c FROM Cedentebancario c WHERE c.banco = :banco"),
    @NamedQuery(name = "Cedentebancario.findByAgencia", query = "SELECT c FROM Cedentebancario c WHERE c.agencia = :agencia"),
    @NamedQuery(name = "Cedentebancario.findByAgenciaDig", query = "SELECT c FROM Cedentebancario c WHERE c.agenciaDig = :agenciaDig"),
    @NamedQuery(name = "Cedentebancario.findByConta", query = "SELECT c FROM Cedentebancario c WHERE c.conta = :conta"),
    @NamedQuery(name = "Cedentebancario.findByContaDig", query = "SELECT c FROM Cedentebancario c WHERE c.contaDig = :contaDig"),
    @NamedQuery(name = "Cedentebancario.findByCodigo", query = "SELECT c FROM Cedentebancario c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Cedentebancario.findByDigito", query = "SELECT c FROM Cedentebancario c WHERE c.digito = :digito"),
    @NamedQuery(name = "Cedentebancario.findByCodigoBanco", query = "SELECT c FROM Cedentebancario c WHERE c.codigoBanco = :codigoBanco"),
    @NamedQuery(name = "Cedentebancario.findByArquivoNumero", query = "SELECT c FROM Cedentebancario c WHERE c.arquivoNumero = :arquivoNumero"),
    @NamedQuery(name = "Cedentebancario.findByQuemImprime", query = "SELECT c FROM Cedentebancario c WHERE c.quemImprime = :quemImprime"),
    @NamedQuery(name = "Cedentebancario.findByDescricaoCedente", query = "SELECT c FROM Cedentebancario c WHERE c.descricaoCedente = :descricaoCedente")})
public class Cedentebancario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCedente")
    private Long idCedente;
    @Column(name = "carteira")
    private String carteira;
    @Column(name = "instrucao")
    private String instrucao;
    @Column(name = "ultimoNumero")
    private String ultimoNumero;
    @Column(name = "banco")
    private String banco;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "agenciaDig")
    private String agenciaDig;
    @Column(name = "conta")
    private String conta;
    @Column(name = "contaDig")
    private String contaDig;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "digito")
    private String digito;
    @Column(name = "codigoBanco")
    private String codigoBanco;
    @Column(name = "arquivoNumero")
    private BigInteger arquivoNumero;
    @Column(name = "quemImprime")
    private String quemImprime;
    @Column(name = "descricaoCedente")
    private String descricaoCedente;
    @OneToMany(mappedBy = "cedentebancario")
    private List<Boletobancario> boletoList;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "idPlanoContas", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas planoContas;
    @Column(name = "multaCobrada")
    private BigDecimal multaCobrada;
    @Column(name = "jurosMora")
    private BigDecimal jurosMora; 
    @Column(name = "imprimeObservacaoTransacao")
    private String imprimeObservacaoTransacao;
    
    public Cedentebancario() {
    }

    public Cedentebancario(Long idCedente) {
        this.idCedente = idCedente;
    }

    public Long getIdCedente() {
        return idCedente;
    }

    public void setIdCedente(Long idCedente) {
        this.idCedente = idCedente;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public String getUltimoNumero() {
        return ultimoNumero;
    }

    public void setUltimoNumero(String ultimoNumero) {
        this.ultimoNumero = ultimoNumero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getAgenciaDig() {
        return agenciaDig;
    }

    public void setAgenciaDig(String agenciaDig) {
        this.agenciaDig = agenciaDig;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getContaDig() {
        return contaDig;
    }

    public void setContaDig(String contaDig) {
        this.contaDig = contaDig;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public BigInteger getArquivoNumero() {
        return arquivoNumero;
    }

    public void setArquivoNumero(BigInteger arquivoNumero) {
        this.arquivoNumero = arquivoNumero;
    }

    public String getQuemImprime() {
        return quemImprime;
    }

    public void setQuemImprime(String quemImprime) {
        this.quemImprime = quemImprime;
    }

    public String getDescricaoCedente() {
        return descricaoCedente;
    }

    public void setDescricaoCedente(String descricaoCedente) {
        this.descricaoCedente = descricaoCedente;
    }

    public String getImprimeObservacaoTransacao() {
        return imprimeObservacaoTransacao;
    }

    public void setImprimeObservacaoTransacao(String imprimiObservacaoTransacao) {
        this.imprimeObservacaoTransacao = imprimiObservacaoTransacao;
    }    

    @XmlTransient
    public List<Boletobancario> getBoletoList() {
        return boletoList;
    }

    public void setBoletoList(List<Boletobancario> boletoList) {
        this.boletoList = boletoList;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public BigDecimal getMultaCobrada() {
        return multaCobrada;
    }

    public void setMultaCobrada(BigDecimal multaCobrada) {
        this.multaCobrada = multaCobrada;
    }

    public BigDecimal getJurosMora() {
        return jurosMora;
    }

    public void setJurosMora(BigDecimal jurosMora) {
        this.jurosMora = jurosMora;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCedente != null ? idCedente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cedentebancario)) {
            return false;
        }
        Cedentebancario other = (Cedentebancario) object;
        if ((this.idCedente == null && other.idCedente != null) || (this.idCedente != null && !this.idCedente.equals(other.idCedente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idCedente + "-" + banco+":"+agencia+":"+conta+":"+descricaoCedente;
    }

    public Planocontas getPlanoContas() {
        return planoContas;
    }

    public void setPlanoContas(Planocontas planoContas) {
        this.planoContas = planoContas;
    }
    
}
