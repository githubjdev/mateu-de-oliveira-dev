package mat.dev.exerciciologica;

import java.util.Calendar;

public class MainVendaProduto {

	public static void main(String[] args) {

		/* Produtos */
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setMarca("Original");
		produto.setNome("Cerveja Original");
		produto.setTipo("Bebida cerveja");
		produto.setValor(2.58);

		Produto produto2 = new Produto();
		produto2.setId(2L);
		produto2.setMarca("Cocamar");
		produto2.setNome("Neguinho");
		produto2.setTipo("Bebida Café");
		produto2.setValor(5.58);

		Produto produto3 = new Produto();
		produto3.setId(3L);
		produto3.setMarca("Todesquini");
		produto3.setNome("Macarrão");
		produto3.setTipo("Massas");
		produto3.setValor(3.78);

		/* Pessoa ou Cliente */
		Pessoa pessoa = new Pessoa();
		pessoa.setId(10L);
		pessoa.setCpf("44.545444.54");
		pessoa.setEmail("alex@gmail.com");
		pessoa.setNome("Alex fernando egidio");
		pessoa.setTelefone("545454545445");
		

		/* Venda Compra para o cliente (Pessoa) */
		Venda venda = new Venda();
		venda.setId(14L);
		venda.setData(Calendar.getInstance().getTime());
		venda.setPessoa(pessoa);

		/* Item que está sendo vendido */
		/* Lista de Itens da venda List<VendaItemProduto> itens */
		/* Item da venda junta os dados da venda e do item da venda */
		ItemVendido itemVendido = new ItemVendido();
		itemVendido.setId(10L);
		itemVendido.setQuantidade(2);
		itemVendido.setProduto(produto);
		itemVendido.setVenda(venda);

		/* Adicionei o primeiro produto da venda */

		venda.addProduto(itemVendido);

		/* Item 2 de venda */
		ItemVendido itemVendido2 = new ItemVendido();
		itemVendido2.setId(21L);
		itemVendido2.setProduto(produto2);
		itemVendido2.setVenda(venda);
		itemVendido2.setQuantidade(4);

		/* Adicionei o segundo produto da venda */
		venda.addProduto(itemVendido2);

		/* Item 2 de venda */
		ItemVendido itemVendido3 = new ItemVendido();
		itemVendido3.setId(21L);
		itemVendido3.setProduto(produto2);
		itemVendido3.setVenda(venda);
		itemVendido3.setQuantidade(4);

		/* Adicionei o segundo produto da venda */
		venda.addProduto(itemVendido3);
		
		
		System.out.println("Total da venda: " + venda.totalVenda());
		System.out.println("Total de Itens: " + venda.quantidadeItem());
		

	}
}
