package net.unikinfo.neoserp.aplicacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.JoinTable;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c"),
    @NamedQuery(name = "Colaborador.findByIdColaborador", query = "SELECT c FROM Colaborador c WHERE c.idColaborador = :idColaborador"),
    @NamedQuery(name = "Colaborador.findByEmpresa", query = "SELECT c FROM Colaborador c WHERE c.empresa = :empresa"),
    @NamedQuery(name = "Colaborador.findByEmpresaAtivo", query = "SELECT c FROM Colaborador c WHERE c.empresa = :empresa AND c.ativo = :ativo"),
    @NamedQuery(name = "Colaborador.findByAdmissao", query = "SELECT c FROM Colaborador c WHERE c.admissao = :admissao"),
    @NamedQuery(name = "Colaborador.findByDemissao", query = "SELECT c FROM Colaborador c WHERE c.demissao = :demissao"),
    @NamedQuery(name = "Colaborador.findByAtivo", query = "SELECT c FROM Colaborador c WHERE c.ativo = :ativo"),
    @NamedQuery(name = "Colaborador.findByValorHora", query = "SELECT c FROM Colaborador c WHERE c.valorHora = :valorHora"),
    @NamedQuery(name = "Colaborador.findByQuantidadeHorasSemanal", query = "SELECT c FROM Colaborador c WHERE c.quantidadeHorasSemanal = :quantidadeHorasSemanal"),
    @NamedQuery(name = "Colaborador.findByNomeUsuario", query = "SELECT c FROM Colaborador c WHERE c.nomeUsuario = :nomeUsuario"),
    @NamedQuery(name = "Colaborador.findBySenhaAcesso", query = "SELECT c FROM Colaborador c WHERE c.senhaAcesso = :senhaAcesso"),
    @NamedQuery(name = "Colaborador.findByNomeColaborador", query = "SELECT c FROM Colaborador c WHERE c.nomeColaborador = :nomeColaborador"),
    @NamedQuery(name = "Colaborador.findByEmpresaNomeUsuario", query = "SELECT c FROM Colaborador c WHERE c.nomeUsuario = :nomeUsuario and c.empresa = :empresa"),
    @NamedQuery(name = "Colaborador.findByTemaColaborador", query = "SELECT c FROM Colaborador c WHERE c.temaColaborador = :temaColaborador")})
public class Colaborador implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcolaborador")
    private Long idColaborador;
    @Column(name = "admissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date admissao;
    @Column(name = "demissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date demissao;
    @Basic(optional = false)
    @Column(name = "ativo")
    private String ativo;
    @Column(name = "valorhora")
    private BigDecimal valorHora;
    @Column(name = "quantidadehorassemanal")
    private BigDecimal quantidadeHorasSemanal;
    @Column(name = "nomeusuario")
    private String nomeUsuario;
    @Column(name = "senhaacesso")
    private String senhaAcesso;
    @Column(name = "nomecolaborador")
    private String nomeColaborador;
    @Column(name = "temacolaborador")
    private String temaColaborador;
    @OneToMany(mappedBy = "colaborador")
    private List<Log> logList;
    
    @JoinColumn(name = "idDepartamento", referencedColumnName = "idDepartamento")
    @ManyToOne
    private Departamento departamento;
    
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne
    private Empresa empresa;

    @Column(name = "registroEmpresa")
    private String registroEmpresa;
    @JoinColumn(name = "idCentroCusto", referencedColumnName = "idCentroCusto")
    @ManyToOne
    private Centrocusto centrocusto;
    
	@ManyToMany
	@JoinTable( 
	        name = "usuarios_roles", 
	        joinColumns = @JoinColumn(
	          name = "usuario_id", referencedColumnName = "idColaborador"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "role_id", referencedColumnName = "nomeRole")) 
    private List<Role> roles;
    
    public Colaborador() {
    }

    public Colaborador(Long idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Colaborador(Long idColaborador, Date admissao, Date demissao) {
        this.idColaborador = idColaborador;
        this.admissao = admissao;
        this.demissao = demissao;
    }

    public Long getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Long idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Date getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    public Date getDemissao() {
        return demissao;
    }

    public void setDemissao(Date demissao) {
        this.demissao = demissao;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public BigDecimal getQuantidadeHorasSemanal() {
        return quantidadeHorasSemanal;
    }

    public void setQuantidadeHorasSemanal(BigDecimal quantidadeHorasSemanal) {
        this.quantidadeHorasSemanal = quantidadeHorasSemanal;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaAcesso() {
        return senhaAcesso;
    }

    public void setSenhaAcesso(String senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getTemaColaborador() {
        return temaColaborador;
    }

    public void setTemaColaborador(String temaColaborador) {
        this.temaColaborador = temaColaborador;
    }

    @XmlTransient
    public List<Log> getLogList() {
        return logList;
    }

    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getRegistroEmpresa() {
        return registroEmpresa;
    }

    public void setRegistroEmpresa(String registroEmpresa) {
        this.registroEmpresa = registroEmpresa;
    }

    public Centrocusto getCentrocusto() {
        return centrocusto;
    }

    public void setCentrocusto(Centrocusto centrocusto) {
        this.centrocusto = centrocusto;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColaborador != null ? idColaborador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.idColaborador == null && other.idColaborador != null) || (this.idColaborador != null && !this.idColaborador.equals(other.idColaborador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idColaborador + "-" + nomeColaborador;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection<? extends GrantedAuthority>) this.roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senhaAcesso;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.nomeUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
    
}
