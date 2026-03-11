package mat.dev.exerciciologica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {

	private Long id;
	private double total; /* Valor toral da venda */
	private Date data;
	private Pessoa pessoa;

	// lista de item List
	private List<ItemVendido> itensVendidos = new ArrayList<ItemVendido>();

	public void addProduto(ItemVendido produto) {
		itensVendidos.add(produto);
	}

	public void removerProduto(ItemVendido produto) {
		itensVendidos.remove(produto);
	}

	public double totalVenda() {

		double total = 0;
		for (ItemVendido produto : itensVendidos) {
			total += produto.getProduto().getValor();
		}

		setTotal(total);
		
		return total;
	}

	public int quantidadeItem() {
		return itensVendidos.size();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<ItemVendido> getItens() {
		return itensVendidos;
	}

	public void setItens(List<ItemVendido> itens) {
		this.itensVendidos = itens;
	}

}
