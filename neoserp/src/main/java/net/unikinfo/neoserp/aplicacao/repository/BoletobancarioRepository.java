package net.unikinfo.neoserp.aplicacao.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.unikinfo.neoserp.aplicacao.model.Boletobancario;
import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Transacaodup;

public interface BoletobancarioRepository extends JpaRepository<Boletobancario, String> {
	
	@Query("SELECT b FROM Boletobancario b WHERE b.empresa = :empresa order by b.dtDocumento desc")
	public List<Boletobancario> findByEmpresa(@Param("empresa") Empresa empresa);
	
	@Query("SELECT b FROM Boletobancario b WHERE b.empresa = :empresa and b.dtVencimento between :dtInicio and :dtFim ORDER BY b.dtVencimento DESC")	
	public List<Boletobancario> findByEmpresaPeriodoVencimentoBoletobancarioVencto(@Param("empresa") Empresa empresa,
			@Param("dtInicio") Date dtInicio, @Param("dtFim") Date dtFim);
	
	@Query("SELECT b FROM Boletobancario b WHERE b.empresa = :empresa and b.dtDocumento between :dtInicio and :dtFim ORDER BY b.dtVencimento DESC")
	public List<Boletobancario> findByEmpresaPeriodoVencimentoBoletobancarioEmissao(@Param("empresa") Empresa empresa,
			@Param("dtInicio") Date dtInicio, @Param("dtFim") Date dtFim);

	@Query("SELECT b FROM Boletobancario b WHERE (b.clifor.razaoSocial like :clifor or b.clifor.cpfCnpj like :clifor) and b.empresa = :empresa and b.dtVencimento between :dtInicio and :dtFim ORDER BY b.dtVencimento DESC")
	public List<Boletobancario> findByCliforEmpresaPeriodoVencimentoBoletobancario(
										@Param("clifor") String clifor,
										@Param("empresa") Empresa empresa,
										@Param("dtInicio") Date dtInicio, 
										@Param("dtFim") Date dtFim);

	@Query("SELECT b FROM Boletobancario b WHERE b.transacaodup=:transacaodup")
	public List<Boletobancario> findByTransacaodupSemDtPagto(@Param("transacaodup") Transacaodup transacaodup);
	
	@Query("SELECT b FROM Boletobancario b WHERE b.transacaodup=:transacaodup and b.dtPagamento is not null ORDER BY b.dtVencimento DESC")
	public List<Boletobancario> findByTransacaodup(@Param("transacaodup") Transacaodup transacaodup);
			
			
}
