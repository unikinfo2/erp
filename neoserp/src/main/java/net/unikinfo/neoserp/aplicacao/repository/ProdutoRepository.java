package net.unikinfo.neoserp.aplicacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.unikinfo.neoserp.aplicacao.model.Empresa;
import net.unikinfo.neoserp.aplicacao.model.Produto;
import net.unikinfo.neoserp.aplicacao.model.User;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

	@Query("SELECT p from Produto p where p.empresa = :empresa")
	public List<Produto> findAllByEmpresa(@Param("empresa") Empresa empresa);
	@Query("SELECT p FROM Produto p WHERE p.descricao = :descricao and p.empresa = :empresa")
	public List<Produto> findByDescricao(@Param("empresa") Empresa empresa, @Param("descricao") String descricao);
	@Query("SELECT p FROM Produto p WHERE p.empresa = :matriz")
	public List<Produto> findByEmpresaMatriz(@Param("matriz") Empresa empresa);
	@Query("SELECT p FROM Produto p WHERE p.empresa = :empresa and p.codigoBarras = :codigoBarras")
	public List<Produto> findByCodigoBarras(@Param("empresa") Empresa empresa, @Param("codigoBarras") String codigoBarras);
	@Query("SELECT p FROM Produto p WHERE p.codigoAux = :codigoAux")
	public List<Produto> findByCodigoAux(@Param("codigoAux") String codigoAux);

}
