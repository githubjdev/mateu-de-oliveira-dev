package mat.dev.listarraylist;

import java.util.HashMap;
import java.util.Map;

public class MapPutIfAbsent {
	
	public static void main(String[] args) {
		
		//mapPedidos.put("Alex", new Pedido("51", "CRIADO"));
		//mapPedidos.put("Matheus", new Pedido("52", "PRONTO"));
		
		Map<String, Pedido> mapPedidos = new HashMap<String, Pedido>();
		mapPedidos.putIfAbsent("Alex", new Pedido("51", "CRIADO"));
		mapPedidos.putIfAbsent("Alex Fernando", new Pedido("52", "PRONTO"));
		/*Não deixa substituir se a chave já existe*/
		
		
		for (String chave : mapPedidos.keySet()) {
			System.out.println("Pedido : " + chave + " - > " + mapPedidos.get(chave).status);
		}
		
	}

}
