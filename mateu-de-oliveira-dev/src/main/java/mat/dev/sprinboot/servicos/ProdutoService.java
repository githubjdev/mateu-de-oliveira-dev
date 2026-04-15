package mat.dev.sprinboot.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mat.dev.sprinboot.entidades.Produto;
import mat.dev.sprinboot.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto salvar(Produto produto) {
		return produtoRepository.saveAndFlush(produto);
	}

	public List<Produto> lista() {
		return produtoRepository.findAll();
	}

}
