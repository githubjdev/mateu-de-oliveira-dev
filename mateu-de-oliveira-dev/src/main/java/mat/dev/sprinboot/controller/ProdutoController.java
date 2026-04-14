package mat.dev.sprinboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mat.dev.sprinboot.servicos.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/teste")
	public ResponseEntity<String> teste(){
		
		return ResponseEntity.ok("End-point funcinando");
	}
	

}
