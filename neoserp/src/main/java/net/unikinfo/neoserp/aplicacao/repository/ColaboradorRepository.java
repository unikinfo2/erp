package net.unikinfo.neoserp.aplicacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.unikinfo.neoserp.aplicacao.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
	Colaborador findById(long id);
	Colaborador findByNomeUsuario(String nomeUsuario);
	
	//@Query("SELECT m FROM Menucolaborador m WHERE m.idColaborador = ?1")
	//List<Menucolaborador> findMenucolaboradorByIdColaborador(Long idColaborador);
}


