package mat.dev.switchcase;

public class Ex2 {

	public static void main(String[] args) {
		String status = "CANCELADO"; /*Virá do banco de dados, tela e etc*/

		final String PENDENTE = "PENDENTE"; /*O final não deixa mudar o valor*/
		final String PAGO = "PAGO";
		final String CANCELADO = "CANCELADO";
		
		

		String descricao = switch (status) {
		case PENDENTE -> "Aguardando Pagamento";
		case PAGO -> "Pago";
		case CANCELADO -> {
			cancelarPedido();
			yield "Cancelado";
		}
		default -> "Não encontrado";
		};

		System.out.println("Saida: " + descricao);
		


	}

	private static void cancelarPedido() {
		System.out.println("Pedido cancelado....");

	}

}
