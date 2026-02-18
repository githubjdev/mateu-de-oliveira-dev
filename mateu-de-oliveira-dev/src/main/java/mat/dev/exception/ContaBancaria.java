package mat.dev.exception;

public class ContaBancaria {

	private double saldo;

	public ContaBancaria(double saldo) {
		this.saldo = saldo;
	}

	public void sacar(double valor) throws SaldoInsuficienteException {

		if (valor > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente para sacar o valor de :" + valor);
		} else {
			saldo -= valor;
		}

	}
	
	
	public double getSaldo() {
		return saldo;
	}

}
