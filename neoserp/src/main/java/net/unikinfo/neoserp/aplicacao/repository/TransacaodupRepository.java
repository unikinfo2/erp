package net.unikinfo.neoserp.aplicacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.unikinfo.neoserp.aplicacao.model.Transacaodup;

public interface TransacaodupRepository extends JpaRepository<Transacaodup, String> {
	

}
