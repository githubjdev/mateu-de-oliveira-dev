package mat.dev.listarraylist;

import java.util.ArrayList;
import java.util.List;

public class ListaArrayObjeto {

	public static void main(String[] args) {

		List<Object[]> objects = new ArrayList<Object[]>();
		List<Produtos> produtos = new ArrayList<Produtos>();

		objects.add(new Object[] { "Teclado", 10, 150.00, true, "Asus", "Informatica" });
		objects.add(new Object[] { "Mouse", 15, 50.00, false, "Login", "Informatica" });
		objects.add(new Object[] { "Monitor", 30, 950.00, true, "AOC", "Informatica" });

		/* Percorre cada linha da lista */
		for (Object[] obj : objects) {

			System.out.println("==============================================================");

				/* Percorre cada posição do array */
				String nome = (String) obj[0];
				int estoque = (int) obj[1];
				double valor = Double.parseDouble("" + obj[2]);
				boolean ativo = (Boolean) obj[3];
				String marca = (String) obj[4];
				String categoria = (String) obj[5];

			produtos.add(new Produtos(nome, valor, estoque, ativo, marca, categoria));

		}

		System.out.println("======Lista de produtos em classes(Objetos reais)========");
		for (Produtos prod : produtos) {
			System.out.println(prod);
		}

	}

}
