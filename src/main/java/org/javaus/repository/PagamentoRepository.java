package org.javaus.repository;

import java.util.Optional;

import org.javaus.domain.Pagamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends MongoRepository<Pagamento, String>{
	
	//@Query("{'_id': ?0 }")
	Optional<Pagamento> findByPedidoId(String id);
	
}
