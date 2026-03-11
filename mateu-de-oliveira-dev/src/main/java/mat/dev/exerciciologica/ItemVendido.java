package mat.dev.exerciciologica;

import java.util.Objects;

/*Item que está sendo vendido*/
public class ItemVendido {

	private Long id;
	private double quantidade; /* Duas cerveja */
	private Produto produto;
	private Venda venda;
	private String obs;
	
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	public String getObs() {
		return obs;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, produto, quantidade, venda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVendido other = (ItemVendido) obj;
		return Objects.equals(id, other.id) && Objects.equals(produto, other.produto)
				&& Double.doubleToLongBits(quantidade) == Double.doubleToLongBits(other.quantidade)
				&& Objects.equals(venda, other.venda);
	}

}
