package org.javaus.dto;

import java.io.Serializable;

import org.javaus.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public CategoriaDTO() {
	
	}
	
	public CategoriaDTO(Categoria obj){
		this.id = obj.getId();
		this.nome = obj.getNome();
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
	
	
}