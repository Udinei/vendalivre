package org.javaus.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.javaus.domain.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@GetMapping
	public List<Categoria> findAll(){
		Categoria cat1 =  new Categoria(1, "Informatica");
		Categoria cat2 =  new Categoria(2, "Escritorio");
		
		List<Categoria> list = new ArrayList<>();
		list.addAll(Arrays.asList(cat1, cat2));
				
		return list;
	}

}
