package mat.dev.listarraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncionarioMain2 {

	public static void main(String[] args) {

		List<Funcionario> funcionarios = List.of(new Funcionario("Alex", "TI"), 
				new Funcionario("Pedro", "TI"),
				new Funcionario("Matheus", "TI"),
				new Funcionario("Joao", "RH"), 
				new Funcionario("Maria", "RH"));

		Map<String, List<Funcionario>> grupo = new HashMap<>();

		for (Funcionario f : funcionarios) {

			String chave = f.getDepartamento(); // TI, RH, etc

			if (!grupo.containsKey(chave)) {
				grupo.put(chave, new ArrayList<>());
			}

			grupo.get(chave).add(f);
		}
		
		
		for (String key : grupo.keySet()) { /*Percorrendo as chaves*/

			List<Funcionario> funcGrupo = grupo.get(key); /*Pegando a lista de Func. de cada departamento (Chave)*/

			System.out.println("===========" + key + "=========");
			
			for (Funcionario funcionario : funcGrupo) { /*A lista por chave*/
				System.out.println("Nome : " + funcionario.getNome() + " - Departamento: " + funcionario.getDepartamento());
			}

		}

	}

}
