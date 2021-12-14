/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Carlos
 */
@Embeddable
public class ConfiguracaoPK implements Serializable {
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "CHAVE")
    private String chave;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 100)
    @Column(name = "DESCRICAO")
    private String descricao;

    public ConfiguracaoPK() {
    }

    public ConfiguracaoPK(String chave, String descricao) {
        this.chave = chave;
        this.descricao = descricao;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chave != null ? chave.hashCode() : 0);
        hash += (descricao != null ? descricao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracaoPK)) {
            return false;
        }
        ConfiguracaoPK other = (ConfiguracaoPK) object;
        if ((this.chave == null && other.chave != null) || (this.chave != null && !this.chave.equals(other.chave))) {
            return false;
        }
        if ((this.descricao == null && other.descricao != null) || (this.descricao != null && !this.descricao.equals(other.descricao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.ConfiguracaoPK[ chave=" + chave + ", descricao=" + descricao + " ]";
    }
    
}
