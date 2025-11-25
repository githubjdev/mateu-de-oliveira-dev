package mat.dev.abstracao;

public class Pg_Boleto extends Pagamento {

	public Pg_Boleto(double valor) {
		super(valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String EfetuarPagamento() {
		// TODO Auto-generated method stub
		return "Boleto;";
	}

	public void MensagemDeProcessamento() {
		System.out.println("Estamos processando seu pagamento . . .");
	}

}
