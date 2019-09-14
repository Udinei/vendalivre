package org.javaus.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.javaus.domain.Categoria;
import org.javaus.dto.CategoriaDTO;
import org.javaus.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public  ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = categoriaService.findAll();
		List<CategoriaDTO> listDto = list.stream().map(x -> new CategoriaDTO(x)).collect(Collectors.toList());
				
		return ResponseEntity.ok().body(listDto);
	}
	
	
	
	@GetMapping(value="/{id}")
	public  ResponseEntity<CategoriaDTO> findId(@PathVariable String id){
		Categoria obj = categoriaService.findByid(id);
		
		return ResponseEntity.ok().body(new CategoriaDTO(obj));
	}

}
