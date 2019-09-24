package org.javaus.services;

import java.util.Optional;

import org.javaus.domain.ItemPedido;
import org.javaus.repository.ItemPedidoRepository;
import org.javaus.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRespository;
	
	public ItemPedido findById(String id){
		Optional<ItemPedido> itemPedido = itemPedidoRespository.findById(id);
		return itemPedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
	

}
