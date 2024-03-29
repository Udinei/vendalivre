package org.javaus.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.javaus.domain.Categoria;
import org.javaus.domain.Produto;
import org.javaus.dto.CategoriaDTO;
import org.javaus.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	
	// carrega categorias por Id
	@GetMapping(value="/{id}")
	public  ResponseEntity<CategoriaDTO> findById(@PathVariable String id){
		Categoria obj = categoriaService.findById(id);
		return ResponseEntity.ok().body(new CategoriaDTO(obj));
	}
	
	@PostMapping
	public  ResponseEntity<CategoriaDTO> insert(@RequestBody CategoriaDTO objDto){
		Categoria obj = categoriaService.fromDTO(objDto);
		obj= categoriaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value="/{id}")
	public  ResponseEntity<Void> delete(@PathVariable String id){
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public  ResponseEntity<Void> update(@RequestBody CategoriaDTO objDto, @PathVariable String id){
		Categoria obj = categoriaService.fromDTO(objDto);
		obj.setId(id); 
		obj = categoriaService.update(obj);
		
		return ResponseEntity.noContent().build();	
		
	}
	
	// Retorna produtos da categoria
	@GetMapping(value="/{id}/produtos")
	public  ResponseEntity<List<Produto>> findProdutos(@PathVariable String id){
		Categoria obj = categoriaService.findById(id);
		return ResponseEntity.ok().body(obj.getProdutos());
	}
	


}
