/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Bruno Gomes
 */
@Entity
public class CamposRelatorioEstoque implements Serializable, Comparable<CamposRelatorioEstoque> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCampo;
    private String idProduto;
    private String idEstoque;
    private String descricao;
    private BigDecimal saldoAtual;
    private String codigoAuxEstoque;
    private BigDecimal precoVenda;
    @OneToMany
    private List<CamposRelatorioEstoque> listaCampo;

    public CamposRelatorioEstoque() {
    }
    
    public CamposRelatorioEstoque (String idProd, String idEst, String desc, BigDecimal quant, String codAuxEst, BigDecimal quantAtual, BigDecimal precoVenda){
        this.idProduto = idProd;
        this.idEstoque = idEst;
        this.descricao = desc;
        this.saldoAtual = quant;
        this.codigoAuxEstoque = codAuxEst;
        this.precoVenda = precoVenda;
        listaCampo = new ArrayList();
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProd) {
        this.idProduto = idProd;
    }

    public String getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(String idEst) {
        this.idEstoque = idEst;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String desc) {
        this.descricao = desc;
    }

    public BigDecimal getSaldoAtual() {
        return saldoAtual;
    }

    public void setQuantidade(BigDecimal quant) {
        this.saldoAtual = quant;
    }

    public String getCodigoAuxEstoque() {
        return codigoAuxEstoque;
    }

    public void setCodigoAuxEstoque(String codAuxEst) {
        this.codigoAuxEstoque = codAuxEst;
    }

    public List<CamposRelatorioEstoque> getListaCampo() {
        return listaCampo;
    }

    public void setListCampo(List<CamposRelatorioEstoque> listaCampo) {
        this.listaCampo = listaCampo;
    }
       
    public Long getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(Long idCampo) {
        this.idCampo = idCampo;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCampo != null ? idCampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CamposRelatorioEstoque)) {
            return false;
        }
        CamposRelatorioEstoque other = (CamposRelatorioEstoque) object;
        if ((this.idCampo == null && other.idCampo != null) || (this.idCampo != null && !this.idCampo.equals(other.idCampo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idEstoque  + "-" + idProduto +"-" + descricao ;
    }

    @Override
    public int compareTo(CamposRelatorioEstoque o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
