package mat.dev.abstracao;

public class Pg_Cartao extends Pagamento {

	public Pg_Cartao(double valor) {
		super(valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String EfetuarPagamento() {
		// TODO Auto-generated method stub
		return "Cartao;";

	}

	public String confirmarPagamento() {
		return ("  pagamento no cartão");
	}


}
