package org.javaus.repository;

import java.util.List;
import java.util.Optional;

import org.javaus.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{
	
	//@Query("{'_id': ?0 }, {'cliente.enderecos'}")
	//Optional<Cliente> carregaObjetoPorId(String id);
	

	
}
