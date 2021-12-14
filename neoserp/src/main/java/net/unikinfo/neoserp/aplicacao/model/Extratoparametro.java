/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
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
@Table(name = "extratoparametro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extratoparametro.findAll", query = "SELECT e FROM Extratoparametro e"),
    @NamedQuery(name = "Extratoparametro.findByIdExtratoParamentro", query = "SELECT e FROM Extratoparametro e WHERE e.idExtratoParamentro = :idExtratoParamentro"),
    @NamedQuery(name = "Extratoparametro.findByHistoricoMovto", query = "SELECT e FROM Extratoparametro e WHERE e.historicoMovto = :historicoMovto")})
public class Extratoparametro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idExtratoParamentro")
    private Long idExtratoParamentro;

    //@Size(max = 250)
    @Column(name = "historicoMovto")
    private String historicoMovto;

    @JoinColumn(name = "contaContraPartida", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas contaContraPartida;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;

    public Extratoparametro() {
    }

    public Extratoparametro(Long idExtratoParamentro) {
        this.idExtratoParamentro = idExtratoParamentro;
    }

    public Long getIdExtratoParamentro() {
        return idExtratoParamentro;
    }

    public void setIdExtratoParamentro(Long idExtratoParamentro) {
        this.idExtratoParamentro = idExtratoParamentro;
    }

    public String getHistoricoMovto() {
        return historicoMovto;
    }

    public void setHistoricoMovto(String historicoMovto) {
        this.historicoMovto = historicoMovto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExtratoParamentro != null ? idExtratoParamentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extratoparametro)) {
            return false;
        }
        Extratoparametro other = (Extratoparametro) object;
        if ((this.idExtratoParamentro == null && other.idExtratoParamentro != null) || (this.idExtratoParamentro != null && !this.idExtratoParamentro.equals(other.idExtratoParamentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idExtratoParamentro.toString();
    }

    public Planocontas getContaContraPartida() {
        return contaContraPartida;
    }

    public void setContaContraPartida(Planocontas contaContraPartida) {
        this.contaContraPartida = contaContraPartida;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    

}
