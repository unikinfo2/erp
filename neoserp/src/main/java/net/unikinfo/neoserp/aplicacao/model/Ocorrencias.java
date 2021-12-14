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
@Table(name = "ocorrenciaprocesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocorrencias.findAll", query = "SELECT o FROM Ocorrencias o"),    
    @NamedQuery(name = "Ocorrencias.findByProcesso", query = "SELECT o FROM Ocorrencias o WHERE o.processo = :processo")})
public class Ocorrencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOcorrencia")
    private Long idOcorrencia;    
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "dtOcorrencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtOcorrencia;
    @JoinColumn(name = "idProcesso", referencedColumnName = "idProcesso")
    @ManyToOne
    private Processos processo;

    
    public Ocorrencias() {
    }

    public Ocorrencias(Long idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public Long getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(Long idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtOcorrencia() {
        return dtOcorrencia;
    }

    public void setDtOcorrencia(Date dtOcorrencia) {
        this.dtOcorrencia = dtOcorrencia;
    }

    public Processos getProcesso() {
        return processo;
    }

    public void setProcesso(Processos processo) {
        this.processo = processo;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOcorrencia != null ? idOcorrencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocorrencias)) {
            return false;
        }
        Ocorrencias other = (Ocorrencias) object;
        if ((this.idOcorrencia == null && other.idOcorrencia != null) || (this.idOcorrencia != null && !this.idOcorrencia.equals(other.idOcorrencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idOcorrencia + "-" + dtOcorrencia + ":" + processo;
    }

}
