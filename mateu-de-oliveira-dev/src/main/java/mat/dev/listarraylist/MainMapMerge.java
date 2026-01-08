package mat.dev.listarraylist;

import java.util.HashMap;
import java.util.Map;

import mat.dev.array.Aluno;

public class MainMapMerge {

	public static void main(String[] args) {
		Map<String, Integer> mapSoma = new HashMap<String, Integer>();

		Aluno alex = new Aluno("Alex");
		Aluno matheus = new Aluno("Matheus");

		mapSoma.merge(alex.nome, 50, Integer::sum);
		mapSoma.merge(alex.nome, 20, Integer::sum);
		mapSoma.merge(alex.nome, 90, Integer::sum);

		mapSoma.merge(matheus.nome, 10, Integer::sum);
		mapSoma.merge(matheus.nome, 500, Integer::sum);
		mapSoma.merge(matheus.nome, 1500, Integer::sum);

		System.out.println("Soma " + alex.nome + ": " + mapSoma.get(alex.nome));
		System.out.println("Soma " + matheus.nome + ": " + mapSoma.get(matheus.nome));
	}

}
