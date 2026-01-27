package mat.dev.listarraylist;

import java.util.Objects;

public class Produtos {

	private String nome;
	private double preco;
	private double estoque;
	private boolean ativo;
	private String marca;
	private String categoria;

	public Produtos(String nome, double preco, double estoque) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;

	}

	public Produtos(String nome, double preco, double estoque, boolean ativo, String marca, String categoria) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
		this.ativo = ativo;
		this.marca = marca;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getEstoque() {
		return estoque;
	}

	public void setEstoque(double estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return "Produtos [nome=" + nome + ", preco=" + preco + ", estoque=" + estoque + ", ativo=" + ativo + ", marca="
				+ marca + ", categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(estoque, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		return Double.doubleToLongBits(estoque) == Double.doubleToLongBits(other.estoque)
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}

	public void adicionarEstoque(double qtd) {
		this.estoque += qtd;
	}

	public void removerEstoque(double qtd) {
		this.estoque -= qtd;
	}

	public double desconto(int desconto) {
		if (desconto <= 0 || desconto > 20) {
			return this.preco;
		}
		return this.preco - ((desconto / 100.0) * this.preco);
	}

}