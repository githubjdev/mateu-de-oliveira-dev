package mat.dev.listarraylist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainHashSet {

	public static void main(String[] args) {

		List<String> email = new ArrayList<String>();	

		email.add("alex@gmail.com");
		email.add("joao@gmail.com");
		email.add("alex@gmail.com");

		System.out.println(email);
		
		System.out.println("====================================================");
		
		Set<String> emaiLSet = new HashSet<String>(email);
		
		System.out.println(emaiLSet);
		
		
		System.out.println("====================================================");
		
		Set<Pedido> pedidosSet = new HashSet<Pedido>();
		pedidosSet.add(new Pedido("P1", "OK"));
		pedidosSet.add(new Pedido("P2", "CANCELADO"));
		pedidosSet.add(new Pedido("P2", "CANCELADO"));
		pedidosSet.add(new Pedido("P3", "OK"));
		pedidosSet.add(new Pedido("P5", "ENTREGUE"));
		
		Object[] objects = pedidosSet.toArray();
		
		for (Object object : objects) {
			System.out.println(object);
		}

	}

}
