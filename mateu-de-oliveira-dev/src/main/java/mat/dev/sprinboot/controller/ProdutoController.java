package mat.dev.sprinboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mat.dev.sprinboot.entidades.Produto;
import mat.dev.sprinboot.servicos.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/teste")
	public ResponseEntity<String> teste() {
		return ResponseEntity.ok("End-point funcinando");
	}

	@PostMapping("/salvar")
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
		Produto prodSaldo = produtoService.salvar(produto);
		return ResponseEntity.ok(prodSaldo);
	}

	@GetMapping("/lista")
	public ResponseEntity<List<Produto>> lista() {

		return ResponseEntity.ok(produtoService.lista());
	}

}
