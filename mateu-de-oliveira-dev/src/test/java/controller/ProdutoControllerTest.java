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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import contexto.TestContextoSpring;
import mat.dev.sprinboot.controller.ProdutoController;
import mat.dev.sprinboot.dto.ProdutoDTO;
import mat.dev.sprinboot.entidades.Categoria;
import mat.dev.sprinboot.entidades.Produto;
import mat.dev.sprinboot.servicos.ProdutoService;

class ProdutoControllerTest extends TestContextoSpring {

    @Mock
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProdutoService produtoService;
    
    @InjectMocks
    private ProdutoController produtoController;
    
    
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(produtoController)
        		.defaultResponseCharacterEncoding(StandardCharsets.UTF_8)
        		.build();
    }

    private Produto criarProduto() {
    	
    	    Categoria categoria = new Categoria();
    	    categoria.setNome("Categoria Teste");

        Produto produto = new Produto();

        produto.setId(1L);
        produto.setNome("Notebook");
        produto.setQuantidade(10);
        produto.setPreco(2500.00);
        produto.setCategoria(categoria);

        return produto;
    }

    @Test
    @DisplayName("GET /teste")
    void deveRetornarEndpointFuncionando() throws Exception {
    	
        mockMvc.perform(get("/api/produto/teste"))
                .andExpect(status().isOk())
                .andExpect(content().string("End-point funcinando"));
    }

    @Test
    @DisplayName("POST /salvarList")
    void deveSalvarLista() throws Exception {

        Produto produto = criarProduto();

        when(produtoService.salvarList(any()))
                .thenReturn(Collections.singletonList(produto));

        mockMvc.perform(post("/api/produto/salvarList")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                Collections.singletonList(produto))))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("POST /salvar")
    void deveSalvarProduto() throws Exception {

        Produto produto = criarProduto();

        when(produtoService.salvar(any()))
                .thenReturn(produto);

        mockMvc.perform(post("/api/produto/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("POST /adicionarEstoque")
    void deveAdicionarEstoque() throws Exception {

        ProdutoDTO dto = new ProdutoDTO();

        mockMvc.perform(post("/api/produto/adicionarEstoque")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Estoque atualizado com sucesso!"));
    }

    @Test
    @DisplayName("POST /removerEstoque")
    void deveRemoverEstoque() throws Exception {

        ProdutoDTO dto = new ProdutoDTO();

        mockMvc.perform(post("/api/produto/removerEstoque")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Estoque atualizado com sucesso!"));
    }

    @Test
    @DisplayName("PUT /update")
    void deveAtualizarProduto() throws Exception {

        Produto produto = criarProduto();

        when(produtoService.existe(anyLong()))
                .thenReturn(Optional.of(produto));

        when(produtoService.salvar(any()))
                .thenReturn(produto);

        mockMvc.perform(put("/api/produto/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /lista")
    void deveListarProdutos() throws Exception {

        when(produtoService.lista())
                .thenReturn(Arrays.asList(criarProduto()));

        mockMvc.perform(get("/api/produto/lista"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /{id}")
    void deveBuscarProdutoPorId() throws Exception {

        Produto produto = criarProduto();

        when(produtoService.existe(1L))
                .thenReturn(Optional.of(produto));

        /*mockMvc.perform(get("/api/produto/1"))
                .andExpect(status().isOk());*/
        
        
        MvcResult result = mockMvc.perform(get("/api/produto/1"))
                           .andExpect(status().isOk())
                           .andReturn();
        
        String json = result.getResponse().getContentAsString();
        
        Produto produtoRetorno = objectMapper.readValue(json, Produto.class);
        
        assertEquals("Notebook", produtoRetorno.getNome());
        assertEquals("Categoria Teste", produtoRetorno.getCategoria().getNome());
    }

    @Test
    @DisplayName("DELETE /{id}")
    void deveDeletarProduto() throws Exception {
    	
        Produto produto = criarProduto();

        when(produtoService.existe(1L))
                .thenReturn(Optional.of(produto));

        doNothing().when(produtoService)
                .deletar(1L);

        mockMvc.perform(delete("/api/produto/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("DELETE /{id} inválido")
    void deveRetornarBadRequestAoDeletarIdInvalido() throws Exception {

        mockMvc.perform(delete("/api/produto/0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET buscarPorNome")
    void deveBuscarPorNome() throws Exception {

        when(produtoService.buscarPorNome("Notebook"))
                .thenReturn(Collections.singletonList(criarProduto()));

        mockMvc.perform(get("/api/produto/buscarPorNome/Notebook"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET buscarPorCategoria")
    void deveBuscarPorCategoria() throws Exception {

        when(produtoService.buscarPorCategoria(1L))
                .thenReturn(Collections.singletonList(criarProduto()));

        mockMvc.perform(get("/api/produto/buscarPorCategoria/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET listaPaginada")
    void deveRetornarListaPaginada() throws Exception {

        when(produtoService.listaPaginada(0, 10))
                .thenReturn(new PageImpl<>(
                        Collections.singletonList(criarProduto())));

        mockMvc.perform(get("/api/produto/listaPaginada")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk());
    }
}