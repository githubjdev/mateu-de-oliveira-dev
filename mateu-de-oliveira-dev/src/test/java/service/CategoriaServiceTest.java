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
import mat.dev.sprinboot.entidades.Categoria;
import mat.dev.sprinboot.exception.MsgApiException;
import mat.dev.sprinboot.repository.CategoriaRepository;
import mat.dev.sprinboot.servicos.CategoriaService;

public class CategoriaServiceTest extends TestContextoSpring {
	@Mock
	private CategoriaRepository categoriaRepository;
	
	@InjectMocks
	private CategoriaService categoriaService;

	private Categoria criarCategoria() {
		Categoria categoria = new Categoria();
		categoria.setId(1L);
		categoria.setNome("Eletrônicos");
		return categoria;
	}

	@Test
	@DisplayName("Deve retornar categoria existente")
	void deveRetornarCategoriaExistente() {
		Categoria categoria = criarCategoria();
		when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));
		Optional<Categoria> retorno = categoriaService.existe(1L);
		assertTrue(retorno.isPresent());
		assertEquals("Eletrônicos", retorno.get().getNome());
		verify(categoriaRepository).findById(1L);
	}

	@Test
	@DisplayName("Deve retornar Optional vazio")
	void deveRetornarOptionalVazio() {
		when(categoriaRepository.findById(1L)).thenReturn(Optional.empty());
		Optional<Categoria> retorno = categoriaService.existe(1L);
		assertFalse(retorno.isPresent());
	}

	@Test
	@DisplayName("Deve salvar categoria")
	void deveSalvarCategoria() {
		Categoria categoria = criarCategoria();
		when(categoriaRepository.saveAndFlush(any())).thenReturn(categoria);
		Categoria retorno = categoriaService.salvar(categoria);
		assertNotNull(retorno);
		assertEquals("Eletrônicos", retorno.getNome());
		verify(categoriaRepository).saveAndFlush(categoria);
	}

	@Test
	@DisplayName("Deve lançar exceção quando nome for nulo")
	void deveLancarExcecaoNomeNulo() {
		Categoria categoria = criarCategoria();
		categoria.setNome(null);
		MsgApiException ex = assertThrows(MsgApiException.class, () -> categoriaService.salvar(categoria));
		assertEquals("Categoria ter nome para ser cadastrada.", ex.getMessage());
		verify(categoriaRepository, never()).saveAndFlush(any());
	}

	@Test
	@DisplayName("Deve salvar lista de categorias")
	void deveSalvarListaCategorias() {
		Categoria categoria = criarCategoria();
		List<Categoria> lista = Arrays.asList(categoria);
		when(categoriaRepository.saveAll(lista)).thenReturn(lista);
		List<Categoria> retorno = categoriaService.salvarList(lista);
		assertEquals(1, retorno.size());
		verify(categoriaRepository).saveAll(lista);
	}

	@Test
	@DisplayName("Deve listar categorias")
	void deveListarCategorias() {
		Categoria categoria = criarCategoria();
		when(categoriaRepository.findAll()).thenReturn(List.of(categoria));
		List<Categoria> lista = categoriaService.lista();
		assertEquals(1, lista.size());
		verify(categoriaRepository).findAll();
	}

	@Test
	@DisplayName("Deve retornar lista vazia")
	void deveRetornarListaVazia() {
		when(categoriaRepository.findAll()).thenReturn(Collections.emptyList());
		List<Categoria> lista = categoriaService.lista();
		assertTrue(lista.isEmpty());
	}

	@Test
	@DisplayName("Deve deletar categoria")
	void deveDeletarCategoria() {
		categoriaService.deletar(1L);
		verify(categoriaRepository).deleteById(1L);
	}

	@Test
	@DisplayName("Deve buscar categoria por nome")
	void deveBuscarCategoriaPorNome() {
		Categoria categoria = criarCategoria();
		when(categoriaRepository.buscarPorNome("ele")).thenReturn(List.of(categoria));
		List<Categoria> lista = categoriaService.buscarPorNome("Ele");
		assertEquals(1, lista.size());
		verify(categoriaRepository).buscarPorNome("ele");
	}

	@Test
	@DisplayName("Deve retornar página de categorias")
	void deveRetornarPaginaCategorias() {
		Categoria categoria = criarCategoria();
		Page<Categoria> pagina = new PageImpl<>(List.of(categoria));
		when(categoriaRepository.findAll(any(org.springframework.data.domain.Pageable.class))).thenReturn(pagina);
		Page<Categoria> retorno = categoriaService.listaPaginada(0, 10);
		assertEquals(1, retorno.getContent().size());
		verify(categoriaRepository).findAll(any(org.springframework.data.domain.Pageable.class));
	}
}
