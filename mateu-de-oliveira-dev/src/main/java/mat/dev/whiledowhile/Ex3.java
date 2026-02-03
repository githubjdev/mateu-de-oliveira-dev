package mat.dev.whiledowhile;

import java.util.Scanner;

public class Ex3 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String resposta;
		
		do { /*Primeiro executa e depoius verifica*/
			
			System.out.println("Deseja continuar no sistema? (digite N para encerrar):");
			resposta = scanner.next();
			
		}while(!resposta.equalsIgnoreCase("n"));/*Enquanto for diferente de (n)*/
		
		
		scanner.close();
		System.out.println("Programa finalizado");
		
	}

}
