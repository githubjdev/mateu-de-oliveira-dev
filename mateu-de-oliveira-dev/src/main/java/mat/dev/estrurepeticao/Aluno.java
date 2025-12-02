package mat.dev.estrurepeticao;

public class Aluno {

	String nome;
	int idade;
	
	
	double[] nota = new double[4];

	public Aluno(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNota(double[] nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + "]";
	}

}
