package mat.dev.switchcase;

public class Exe6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int statusCode = 404;

		String mensagem;

		switch (statusCode) {
		case 200:
			mensagem = "OK, Requisição bem sucedida.";
			break;
		case 201:
			mensagem = "CREATED - Recurso criado com sucesso.";
			break;
		case 400:
			mensagem = "BAD REQUEST - Requisicao invalida";
			break;
		case 401:
			mensagem = "UNAUTHORIZED - Não autorizado.";
			break;
		case 404:
			mensagem = "\"NOT FOUND - Recurso não encontrado.\"";
			break;
		case 500:
			mensagem = "INTERNAL SERVER ERROR - Erro interno no servidor";
			break;

		default:
			mensagem = "Codigo HTTP desconhecido: " + statusCode;
			break;
		}

		System.out.println(mensagem);
	}

}
