package net.unikinfo.neoserp.aplicacao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.unikinfo.neoserp.aplicacao.model.Diario;
import net.unikinfo.neoserp.aplicacao.model.Empresa;

public interface DiarioRepository extends JpaRepository<Diario, Long> {

	@Query("SELECT d FROM Diario d WHERE d.empresa = :empresa and d.dtDocumento >= :dtDocumento1 and d.dtDocumento <= :dtDocumento2 order by d.dtLancamento, d.transacao asc")
	public List<Diario> findByPeriodo(
			@Param("empresa") Empresa empresa,
			@Param("dtDocumento1") Date dtInicio, 
			@Param("dtDocumento2") Date dtFim
			); 
}
