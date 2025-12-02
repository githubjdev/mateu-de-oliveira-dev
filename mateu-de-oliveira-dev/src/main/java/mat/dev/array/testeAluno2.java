package mat.dev.array;

public class testeAluno2 {

	public static void main(String[] args) {

		Aluno aluno = new Aluno("mateus");

		aluno.setNotas(new double[] { 20.00, 45.00, 68.45, 87.69 });

		System.out.println("Notas do aluno " + aluno.exibirNota());

		System.out.println("Soma das notas " + aluno.somaNotas());

		System.out.println(aluno + " Tirou a media de " + aluno.media());

	}

}
