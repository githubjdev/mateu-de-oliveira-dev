package mat.dev.abstracao;

public class Pg_Pix extends Pagamento{

	

	public Pg_Pix(double valor) {
		super(valor);
		// TODO Auto-generated constructor stub

	}

	@Override
	public String EfetuarPagamento() {
		// TODO Auto-generated method stub
		return " pix estantaneo;";
	}

	public void MensagemDeProcessamento() {
		System.out.println("Estamos processando seu pagamento . . .");
	}


	public String confirmarPagamento() {
		return (" Pagamento realizado com sucesso");
	}

}
