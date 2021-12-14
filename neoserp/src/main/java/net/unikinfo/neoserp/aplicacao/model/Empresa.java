/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findMax", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = (SELECT MAX(x.idEmpresa) FROM Empresa x)"),
    @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresa.findByRazaoEmp", query = "SELECT e FROM Empresa e WHERE e.razaoEmp = :razaoEmp"),
    @NamedQuery(name = "Empresa.findByNomeFantasiaEmp", query = "SELECT e FROM Empresa e WHERE e.nomeFantasiaEmp = :nomeFantasiaEmp"),
    @NamedQuery(name = "Empresa.findByEnderecoEmp", query = "SELECT e FROM Empresa e WHERE e.enderecoEmp = :enderecoEmp"),
    @NamedQuery(name = "Empresa.findByComplEnd", query = "SELECT e FROM Empresa e WHERE e.complEnd = :complEnd"),
    @NamedQuery(name = "Empresa.findByNumeroEnd", query = "SELECT e FROM Empresa e WHERE e.numeroEnd = :numeroEnd"),
    @NamedQuery(name = "Empresa.findByCepEmp", query = "SELECT e FROM Empresa e WHERE e.cepEmp = :cepEmp"),
    @NamedQuery(name = "Empresa.findByCidadeEmp", query = "SELECT e FROM Empresa e WHERE e.cidadeEmp = :cidadeEmp"),
    @NamedQuery(name = "Empresa.findByCodigoMunicipioEmp", query = "SELECT e FROM Empresa e WHERE e.codigoMunicipioEmp = :codigoMunicipioEmp"),
    @NamedQuery(name = "Empresa.findByEmailEmp", query = "SELECT e FROM Empresa e WHERE e.emailEmp = :emailEmp"),
    @NamedQuery(name = "Empresa.findBySiteEmp", query = "SELECT e FROM Empresa e WHERE e.siteEmp = :siteEmp"),
    @NamedQuery(name = "Empresa.findByTpPessoa", query = "SELECT e FROM Empresa e WHERE e.tpPessoa = :tpPessoa"),
    @NamedQuery(name = "Empresa.findByCnpjEmp", query = "SELECT e FROM Empresa e WHERE e.cnpjEmp = :cnpjEmp"),
    @NamedQuery(name = "Empresa.findByIEstEmp", query = "SELECT e FROM Empresa e WHERE e.iEstEmp = :iEstEmp"),
    @NamedQuery(name = "Empresa.findByCcmEmp", query = "SELECT e FROM Empresa e WHERE e.ccmEmp = :ccmEmp"),
    @NamedQuery(name = "Empresa.findByFone1Emp", query = "SELECT e FROM Empresa e WHERE e.fone1Emp = :fone1Emp"),
    @NamedQuery(name = "Empresa.findByFone2Emp", query = "SELECT e FROM Empresa e WHERE e.fone2Emp = :fone2Emp"),
    @NamedQuery(name = "Empresa.findByFone3Emp", query = "SELECT e FROM Empresa e WHERE e.fone3Emp = :fone3Emp"),
    @NamedQuery(name = "Empresa.findByFone4Emp", query = "SELECT e FROM Empresa e WHERE e.fone4Emp = :fone4Emp"),
    @NamedQuery(name = "Empresa.findByFaxEmp", query = "SELECT e FROM Empresa e WHERE e.faxEmp = :faxEmp"),
    @NamedQuery(name = "Empresa.findByTpRelPv", query = "SELECT e FROM Empresa e WHERE e.tpRelPv = :tpRelPv")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmpresa")
    private Long idEmpresa;
    @Column(name = "razaoEmp")
    private String razaoEmp;
    @Column(name = "nomeFantasiaEmp")
    private String nomeFantasiaEmp;
    @Column(name = "enderecoEmp")
    private String enderecoEmp;
    @Column(name = "complEnd")
    private String complEnd;
    @Column(name = "numeroEnd")
    private String numeroEnd;
    @Column(name = "cepEmp")
    private String cepEmp;
    @Column(name = "cidadeEmp")
    private String cidadeEmp;
    @Column(name = "codigoMunicipioEmp")
    private String codigoMunicipioEmp;
    @Column(name = "emailEmp")
    private String emailEmp;
    @Column(name = "siteEmp")
    private String siteEmp;
    @Column(name = "tpPessoa")
    private String tpPessoa;
    @Column(name = "cnpjEmp")
    private String cnpjEmp;
    @Column(name = "iEstEmp")
    private String iEstEmp;
    @Column(name = "ccmEmp")
    private String ccmEmp;
    @Column(name = "fone1Emp")
    private String fone1Emp;
    @Column(name = "fone2Emp")
    private String fone2Emp;
    @Column(name = "fone3Emp")
    private String fone3Emp;
    @Column(name = "fone4Emp")
    private String fone4Emp;
    @Column(name = "faxEmp")
    private String faxEmp;
    @Column(name = "tpRelPv")
    private String tpRelPv;
    @Column(name = "caminhoLogo")
    private String caminhoLogo;
    @Column(name = "caminhoLogoSecundario")
    private String caminhoLogoSecundario;
    @Column(name = "codigoAux")
    private String codigoAux;
    @Column(name = "cnaeEmp")
    private String cnaeEmp;

    @JoinColumn(name = "UFEmp", referencedColumnName = "uf")
    @ManyToOne
    private Estado estado;
    @Column(name = "verCliForMatriz")
    private String verCliForMatriz;
    @Column(name = "verEstoqueMatriz")
    private String verEstoqueMatriz;
    
    @JoinColumn(name = "idEmpresaMatriz", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa idEmpresaMatriz;
    
    @Column(name = "regimeEmpresa")
    private String regimeEmpresa;
    @Column(name = "bairroEmp")
    private String bairroEmp;
    @Column(name = "editaAutorizada")
    private String editaAutorizada;
    @Column(name = "taxaEntrega")
    private BigDecimal taxaEntrega;
    @Column(name = "percDifalDestino")
    private BigDecimal percDifalDestino;
    @Column(name = "percDifalOrigem")
    private BigDecimal percDifalOrigem;

    public Empresa() {
    }

    public Empresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazaoEmp() {
        return razaoEmp;
    }

    public void setRazaoEmp(String razaoEmp) {
        this.razaoEmp = razaoEmp;
    }

    public String getNomeFantasiaEmp() {
        return nomeFantasiaEmp;
    }

    public void setNomeFantasiaEmp(String nomeFantasiaEmp) {
        this.nomeFantasiaEmp = nomeFantasiaEmp;
    }

    public String getEnderecoEmp() {
        return enderecoEmp;
    }

    public String getCodigoAux() {
        return codigoAux;
    }

    public void setCodigoAux(String codigoAux) {
        this.codigoAux = codigoAux;
    }

    public void setEnderecoEmp(String enderecoEmp) {
        this.enderecoEmp = enderecoEmp;
    }

    public String getComplEnd() {
        return complEnd;
    }

    public void setComplEnd(String complEnd) {
        this.complEnd = complEnd;
    }

    public String getNumeroEnd() {
        return numeroEnd;
    }

    public void setNumeroEnd(String numeroEnd) {
        this.numeroEnd = numeroEnd;
    }

    public String getCepEmp() {
        return cepEmp;
    }

    public void setCepEmp(String cepEmp) {
        this.cepEmp = cepEmp;
    }

    public String getCidadeEmp() {
        return cidadeEmp;
    }

    public void setCidadeEmp(String cidadeEmp) {
        this.cidadeEmp = cidadeEmp;
    }

    public String getCodigoMunicipioEmp() {
        return codigoMunicipioEmp;
    }

    public void setCodigoMunicipioEmp(String codigoMunicipioEmp) {
        this.codigoMunicipioEmp = codigoMunicipioEmp;
    }

    public String getEmailEmp() {
        return emailEmp;
    }

    public void setEmailEmp(String emailEmp) {
        this.emailEmp = emailEmp;
    }

    public String getSiteEmp() {
        return siteEmp;
    }

    public void setSiteEmp(String siteEmp) {
        this.siteEmp = siteEmp;
    }

    public String getTpPessoa() {
        return tpPessoa;
    }

    public void setTpPessoa(String tpPessoa) {
        this.tpPessoa = tpPessoa;
    }

    public String getCnpjEmp() {
        return cnpjEmp;
    }

    public void setCnpjEmp(String cnpjEmp) {
        this.cnpjEmp = cnpjEmp;
    }

    public String getIEstEmp() {
        return iEstEmp;
    }

    public void setIEstEmp(String iEstEmp) {
        this.iEstEmp = iEstEmp;
    }

    public String getCcmEmp() {
        return ccmEmp;
    }

    public void setCcmEmp(String ccmEmp) {
        this.ccmEmp = ccmEmp;
    }

    public String getFone1Emp() {
        return fone1Emp;
    }

    public void setFone1Emp(String fone1Emp) {
        this.fone1Emp = fone1Emp;
    }

    public String getFone2Emp() {
        return fone2Emp;
    }

    public void setFone2Emp(String fone2Emp) {
        this.fone2Emp = fone2Emp;
    }

    public String getFone3Emp() {
        return fone3Emp;
    }

    public void setFone3Emp(String fone3Emp) {
        this.fone3Emp = fone3Emp;
    }

    public String getFone4Emp() {
        return fone4Emp;
    }

    public void setFone4Emp(String fone4Emp) {
        this.fone4Emp = fone4Emp;
    }

    public String getFaxEmp() {
        return faxEmp;
    }

    public void setFaxEmp(String faxEmp) {
        this.faxEmp = faxEmp;
    }

    public String getiEstEmp() {
        return iEstEmp;
    }

    public void setiEstEmp(String iEstEmp) {
        this.iEstEmp = iEstEmp;
    }

    public String getTpRelPv() {
        return tpRelPv;
    }

    public void setTpRelPv(String tpRelPv) {
        this.tpRelPv = tpRelPv;
    }

    public String getCaminhoLogo() {
        return caminhoLogo;
    }

    public String getCaminhoLogoSecundario() {
        return caminhoLogoSecundario;
    }

    public void setCaminhoLogoSecundario(String caminhoLogoSecundario) {
        this.caminhoLogoSecundario = caminhoLogoSecundario;
    }

    public void setCaminhoLogo(String caminhoLogo) {
        this.caminhoLogo = caminhoLogo;
    }

    public Empresa getIdEmpresaMatriz() {
        return idEmpresaMatriz;
    }

    public void setIdEmpresaMatriz(Empresa idEmpresaMatriz) {
        this.idEmpresaMatriz = idEmpresaMatriz;
    }

    public String getVerCliForMatriz() {
        return verCliForMatriz;
    }

    public void setVerCliForMatriz(String verCliForMatriz) {
        this.verCliForMatriz = verCliForMatriz;
    }

    public String getVerEstoqueMatriz() {
        return verEstoqueMatriz;
    }

    public void setVerEstoqueMatriz(String verEstoqueMatriz) {
        this.verEstoqueMatriz = verEstoqueMatriz;
    }


    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCnaeEmp() {
        return cnaeEmp;
    }

    public void setCnaeEmp(String cnaeEmp) {
        this.cnaeEmp = cnaeEmp;
    }

    public String getEditaAutorizada() {
        return editaAutorizada;
    }

    public void setEditaAutorizada(String editaAutorizada) {
        this.editaAutorizada = editaAutorizada;
    }
    
    
    public BigDecimal getTaxaEntrega() {
		return taxaEntrega;
	}

	public void setTaxaEntrega(BigDecimal taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#00");
        return df.format(idEmpresa) + "-" + razaoEmp;
    }

    public String getRegimeEmpresa() {
        return regimeEmpresa;
    }

    public void setRegimeEmpresa(String regimeEmpresa) {
        this.regimeEmpresa = regimeEmpresa;
    }

    public String getBairroEmp() {
        return bairroEmp;
    }

    public void setBairroEmp(String bairroEmp) {
        this.bairroEmp = bairroEmp;
    }

	public BigDecimal getPercDifalDestino() {
		return percDifalDestino;
	}

	public void setPercDifalDestino(BigDecimal percDifalDestino) {
		this.percDifalDestino = percDifalDestino;
	}

	public BigDecimal getPercDifalOrigem() {
		return percDifalOrigem;
	}

	public void setPercDifalOrigem(BigDecimal percDifalOrigem) {
		this.percDifalOrigem = percDifalOrigem;
	}

}
