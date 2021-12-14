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
@Table(name = "planocontas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planocontas.findAll", query = "SELECT p FROM Planocontas p"),
    @NamedQuery(name = "Planocontas.findByIdConta", query = "SELECT p FROM Planocontas p WHERE p.idConta = :idConta"),
    @NamedQuery(name = "Planocontas.findByEmpresa", query = "SELECT p FROM Planocontas p WHERE p.empresa = :empresa order by p.tipoConta,p.codConta"),
    @NamedQuery(name = "Planocontas.findByCodConta", query = "SELECT p FROM Planocontas p WHERE p.codConta = :codConta"),
    @NamedQuery(name = "Planocontas.findByDescConta", query = "SELECT p FROM Planocontas p WHERE p.descConta = :descConta"),
    @NamedQuery(name = "Planocontas.findByTipoConta", query = "SELECT p FROM Planocontas p WHERE p.tipoConta = :tipoConta"),
    @NamedQuery(name = "Planocontas.findByTipoEmpresa", query = "SELECT p FROM Planocontas p WHERE p.tipoConta = :tipoConta AND p.empresa = :empresa"),
    @NamedQuery(name = "Planocontas.findInTipoConta", query = "SELECT p FROM Planocontas p WHERE p.tipoConta in (:tipoConta1, :tipoConta2)"),
    @NamedQuery(name = "Planocontas.findByAtivaConta", query = "SELECT p FROM Planocontas p WHERE p.ativaConta = :ativaConta")})
public class Planocontas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConta")
    private Long idConta;
    //@Size(max = 20)
    @Column(name = "codConta")
    private String codConta;
    //@Size(max = 150)
    @Column(name = "descConta")
    private String descConta;
    //@Size(max = 50)
    @Column(name = "tipoConta")
    private String tipoConta;
    //@Size(max = 1)
    @Column(name = "ativaConta")
    private String ativaConta;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "idContaPrincipal", referencedColumnName = "idConta")
    @ManyToOne
    private Planocontas planocontas;
    //@Size(max = 20)
    @Column(name = "contaClassificacao")
    private String contaClassificacao;
    //@Size(max = 20)
    @Column(name = "contaPara")
    private String contaPara;

    public Planocontas() {
    }

    public Planocontas(Long idConta) {
        this.idConta = idConta;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getCodConta() {
        return codConta;
    }

    public String getContaClassificacao() {
        return contaClassificacao;
    }

    public void setContaClassificacao(String contaClassificacao) {
        this.contaClassificacao = contaClassificacao;
    }

    public String getContaPara() {
        return contaPara;
    }

    public void setContaPara(String contaPara) {
        this.contaPara = contaPara;
    }

    public void setCodConta(String codConta) {
        this.codConta = codConta;
    }

    public String getDescConta() {
        return descConta;
    }

    public void setDescConta(String descConta) {
        this.descConta = descConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getAtivaConta() {
        return ativaConta;
    }

    public void setAtivaConta(String ativaConta) {
        this.ativaConta = ativaConta;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Planocontas getPlanocontas() {
        return planocontas;
    }

    public void setPlanocontas(Planocontas planocontas) {
        this.planocontas = planocontas;
    }

    
    public String getNomeConta() {
        String ret = "";
        if (codConta != null) {
            ret += codConta.trim();
        }
        if (descConta != null) {
            if (ret.length() > 0) {
                ret += " � "; // alt 250
            }
            ret += descConta;
        }
        ret += " � " + tipoConta; //alt 250
        return ret;
    }

    public String getFullName() {
        String retorno = "";
        String codigoConta = "";
        try {
            if (this.planocontas.getCodConta() != null) {
                codigoConta = this.planocontas.getCodConta() + " � ";
            }
        } catch (Exception e) {
        }
        try {
            if (this.planocontas != null) {
                retorno = codigoConta + this.planocontas.getDescConta();
                if (this.planocontas.getPlanocontas() != null) {
                    if (this.planocontas.getPlanocontas().getCodConta() != null) {
                        codigoConta = this.planocontas.getPlanocontas().getCodConta() + " � ";
                    }
                    retorno = codigoConta + this.planocontas.getPlanocontas().getDescConta() + ":" + retorno;
                    if (this.planocontas.getPlanocontas().getPlanocontas() != null) {
                        if (this.planocontas.getPlanocontas().getPlanocontas().getCodConta() != null) {
                            codigoConta = this.planocontas.getPlanocontas().getPlanocontas().getCodConta() + " � ";
                        }
                        retorno = codigoConta + this.planocontas.getPlanocontas().getPlanocontas().getDescConta() + ":" + retorno;
                    }
                }
            }
        } catch (Exception e) {
        }
        if (!retorno.isEmpty()) {
            retorno = retorno + ":";
        }
        retorno = retorno + codigoConta + this.getDescConta();
        return retorno;
    }

    public String getFullName2() {
        String retorno = "";
        if (this.planocontas != null) {
            retorno = this.planocontas.getCodConta() + " � " + this.planocontas.getDescConta();
            if (this.planocontas.getPlanocontas() != null) {
                retorno = this.planocontas.getPlanocontas().getCodConta() + ":" + retorno;
                if (this.planocontas.getPlanocontas().getPlanocontas() != null) {
                    retorno = this.planocontas.getPlanocontas().getPlanocontas().getCodConta() + ":" + retorno;
                }
            }
        }
        if (!retorno.isEmpty()) {
            retorno = retorno + ":";
        }
        retorno = retorno + this.getCodConta() + " � " + this.getDescConta();
        return retorno;
    }

    public Integer getNivelConta() {
        Integer retorno = 1;
        if (this.planocontas != null) {
            retorno = 2;
            if (this.planocontas.getPlanocontas() != null) {
                retorno = 3;
                if (this.planocontas.getPlanocontas().getPlanocontas() != null) {
                    retorno = 4;
                }
            }
        }
        return retorno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConta != null ? idConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planocontas)) {
            return false;
        }
        Planocontas other = (Planocontas) object;
        if ((this.idConta == null && other.idConta != null) || (this.idConta != null && !this.idConta.equals(other.idConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String ret = "";
        if (codConta != null) {
            ret += codConta.trim();
        }
        if (descConta != null) {
            if (ret.length() > 0) {
                ret += " � ";
            }
            ret += descConta;
        }
        return ret;
    }

}
