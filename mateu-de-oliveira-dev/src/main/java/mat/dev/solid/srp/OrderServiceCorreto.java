package mat.dev.solid.srp;

public class OrderServiceCorreto {

	private OrderRepository orderRepository = new OrderRepository();
	private EmailService emailService = new EmailService();

	public void processarPedido() {
		orderRepository.salvarPedido();
		emailService.enviarEmailConfirmacao();
	}

}
