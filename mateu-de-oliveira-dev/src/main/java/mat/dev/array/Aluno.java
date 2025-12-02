package mat.dev.array;

public class Aluno {

	public String nome;

	double[] notas = new double[4];

	public Aluno(String nome) {
		super();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + "]";
	}

	public String exibirNota() {
		String retorno = "";
		for (double nota : notas) {
			retorno += "" + nota + "\n";
		}
		return retorno;
	}

	public double somaNotas() {

		double somanota = 0;

		for (double nota : getNotas()) {

			somanota += nota;

		}
		return somanota;

	}

	public double media() {

		return somaNotas() / getNotas().length;
	}

}
