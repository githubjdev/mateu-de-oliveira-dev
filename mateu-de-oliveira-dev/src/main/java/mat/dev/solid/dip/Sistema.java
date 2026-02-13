package mat.dev.solid.dip;

public class Sistema {

	private Banco banco;

	public Sistema(Banco banco) {
		this.banco = banco;
	}
	
	
	public void conectar() {
		this.banco.conectart();
	}

}
