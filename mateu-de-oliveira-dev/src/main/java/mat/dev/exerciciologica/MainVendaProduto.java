package mat.dev.exerciciologica;

import java.util.Calendar;

public class MainVendaProduto {

	public static void main(String[] args) {
		
		/*Produtos*/
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
		
		
		/*Pessoa*/
		Pessoa pessoa = new Pessoa();
		pessoa.setId(10L);
		pessoa.setCpf("44.545444.54");
		pessoa.setEmail("alex@gmail.com");
        pessoa.setNome("Alex fernando egidio");
        pessoa.setTelefone("545454545445");
        
        
        /*Venda Compra*/
        VendaCompra vendaCompra = new VendaCompra();
        vendaCompra.setId(14L);
        vendaCompra.setData(Calendar.getInstance().getTime());
        vendaCompra.setPessoa(pessoa);
        
        
        /*Item 1 de venda*/
        VendaItemProduto itemProduto = new VendaItemProduto();
        itemProduto.setId(10L);
        itemProduto.setQuantidade(2);
        itemProduto.setProduto(produto);
        itemProduto.setVenda(vendaCompra);
        
        vendaCompra.addProduto(itemProduto);
        
        /*Item 2 de venda*/
        VendaItemProduto itemProduto2 = new VendaItemProduto();
        itemProduto2.setId(21L);
        itemProduto2.setProduto(produto2);
        itemProduto2.setVenda(vendaCompra);
        itemProduto2.setQuantidade(4);
        
        vendaCompra.addProduto(itemProduto2);
        
        
        /*Item 3 de venda*/
        VendaItemProduto itemProduto3 = new VendaItemProduto();
        itemProduto3.setId(21L);
        itemProduto3.setProduto(produto3);
        itemProduto3.setVenda(vendaCompra);
        itemProduto3.setQuantidade(6);
        
        vendaCompra.addProduto(itemProduto3);
        
        
        
        System.out.println("Total da venda: " + vendaCompra.totalVenda());
        System.out.println("Total da de itens: " + vendaCompra.quantidadeItem());
	}

}
