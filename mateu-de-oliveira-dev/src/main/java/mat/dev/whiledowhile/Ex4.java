package mat.dev.whiledowhile;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {

			System.out.println("=======MENU=======");
			System.out.println("=======1 - cadatrar=======");
			System.out.println("=======2 - listar=======");
			System.out.println("=======0 - sair=======");
			System.out.println("=======Escolha: =======");
			opcao = scanner.nextInt();
			
			if (opcao == 2) {
				System.out.println("Informe os dados do cadastro.");
			}

		} while (opcao != 0); /*Enquanto for diferente de zero*/

		scanner.close();
		System.out.println("Sistema finalizada.");

	}

}
