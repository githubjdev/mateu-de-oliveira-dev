package mat.dev.exerciciologica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VendaCompra {

	private Long id;
	private double total; /* Valor toral da venda */
	private Date data;
	private Pessoa pessoa;

	// lista de item List
	private List<VendaItemProduto> itens = new ArrayList<VendaItemProduto>();

	public void addProduto(VendaItemProduto produto) {
		itens.add(produto);
	}

	public void removerProduto(VendaItemProduto produto) {
		itens.remove(produto);
	}

	public double totalVenda() {

		double total = 0;
		for (VendaItemProduto produto : itens) {
			total += produto.getProduto().getValor();
		}

		setTotal(total);
		
		return total;
	}

	public int quantidadeItem() {
		return itens.size();
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

	public List<VendaItemProduto> getItens() {
		return itens;
	}

	public void setItens(List<VendaItemProduto> itens) {
		this.itens = itens;
	}

}
