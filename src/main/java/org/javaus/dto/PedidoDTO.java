package org.javaus.dto;

import java.io.Serializable;
import java.util.Date;

import org.javaus.domain.Cliente;
import org.javaus.domain.Endereco;
import org.javaus.domain.Pagamento;
import org.javaus.domain.Pedido;

import com.fasterxml.jackson.annotation.JsonFormat;


public class PedidoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	@JsonFormat(pattern="dd/MM/yyyy H:mm")
	private Date instante;
	
	private Pagamento pagamento;
	
	private Endereco enderecoDeEntrega;
	
	private Cliente cliente;
	
		
	public PedidoDTO() {
	
	}
	
	
	public PedidoDTO(Pedido pedido){
		super();
		this.id = pedido.getId();
		this.instante = pedido.getInstante();
		this.cliente = pedido.getCliente();
		this.pagamento = pedido.getPagamento();
		System.out.println("Pagamento.... " + pedido.getPagamento());
  		this.enderecoDeEntrega = pedido.getEnderecoDeEntrega();
	}

  
    
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
	
	
}
