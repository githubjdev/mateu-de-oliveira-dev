package mat.dev.exception;

public class MainContaBancaria {

	public static void main(String[] args) throws SaldoInsuficienteException {
		
		// Intercepta todas as exceções não tratadas
		Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());
		

		ContaBancaria contaBancaria = new ContaBancaria(300);

		contaBancaria.sacar(400);
		
		System.out.println("Saldo: " + contaBancaria.getSaldo());
	}

}
