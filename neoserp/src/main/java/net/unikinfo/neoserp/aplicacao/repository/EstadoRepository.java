package net.unikinfo.neoserp.aplicacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.unikinfo.neoserp.aplicacao.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, String> {
	
	@Query("SELECT e FROM Estado e WHERE e.uf = :uf")
	public Estado findByUf(@Param("uf") String uf); 

}
