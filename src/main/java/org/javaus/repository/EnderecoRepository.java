package org.javaus.repository;

import org.javaus.domain.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String>{
	
	//List<Endereco> findByCliente(String id);

}
