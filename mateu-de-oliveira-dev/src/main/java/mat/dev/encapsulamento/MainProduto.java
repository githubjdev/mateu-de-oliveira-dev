package mat.dev.encapsulamento;

public class MainProduto {
	
	public static void main(String[] args) throws Exception {
		
		Produto produto = new Produto("Teclado");
		
		produto.adicionarEstoque(20);
		System.out.println("Estoque atual: " + produto.getEstoque());
		
		produto.removerEstoque(10);
		System.out.println("Estoque atual: " + produto.getEstoque());
		
	}

}
