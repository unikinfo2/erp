package net.unikinfo.neoserp.aplicacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.unikinfo.neoserp.aplicacao.model.Transacao;
import net.unikinfo.neoserp.aplicacao.model.Transacaogarantia;

public interface TransacaogarantiaRepository extends JpaRepository<Transacaogarantia, String> {

	@Query("SELECT t FROM Transacaogarantia t WHERE t.transacao = :transacao")
	public List<Transacaogarantia> findByTransacao(@Param("transacao") Transacao transacao);

}
