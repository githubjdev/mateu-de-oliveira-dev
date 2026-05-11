package mat.dev.sprinboot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mat.dev.sprinboot.entidades.Categoria;
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

	public List<Categoria> buscarPorNome(String nome) {
		return categoriaRepository.buscarPorNome(nome.toLowerCase());
	}

	public Page<Categoria> listaPaginada(int page, int size) {
		return categoriaRepository.findAll(PageRequest.of(page, size, Sort.by("nome")));
	}

}
