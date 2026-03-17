package mat.dev.switchcase;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String comando = "CRIAR";

		switch (comando) {
		case "CRIAR":
			System.out.println("Usuario criando com sucesso!");
			dados();

			break;
		case "ATUALIZAR":
			System.out.println("Cadastrato do usuario atualizado com sucesso!");
			break;
		case "DELETAR":
			System.out.println("Cadastrato do usuario atualizado com sucesso!");

		default:
			System.out.println("Comando invalido :" + " " + comando);
			break;
		}

	}

	private static void dados() {
		System.out.println("Criando dados do usuarios");
	}


}
