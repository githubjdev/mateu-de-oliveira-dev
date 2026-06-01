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
import mat.dev.sprinboot.entidades.Categoria;
import mat.dev.sprinboot.repository.CategoriaRepository;

public class TesteCategoriaRepository extends TestContextoSpring {

    @Autowired
    private CategoriaRepository categoriaRepository;

    /* =========================================================
     * MÉTODO AUXILIAR
     * ========================================================= */

    private Categoria criarCategoria(String nome) {

        Categoria categoria = new Categoria();
        categoria.setNome(nome);

        return categoria;
    }

    /* =========================================================
     * TESTES DE SAVE
     * ========================================================= */

    @Test
    @Order(1)
    @DisplayName("Deve salvar categoria com sucesso")
    public void deveSalvarCategoriaComSucesso() {

        Categoria categoria = criarCategoria("Eletrônicos");

        categoria = categoriaRepository.saveAndFlush(categoria);

        assertNotNull(categoria);
        assertNotNull(categoria.getId());
        assertEquals("Eletrônicos", categoria.getNome());
    }

    @Test
    @Order(2)
    @DisplayName("Não deve salvar categoria sem nome")
    public void naoDeveSalvarCategoriaSemNome() {

        Categoria categoria = criarCategoria(null);

        assertThrows(Exception.class, () -> {
            categoriaRepository.saveAndFlush(categoria);
        });
    }

    @Test
    @Order(3)
    @DisplayName("Não deve salvar categoria com nome vazio")
    public void naoDeveSalvarCategoriaComNomeVazio() {

        Categoria categoria = criarCategoria("");

        assertThrows(Exception.class, () -> {
            categoriaRepository.saveAndFlush(categoria);
        });
    }

    @Test
    @Order(4)
    @DisplayName("Não deve permitir nome duplicado")
    public void naoDevePermitirNomeDuplicado() {

        Categoria categoria1 = criarCategoria("Informática teste");
        categoriaRepository.saveAndFlush(categoria1);

        Categoria categoria2 = criarCategoria("Informática teste");

        assertThrows(Exception.class, () -> {
            categoriaRepository.saveAndFlush(categoria2);
        });
    }

    /* =========================================================
     * TESTES DE QUERY
     * ========================================================= */

    @Test
    @Order(5)
    @DisplayName("Deve buscar categoria por nome")
    public void deveBuscarCategoriaPorNome() {

        Categoria categoria = criarCategoria("Periféricos");
        categoriaRepository.saveAndFlush(categoria);

        List<Categoria> lista =
                categoriaRepository.buscarPorNome("Periféricos");

        assertNotNull(lista);
        assertFalse(lista.isEmpty());

        assertEquals(
                "Periféricos",
                lista.get(0).getNome());
    }

    @Test
    @Order(6)
    @DisplayName("Deve buscar ignorando maiúsculas")
    public void deveBuscarCategoriaCaseInsensitive() {

        Categoria categoria = criarCategoria("Hardware");
        categoriaRepository.saveAndFlush(categoria);

        List<Categoria> lista =
                categoriaRepository.buscarPorNome("hard");

        assertFalse(lista.isEmpty());

        assertEquals(
                "Hardware",
                lista.get(0).getNome());
    }

    @Test
    @Order(7)
    @DisplayName("Deve retornar lista vazia")
    public void deveRetornarListaVazia() {

        List<Categoria> lista =
                categoriaRepository.buscarPorNome("XYZ123");

        assertNotNull(lista);
        assertTrue(lista.isEmpty());
    }

    /* =========================================================
     * TESTES DE UPDATE
     * ========================================================= */

    @Test
    @Order(8)
    @DisplayName("Deve atualizar categoria")
    public void deveAtualizarCategoria() {

        Categoria categoria =
                criarCategoria("Categoria Antiga");

        categoria =
                categoriaRepository.saveAndFlush(categoria);

        categoria.setNome("Categoria Nova");

        categoriaRepository.saveAndFlush(categoria);

        Categoria categoriaAtualizada =
                categoriaRepository.findById(
                        categoria.getId())
                        .orElseThrow();

        assertEquals(
                "Categoria Nova",
                categoriaAtualizada.getNome());
    }

    /* =========================================================
     * TESTES DE DELETE
     * ========================================================= */

    @Test
    @Order(9)
    @DisplayName("Deve excluir categoria")
    public void deveExcluirCategoria() {

        Categoria categoria =
                criarCategoria("Categoria Delete");

        categoria =
                categoriaRepository.saveAndFlush(categoria);

        Long id = categoria.getId();

        categoriaRepository.deleteById(id);

        assertFalse(
                categoriaRepository.findById(id)
                        .isPresent());
    }

    /* =========================================================
     * TESTES ENTITY
     * ========================================================= */

    @Test
    @Order(10)
    @DisplayName("Getters e Setters devem funcionar")
    public void gettersESettersDevemFuncionar() {

        Categoria categoria = new Categoria();

        categoria.setId(1L);
        categoria.setNome("Categoria Teste");

        assertEquals(1L, categoria.getId());
        assertEquals(
                "Categoria Teste",
                categoria.getNome());

        assertNotNull(categoria.getProdutos());
    }

    /* =========================================================
     * TESTE FINAL
     * ========================================================= */

    @Test
    @Order(11)
    @DisplayName("SaveAndFlush não deve lançar exceção")
    public void saveAndFlushNaoDeveLancarExcecao() {

        Categoria categoria =
                criarCategoria("Categoria Final");

        assertDoesNotThrow(() -> {
            categoriaRepository.saveAndFlush(categoria);
        });
    }

}