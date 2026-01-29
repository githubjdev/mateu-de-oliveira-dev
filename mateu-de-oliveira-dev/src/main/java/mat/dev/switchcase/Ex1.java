package mat.dev.switchcase;

public class Ex1 {

	public static void main(String[] args) {

		// 1 - Domingo
		// 2 - Segunda
		// 3 - Terça

		int dia = 0; /* Vem de um cadastro ou banco de dados */
		String nomeDia;

		switch (dia) {
			case 1:
				nomeDia = "Domingo";
				break;
			case 2:
				nomeDia = "Segunda";
				break;
			case 3:
				nomeDia = "Terça - feira";
				break;
			default:
				nomeDia = "Dia não encontrado";
				break;
		}

		System.out.println("dia da semana: " + nomeDia);

	}

}
