package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import contexto.TestContextoSpring;
import mat.dev.sprinboot.controller.CategoriaController;
import mat.dev.sprinboot.entidades.Categoria;
import mat.dev.sprinboot.servicos.CategoriaService;

class CategoriaControllerTest extends TestContextoSpring {

	@Mock
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private CategoriaService categoriaService;

	@InjectMocks
	private CategoriaController categoriaController;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(categoriaController)
				.defaultResponseCharacterEncoding(StandardCharsets.UTF_8)
				.build();
	}

	private Categoria criarCategoria() {

		Categoria categoria = new Categoria();

		categoria.setId(1L);
		categoria.setNome("Eletrônicos");

		return categoria;
	}

	@Test
	@DisplayName("GET /teste")
	void deveRetornarEndpointFuncionando() throws Exception {

		mockMvc.perform(get("/api/categoria/teste")).andExpect(status().isOk())
				.andExpect(content().string("End-point funcinando"));
	}

	@Test
	@DisplayName("POST /salvarList")
	void deveSalvarLista() throws Exception {

		Categoria categoria = criarCategoria();

		when(categoriaService.salvarList(any())).thenReturn(Collections.singletonList(categoria));

		mockMvc.perform(post("/api/categoria/salvarList").contentType("application/json")
				.content(objectMapper.writeValueAsString(Collections.singletonList(categoria))))
				.andExpect(status().isOk());
	}

	@Test
	@DisplayName("POST /salvar")
	void deveSalvarCategoria() throws Exception {

		Categoria categoria = criarCategoria();

		when(categoriaService.salvar(any())).thenReturn(categoria);

		MvcResult result = mockMvc.perform(post("/api/categoria/salvar").contentType("application/json")
				.content(objectMapper.writeValueAsString(categoria))).andExpect(status().isOk()).andReturn();

		Categoria retorno = objectMapper.readValue(result.getResponse().getContentAsString(), Categoria.class);

		assertEquals("Eletrônicos", retorno.getNome());
	}

	@Test
	@DisplayName("PUT /update")
	void deveAtualizarCategoria() throws Exception {

		Categoria categoria = criarCategoria();

		when(categoriaService.existe(anyLong())).thenReturn(Optional.of(categoria));

		when(categoriaService.salvar(any())).thenReturn(categoria);

		mockMvc.perform(put("/api/categoria/update").contentType("application/json")
				.content(objectMapper.writeValueAsString(categoria))).andExpect(status().isOk());
	}

	@Test
	@DisplayName("GET /lista")
	void deveListarCategorias() throws Exception {

		when(categoriaService.lista()).thenReturn(Arrays.asList(criarCategoria()));

		MvcResult result = mockMvc.perform(get("/api/categoria/lista")).andExpect(status().isOk()).andReturn();

		var categorias = objectMapper.readValue(result.getResponse().getContentAsString(),
				new TypeReference<java.util.List<Categoria>>() {
				});

		assertEquals(1, categorias.size());
		assertEquals("Eletrônicos", categorias.get(0).getNome());
	}

	@Test
	@DisplayName("GET /{id}")
	void deveBuscarCategoriaPorId() throws Exception {

		Categoria categoria = criarCategoria();

		when(categoriaService.existe(1L)).thenReturn(Optional.of(categoria));

		MvcResult result = mockMvc.perform(get("/api/categoria/1")).andExpect(status().isOk()).andReturn();

		Categoria retorno = objectMapper.readValue(result.getResponse().getContentAsString(), Categoria.class);

		assertEquals("Eletrônicos", retorno.getNome());
	}

	@Test
	@DisplayName("DELETE /{id}")
	void deveDeletarCategoria() throws Exception {

		Categoria categoria = criarCategoria();

		when(categoriaService.existe(1L)).thenReturn(Optional.of(categoria));

		doNothing().when(categoriaService).deletar(1L);

		mockMvc.perform(delete("/api/categoria/1")).andExpect(status().isOk());
	}

	@Test
	@DisplayName("DELETE /{id} inválido")
	void deveRetornarBadRequestAoDeletarIdInvalido() throws Exception {

		mockMvc.perform(delete("/api/categoria/0")).andExpect(status().isBadRequest());
	}

	@Test
	@DisplayName("GET buscarPorNome")
	void deveBuscarPorNome() throws Exception {

		when(categoriaService.buscarPorNome("Eletrônicos")).thenReturn(Collections.singletonList(criarCategoria()));

		MvcResult result = mockMvc.perform(get("/api/categoria/buscarPorNome/Eletrônicos")).andExpect(status().isOk())
				.andReturn();

		var categorias = objectMapper.readValue(result.getResponse().getContentAsString(),
				new TypeReference<java.util.List<Categoria>>() {
				});

		assertEquals(1, categorias.size());
		assertEquals("Eletrônicos", categorias.get(0).getNome());
	}

	@Test
	@DisplayName("GET listaPaginada")
	void deveRetornarListaPaginada() throws Exception {

		when(categoriaService.listaPaginada(0, 10)).thenReturn(
				new org.springframework.data.domain.PageImpl<>(Collections.singletonList(criarCategoria())));

		   MvcResult result = mockMvc.perform(
		            get("/api/categoria/listaPaginada")
		                    .param("page", "0")
		                    .param("size", "10"))
		            .andReturn();

		    System.out.println("STATUS = " + result.getResponse().getStatus());
		    System.out.println("CONTENT TYPE = " + result.getResponse().getContentType());
		    System.out.println("BODY = ");
		    System.out.println(result.getResponse().getContentAsString());

		var categorias = objectMapper.readValue(result.getResponse().getContentAsString(),
				new TypeReference<java.util.List<Categoria>>() {
				});

		assertEquals(1, categorias.size());
		assertEquals("Eletrônicos", categorias.get(0).getNome());
	}
}