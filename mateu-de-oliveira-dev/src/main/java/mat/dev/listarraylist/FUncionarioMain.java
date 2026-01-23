package mat.dev.listarraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FUncionarioMain {

	public static void main(String[] args) {

		List<Funcionario> funcionarios = List.of(new Funcionario("Alex", "TI"), 
				                         new Funcionario("Pedro", "TI"),
				                         new Funcionario("Matheus", "TI"), 
				                         new Funcionario("Joao", "RH"),
				                         new Funcionario("Maria", "RH"));

		Map<String, List<Funcionario>> funcionariosGrupo = new HashMap<String, List<Funcionario>>();
		
		/*funcionariosGrupo.put("RH", List.of(new Funcionario("Joao", "RH"),
				                    new Funcionario("Maria", "RH")));*/
		

		for (Funcionario f : funcionarios) { /*Agrupamento pelas chaves*/
			funcionariosGrupo.computeIfAbsent(f.getDepartamento(), K -> new ArrayList<Funcionario>()).add(f);
		}
		
		

		for (String key : funcionariosGrupo.keySet()) { /*Percorrendo as chaves*/

			List<Funcionario> funcGrupo = funcionariosGrupo.get(key); /*Pegando a lista de Func. de cada departamento (Chave)*/

			System.out.println("===========" + key + "=========");
			
			for (Funcionario funcionario : funcGrupo) { /*A lista por chave*/
				System.out.println("Nome : " + funcionario.getNome() + " - Departamento: " + funcionario.getDepartamento());
			}

		}

	}
	
	/*select nome, departamento from funcionario groupy by departamento*/

}
