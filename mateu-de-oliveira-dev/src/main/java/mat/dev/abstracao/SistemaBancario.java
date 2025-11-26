package mat.dev.abstracao;

public class SistemaBancario {

	public static void main(String[] args) {
		
		 /*Teste Git*/

			Pagamento pix = new Pg_Pix(1000);
		
		pix.EfetuarPagamento();
		pix.confirmarPagamento();


		Pagamento boleto = new Pg_Boleto(5000);

		boleto.EfetuarPagamento();
		boleto.confirmarPagamento();


		Pagamento cartao = new Pg_Cartao(2500);

		cartao.EfetuarPagamento();
		cartao.confirmarPagamento();


		processarPagamento(pix);
		processarPagamento(boleto);
		processarPagamento(cartao);

	}


	public static void processarPagamento(Pagamento pagamento) {

		System.out.println(
				pagamento.EfetuarPagamento() + "" + pagamento.confirmarPagamento() + " no valor de " + pagamento.valor);
				
		System.out.println("-------------------------------------------------------------------------");
	}
}
