package mat.dev.sprinboot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mat.dev.sprinboot.entidades.Produto;
import mat.dev.sprinboot.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Optional<Produto> existe(Long id) {
		return produtoRepository.findById(id);
	}

	public Produto salvar(Produto produto) {
		return produtoRepository.saveAndFlush(produto);
	}

	public List<Produto> lista() {
		return produtoRepository.findAll();
	}

	public void deletar(Long id) {
		produtoRepository.deleteById(id);
	}

	public List<Produto> buscarPorNome(String nome) {
		return produtoRepository.buscarPorNome(nome.toLowerCase());
	}

}
