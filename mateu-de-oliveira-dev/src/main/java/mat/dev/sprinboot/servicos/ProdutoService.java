package mat.dev.sprinboot.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mat.dev.sprinboot.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	
	@Autowired
	private ProdutoRepository produtoRepository;
	

}
