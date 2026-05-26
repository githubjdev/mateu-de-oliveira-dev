package respository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import contexto.TestContextoSpring;
import mat.dev.sprinboot.entidades.Produto;
import mat.dev.sprinboot.repository.ProdutoRepository;

public class TesteProdutoRepository extends TestContextoSpring {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Test
	public void testBuscarPorNome() {
		List<Produto> produtos = produtoRepository.buscarPorNome("Notebook Dell Inspiron i7 pdate 2");
		
		assertNotNull(produtos);
		assertEquals(1, produtos.size());
		
		Produto produto = produtos.get(0);
		
		assertEquals("Notebook Dell Inspiron i7 pdate 2", produto.getNome());
	}

}
