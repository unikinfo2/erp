package net.unikinfo.neoserp.aplicacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.unikinfo.neoserp.aplicacao.model.Produtoadicional;

public interface ProdutoadicionalRepository extends JpaRepository<Produtoadicional, String> {
	

}
