package com.eCommerce.lojaOnline.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	
	@NotNull
	@Size(max=45)
	private String nome;
	
	@NotNull
	@Size(max=45)
	private String usuario;
	
	@NotNull
	@Size(max=45)
	private String senha;
	
	@ManyToMany(mappedBy = "usuarios", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"descricao", "usuarios"})
	private List<Loja> inscricao = new ArrayList<>();
	
	@OneToMany(mappedBy =  "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produto;
	
	@OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Loja> loja;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Loja> getInscricao() {
		return inscricao;
	}

	public void setInscricao(List<Loja> inscricao) {
		this.inscricao = inscricao;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public List<Loja> getLoja() {
		return loja;
	}

	public void setLoja(List<Loja> loja) {
		this.loja = loja;
	}
	
	

}
