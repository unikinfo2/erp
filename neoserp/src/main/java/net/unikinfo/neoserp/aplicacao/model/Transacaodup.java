/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "transacaodup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacaodup.findAll", query = "SELECT t FROM Transacaodup t order by t.dtVencto desc"),
    @NamedQuery(name = "Transacaodup.findByIdDup", query = "SELECT t FROM Transacaodup t WHERE t.idDup = :idDup"),
    @NamedQuery(name = "Transacaodup.findByEmpresa", query = "SELECT t FROM Transacaodup t WHERE t.transacao.empresa = :empresa order by t.dtVencto desc"),
    @NamedQuery(name = "Transacaodup.findByEmpresaTipoRecto", query = "SELECT t FROM Transacaodup t WHERE t.transacao.empresa = :empresa and t.tipoRecebimento = :tipoRec and t.chequeUsado = :chqUsado and t.transacao.tipoTransacao in (:tp1, :tp2) and t.transacao.statusTransacao in (:statusTransacao1, :statusTransacao2) and t.dtVencto between :dt1 and :dt2 order by t.dtVencto desc"),
    @NamedQuery(name = "Transacaodup.findByEmpresaPeriodoVencto", query = "SELECT t FROM Transacaodup t WHERE t.transacao.empresa = :empresa and t.dtVencto between :dt1 and :dt2 order by t.dtVencto desc"),
    @NamedQuery(name = "Transacaodup.findByCliforEmpresaPeriodoVencto", query = "SELECT t FROM Transacaodup t WHERE (t.transacao.clifor.razaoSocial like :clifor or t.transacao.clifor.cpfCnpj like :clifor) and t.transacao.empresa = :empresa and t.dtVencto between :dt1 and :dt2 order by t.dtVencto desc"),
    @NamedQuery(name = "Transacaodup.findByEmpresaPeriodoCriacao", query = "SELECT t FROM Transacaodup t WHERE t.transacao.empresa = :empresa and t.transacao.dataCriacao between :dt1 and :dt2 order by t.transacao.dataCriacao desc"),
    @NamedQuery(name = "Transacaodup.findByTransacao", query = "SELECT t FROM Transacaodup t WHERE t.transacao = :transacao"),
    @NamedQuery(name = "Transacaodup.findByTransacaoEvencto", query = "SELECT t FROM Transacaodup t WHERE t.transacao = :transacao and t.dtVencto = :dtVencto"),
    @NamedQuery(name = "Transacaodup.findByDtVencto", query = "SELECT t FROM Transacaodup t WHERE t.dtVencto = :dtVencto"),
    @NamedQuery(name = "Transacaodup.findByDtPagto", query = "SELECT t FROM Transacaodup t WHERE t.dtPagto = :dtPagto"),
    @NamedQuery(name = "Transacaodup.findByValor", query = "SELECT t FROM Transacaodup t WHERE t.valor = :valor"),
    @NamedQuery(name = "Transacaodup.findByCobrancaGerada", query = "SELECT t FROM Transacaodup t WHERE t.cobrancaGerada = :cobrancaGerada"),
    @NamedQuery(name = "Transacaodup.findByValorComissao", query = "SELECT t FROM Transacaodup t WHERE t.valorComissao = :valorComissao"),
    @NamedQuery(name = "Transacaodup.findByDtPagtoComissao", query = "SELECT t FROM Transacaodup t WHERE t.dtPagtoComissao = :dtPagtoComissao"),
    @NamedQuery(name = "Transacaodup.findByRazaoSocial", query = "SELECT t FROM Transacaodup t WHERE t.transacao.clifor.razaoSocial = :razaoSocial")})
public class Transacaodup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDup")
    private Long idDup;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "dtVencto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtVencto;
    @Column(name = "dtPagto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPagto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    //@Size(max = 1)
    @Column(name = "cobrancaGerada")
    private String cobrancaGerada;
    @Column(name = "valorComissao")
    private BigDecimal valorComissao;
    @Column(name = "dtPagtoComissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPagtoComissao;
    //@OneToMany(mappedBy = "transacaodup")
    //private List<Boletobancario> boletoList;
    @JoinColumn(name = "idTransacao", referencedColumnName = "idTransacao")
    @ManyToOne
    private Transacao transacao;
    @Column(name = "tipoRecebimento")
    private String tipoRecebimento;
    @Column(name = "numeroDocumento")
    private String numeroDocumento;
    //@Size(max = 1)
    @Column(name = "chequeUsado")
    private String chequeUsado;
    
    public Transacaodup() {
    }

    public Transacaodup(Long idDup) {
        this.idDup = idDup;
    }

    public Transacaodup(Long idDup, Date dtVencto, Date dtPagto, Date dtPagtoComissao) {
        this.idDup = idDup;
        this.dtVencto = dtVencto;
        this.dtPagto = dtPagto;
        this.dtPagtoComissao = dtPagtoComissao;
    }

    public Long getIdDup() {
        return idDup;
    }

    public void setIdDup(Long idDup) {
        this.idDup = idDup;
    }

    public Date getDtVencto() {
        return dtVencto;
    }

    public void setDtVencto(Date dtVencto) {
        this.dtVencto = dtVencto;
    }

    public Date getDtPagto() {
        return dtPagto;
    }

    public void setDtPagto(Date dtPagto) {
        this.dtPagto = dtPagto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCobrancaGerada() {
        return cobrancaGerada;
    }

    public void setCobrancaGerada(String cobrancaGerada) {
        this.cobrancaGerada = cobrancaGerada;
    }

    public BigDecimal getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(BigDecimal valorComissao) {
        this.valorComissao = valorComissao;
    }

    public Date getDtPagtoComissao() {
        return dtPagtoComissao;
    }

    public void setDtPagtoComissao(Date dtPagtoComissao) {
        this.dtPagtoComissao = dtPagtoComissao;
    }

    /*@XmlTransient
    public List<Boletobancario> getBoletoList() {
        return boletoList;
    }

    public void setBoletoList(List<Boletobancario> boletoList) {
        this.boletoList = boletoList;
    }*/

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public String getTipoRecebimento() {
        return tipoRecebimento;
    }

    public void setTipoRecebimento(String tipoRecebimento) {
        this.tipoRecebimento = tipoRecebimento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getChequeUsado() {
        return chequeUsado;
    }

    public void setChequeUsado(String chequeUsado) {
        this.chequeUsado = chequeUsado;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDup != null ? idDup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacaodup)) {
            return false;
        }
        Transacaodup other = (Transacaodup) object;
        if ((this.idDup == null && other.idDup != null) || (this.idDup != null && !this.idDup.equals(other.idDup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(transacao != null){
            return ""+ transacao.getNumeroTransacao() + ":" + dateFormat.format(dtVencto) + " -> " + valor;
        } else {
            return ""+ dateFormat.format(dtVencto) + " -> " + valor;
        }
    }
    
}
