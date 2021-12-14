package net.unikinfo.neoserp.aplicacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.unikinfo.neoserp.aplicacao.model.Aliquotasporestado;

public interface AliquotasporestadoRepository extends JpaRepository<Aliquotasporestado, String> {
	
	@Query("SELECT a FROM Aliquotasporestado a WHERE a.uf = :uf and a.ncm = :ncm")
	public List<Aliquotasporestado> findByUfNcm(@Param("uf") String uf, @Param("ncm") String ncm);
	
}
