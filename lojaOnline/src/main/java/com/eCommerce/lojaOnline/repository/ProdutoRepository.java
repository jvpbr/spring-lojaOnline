package com.eCommerce.lojaOnline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eCommerce.lojaOnline.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Produto> findAllByTituloProdutoContainingIgnoreCase(String tituloProduto);
	
	public List<Produto> findAllByValorLessThanEqual (float valor);
	
	public List<Produto> findAllByValorGreaterThanEqual (float valor);

	@Query(value = "select * from tb_produto inner join tb_loja on tb_loja.idLoja = tb_produto.loja_idLoja where tb_loja.descricao = :descricao", nativeQuery = true)
	public List<Produto> findAllProdutoByLojaDescricao(@Param("descricao") String descricao);
	
}
