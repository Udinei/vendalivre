package org.javaus.services;

import java.util.Optional;

import org.javaus.domain.Pedido;
import org.javaus.repository.PedidoRepository;
import org.javaus.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
		
	public Pedido find(String id){
		Optional<Pedido> obj = pedidoRepository.findById(id);
		
		// caso o objeto nao exista sera lancado uma exceção informando o id e o nome da classe do objeto
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id 
				+ ", tipo: " + Pedido.class.getName())); 
			
	}
	

}
