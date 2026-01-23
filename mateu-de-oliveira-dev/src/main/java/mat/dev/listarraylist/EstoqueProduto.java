package mat.dev.listarraylist;

public class EstoqueProduto {

	public static void main(String[] args) {

		Produtos produtos = new Produtos("Teclado", 6000, 54);

		produtos.adicionarEstoque(50);
		produtos.removerEstoque(60);
		System.out.println(produtos.desconto(15));
	}

}
