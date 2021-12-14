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
@Table(name = "processos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Processos.findAll", query = "SELECT p FROM Processos p"),
    @NamedQuery(name = "Processos.findByIdProcesso", query = "SELECT p FROM Processos p WHERE p.idProcesso = :idProcesso"),
    @NamedQuery(name = "Processos.findByEmpresa", query = "SELECT p FROM Processos p WHERE p.empresa = :empresa order by p.dataAbertura desc" )})
public class Processos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProcesso")
    private Long idProcesso;
    //@Size(max = 45)
    @Column(name = "contato")
    private String contato;
    @Column(name = "statusAtendimento")
    private String statusAtendimento;
    @Column(name = "prioridade")
    private String prioridade;
    @Column(name = "dataAbertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAbertura;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "relatoCliforOperador")
    private String relatoCliforOperador;
    @Column(name = "geraCobranca")
    private String geraCobranca;
    @Column(name = "tipoAtendimento")
    private String tipoAtendimento;
    @Column(name = "dtInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInicio;
    @Column(name = "dtPrevistaFechamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPrevistaFechamento;
    @Column(name = "dtFechamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFechamento;

    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "idCliFor", referencedColumnName = "idCliFor")
    @ManyToOne
    private Clifor clifor;
    @JoinColumn(name = "idColaborador", referencedColumnName = "idColaborador")
    @ManyToOne
    private Colaborador colaborador;
    @Column(name = "nomeClifor")
    private String nomeClifor;

    public Processos() {
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Clifor getClifor() {
        return clifor;
    }

    public void setClifor(Clifor clifor) {
        this.clifor = clifor;
    }

    public Long getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Long idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getStatusAtendimento() {
        return statusAtendimento;
    }

    public void setStatusAtendimento(String statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRelatoCliforOperador() {
        return relatoCliforOperador;
    }

    public void setRelatoCliforOperador(String relatoCliforOperador) {
        this.relatoCliforOperador = relatoCliforOperador;
    }

    public String getGeraCobranca() {
        return geraCobranca;
    }

    public void setGeraCobranca(String geraCobranca) {
        this.geraCobranca = geraCobranca;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtPrevistaFechamento() {
        return dtPrevistaFechamento;
    }

    public void setDtPrevistaFechamento(Date dtPrevistaFechamento) {
        this.dtPrevistaFechamento = dtPrevistaFechamento;
    }

    public Date getDtFechamento() {
        return dtFechamento;
    }

    public void setDtFechamento(Date dtFechamento) {
        this.dtFechamento = dtFechamento;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public String getNomeClifor() {
        return nomeClifor;
    }

    public void setNomeClifor(String nomeClifor) {
        this.nomeClifor = nomeClifor;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesso != null ? idProcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projeto)) {
            return false;
        }
        Processos other = (Processos) object;
        if ((this.idProcesso == null && other.idProcesso != null) || (this.idProcesso != null && !this.idProcesso.equals(other.idProcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idProcesso + "-" + tipoAtendimento + "-" + clifor;
    }

}
