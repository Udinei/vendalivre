package org.javaus.config;


import java.util.Arrays;

import org.javaus.domain.Categoria;
import org.javaus.domain.Cidade;
import org.javaus.domain.Cliente;
import org.javaus.domain.Endereco;
import org.javaus.domain.Estado;
import org.javaus.domain.Produto;
import org.javaus.domain.Telefone;
import org.javaus.domain.enums.TipoCliente;
import org.javaus.repository.CategoriaRepository;
import org.javaus.repository.CidadeRepository;
import org.javaus.repository.ClienteRepository;
import org.javaus.repository.EnderecoRepository;
import org.javaus.repository.EstadoRepository;
import org.javaus.repository.ProdutoRepository;
import org.javaus.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Instantiation implements CommandLineRunner {
    
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
    @Autowired
	private EstadoRepository estadoRepository;
	    
	@Autowired
	private CidadeRepository cidadeRepository;
		    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private TelefoneRepository telefoneRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		limpaBD();
		categoriaAndProduto();
				
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
	
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		//cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "54305209197", TipoCliente.PESSOAFISICA, "maria@gmail.com");
		
		Telefone te1 = new Telefone(null, "27363323");
		Telefone te2 = new Telefone(null, "93838393");
		
		telefoneRepository.saveAll(Arrays.asList(te1, te2));
		
		cli1.getTelefones().addAll(Arrays.asList(te1, te2));
		
		clienteRepository.saveAll (Arrays.asList(cli1));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303","Jardim", "38208834", c1, cli1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800","Centro", "38777012", c2, cli1);
			    
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		clienteRepository.saveAll (Arrays.asList(cli1));
		
        						
		
		
	}
	

	private void categoriaAndProduto() {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

	private void limpaBD() {
		categoriaRepository.deleteAll();
		produtoRepository.deleteAll();
		cidadeRepository.deleteAll();
		estadoRepository.deleteAll();
		enderecoRepository.deleteAll();
		clienteRepository.deleteAll();
		telefoneRepository.deleteAll();
	}
	
}
