/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
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
@Table(name = "log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByIdLog", query = "SELECT l FROM Log l WHERE l.idLog = :idLog"),
    @NamedQuery(name = "Log.findByModuloLog", query = "SELECT l FROM Log l WHERE l.moduloLog = :moduloLog"),
    @NamedQuery(name = "Log.findByIdModulo", query = "SELECT l FROM Log l WHERE l.idModulo = :idModulo"),
    @NamedQuery(name = "Log.findByAcaoLog", query = "SELECT l FROM Log l WHERE l.acaoLog = :acaoLog"),
    @NamedQuery(name = "Log.findByDatahoraLog", query = "SELECT l FROM Log l WHERE l.datahoraLog = :datahoraLog")})
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLog")
    private Long idLog;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(name = "moduloLog")
    private String moduloLog;
    @Column(name = "idModulo")
    private Integer idModulo;
    //@Size(max = 45)
    @Column(name = "acaoLog")
    private String acaoLog;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "datahoraLog")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahoraLog;
    @JoinColumn(name = "idColaboradorLog", referencedColumnName = "idColaborador")
    @ManyToOne
    private Colaborador colaborador;

    public Log() {
    }

    public Log(Long idLog) {
        this.idLog = idLog;
    }

    public Log(Long idLog, String moduloLog, Date datahoraLog) {
        this.idLog = idLog;
        this.moduloLog = moduloLog;
        this.datahoraLog = datahoraLog;
    }

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public String getModuloLog() {
        return moduloLog;
    }

    public void setModuloLog(String moduloLog) {
        this.moduloLog = moduloLog;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public String getAcaoLog() {
        return acaoLog;
    }

    public void setAcaoLog(String acaoLog) {
        this.acaoLog = acaoLog;
    }

    public Date getDatahoraLog() {
        return datahoraLog;
    }

    public void setDatahoraLog(Date datahoraLog) {
        this.datahoraLog = datahoraLog;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Log[ idLog=" + idLog + " ]";
    }
    
}
