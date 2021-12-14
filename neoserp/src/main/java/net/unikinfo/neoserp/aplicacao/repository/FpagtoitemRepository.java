package net.unikinfo.neoserp.aplicacao.repository;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Fpagto;
import net.unikinfo.neoserp.aplicacao.model.Fpagtoitem;

public interface FpagtoitemRepository extends JpaRepository<Fpagtoitem, String> {

	@Query("SELECT f FROM Fpagtoitem f WHERE f.fpagto = :fpagto")
    public List<Fpagtoitem> findByFPagto(@Param("fpagto") Fpagto fpagto);

}
