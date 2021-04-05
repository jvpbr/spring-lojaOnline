package com.eCommerce.lojaOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.lojaOnline.model.Loja;
import com.eCommerce.lojaOnline.repository.LojaRepository;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/loja")
public class LojaController {
	
	@Autowired
	public LojaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Loja>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Loja> GetById(@PathVariable long idLoja){
		return repository.findById(idLoja)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Loja>> GetByNomeLoja(@PathVariable String nomeLoja){
		return ResponseEntity.ok(repository.findAllByNomeLojaContainingIgnoreCase(nomeLoja));
	}
	
	@PostMapping
	public ResponseEntity<Loja> post (@RequestBody Loja loja){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(loja));
	}
	
	@PutMapping
	public ResponseEntity<Loja> put (@RequestBody Loja loja){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(loja));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long idLoja){
		repository.deleteById(idLoja);
	}
	
}
