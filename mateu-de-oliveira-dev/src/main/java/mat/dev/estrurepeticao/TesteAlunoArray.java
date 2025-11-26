package mat.dev.estrurepeticao;

import java.util.ArrayList;
import java.util.List;

public class TesteAlunoArray {
	
	
	public static void main(String[] args) {
		
		Aluno[] alunos = new Aluno[3];
		
		alunos[0] = new Aluno("Alex", 20); 
		alunos[1] =	new Aluno("Jose", 55);
		alunos[2] =	new Aluno("Pedro", 33);
		
	
		
		for (Aluno aluno : alunos) {
			System.out.println(aluno.nome + " idade : " + aluno.idade);
		}
		
		System.out.println("-------------------------------------------------");
		
		
		List<Aluno> list = new ArrayList<>();
		list.add(new Aluno("Mario", 50));
		list.add(new Aluno("POaulo", 45));
		list.add(new Aluno("Felipe", 50));
		
		for (Aluno aluno : list) {
			System.out.println(aluno.nome + " idade : " + aluno.idade);
		}
		
	}

}
