package org.javaus.resources;

import org.javaus.domain.Pagamento;
import org.javaus.domain.Pedido;
import org.javaus.dto.PedidoDTO;
import org.javaus.services.PagamentoService;
import org.javaus.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	PagamentoService pagamentoService;	
	
	//@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@GetMapping(value="/{id}")
	public ResponseEntity<PedidoDTO> find(@PathVariable String id){
		Pedido obj = pedidoService.find(id);
		Pagamento pagamento = pagamentoService.findByPedidoId(obj.getId());
		//System.out.println("Pag..."+ pag.getClass());
		obj.setPagamento(pagamento);
		return ResponseEntity.ok().body(new PedidoDTO(obj));
	}
}
