package org.javaus.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.javaus.domain.Cidade;
import org.javaus.domain.Cliente;
import org.javaus.domain.Endereco;
import org.javaus.domain.Telefone;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;
		
	private List<Endereco> enderecos = new ArrayList<>();
	
	private List<Telefone> telefones = new ArrayList<>();
		
//	public ClienteDTO() {
//	
//	}
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome= cliente.getNome();
		this.email= cliente.getEmail();
		this.cpfOuCnpj= cliente.getCpfOuCnpj();
		this.tipo= cliente.getTipo().getCod();
		this.telefones = cliente.getTelefones();
		this.enderecos = cliente.getEnderecos();
	
		}
	
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
}
