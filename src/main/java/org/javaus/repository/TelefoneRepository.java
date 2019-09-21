package org.javaus.repository;

import org.javaus.domain.Telefone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends MongoRepository<Telefone, String>{
	

}
