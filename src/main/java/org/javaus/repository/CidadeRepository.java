package org.javaus.repository;

import java.util.List;

import org.javaus.domain.Cidade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends MongoRepository<Cidade, String>{
	
    
}
