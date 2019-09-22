package org.javaus.config;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.javaus.domain.Categoria;
import org.javaus.domain.Cidade;
import org.javaus.domain.Cliente;
import org.javaus.domain.Endereco;
import org.javaus.domain.Estado;
import org.javaus.domain.Pagamento;
import org.javaus.domain.PagamentoComBoleto;
import org.javaus.domain.PagamentoComCartao;
import org.javaus.domain.Pedido;
import org.javaus.domain.Produto;
import org.javaus.domain.Telefone;
import org.javaus.domain.enums.EstadoPagamento;
import org.javaus.domain.enums.TipoCliente;
import org.javaus.repository.CategoriaRepository;
import org.javaus.repository.CidadeRepository;
import org.javaus.repository.ClienteRepository;
import org.javaus.repository.EnderecoRepository;
import org.javaus.repository.EstadoRepository;
import org.javaus.repository.PagamentoRepository;
import org.javaus.repository.PedidoRepository;
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
	
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    
	@Override
	public void run(String... args) throws Exception {
		gravaDadoBD();
	
	}
	

	private void categoriaAndProduto() {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
			
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 2000.00);
		Produto p3 = new Produto(null, "Mouse", 2000.00);
			
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		//  salvando categorias 
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
		pagamentoRepository.deleteAll();
		pedidoRepository.deleteAll();
	}
	
	private void gravaDadoBD() throws ParseException{
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
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 10:32"), cli1, e2);
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
				
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,ped2, sdf.parse("20/10/2017 20:35"), null);
		ped2.setPagamento(pagto2);
		
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
				
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		clienteRepository.saveAll (Arrays.asList(cli1));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
	}
	
}
