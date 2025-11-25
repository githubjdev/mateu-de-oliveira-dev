package mat.dev.abstracao;

/*
Abstração:
A classe Pagamento funciona como um molde geral.
Ela define o que todo pagamento deve ter, mas não pode ser usada diretamente.
Por isso é uma classe abstrata e possui métodos abstratos.
*/

/*
Herança:
As classes Pg_Pix, Pg_Boleto e Pg_Cartao herdam da superclasse Pagamento.
Elas aproveitam os atributos e métodos da classe mãe
e implementam apenas o que é específico de cada tipo de pagamento.
*/

/*
Polimorfismo:
Ocorre nas subclasses, porque cada uma delas implementa ou sobrescreve 
métodos como EfetuarPagamento() e confirmarPagamento() à sua própria maneira.
O nome do método é o mesmo, mas o comportamento muda de acordo com o tipo de pagamento.
*/

public abstract class Pagamento {

	protected double valor;

	public abstract String EfetuarPagamento();

	public Pagamento(double valor) {
		this.valor = valor;
	}



	public String confirmarPagamento() {
		return (" Pagamento sera compensado em 3 uteis");
	}



	public void MensagemDeProcessamento() {
		System.out.println("Estamos processando seu pagamento . . .");
	}

}
