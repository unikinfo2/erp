package net.unikinfo.neoserp.aplicacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.unikinfo.neoserp.aplicacao.model.Unidademedida;

public interface UnidademedidaRepository extends JpaRepository<Unidademedida, String> {
	Unidademedida findByCodUniMed(String codUniMed);

}
