package com.eCommerce.lojaOnline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommerce.lojaOnline.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long>{
	public List<Loja> findAllByNomeLojaContainingIgnoreCase(String nomeLoja); 
}
