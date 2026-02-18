package mat.dev.exception;

public class Ex1 {

	public static void main(String[] args) throws Exception {

		/* Simulação com 600 conta a receber */
		System.out.println("Inicio do programa");

		int a = 10;
		int b = 0; /* Vai vim do banco de dados com inumeros valores diferentes */

		if (b <= 0) {
			throw new Exception("Variavel b não pode ser zero(0) para realizar a divisão correta.");
		}

		int resultado = a / b;

		System.out.println("Resultado: " + resultado);

		System.out.println("Fim do programa");

	}

}
