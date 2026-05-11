package mat.dev.sprinboot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mat.dev.sprinboot.dto.ProdutoDTO;
import mat.dev.sprinboot.entidades.Produto;
import mat.dev.sprinboot.exception.MsgApiException;
import mat.dev.sprinboot.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Optional<Produto> existe(Long id) {
		return produtoRepository.findById(id);
	}

	public Produto salvar(Produto produto) {
		
		if (produto.getCategoria() == null) {
			throw new MsgApiException("Categoria deve ser informado para cadastrar um produto.");
		}
		
		return produtoRepository.saveAndFlush(produto);
	}
	
	public List<Produto> salvarList(List<Produto> produto) {
		return produtoRepository.saveAll(produto);
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
	
	
	public List<Produto> buscarPorCategoria(Long idCategoria) {
		return produtoRepository.buscarPorCategoria(idCategoria);
	}

	public Page<Produto> listaPaginada(int page, int size) {
		return produtoRepository.findAll(PageRequest.of(page, size, Sort.by("nome")));
	}

	public void adicionarEstoque(ProdutoDTO produtoDTO) {
		produtoRepository.adicionarEstoque(produtoDTO.getId(), produtoDTO.getQuantidade());
	}
	
	public void removerEstoque(ProdutoDTO produtoDTO) {
		produtoRepository.removerEstoque(produtoDTO.getId(), produtoDTO.getQuantidade());
	}

}
