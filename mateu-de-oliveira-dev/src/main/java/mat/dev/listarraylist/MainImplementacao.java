package mat.dev.listarraylist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainImplementacao {

	public static void main(String[] args) {

		List<Pedido> list = new ArrayList<Pedido>();
		Pedido pedido = new Pedido("3", "Cancelado");

		list.add(new Pedido("1", "Aberto"));
		list.add(new Pedido("2", "Fechado"));
		list.add(pedido);
		list.add(3, new Pedido("4", "Concluido"));
		
		
	
	    Pedido removidoPrimeiro  = 	list.removeFirst();
	    Pedido removidoUltimo  = 	list.removeLast();
		
		

		List<Pedido> concluido = new ArrayList<Pedido>();
		List<Pedido> outros = new ArrayList<Pedido>();

		for (Pedido p : list) {
			if (p.concluido()) {
				concluido.add(p);
			}else {
				outros.add(p);
			}
		}
		
		
		
		
		
		
		
		
		Set<Pedido> todos = new HashSet<Pedido>();
		todos.addAll(concluido);
		todos.addAll(outros);
		todos.addAll(list);
		
		for (Pedido p2 : todos) {
			System.out.println(p2);
		}

	}

}
