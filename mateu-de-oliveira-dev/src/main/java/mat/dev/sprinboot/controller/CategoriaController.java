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

import mat.dev.sprinboot.entidades.Categoria;
import mat.dev.sprinboot.exception.MsgApiException;
import mat.dev.sprinboot.servicos.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = "/teste", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> teste() {
		return ResponseEntity.ok("End-point funcinando");
	}
	
	
	@PostMapping(value = "/salvarList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> salvarList(@RequestBody List<Categoria> categoria) throws MsgApiException {
		List<Categoria> prodSaldo = categoriaService.salvarList(categoria);
		return ResponseEntity.ok(prodSaldo);
	}

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) throws MsgApiException {

		Categoria prodSaldo = categoriaService.salvar(categoria);
		return ResponseEntity.ok(prodSaldo);
	}
	

	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) throws MsgApiException {

		Optional<Categoria> optional = categoriaService.existe(categoria.getId());

		if (!optional.isPresent()) {
			throw new MsgApiException("Categoria com ID " + categoria.getId() + " não encontrado para atualizar");
		}


		Categoria cat = categoriaService.salvar(categoria);
		return ResponseEntity.ok(cat);
	}

	@GetMapping(value = "/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> lista() {

		return ResponseEntity.ok(categoriaService.lista());
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> buscarId(@PathVariable(name = "id") Long id) throws MsgApiException {

		if (id <= 0) { /* Valida se o ID é maior que zero */
			throw new MsgApiException("Categoria não encontrado com ID: " + id);
		}

		/* Consulta pra saber se o objeto existe no banco de dados */
		Optional<Categoria> optional = categoriaService.existe(id);

		/* Caso não exista dê msg de erro */
		if (!optional.isPresent()) {
			throw new MsgApiException("Categoria com ID " + id + " não encontrado busca");
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
		Optional<Categoria> optional = categoriaService.existe(id);

		/* Caso não exista dê msg de erro */
		if (!optional.isPresent()) {
			throw new MsgApiException("Categoria com ID " + id + " não encontrado para deletar");
		}

		categoriaService.deletar(id);

		/* Caso esteja salvo no banco de dados, então mostra na tela */
		return ResponseEntity.ok().build();

	}

	@GetMapping(value = "buscarPorNome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> buscarPorNome(@PathVariable(name = "nome") String nome) {
		List<Categoria> categorias = categoriaService.buscarPorNome(nome);

		return ResponseEntity.ok(categorias);
	}
	
	
	@GetMapping("/listaPaginada")
	public ResponseEntity<List<Categoria>> listaPaginada(@RequestParam(defaultValue = "0") int page,
													   @RequestParam(defaultValue = "10") int size) {

		Page<Categoria> pagina = categoriaService.listaPaginada(page, size);
		return ResponseEntity.ok(pagina.getContent());
	}
	
	
	

}
