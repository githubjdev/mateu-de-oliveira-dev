package mat.dev.whiledowhile;

import java.util.Scanner;

public class Ex2 {

	/*
	 * Vamos pedir uma nota para a pessoa enquanto ela digitar errado vamos
	 * continuar pedindo a nota
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int nota = -1;

		/* Pede a nota correta enquanto estiver digitando errado */
		while (nota < 0 || nota > 10) {
			System.out.println("Digita uma nota em 0 e 10:");
			nota = scanner.nextInt();
		}

		System.out.println("Nota correta: " + nota);
		scanner.close();

	}

}
