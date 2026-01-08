package mat.dev.listarraylist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListOrdem {

	public static void main(String[] args) {

		List<Pedido> pedidos = new ArrayList<Pedido>();

		pedidos.add(new Pedido("1", "CANCELADO"));
		pedidos.add(new Pedido("2", "PAGO"));
		pedidos.add(new Pedido("3", "ESTORNADO"));
		pedidos.add(new Pedido("4", "DEVOLVIDO"));
		pedidos.add(new Pedido("5", "ABERTO"));
		pedidos.add(new Pedido("6", "FECHADO"));

		pedidos.sort(Comparator.comparing(p -> p.status));

		for (Pedido pedido : pedidos) {
			System.out.println(pedido);
		}

	}

}
