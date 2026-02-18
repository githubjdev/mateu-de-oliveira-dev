package mat.dev.exception;

public class Ex2 {

	public static void main(String[] args) {

		int a = 10;
		int b = 0;

		int resultado = 0;
		
		try {
			resultado = a / b;
		} catch (ArithmeticException e) {
			b = 10;
		}

		resultado = a / b;
		System.out.println("Resultado: " + resultado);

	}

}
