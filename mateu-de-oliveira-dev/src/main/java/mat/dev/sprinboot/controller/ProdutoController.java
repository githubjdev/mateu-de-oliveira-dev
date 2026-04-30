package mat.dev.sprinboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mat.dev.sprinboot.entidades.Produto;
import mat.dev.sprinboot.exception.MsgApiException;
import mat.dev.sprinboot.servicos.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/teste", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> teste() {
		return ResponseEntity.ok("End-point funcinando");
	}
	
	
	@PostMapping(value = "/salvarList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Produto>> salvarList(@RequestBody List<Produto> produto) throws MsgApiException {
		List<Produto> prodSaldo = produtoService.salvarList(produto);
		return ResponseEntity.ok(prodSaldo);
	}

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) throws MsgApiException {

		if (!produto.qtdValida()) {
			throw new MsgApiException("Quantidade de estoque é inválida.");
		}

		if (!produto.precoValido()) {
			throw new MsgApiException("Preço do produto é inválida.");
		}

		Produto prodSaldo = produtoService.salvar(produto);
		return ResponseEntity.ok(prodSaldo);
	}

	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> update(@RequestBody Produto produto) throws MsgApiException {

		Optional<Produto> optional = produtoService.existe(produto.getId());

		if (!optional.isPresent()) {
			throw new MsgApiException("Produto com ID " + produto.getId() + " não encontrado para atualizar");
		}

		if (!produto.qtdValida()) {
			throw new MsgApiException("Quantidade de estoque é inválida.");
		}

		if (!produto.precoValido()) {
			throw new MsgApiException("Preço do produto é inválida.");
		}

		Produto prodSaldo = produtoService.salvar(produto);
		return ResponseEntity.ok(prodSaldo);
	}

	@GetMapping(value = "/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Produto>> lista() {

		return ResponseEntity.ok(produtoService.lista());
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> buscarId(@PathVariable(name = "id") Long id) throws MsgApiException {

		if (id <= 0) { /* Valida se o ID é maior que zero */
			throw new MsgApiException("Produto não encontrado com ID: " + id);
		}

		/* Consulta pra saber se o objeto existe no banco de dados */
		Optional<Produto> optional = produtoService.existe(id);

		/* Caso não exista dê msg de erro */
		if (!optional.isPresent()) {
			throw new MsgApiException("Produto com ID " + id + " não encontrado busca");
		}

		/* Caso esteja salvo no banco de dados, então mostra na tela */
		return ResponseEntity.ok(optional.get());

	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteId(@PathVariable(name = "id") Long id) throws MsgApiException {

		if (id <= 0) { /* Valida se o ID é maior que zero */
			return ResponseEntity.badRequest().build();
		}

		/* Consulta pra saber se o objeto existe no banco de dados */
		Optional<Produto> optional = produtoService.existe(id);

		/* Caso não exista dê msg de erro */
		if (!optional.isPresent()) {
			throw new MsgApiException("Produto com ID " + id + " não encontrado para deletar");
		}

		produtoService.deletar(id);

		/* Caso esteja salvo no banco de dados, então mostra na tela */
		return ResponseEntity.ok().build();

	}

	@GetMapping(value = "buscarPorNome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Produto>> buscarPorNome(@PathVariable(name = "nome") String nome) {
		List<Produto> produtos = produtoService.buscarPorNome(nome);

		return ResponseEntity.ok(produtos);
	}
	
	
	@GetMapping("/listaPaginada")
	public ResponseEntity<List<Produto>> listaPaginada(@RequestParam(defaultValue = "0") int page,
													   @RequestParam(defaultValue = "10") int size) {

		Page<Produto> pagina = produtoService.listaPaginada(page, size);
		return ResponseEntity.ok(pagina.getContent());
	}

}
