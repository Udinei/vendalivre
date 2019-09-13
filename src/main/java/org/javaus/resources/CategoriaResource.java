package org.javaus.resources;

import java.util.List;

import org.javaus.domain.Categoria;
import org.javaus.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public  ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> list = categoriaService.findAll();
				
		return ResponseEntity.ok().body(list);
	}

}
