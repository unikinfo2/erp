/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "ordemdespacho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdemDespacho.findAll", query = "SELECT e FROM OrdemDespacho e"),
    @NamedQuery(name = "OrdemDespacho.findOrdemDespachoPorPedido", query = "SELECT o FROM OrdemDespacho o WHERE o.transacao = :transacao"),
    //@NamedQuery(name = "OrdemDespacho.findOrdemDespachoPorCep", query = "SELECT o FROM OrdemDespacho o WHERE o.transacao.clifor.cep = :cepRel order by o.precoCubado desc"),
    @NamedQuery(name = "OrdemDespacho.findOrdemDespachoPorTransportadora", query = "SELECT o FROM OrdemDespacho o WHERE o.transportadora = :transp")})

public class OrdemDespacho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrdemDespacho")
    private Long idOrdemDespacho;
    //@Size(max = 250)
    @Column(name = "motorista")
    private String motorista;
    //@Size(max = 250)
    @Column(name = "rg")
    private String rg;
    @JoinColumn(name = "idTransp", referencedColumnName = "idTransp")
    @ManyToOne
    private Transportadora transportadora;
    @JoinColumn(name = "idTransacao", referencedColumnName = "idTransacao")
    @ManyToOne
    private Transacao transacao;
    @Column(name = "precoCubado")
    private BigDecimal precoCubado;
    @Column(name = "totalFrete")
    private BigDecimal totalFrete;
    @Column(name = "totalCubado")
    private BigDecimal totalCubado;    
    @Column(name = "dtEnvio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEnvio;
    //@Size(max = 45)
    @Column(name = "placa")
    private String placa;
    @Column(name = "itensConferidos")
    private String itensConferidos;    
    @Column(name = "percFreteSobreNota")
    private BigDecimal percFreteSobreNota; 
    
    public OrdemDespacho() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdemDespacho != null ? idOrdemDespacho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemDespacho)) {
            return false;
        }
        OrdemDespacho other = (OrdemDespacho) object;
        if ((this.idOrdemDespacho == null && other.idOrdemDespacho != null) || (this.idOrdemDespacho != null && !this.idOrdemDespacho.equals(other.idOrdemDespacho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.OrdemDespacho[ idOrdemDespacho=" + idOrdemDespacho + " ]";
    }

    public Long getIdOrdemDespacho() {
        return idOrdemDespacho;
    }

    public void setIdOrdemDespacho(Long idOrdemDespacho) {
        this.idOrdemDespacho = idOrdemDespacho;
    }


    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public BigDecimal getPrecoCubado() {
        return precoCubado;
    }

    public void setPrecoCubado(BigDecimal precoCubado) {
        this.precoCubado = precoCubado;
    }

    public BigDecimal getTotalFrete() {
        return totalFrete;
    }

    public void setTotalFrete(BigDecimal totalFrete) {
        this.totalFrete = totalFrete;
    }

    public BigDecimal getTotalCubado() {
        return totalCubado;
    }

    public void setTotalCubado(BigDecimal totalCubado) {
        this.totalCubado = totalCubado;
    }

    public Date getDtEnvio() {
        return dtEnvio;
    }

    public void setDtEnvio(Date dtEnvio) {
        this.dtEnvio = dtEnvio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getItensConferidos() {
        return itensConferidos;
    }

    public void setItensConferidos(String itensConferidos) {
        this.itensConferidos = itensConferidos;
    }

    public BigDecimal getPercFreteSobreNota() {
        return percFreteSobreNota;
    }

    public void setPercFreteSobreNota(BigDecimal percFreteSobreNota) {
        this.percFreteSobreNota = percFreteSobreNota;
    }

    
}
