package respository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import contexto.TestContextoSpring;
import jakarta.validation.ConstraintViolationException;
import mat.dev.sprinboot.entidades.Categoria;
import mat.dev.sprinboot.entidades.Produto;
import mat.dev.sprinboot.repository.CategoriaRepository;
import mat.dev.sprinboot.repository.ProdutoRepository;

public class TesteProdutoRepository extends TestContextoSpring {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	/* =========================================================
	 * MÉTODO AUXILIAR
	 * ========================================================= */
	private Categoria criarCategoria(String nome) {

		Categoria categoria = new Categoria();
		categoria.setNome(nome);

		return categoriaRepository.saveAndFlush(categoria);
	}

	private Produto criarProduto(String nome, Double preco, Integer quantidade, Categoria categoria) {

		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setQuantidade(quantidade);
		produto.setCategoria(categoria);

		return produto;
	}

	/* =========================================================
	 * TESTES DE SAVE
	 * ========================================================= */

	@Test
	@Order(1)
	@DisplayName("Deve salvar produto com sucesso")
	public void deveSalvarProdutoComSucesso() {

		Categoria categoria = criarCategoria("Categoria Save");

		Produto produto = criarProduto(
				"Produto Save",
				100.00,
				50,
				categoria);

		produto = produtoRepository.saveAndFlush(produto);

		assertNotNull(produto);
		assertNotNull(produto.getId());
		assertEquals("Produto Save", produto.getNome());
		assertEquals(100.00, produto.getPreco());
		assertEquals(50, produto.getQuantidade());
		assertNotNull(produto.getCategoria());
	}

	@Test
	@Order(2)
	@DisplayName("Não deve salvar produto sem nome")
	public void naoDeveSalvarProdutoSemNome() {

		Categoria categoria = criarCategoria("Categoria Sem Nome");

		Produto produto = criarProduto(
				null,
				100.00,
				50,
				categoria);

		assertThrows(ConstraintViolationException.class, () -> {
			produtoRepository.saveAndFlush(produto);
		});
	}

	@Test
	@Order(3)
	@DisplayName("Não deve salvar produto com nome vazio")
	public void naoDeveSalvarProdutoComNomeVazio() {

		Categoria categoria = criarCategoria("Categoria Nome Vazio");

		Produto produto = criarProduto(
				"",
				100.00,
				50,
				categoria);

		assertThrows(ConstraintViolationException.class, () -> {
			produtoRepository.saveAndFlush(produto);
		});
	}

	@Test
	@Order(4)
	@DisplayName("Não deve salvar produto com preco zero")
	public void naoDeveSalvarProdutoComPrecoZero() {

		Categoria categoria = criarCategoria("Categoria Preco Zero");

		Produto produto = criarProduto(
				"Produto Preco Zero",
				0.0,
				50,
				categoria);

		assertThrows(ConstraintViolationException.class, () -> {
			produtoRepository.saveAndFlush(produto);
		});
	}

	@Test
	@Order(5)
	@DisplayName("Não deve salvar produto com preco negativo")
	public void naoDeveSalvarProdutoComPrecoNegativo() {

		Categoria categoria = criarCategoria("Categoria Preco Negativo");

		Produto produto = criarProduto(
				"Produto Preco Negativo",
				-10.0,
				50,
				categoria);

		assertThrows(ConstraintViolationException.class, () -> {
			produtoRepository.saveAndFlush(produto);
		});
	}

	@Test
	@Order(6)
	@DisplayName("Não deve salvar produto com estoque menor que cinco")
	public void naoDeveSalvarProdutoComQuantidadeMenorQueCinco() {

		Categoria categoria = criarCategoria("Categoria Estoque Minimo");

		Produto produto = criarProduto(
				"Produto Estoque Minimo",
				10.0,
				4,
				categoria);

		assertThrows(ConstraintViolationException.class, () -> {
			produtoRepository.saveAndFlush(produto);
		});
	}

	@Test
	@Order(7)
	@DisplayName("Não deve salvar produto com estoque maior que quinhentos")
	public void naoDeveSalvarProdutoComQuantidadeMaiorQueQuinhentos() {

		Categoria categoria = criarCategoria("Categoria Estoque Maximo");

		Produto produto = criarProduto(
				"Produto Estoque Maximo",
				10.0,
				501,
				categoria);

		assertThrows(ConstraintViolationException.class, () -> {
			produtoRepository.saveAndFlush(produto);
		});
	}

	@Test
	@Order(8)
	@DisplayName("Não deve salvar produto sem categoria")
	public void naoDeveSalvarProdutoSemCategoria() {

		Produto produto = criarProduto(
				"Produto Sem Categoria",
				10.0,
				50,
				null);

		assertThrows(Exception.class, () -> {
			produtoRepository.saveAndFlush(produto);
		});
	}

	@Test
	@Order(9)
	@DisplayName("Não deve permitir nome duplicado")
	public void naoDevePermitirNomeDuplicado() {

		Categoria categoria = criarCategoria("Categoria Nome Duplicado");

		Produto produto1 = criarProduto(
				"Produto Duplicado",
				10.0,
				50,
				categoria);

		produtoRepository.saveAndFlush(produto1);

		Produto produto2 = criarProduto(
				"Produto Duplicado",
				20.0,
				60,
				categoria);

		assertThrows(Exception.class, () -> {
			produtoRepository.saveAndFlush(produto2);
		});
	}

	/* =========================================================
	 * TESTES DE QUERY
	 * ========================================================= */

	@Test
	@Order(10)
	@DisplayName("Deve buscar produto por nome")
	public void deveBuscarProdutoPorNome() {

		Categoria categoria = criarCategoria("Categoria Busca Nome");

		Produto produto = criarProduto(
				"Notebook Gamer",
				5000.0,
				20,
				categoria);

		produtoRepository.saveAndFlush(produto);

		List<Produto> produtos =
				produtoRepository.buscarPorNome("Notebook Gamer");

		assertNotNull(produtos);
		assertFalse(produtos.isEmpty());
		assertEquals("Notebook Gamer", produtos.get(0).getNome());
	}

	@Test
	@Order(11)
	@DisplayName("Deve buscar produto ignorando letras maiusculas")
	public void deveBuscarProdutoCaseInsensitive() {

		Categoria categoria = criarCategoria("Categoria Case");

		Produto produto = criarProduto(
				"Mouse Logitech",
				200.0,
				30,
				categoria);

		produtoRepository.saveAndFlush(produto);

		List<Produto> produtos =
				produtoRepository.buscarPorNome("mOuSe");

		assertFalse(produtos.isEmpty());
		assertEquals("Mouse Logitech", produtos.get(0).getNome());
	}

	@Test
	@Order(12)
	@DisplayName("Deve retornar lista vazia ao nao encontrar produto")
	public void deveRetornarListaVaziaAoNaoEncontrarProduto() {

		List<Produto> produtos =
				produtoRepository.buscarPorNome("ProdutoInexistente");

		assertNotNull(produtos);
		assertTrue(produtos.isEmpty());
	}

	@Test
	@Order(13)
	@DisplayName("Deve buscar produtos por categoria")
	public void deveBuscarProdutosPorCategoria() {

		Categoria categoria = criarCategoria("Categoria Busca Categoria");

		Produto produto1 = criarProduto(
				"Produto Categoria 1",
				100.0,
				20,
				categoria);

		Produto produto2 = criarProduto(
				"Produto Categoria 2",
				200.0,
				25,
				categoria);

		produtoRepository.saveAndFlush(produto1);
		produtoRepository.saveAndFlush(produto2);

		List<Produto> produtos =
				produtoRepository.buscarPorCategoria(categoria.getId());

		assertNotNull(produtos);
		assertEquals(2, produtos.size());
	}

	/* =========================================================
	 * TESTES DE UPDATE ESTOQUE
	 * ========================================================= */

	@Test
	@Order(14)
	@DisplayName("Deve adicionar estoque")
	public void deveAdicionarEstoque() {

		Categoria categoria = criarCategoria("Categoria Add Estoque");

		Produto produto = criarProduto(
				"Produto Estoque",
				50.0,
				10,
				categoria);

		produto = produtoRepository.saveAndFlush(produto);

		produtoRepository.adicionarEstoque(produto.getId(), 5);

		Produto produtoAtualizado =
				produtoRepository.findById(produto.getId()).get();

		assertEquals(15, produtoAtualizado.getQuantidade());
	}

	@Test
	@Order(15)
	@DisplayName("Deve remover estoque")
	public void deveRemoverEstoque() {

		Categoria categoria = criarCategoria("Categoria Remove Estoque");

		Produto produto = criarProduto(
				"Produto Remove Estoque",
				50.0,
				20,
				categoria);

		produto = produtoRepository.saveAndFlush(produto);

		produtoRepository.removerEstoque(produto.getId(), 5);

		Produto produtoAtualizado = produtoRepository.findById(produto.getId()).get();

		assertEquals(15, produtoAtualizado.getQuantidade());
	}

	@Test
	@Order(16)
	@DisplayName("Deve permitir estoque negativo atualmente")
	public void devePermitirEstoqueNegativoAtualmente() {

		Categoria categoria = criarCategoria("Categoria Estoque Negativo");

		Produto produto = criarProduto(
				"Produto Estoque Negativo",
				50.0,
				10,
				categoria);

		produto = produtoRepository.saveAndFlush(produto);

		produtoRepository.removerEstoque(produto.getId(), 20);

		Produto produtoAtualizado =
				produtoRepository.findById(produto.getId()).get();

		assertEquals(-10, produtoAtualizado.getQuantidade());
	}

	/* =========================================================
	 * TESTES DOS MÉTODOS DA ENTITY
	 * ========================================================= */

	@Test
	@Order(17)
	@DisplayName("Metodo qtdValida deve retornar true")
	public void qtdValidaDeveRetornarTrue() {

		Produto produto = new Produto();
		produto.setQuantidade(10);

		assertTrue(produto.qtdValida());
	}

	@Test
	@Order(18)
	@DisplayName("Metodo qtdValida deve retornar false")
	public void qtdValidaDeveRetornarFalse() {

		Produto produto = new Produto();
		produto.setQuantidade(0);

		assertFalse(produto.qtdValida());
	}

	@Test
	@Order(19)
	@DisplayName("Metodo precoValido deve retornar true")
	public void precoValidoDeveRetornarTrue() {

		Produto produto = new Produto();
		produto.setPreco(10.0);

		assertTrue(produto.precoValido());
	}

	@Test
	@Order(20)
	@DisplayName("Metodo precoValido deve retornar false")
	public void precoValidoDeveRetornarFalse() {

		Produto produto = new Produto();
		produto.setPreco(0.0);

		assertFalse(produto.precoValido());
	}

	@Test
	@Order(21)
	@DisplayName("Getters e setters devem funcionar")
	public void gettersESettersDevemFuncionar() {

		Categoria categoria = new Categoria();

		Produto produto = new Produto();

		produto.setId(1L);
		produto.setNome("Produto Getter");
		produto.setPreco(99.99);
		produto.setQuantidade(100);
		produto.setCategoria(categoria);

		assertEquals(1L, produto.getId());
		assertEquals("Produto Getter", produto.getNome());
		assertEquals(99.99, produto.getPreco());
		assertEquals(100, produto.getQuantidade());
		assertEquals(categoria, produto.getCategoria());
	}

	@Test
	@Order(22)
	@DisplayName("SaveAndFlush nao deve lançar excecao para produto valido")
	public void saveAndFlushNaoDeveLancarExcecao() {

		Categoria categoria = criarCategoria("Categoria Final");

		Produto produto = criarProduto(
				"Produto Final",
				100.0,
				100,
				categoria);

		assertDoesNotThrow(() -> {
			produtoRepository.saveAndFlush(produto);
		});
	}

	@Test
	@Order(23)
	@DisplayName("Salva e consulta o produto")
	public void testBuscarPorNome() {
		
		Categoria categoria = new Categoria();
		categoria.setNome("Categoria Teste");
		categoria = categoriaRepository.saveAndFlush(categoria);
		
		Produto produto = new Produto();
		produto.setNome("Produto teste");
		produto.setPreco(50.00);
		produto.setQuantidade(50);
		produto.setCategoria(categoria);
		
		produto = produtoRepository.saveAndFlush(produto);
		
		List<Produto> produtos = produtoRepository.buscarPorNome("Produto teste");
		
		assertNotNull(produtos);
		assertEquals(1, produtos.size());
		
		Produto pro = produtos.get(0);
		
		assertEquals("Produto teste", pro.getNome());
	}

}
