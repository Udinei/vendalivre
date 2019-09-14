package org.javaus.services;

import java.util.List;
import java.util.Optional;

import org.javaus.domain.Categoria;
import org.javaus.dto.CategoriaDTO;
import org.javaus.repository.CategoriaRepositoriy;
import org.javaus.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepositoriy categoriaRepositoriy; 
	
	public List<Categoria> findAll(){
		return categoriaRepositoriy.findAll();
	}
	
	
	public Categoria findByid(String id){
		Optional<Categoria> categoria = categoriaRepositoriy.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
	public Categoria insert(Categoria obj){
		return categoriaRepositoriy.insert(obj);
	}
	
	
	public Categoria fromDTO(CategoriaDTO obj){
  	   return new Categoria(obj.getId(), obj.getNome());
	}

}
