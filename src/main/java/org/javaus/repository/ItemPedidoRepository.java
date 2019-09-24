package org.javaus.repository;

import java.util.Optional;

import org.javaus.domain.ItemPedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends MongoRepository<ItemPedido, String>{
	
	//@Query("{'_id': ?0 }")
    Optional<ItemPedido> findById(String id); 
}
