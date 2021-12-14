package net.unikinfo.neoserp.aplicacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.unikinfo.neoserp.aplicacao.model.Estoqueitens;

public interface EstoqueitensRepository extends JpaRepository<Estoqueitens, String> {
	

}
