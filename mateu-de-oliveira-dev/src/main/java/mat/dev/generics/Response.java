package mat.dev.generics;

public class Response<T> {

	private T data; /* produto, venda, pessoa, nota fiscal */
	private String message;

	/*Recebe qualquer objeto e uma msg*/
	public Response(T data, String message) {
		super();
		this.data = data;
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

}
