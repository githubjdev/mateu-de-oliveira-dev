package atividadeArray2_0;

public class ContaBancaria {

	// teste teste cambio

	public String titular;

	double[] transacoes = new double[6];

	String[] diaSemana = { "segunda", "terca", "quarta", "quinta", "sexta", "sabado" };
	String[] feriados = { "segunda", "terca", "quarta", "quinta", "sexta", "sabado" };


	public ContaBancaria(String titular) {
		super();
		this.titular = titular;
	}

	public String[] getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String[] diaSemana) {
		this.diaSemana = diaSemana;
	}


	public void setTransacoes(double[] transacoes) {
		this.transacoes = transacoes;
	}


	public void preencherTransacoes(double[] transacoes) {
		setTransacoes(transacoes);

	}

	public String mostrarTransacoes() {

		String retorno = "";

		retorno += "--------Transacoes Registradas----------- \n";

		for (int i = 0; i < diaSemana.length; i++) {
			retorno += diaSemana[i] + " --> foi gasto o valor de " + "R$: " + transacoes[i] + "\n";
		}

		return retorno;

	}





}
