package com.eCommerce.lojaOnline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eCommerce.lojaOnline.model.Loja;
import com.eCommerce.lojaOnline.model.Produto;
import com.eCommerce.lojaOnline.repository.LojaRepository;
import com.eCommerce.lojaOnline.repository.ProdutoRepository;

@Service
public class LojaService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private LojaRepository lojaRepository;
	
	public Loja cadastroProdutoLoja(long idLoja, long idProduto) {
		
		Optional<Produto> produtoExistente = produtoRepository.findById(idProduto);
		Optional<Loja> lojaExistente = lojaRepository.findById(idLoja);

		if(produtoExistente.isPresent()&&lojaExistente.isPresent()) {
			
			lojaExistente.get().getProduto().add(produtoExistente.get());
			
			lojaRepository.save(lojaExistente.get());
			
			return lojaRepository.save(lojaExistente.get());
		}
		return null;
	}
}
