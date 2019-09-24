package org.javaus.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.javaus.domain.Cliente;
import org.javaus.domain.Endereco;
import org.javaus.domain.ItemPedido;
import org.javaus.domain.Pagamento;
import org.javaus.domain.Pedido;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class PedidoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	@JsonFormat(pattern="dd/MM/yyyy H:mm")
	private Date instante;
	
	private Pagamento pagamento;
	
	private Endereco enderecoDeEntrega;
	
	private Cliente cliente;
		
	private Set<ItemPedido> itens = new HashSet<>();
	
	//private List<ItemPedido> itensPedido = new ArrayList<>();
	
	public PedidoDTO() {
	
	}
	
	
	public PedidoDTO(Pedido pedido){
		super();
		this.id = pedido.getId();
		this.instante = pedido.getInstante();
		this.cliente = pedido.getCliente();
	    	cliente.setEnderecos(null);
		this.pagamento = pedido.getPagamento();
		this.enderecoDeEntrega = pedido.getEnderecoDeEntrega();
		this.itens = pedido.getItens();
		//this.itensPedido = pedido.getItensPedido();
  		
	}

//	// criado uma lista de itens do pedido
//	@JsonIgnore
//	public List<Pedido> getPedidos(){
//		List<Pedido> lista = new ArrayList<>();
//		for(ItemPedido x : itens){
//			lista.add(x.getPedido());
//		}
//		return lista;
//	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getInstante() {
		return instante;
	}
	
	public void setInstante(Date instante) {
		this.instante = instante;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}
	
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}
	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
//
//
//	public List<ItemPedido> getItensPedido() {
//		return itensPedido;
//	}
//
//
//	public void setItensPedido(List<ItemPedido> itensPedido) {
//		this.itensPedido = itensPedido;
//	}
	
}
