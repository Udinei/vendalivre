package org.javaus.config;


import java.util.Arrays;

import org.javaus.domain.Categoria;
import org.javaus.repository.CategoriaRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Instantiation implements CommandLineRunner {
    
	@Autowired
	private CategoriaRepositoriy categoriaRepositoriy;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		categoriaRepositoriy.deleteAll();
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		categoriaRepositoriy.saveAll(Arrays.asList(cat1, cat2));
	}
	
	 

}
