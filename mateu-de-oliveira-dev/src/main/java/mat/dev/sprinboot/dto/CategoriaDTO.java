package mat.dev.sprinboot.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {

	private String nome;
	private List<ProdutoDTO> produtoDTOs = new ArrayList<ProdutoDTO>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ProdutoDTO> getProdutoDTOs() {
		return produtoDTOs;
	}

	public void setProdutoDTOs(List<ProdutoDTO> produtoDTOs) {
		this.produtoDTOs = produtoDTOs;
	}

}
