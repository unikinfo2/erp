package net.unikinfo.neoserp.aplicacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.unikinfo.neoserp.aplicacao.model.Configdre;
import net.unikinfo.neoserp.aplicacao.model.Empresa;

public interface ConfigdreRepository extends JpaRepository<Configdre, String> {
	
	@Query("SELECT c FROM Configdre c WHERE c.empresa = :empresa")
	public List<Configdre> findByEmpresa(@Param("empresa") Empresa empresa);

}
