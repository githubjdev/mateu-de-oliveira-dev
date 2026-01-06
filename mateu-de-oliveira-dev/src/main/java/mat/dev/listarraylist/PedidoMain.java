package mat.dev.listarraylist;

import java.util.ArrayList;
import java.util.List;

public class PedidoMain {

	public static void main(String[] args) {

		List<Pedido> pedidos = new ArrayList<Pedido>();

		pedidos.add(new Pedido("P1", "OK"));
		pedidos.add(new Pedido("P2", "CANCELADO"));
		pedidos.add(new Pedido("P3", "OK"));
		pedidos.add(new Pedido("P4", "CANCELADO"));
		pedidos.add(new Pedido("P5", "ENTREGUE"));
		
		for (Pedido pedido : pedidos) {
			System.out.println(pedido);
		}

		System.out.println("=========================================================================");

		pedidos.removeIf(p -> p.getStatus().equals("CANCELADO"));

		for (Pedido pedido : pedidos) {
			System.out.println(pedido);
		}

	}

}
