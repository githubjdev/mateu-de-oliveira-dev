package mat.cleancode;

public class Usuario {
	
	private static final int MAIOR_DE_IDADE = 18;
	
	private String nome;
	private int idade;
	
	
	public boolean maiorDeIdade() {
		return idade >= MAIOR_DE_IDADE;
	}
	
	
	public String msgDeAutorizacao (int idade) {
		return idade >= MAIOR_DE_IDADE ? "ok, autorizado" : "Não autorizado";
	}
	
	
	public int getIdade() {
		return idade;
	}
	

}
