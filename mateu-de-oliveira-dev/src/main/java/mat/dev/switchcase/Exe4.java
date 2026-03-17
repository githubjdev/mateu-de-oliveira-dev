package mat.dev.switchcase;

import java.util.Scanner;

public class Exe4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("===Menu===");
		System.out.println("1 - Consultar saldo");
		System.out.println("2 - Depositar");
		System.out.println("3 - Sacar");
		System.out.println("0 - Sair");
		System.out.println("Escolher uma opcao:");

		int opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			System.out.println("Consultar saldo...");
			break;
		case 2:
			System.out.println("Realizando deposito");
			break;
		case 3:
			System.out.println("Realizando saque");
			break;
		case 0:
			System.out.println("Saindo do sistema");
			break;


		default:
			System.out.println("Opcao invalida");
			break;
		}

	}

}
