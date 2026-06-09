package mat.dev.sprinboot.dto;

/*Seguranca, pra ocultar suas classes persistence, não expor estrutura do banco e classes*/
/*Data Transfer Objeto = Objeto de transgerencia de dados*/
/*A nova forma é usando Record*/
public class ProdutoDTO {

	private Long id;
	private String nome;
	private Integer quantidade;
	private Double preco;
	private String nomeCategoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
