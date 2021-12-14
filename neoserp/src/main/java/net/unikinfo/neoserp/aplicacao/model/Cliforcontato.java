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
@Table(name = "cliforcontato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliforcontato.findAll", query = "SELECT c FROM Cliforcontato c"),
    @NamedQuery(name = "Cliforcontato.findByClifor", query = "SELECT c FROM Cliforcontato c WHERE c.clifor = :clifor"),
    @NamedQuery(name = "Cliforcontato.findByIdcontato", query = "SELECT c FROM Cliforcontato c WHERE c.idcontato = :idcontato"),
    @NamedQuery(name = "Cliforcontato.findByNomeContato", query = "SELECT c FROM Cliforcontato c WHERE c.nomeContato = :nomeContato"),
    @NamedQuery(name = "Cliforcontato.findByCargoContato", query = "SELECT c FROM Cliforcontato c WHERE c.cargoContato = :cargoContato"),
    @NamedQuery(name = "Cliforcontato.findByTelefoneContato", query = "SELECT c FROM Cliforcontato c WHERE c.telefoneContato = :telefoneContato"),
    @NamedQuery(name = "Cliforcontato.findByCelularContato", query = "SELECT c FROM Cliforcontato c WHERE c.celularContato = :celularContato"),
    @NamedQuery(name = "Cliforcontato.findByRadioContato", query = "SELECT c FROM Cliforcontato c WHERE c.radioContato = :radioContato"),
    @NamedQuery(name = "Cliforcontato.findByEmailContato", query = "SELECT c FROM Cliforcontato c WHERE c.emailContato = :emailContato"),
    @NamedQuery(name = "Cliforcontato.findByRamalContato", query = "SELECT c FROM Cliforcontato c WHERE c.ramalContato = :ramalContato"),
    @NamedQuery(name = "Cliforcontato.findByDeptoContato", query = "SELECT c FROM Cliforcontato c WHERE c.deptoContato = :deptoContato")})
public class Cliforcontato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontato")
    private Long idcontato;
    //@Size(max = 40)
    @Column(name = "nomeContato")
    private String nomeContato;
    //@Size(max = 45)
    @Column(name = "cargoContato")
    private String cargoContato;
    //@Size(max = 20)
    @Column(name = "telefoneContato")
    private String telefoneContato;
    //@Size(max = 20)
    @Column(name = "celularContato")
    private String celularContato;
    //@Size(max = 20)
    @Column(name = "radioContato")
    private String radioContato;
    //@Size(max = 100)
    @Column(name = "emailContato")
    private String emailContato;
    //@Size(max = 40)
    @Column(name = "ramalContato")
    private String ramalContato;
    //@Size(max = 40)
    @Column(name = "deptoContato")
    private String deptoContato;
    @JoinColumn(name = "idCliFor", referencedColumnName = "idCliFor")
    @ManyToOne
    private Clifor clifor;

    public Cliforcontato() {
    }

    public Cliforcontato(Long idcontato) {
        this.idcontato = idcontato;
    }

    public Long getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(Long idcontato) {
        this.idcontato = idcontato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getCargoContato() {
        return cargoContato;
    }

    public void setCargoContato(String cargoContato) {
        this.cargoContato = cargoContato;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getCelularContato() {
        return celularContato;
    }

    public void setCelularContato(String celularContato) {
        this.celularContato = celularContato;
    }

    public String getRadioContato() {
        return radioContato;
    }

    public void setRadioContato(String radioContato) {
        this.radioContato = radioContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getRamalContato() {
        return ramalContato;
    }

    public void setRamalContato(String ramalContato) {
        this.ramalContato = ramalContato;
    }

    public String getDeptoContato() {
        return deptoContato;
    }

    public void setDeptoContato(String deptoContato) {
        this.deptoContato = deptoContato;
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
        hash += (idcontato != null ? idcontato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliforcontato)) {
            return false;
        }
        Cliforcontato other = (Cliforcontato) object;
        if ((this.idcontato == null && other.idcontato != null) || (this.idcontato != null && !this.idcontato.equals(other.idcontato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.entidade.Cliforcontato[ idcontato=" + idcontato + " ]";
    }
    
}
