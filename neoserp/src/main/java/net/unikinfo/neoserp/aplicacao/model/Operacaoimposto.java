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
@Table(name = "operacaoimposto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operacaoimposto.findAll", query = "SELECT c FROM Operacaoimposto c"),
    @NamedQuery(name = "Operacaoimposto.findByOperacao", query = "SELECT c FROM Operacaoimposto c WHERE c.operacao = :operacao"),
    @NamedQuery(name = "Operacaoimposto.findByIdOperacaoImposto", query = "SELECT c FROM Operacaoimposto c WHERE c.idOperacaoImposto = :idOperacaoImposto")})
public class Operacaoimposto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOperacaoImposto")
    private Long idOperacaoImposto;
    @JoinColumn(name = "contaDebitoOperacaoImposto", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas planocontas;
    @JoinColumn(name = "contaCreditoOperacaoImposto", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas planocontas1;
    @JoinColumn(name = "codigoOperacao", referencedColumnName = "codigoOperacao")
    @ManyToOne(optional = false)
    private Operacao operacao;
    @JoinColumn(name = "idTipoImposto", referencedColumnName = "idTipoImposto")
    @ManyToOne(optional = false)
    private Tipoimposto tipoimposto;
    private BigDecimal aliqOperacaoImposto;
    @JoinColumn(name = "idCliFor", referencedColumnName = "idCliFor")
    @ManyToOne
    private Clifor clifor;

    public Operacaoimposto() {
    }

    public Operacaoimposto(Long idOperacaoImposto) {
        this.idOperacaoImposto = idOperacaoImposto;
    }

    public Long getIdOperacaoImposto() {
        return idOperacaoImposto;
    }

    public void setIdOperacaoImposto(Long idOperacaoImposto) {
        this.idOperacaoImposto = idOperacaoImposto;
    }

    public Planocontas getPlanocontas() {
        return planocontas;
    }

    public void setPlanocontas(Planocontas planocontas) {
        this.planocontas = planocontas;
    }

    public Planocontas getPlanocontas1() {
        return planocontas1;
    }

    public void setPlanocontas1(Planocontas planocontas1) {
        this.planocontas1 = planocontas1;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Tipoimposto getTipoimposto() {
        return tipoimposto;
    }

    public void setTipoimposto(Tipoimposto tipoimposto) {
        this.tipoimposto = tipoimposto;
    }

    public BigDecimal getAliqOperacaoImposto() {
        return aliqOperacaoImposto;
    }

    public void setAliqOperacaoImposto(BigDecimal aliqOperacaoImposto) {
        this.aliqOperacaoImposto = aliqOperacaoImposto;
    }

    public Clifor getClifor() {
        return clifor;
    }

    public void setClifor(Clifor clifor) {
        this.clifor = clifor;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacaoImposto != null ? idOperacaoImposto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operacaoimposto)) {
            return false;
        }
        Operacaoimposto other = (Operacaoimposto) object;
        if ((this.idOperacaoImposto == null && other.idOperacaoImposto != null) || (this.idOperacaoImposto != null && !this.idOperacaoImposto.equals(other.idOperacaoImposto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idOperacaoImposto + "-" + operacao.getCodigoOperacao() + ":" + tipoimposto.getNomeTipoImposto();
    }
    
}
