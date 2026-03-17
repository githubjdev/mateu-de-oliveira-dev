package mat.dev.switchcase;

import java.util.Scanner;

public class Exe5 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);


		System.out.println("Informe o conceito (A,B,C,D,E):");
		String inptu = scanner.nextLine().trim().toUpperCase();

		if (inptu.length() != 1) {
			System.out.println("Entranda invalida. DIgite apenas uma lentra");
			scanner.close();
			return;
		}

		char conceito = inptu.charAt(0);

		switch (conceito) {
		case 'A':
			System.out.println("Exelente!");

			break;
		case 'B':
			System.out.println("Muito bbom!");

			break;
		case 'C':
			System.out.println("bom!");

		case 'D':
			System.out.println("Precisa melhorar!");
			break;

		case 'E':
			System.out.println("Reprovado!");

			break;


		default:
			System.out.println("Conceito invalido");
			break;
		}

	}

}
