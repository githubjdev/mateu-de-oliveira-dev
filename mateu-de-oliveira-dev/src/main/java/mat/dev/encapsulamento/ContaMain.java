package mat.dev.encapsulamento;

public class ContaMain {

	public static void main(String[] args) throws Exception {
		Conta conta = new Conta();
		
		conta.depositar(100);
		System.out.println("Meu saldo: " + conta.getSaldo());

		conta.sacar(50);
		System.out.println("Meu saldo: " + conta.getSaldo());
		
		

	}

}
