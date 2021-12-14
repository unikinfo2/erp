/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "configuracao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracao.findAll", query = "SELECT c FROM Configuracao c"),
    @NamedQuery(name = "Configuracao.findByChave", query = "SELECT c FROM Configuracao c WHERE c.configuracaoPK.chave = :chave"),
    @NamedQuery(name = "Configuracao.findByDescricao", query = "SELECT c FROM Configuracao c WHERE c.configuracaoPK.descricao = :descricao"),
    @NamedQuery(name = "Configuracao.findByValor", query = "SELECT c FROM Configuracao c WHERE c.valor = :valor")})
public class Configuracao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConfiguracaoPK configuracaoPK;
    //@Size(max = 240)
    @Column(name = "VALOR")
    private String valor;

    public Configuracao() {
    }

    public Configuracao(ConfiguracaoPK configuracaoPK) {
        this.configuracaoPK = configuracaoPK;
    }

    public Configuracao(String chave, String descricao) {
        this.configuracaoPK = new ConfiguracaoPK(chave, descricao);
    }

    public ConfiguracaoPK getConfiguracaoPK() {
        return configuracaoPK;
    }

    public void setConfiguracaoPK(ConfiguracaoPK configuracaoPK) {
        this.configuracaoPK = configuracaoPK;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configuracaoPK != null ? configuracaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracao)) {
            return false;
        }
        Configuracao other = (Configuracao) object;
        if ((this.configuracaoPK == null && other.configuracaoPK != null) || (this.configuracaoPK != null && !this.configuracaoPK.equals(other.configuracaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Configuracao[ configuracaoPK=" + configuracaoPK + " ]";
    }
    
}
