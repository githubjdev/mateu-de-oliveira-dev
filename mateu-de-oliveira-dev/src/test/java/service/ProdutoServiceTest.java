package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import contexto.TestContextoSpring;
import mat.dev.sprinboot.dto.ProdutoDTO;
import mat.dev.sprinboot.entidades.Categoria;
import mat.dev.sprinboot.entidades.Produto;
import mat.dev.sprinboot.exception.MsgApiException;
import mat.dev.sprinboot.repository.ProdutoRepository;
import mat.dev.sprinboot.servicos.ProdutoService;

public class ProdutoServiceTest extends TestContextoSpring {
	
	@Mock
	private ProdutoRepository produtoRepository;
	
	@InjectMocks
	private ProdutoService produtoService;

	private Produto criarProduto() {
		Categoria categoria = new Categoria();
		categoria.setId(1L);
		categoria.setNome("Categoria Teste");
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setNome("Notebook");
		produto.setPreco(5000.0);
		produto.setQuantidade(10);
		produto.setCategoria(categoria);
		return produto;
	}

	@Test
	@DisplayName("Deve retornar produto existente")
	void deveRetornarProdutoExistente() {
		Produto produto = criarProduto();
		when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
		Optional<Produto> retorno = produtoService.existe(1L);
		assertTrue(retorno.isPresent());
		assertEquals("Notebook", retorno.get().getNome());
		verify(produtoRepository).findById(1L);
	}

	@Test
	@DisplayName("Deve retornar vazio quando produto não existir")
	void deveRetornarVazio() {
		when(produtoRepository.findById(1L)).thenReturn(Optional.empty());
		Optional<Produto> retorno = produtoService.existe(1L);
		assertFalse(retorno.isPresent());
	}

	@Test
	@DisplayName("Deve salvar produto")
	void deveSalvarProduto() {
		Produto produto = criarProduto();
		when(produtoRepository.saveAndFlush(any())).thenReturn(produto);
		Produto retorno = produtoService.salvar(produto);
		assertNotNull(retorno);
		assertEquals("Notebook", retorno.getNome());
		verify(produtoRepository).saveAndFlush(produto);
	}

	@Test
	@DisplayName("Deve lançar exceção quando categoria for nula")
	void deveLancarExcecaoCategoriaNula() {
		Produto produto = criarProduto();
		produto.setCategoria(null);
		MsgApiException ex = assertThrows(MsgApiException.class, () -> produtoService.salvar(produto));
		assertEquals("Categoria deve ser informado para cadastrar um produto.", ex.getMessage());
		verify(produtoRepository, never()).saveAndFlush(any());
	}

	@Test
	@DisplayName("Deve salvar lista de produtos")
	void deveSalvarListaProdutos() {
		Produto produto = criarProduto();
		List<Produto> lista = Arrays.asList(produto);
		when(produtoRepository.saveAll(lista)).thenReturn(lista);
		List<Produto> retorno = produtoService.salvarList(lista);
		assertEquals(1, retorno.size());
		verify(produtoRepository).saveAll(lista);
	}

	@Test
	@DisplayName("Deve listar produtos")
	void deveListarProdutos() {
		Produto produto = criarProduto();
		when(produtoRepository.findAll()).thenReturn(List.of(produto));
		List<Produto> lista = produtoService.lista();
		assertEquals(1, lista.size());
		verify(produtoRepository).findAll();
	}

	@Test
	@DisplayName("Deve retornar lista vazia")
	void deveRetornarListaVazia() {
		when(produtoRepository.findAll()).thenReturn(Collections.emptyList());
		List<Produto> lista = produtoService.lista();
		assertTrue(lista.isEmpty());
	}

	@Test
	@DisplayName("Deve deletar produto")
	void deveDeletarProduto() {
		produtoService.deletar(1L);
		verify(produtoRepository).deleteById(1L);
	}

	@Test
	@DisplayName("Deve buscar por nome")
	void deveBuscarPorNome() {
		Produto produto = criarProduto();
		when(produtoRepository.buscarPorNome("notebook")).thenReturn(List.of(produto));
		List<Produto> lista = produtoService.buscarPorNome("Notebook");
		assertEquals(1, lista.size());
		verify(produtoRepository).buscarPorNome("notebook");
	}

	@Test
	@DisplayName("Deve buscar por categoria")
	void deveBuscarPorCategoria() {
		Produto produto = criarProduto();
		when(produtoRepository.buscarPorCategoria(1L)).thenReturn(List.of(produto));
		List<Produto> lista = produtoService.buscarPorCategoria(1L);
		assertEquals(1, lista.size());
		verify(produtoRepository).buscarPorCategoria(1L);
	}

	@Test
	@DisplayName("Deve retornar página de produtos")
	void deveRetornarPagina() {
		Produto produto = criarProduto();
		Page<Produto> pagina = new PageImpl<>(List.of(produto));
		when(produtoRepository.findAll(any(org.springframework.data.domain.Pageable.class))).thenReturn(pagina);
		Page<Produto> retorno = produtoService.listaPaginada(0, 10);
		assertEquals(1, retorno.getContent().size());
		verify(produtoRepository).findAll(any(org.springframework.data.domain.Pageable.class));
	}

	@Test
	@DisplayName("Deve adicionar estoque")
	void deveAdicionarEstoque() {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setId(1L);
		dto.setQuantidade(5);
		produtoService.adicionarEstoque(dto);
		verify(produtoRepository).adicionarEstoque(1L, 5);
	}

	@Test
	@DisplayName("Deve remover estoque")
	void deveRemoverEstoque() {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setId(1L);
		dto.setQuantidade(3);
		produtoService.removerEstoque(dto);
		verify(produtoRepository).removerEstoque(1L, 3);
	}
}
