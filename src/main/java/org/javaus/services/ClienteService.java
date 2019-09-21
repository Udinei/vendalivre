package org.javaus.services;

import java.util.List;
import java.util.Optional;

import org.javaus.domain.Cliente;
import org.javaus.repository.ClienteRepository;
import org.javaus.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.LazyLoadingProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	@Transactional
	public Cliente find(String id){
		Optional<Cliente> obj = clienteRepository.findById(id);
	    	//obj.get().getEnderecos().size();
		// caso o objeto nao exista sera lancado uma exceção informando o id e o nome da classe do objeto
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id 
				+ ", tipo: " + Cliente.class.getName())); 
			
	}
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	@Transactional
	public Cliente findById(String id){
		Optional<Cliente> cliente = clienteRepository.findById(id);
		//Optional<Cliente> cliente = clienteRepository.carregaObjetoPorId(id);
		//System.out.println("lista de enderecos ....: " + cliente.get().getEnderecos());
		//return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id 
				+ ", tipo: " + Cliente.class.getName()));
		
	}
	

}
