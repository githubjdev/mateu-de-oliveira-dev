package mat.dev.array;

public class SegundoMaiorNumero {

	public static void main(String[] args) {

		int[] numeros = { 10, 50, 20, 200, 600, 5, 80, 60 };

		int maior = 0;
		int segundoMaior = 0;

		for (int n : numeros) {
			if (n > maior) { /* Comara o valor anteior com o atual */

				segundoMaior = maior;
				maior = n; /* Se atual for maior, atribui a várial maior */

			} else if (n != maior && n > segundoMaior) {
				segundoMaior = n;
			}
		}

		System.out.println("Maior numero: " + maior);
		System.out.println("Segundo Maior: " + segundoMaior);

	}

}
