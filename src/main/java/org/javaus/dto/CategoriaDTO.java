package org.javaus.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.javaus.domain.Categoria;
import org.javaus.domain.Produto;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	private List<Produto> produtos = new ArrayList<>(); 
	
	public CategoriaDTO() {
	
	}
	
	public CategoriaDTO(Categoria obj){
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.produtos = obj.getProdutos();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
