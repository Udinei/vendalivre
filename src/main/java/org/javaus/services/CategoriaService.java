package org.javaus.services;

import java.util.List;

import org.javaus.domain.Categoria;
import org.javaus.repository.CategoriaRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepositoriy categoriaRepositoriy; 
	
	public List<Categoria> findAll(){
		return categoriaRepositoriy.findAll();
	}

}
