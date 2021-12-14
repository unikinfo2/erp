package net.unikinfo.neoserp.aplicacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.unikinfo.neoserp.aplicacao.model.Estado;

public class DespachoitemRepository {

}

public interface DespachoitemRepository extends JpaRepository<Despachoitem, String> {
	
	@Query("SELECT d FROM Despachoitem d WHERE d.uf = :uf")
	public Estado findByUf(@Param("uf") String uf); 

}
