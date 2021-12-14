package net.unikinfo.neoserp.aplicacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.unikinfo.neoserp.aplicacao.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//Passar jql para a classe
	@Query("SELECT u from User u where u.username = :username")
	public List<User> findUserTeste(@Param("username") String username);
	
	public List<User> findByIdGreaterThan(Long id);

}
