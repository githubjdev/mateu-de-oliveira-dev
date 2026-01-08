package mat.dev.listarraylist;

import java.util.HashMap;
import java.util.Map;

public class MainMap {
	
	public static void main(String[] args) {
		
		Map<String, Pedido> mapPedidos = new HashMap<String, Pedido>();
		
		mapPedidos.put("Alex", new Pedido("51", "CRIADO"));
		mapPedidos.put("Matheus", new Pedido("52", "PRONTO"));
		
		Pedido pedidoMatheus = mapPedidos.get("Matheus"); /*Matheus*/
		
		
		for (Pedido pedido : mapPedidos.values()) {
			System.out.println("Pedido: " + pedido.id + " -> " + pedido.status);
		}
		
		System.out.println("==================================================");
		
		for (String chave : mapPedidos.keySet()) {
			System.out.println("Pedido : " + chave + " - > " + mapPedidos.get(chave).status);
		}
		
		
	}

}
