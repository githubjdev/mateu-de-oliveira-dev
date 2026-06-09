package mat.dev.sprinboot.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mat.dev.sprinboot.dto.CategoriaDTO;
import mat.dev.sprinboot.dto.ProdutoDTO;
import mat.dev.sprinboot.entidades.Categoria;
import mat.dev.sprinboot.entidades.Produto;
import mat.dev.sprinboot.exception.MsgApiException;
import mat.dev.sprinboot.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Optional<Categoria> existe(Long id) {
		return categoriaRepository.findById(id);
	}

	public Categoria salvar(Categoria categoria) {

		if (categoria.getNome() == null) {
			throw new MsgApiException("Categoria ter nome para ser cadastrada.");
		}

		return categoriaRepository.saveAndFlush(categoria);
	}

	public List<Categoria> salvarList(List<Categoria> categorias) {
		return categoriaRepository.saveAll(categorias);
	}

	public List<Categoria> lista() {
		return categoriaRepository.findAll();
	}

	public void deletar(Long id) {
		categoriaRepository.deleteById(id);
	}

	@SuppressWarnings("unused")
	public List<Categoria> buscarPorNome(String nome) {
		
		if (nome == null && (nome!= null && nome.isEmpty())) {
			return new ArrayList<Categoria>();
		}
		
		return categoriaRepository.buscarPorNome(nome.toLowerCase());
	}
	
	
	@SuppressWarnings("unused")
	public List<CategoriaDTO> buscarPorNomeProd(String nome) {

		List<CategoriaDTO> categoriaDTOs = new ArrayList<CategoriaDTO>();

		if (nome == null && (nome != null && nome.isEmpty())) {
			return new ArrayList<CategoriaDTO>();
		}

		List<Categoria> categorias = categoriaRepository.buscarPorNome(nome.toLowerCase());

		for (Categoria categoria : categorias) {
			CategoriaDTO categoriaDTO = new CategoriaDTO();
			categoriaDTO.setNome(categoria.getNome());

			for (Produto produto : categoria.getProdutos()) {
				ProdutoDTO produtoDTO = new ProdutoDTO();
				produtoDTO.setNome(produto.getNome());
				produtoDTO.setNomeCategoria(categoria.getNome());
				produtoDTO.setPreco(produto.getPreco());
				produtoDTO.setQuantidade(produto.getQuantidade());
				categoriaDTO.getProdutoDTOs().add(produtoDTO);
			}

			categoriaDTOs.add(categoriaDTO);
		}

		return categoriaDTOs;
	}

	public Page<Categoria> listaPaginada(int page, int size) {
		return categoriaRepository.findAll(PageRequest.of(page, size, Sort.by("nome")));
	}

}
