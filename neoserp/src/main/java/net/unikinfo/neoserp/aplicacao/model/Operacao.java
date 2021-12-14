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
@Table(name = "operacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operacao.findAll", query = "SELECT c FROM Operacao c"),
    @NamedQuery(name = "Operacao.findByCodigoOperacao", query = "SELECT c FROM Operacao c WHERE c.codigoOperacao = :codigoOperacao"),
    @NamedQuery(name = "Operacao.findByEmpresa", query = "SELECT c FROM Operacao c WHERE c.empresa = :empresa"),
    @NamedQuery(name = "Operacao.findByDescricao", query = "SELECT c FROM Operacao c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Operacao.findByCompoeIpi", query = "SELECT c FROM Operacao c WHERE c.compoeIpi = :compoeIpi"),
    @NamedQuery(name = "Operacao.findByCompoeIcms", query = "SELECT c FROM Operacao c WHERE c.compoeIcms = :compoeIcms"),
    @NamedQuery(name = "Operacao.findByExportaOperacao", query = "SELECT c FROM Operacao c WHERE c.exportaOperacao = :exportaOperacao"),
    @NamedQuery(name = "Operacao.findByPagaComissao", query = "SELECT c FROM Operacao c WHERE c.pagaComissao = :pagaComissao"),
    @NamedQuery(name = "Operacao.findByObservacaoOperacao", query = "SELECT c FROM Operacao c WHERE c.observacaoOperacao = :observacaoOperacao"),
    @NamedQuery(name = "Operacao.findByRefOperacao", query = "SELECT c FROM Operacao c WHERE c.refOperacao = :refOperacao"),
    @NamedQuery(name = "Operacao.findByCalculaPis", query = "SELECT c FROM Operacao c WHERE c.calculaPis = :calculaPis"),
    @NamedQuery(name = "Operacao.findByCalculaCofins", query = "SELECT c FROM Operacao c WHERE c.calculaCofins = :calculaCofins"),
    @NamedQuery(name = "Operacao.findByCalculaCsll", query = "SELECT c FROM Operacao c WHERE c.calculaCsll = :calculaCsll"),
    @NamedQuery(name = "Operacao.findByCalculaIpi", query = "SELECT c FROM Operacao c WHERE c.calculaIpi = :calculaIpi"),
    @NamedQuery(name = "Operacao.findByCalculaIcms", query = "SELECT c FROM Operacao c WHERE c.calculaIcms = :calculaIcms"),
    @NamedQuery(name = "Operacao.findByCalculaST", query = "SELECT c FROM Operacao c WHERE c.calculaST = :calculaST"),
    @NamedQuery(name = "Operacao.findByBonificacao", query = "SELECT c FROM Operacao c WHERE c.bonificacao = :bonificacao"),
    @NamedQuery(name = "Operacao.findByCalculaIrpj", query = "SELECT c FROM Operacao c WHERE c.calculaIrpj = :calculaIrpj"),
    @NamedQuery(name = "Operacao.findByCalculaIss", query = "SELECT c FROM Operacao c WHERE c.calculaIss = :calculaIss"),
    @NamedQuery(name = "Operacao.findByOperacaoContraPartida", query = "SELECT c FROM Operacao c WHERE c.operacaoContraPartida = :operacaoContraPartida"),
    @NamedQuery(name = "Operacao.findByCstPis", query = "SELECT c FROM Operacao c WHERE c.cstPis = :cstPis"),
    @NamedQuery(name = "Operacao.findByCstCofins", query = "SELECT c FROM Operacao c WHERE c.cstCofins = :cstCofins"),
    @NamedQuery(name = "Operacao.findByCstIpi", query = "SELECT c FROM Operacao c WHERE c.cstIpi = :cstIpi"),
    @NamedQuery(name = "Operacao.findByTemplateQB", query = "SELECT c FROM Operacao c WHERE c.templateQB = :templateQB"),
    @NamedQuery(name = "Operacao.findBySomarFreteBaseIpi", query = "SELECT c FROM Operacao c WHERE c.somarFreteBaseIpi = :somarFreteBaseIpi"),
    @NamedQuery(name = "Operacao.findByAliqPis", query = "SELECT c FROM Operacao c WHERE c.aliqPis = :aliqPis"),
    @NamedQuery(name = "Operacao.findByAliqCofins", query = "SELECT c FROM Operacao c WHERE c.aliqCofins = :aliqCofins"),
    @NamedQuery(name = "Operacao.findByAliqCsll", query = "SELECT c FROM Operacao c WHERE c.aliqCsll = :aliqCsll"),
    @NamedQuery(name = "Operacao.findByVenda", query = "SELECT c FROM Operacao c WHERE c.venda = :venda"),
    @NamedQuery(name = "Operacao.findByAliqIRF", query = "SELECT c FROM Operacao c WHERE c.aliqIRF = :aliqIRF"),
    @NamedQuery(name = "Operacao.findByAliqISS", query = "SELECT c FROM Operacao c WHERE c.aliqISS = :aliqISS"),
    @NamedQuery(name = "Operacao.findByCodServico", query = "SELECT c FROM Operacao c WHERE c.codServico = :codServico"),
    @NamedQuery(name = "Operacao.findByPisoCalcIrf", query = "SELECT c FROM Operacao c WHERE c.pisoCalcIrf = :pisoCalcIrf"),
    @NamedQuery(name = "Operacao.findByPisoCalcPisCofinsCsll", query = "SELECT c FROM Operacao c WHERE c.pisoCalcPisCofinsCsll = :pisoCalcPisCofinsCsll"),
    @NamedQuery(name = "Operacao.findByPercLeiTransp", query = "SELECT c FROM Operacao c WHERE c.percLeiTransp = :percLeiTransp")})
public class Operacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 6)
    @Column(name = "codigoOperacao")
    private String codigoOperacao;
    //@Size(max = 40)
    @Column(name = "descricao")
    private String descricao;
    //@Size(max = 1)
    @Column(name = "compoeIpi")
    private String compoeIpi;
    //@Size(max = 1)
    @Column(name = "compoeIcms")
    private String compoeIcms;
    //@Size(max = 1)
    @Column(name = "exportaOperacao")
    private String exportaOperacao;
    //@Size(max = 1)
    @Column(name = "pagaComissao")
    private String pagaComissao;
    //@Size(max = 1000)
    @Column(name = "observacaoOperacao")
    private String observacaoOperacao;
    //@Size(max = 50)
    @Column(name = "refOperacao")
    private String refOperacao;
    //@Size(max = 1)
    @Column(name = "calculaPis")
    private String calculaPis;
    //@Size(max = 1)
    @Column(name = "calculaCofins")
    private String calculaCofins;
    //@Size(max = 1)
    @Column(name = "calculaCsll")
    private String calculaCsll;
    //@Size(max = 1)
    @Column(name = "calculaIpi")
    private String calculaIpi;
    //@Size(max = 1)
    @Column(name = "calculaIcms")
    private String calculaIcms;
    //@Size(max = 1)
    @Column(name = "calculaST")
    private String calculaST;
    //@Size(max = 1)
    @Column(name = "bonificacao")
    private String bonificacao;
    //@Size(max = 1)
    @Column(name = "calculaIrpj")
    private String calculaIrpj;
    //@Size(max = 1)
    @Column(name = "calculaIss")
    private String calculaIss;
    //@Size(max = 6)
    @Column(name = "operacaoContraPartida")
    private String operacaoContraPartida;
    //@Size(max = 4)
    @Column(name = "cstPis")
    private String cstPis;
    //@Size(max = 4)
    @Column(name = "cstCofins")
    private String cstCofins;
    //@Size(max = 4)
    @Column(name = "cstIpi")
    private String cstIpi;
    //@Size(max = 100)
    @Column(name = "templateQB")
    private String templateQB;
    //@Size(max = 1)
    @Column(name = "somarFreteBaseIpi")
    private String somarFreteBaseIpi;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "aliqPis")
    private BigDecimal aliqPis;
    @Column(name = "aliqCofins")
    private BigDecimal aliqCofins;
    @Column(name = "aliqCsll")
    private BigDecimal aliqCsll;
    //@Size(max = 1)
    @Column(name = "venda")
    private String venda;
    @Column(name = "aliqIRF")
    private BigDecimal aliqIRF;
    @Column(name = "aliqISS")
    private BigDecimal aliqISS;
    //@Size(max = 10)
    @Column(name = "codServico")
    private String codServico;
    @Column(name = "pisoCalcIrf")
    private BigDecimal pisoCalcIrf;
    @Column(name = "pisoCalcPisCofinsCsll")
    private BigDecimal pisoCalcPisCofinsCsll;
    @Column(name = "percLeiTransp")
    private BigDecimal percLeiTransp;
    
    @JoinColumn(name = "idContaDebito", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas planocontasDebito;
    
    @JoinColumn(name = "idContaCredito", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas planocontasCredito;
    
    @JoinColumn(name = "idContaRecebivel", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas planocontasRecebivel;
    
    @JoinColumn(name = "idContaReceita", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas planocontasReceita;    
    
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    
    @JoinColumn(name = "idTipoTransacaoNF", referencedColumnName = "idTipoTransacaoNF")
    @ManyToOne
    private Tipotransacaonf tipotransacaonf;
    

    public Operacao() {
    }

    public Operacao(String codigoOperacao) {
        this.codigoOperacao = codigoOperacao;
    }

    public String getCodigoOperacao() {
        return codigoOperacao;
    }

    public void setCodigoOperacao(String codigoOperacao) {
        this.codigoOperacao = codigoOperacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCompoeIpi() {
        return compoeIpi;
    }

    public void setCompoeIpi(String compoeIpi) {
        this.compoeIpi = compoeIpi;
    }

    public String getCompoeIcms() {
        return compoeIcms;
    }

    public void setCompoeIcms(String compoeIcms) {
        this.compoeIcms = compoeIcms;
    }

    public String getExportaOperacao() {
        return exportaOperacao;
    }

    public void setExportaOperacao(String exportaOperacao) {
        this.exportaOperacao = exportaOperacao;
    }

    public String getPagaComissao() {
        return pagaComissao;
    }

    public void setPagaComissao(String pagaComissao) {
        this.pagaComissao = pagaComissao;
    }

    public String getObservacaoOperacao() {
        return observacaoOperacao;
    }

    public void setObservacaoOperacao(String observacaoOperacao) {
        this.observacaoOperacao = observacaoOperacao;
    }

    public String getRefOperacao() {
        return refOperacao;
    }

    public void setRefOperacao(String refOperacao) {
        this.refOperacao = refOperacao;
    }

    public String getCalculaPis() {
        return calculaPis;
    }

    public void setCalculaPis(String calculaPis) {
        this.calculaPis = calculaPis;
    }

    public String getCalculaCofins() {
        return calculaCofins;
    }

    public void setCalculaCofins(String calculaCofins) {
        this.calculaCofins = calculaCofins;
    }

    public String getCalculaCsll() {
        return calculaCsll;
    }

    public void setCalculaCsll(String calculaCsll) {
        this.calculaCsll = calculaCsll;
    }

    public String getCalculaIpi() {
        return calculaIpi;
    }

    public void setCalculaIpi(String calculaIpi) {
        this.calculaIpi = calculaIpi;
    }

    public String getCalculaIcms() {
        return calculaIcms;
    }

    public void setCalculaIcms(String calculaIcms) {
        this.calculaIcms = calculaIcms;
    }

    public String getCalculaST() {
        return calculaST;
    }

    public void setCalculaST(String calculaST) {
        this.calculaST = calculaST;
    }

    public String getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(String bonificacao) {
        this.bonificacao = bonificacao;
    }

    public String getCalculaIrpj() {
        return calculaIrpj;
    }

    public void setCalculaIrpj(String calculaIrpj) {
        this.calculaIrpj = calculaIrpj;
    }

    public String getCalculaIss() {
        return calculaIss;
    }

    public void setCalculaIss(String calculaIss) {
        this.calculaIss = calculaIss;
    }

    public String getOperacaoContraPartida() {
        return operacaoContraPartida;
    }

    public void setOperacaoContraPartida(String operacaoContraPartida) {
        this.operacaoContraPartida = operacaoContraPartida;
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

    public String getCstIpi() {
        return cstIpi;
    }

    public void setCstIpi(String cstIpi) {
        this.cstIpi = cstIpi;
    }

    public String getTemplateQB() {
        return templateQB;
    }

    public void setTemplateQB(String templateQB) {
        this.templateQB = templateQB;
    }

    public String getSomarFreteBaseIpi() {
        return somarFreteBaseIpi;
    }

    public void setSomarFreteBaseIpi(String somarFreteBaseIpi) {
        this.somarFreteBaseIpi = somarFreteBaseIpi;
    }

    public BigDecimal getAliqPis() {
        return aliqPis;
    }

    public void setAliqPis(BigDecimal aliqPis) {
        this.aliqPis = aliqPis;
    }

    public BigDecimal getAliqCofins() {
        return aliqCofins;
    }

    public void setAliqCofins(BigDecimal aliqCofins) {
        this.aliqCofins = aliqCofins;
    }

    public BigDecimal getAliqCsll() {
        return aliqCsll;
    }

    public void setAliqCsll(BigDecimal aliqCsll) {
        this.aliqCsll = aliqCsll;
    }

    public String getVenda() {
        return venda;
    }

    public void setVenda(String venda) {
        this.venda = venda;
    }

    public BigDecimal getAliqIRF() {
        return aliqIRF;
    }

    public void setAliqIRF(BigDecimal aliqIRF) {
        this.aliqIRF = aliqIRF;
    }

    public BigDecimal getAliqISS() {
        return aliqISS;
    }

    public void setAliqISS(BigDecimal aliqISS) {
        this.aliqISS = aliqISS;
    }

    public String getCodServico() {
        return codServico;
    }

    public void setCodServico(String codServico) {
        this.codServico = codServico;
    }

    public BigDecimal getPisoCalcIrf() {
        return pisoCalcIrf;
    }

    public void setPisoCalcIrf(BigDecimal pisoCalcIrf) {
        this.pisoCalcIrf = pisoCalcIrf;
    }

    public BigDecimal getPisoCalcPisCofinsCsll() {
        return pisoCalcPisCofinsCsll;
    }

    public void setPisoCalcPisCofinsCsll(BigDecimal pisoCalcPisCofinsCsll) {
        this.pisoCalcPisCofinsCsll = pisoCalcPisCofinsCsll;
    }

    public BigDecimal getPercLeiTransp() {
        return percLeiTransp;
    }

    public void setPercLeiTransp(BigDecimal percLeiTransp) {
        this.percLeiTransp = percLeiTransp;
    }

    public Planocontas getPlanocontasDebito() {
        return planocontasDebito;
    }

    public void setPlanocontasDebito(Planocontas idContaDebito) {
        this.planocontasDebito = idContaDebito;
    }

    public Planocontas getPlanocontasCredito() {
        return planocontasCredito;
    }

    public void setPlanocontasCredito(Planocontas planocontasCredito) {
        this.planocontasCredito = planocontasCredito;
    }


    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    public Planocontas getPlanocontasRecebivel() {
        return planocontasRecebivel;
    }

    public void setPlanocontasRecebivel(Planocontas planocontasRecebivel) {
        this.planocontasRecebivel = planocontasRecebivel;
    }

    public Planocontas getPlanocontasReceita() {
        return planocontasReceita;
    }

    public void setPlanocontasReceita(Planocontas planocontasReceita) {
        this.planocontasReceita = planocontasReceita;
    }

    public Tipotransacaonf getTipotransacaonf() {
        return tipotransacaonf;
    }

    public void setTipoTransacaoNF(Tipotransacaonf tipotransacaonf) {
        this.tipotransacaonf = tipotransacaonf;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOperacao != null ? codigoOperacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operacao)) {
            return false;
        }
        Operacao other = (Operacao) object;
        if ((this.codigoOperacao == null && other.codigoOperacao != null) || (this.codigoOperacao != null && !this.codigoOperacao.equals(other.codigoOperacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigoOperacao + "-" + codServico + ":" + descricao;
    }
    
}
