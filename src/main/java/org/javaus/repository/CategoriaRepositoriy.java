package org.javaus.repository;

import org.javaus.domain.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositoriy extends MongoRepository<Categoria, String >  {

}
