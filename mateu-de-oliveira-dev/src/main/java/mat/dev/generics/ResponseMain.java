package mat.dev.generics;

import mat.dev.encapsulamento.Produto;

public class ResponseMain {

	public static void main(String[] args) throws Exception {


		
		Response<Produto> response = new Response<Produto>(new Produto("Teclado"), 
                                                 "Processado com sucesso");
		
		
		/*Captura a msg*/
		System.out.println(response.getMessage());
		System.out.println(response.getData().getNome());
		

	}

}
