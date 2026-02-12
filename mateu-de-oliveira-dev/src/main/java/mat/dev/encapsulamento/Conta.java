package mat.dev.encapsulamento;

public class Conta {

	private double saldo = 0;

	public void depositar(double valor) throws Exception {

		if (valor <= 0) {
			throw new Exception("Valor do deposito não pode ser zero o negativo");
		}

		if (valor > 0) {
			saldo += valor;
		}
	}

	public void sacar(double valor) throws Exception {

		if (valor <= 0) {
			throw new Exception("Valor do saque não pode ser negativo ou zero");
		}

		if (valor > 0) {
			saldo -= valor;
		}
	}

	public double getSaldo() {
		return saldo;
	}

	/* Cliente que não tem limite no banco. O saldo nunca pode ser menor que zero */
	public void setSaldo(double saldo) throws Exception {

		if (saldo < 0) {
			throw new Exception("Saldo não pode ser negativo.");
		}

		this.saldo = saldo;
	}

}
