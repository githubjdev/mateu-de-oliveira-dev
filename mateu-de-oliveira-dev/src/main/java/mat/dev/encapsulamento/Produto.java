package mat.dev.encapsulamento;

public class Produto {

	private int estoque;
	
	
	private String nome;
	
	public Produto(String nome) {
		this.nome = nome;
	}

	public void adicionarEstoque(int quantidade) throws Exception {
		if (quantidade <= 0) {
			throw new Exception("Qtde de estoque não pode ser zero");
		}

		estoque += quantidade;

	}

	public void removerEstoque(int quantidade) throws Exception {
		if (quantidade <= this.estoque) {
			estoque -= quantidade;
		} else {
			throw new Exception("Quantidade maior do que o estoque");
		}

	}

	public int getEstoque() {
		return estoque;
	}
	
	
	public String getNome() {
		return nome;
	}

}
