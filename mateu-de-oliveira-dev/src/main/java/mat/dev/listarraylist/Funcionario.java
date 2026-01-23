package mat.dev.listarraylist;

public class Funcionario {

	private String nome;
	private String departamento;

	public Funcionario(String nome, String departamento) {
		super();
		this.nome = nome;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

}
