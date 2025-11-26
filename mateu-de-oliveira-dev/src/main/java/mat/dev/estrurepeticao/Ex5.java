package mat.dev.estrurepeticao;

public class Ex5 {

	public static void main(String[] args) {

		int[] notas = { 10, 20, 30, 40 };
		

		 //for-each → quando só precisa do valor
		 for (int n : notas) {
			System.out.println("Nota : "+ n);
		 }
		 
		 System.out.println("--------------------------");
		 
		 
		//for → quando precisa do índice numero
		 for (int i = 0; i < notas.length; i++) {
			System.out.println("Nota idx: " + notas[i]);
		 }

	}

}
