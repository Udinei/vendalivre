package org.javaus.services;

import java.util.Optional;

import org.javaus.domain.Pagamento;
import org.javaus.repository.PagamentoRepository;
import org.javaus.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
		
	public Pagamento findByPedidoId(String id){
		Optional<Pagamento> obj = pagamentoRepository.findByPedidoId(id);
		
		// caso o objeto nao exista sera lancado uma exceção informando o id e o nome da classe do objeto
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id 
				+ ", tipo: " + Pagamento.class.getName())); 
			
	}
	

}
