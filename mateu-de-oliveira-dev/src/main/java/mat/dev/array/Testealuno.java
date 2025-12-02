package mat.dev.array;

import java.util.Scanner;

public class Testealuno {

	public static void main(String[] args) {

		Aluno aluno = new Aluno("Mateus");
		Aluno aluno1 = new Aluno("lucas");
		Aluno aluno2 = new Aluno("davi");
		Aluno aluno3 = new Aluno("nat");

		
		/*Tenho dificuldade de entender esse array como funciona*/
		Aluno[] arrayAlunos = new Aluno[] { aluno, aluno1, aluno2, aluno3};

		for (Aluno a : arrayAlunos) {

			
			double[] notas = new double[4];
			Scanner scanner = new Scanner(System.in);

			System.out.println("Aluno: " + a.getNome());

			
			for (int i = 0; i < notas.length; i++) {
				System.out.println("Nota " + (i + 1) + ":");
				notas[i] = scanner.nextDouble();
			}

			
			a.setNotas(notas);

			System.out.println("Notas do aluno " + a.exibirNota());
			System.out.println("Soma das notas " + a.somaNotas());
			System.out.println(a + " Tirou a media de " + a.media());
			System.out.println("-------------------------------------");

		}

	}

}
