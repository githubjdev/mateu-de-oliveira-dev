package mat.dev.solid.dip;

public class PostgreSQL implements Banco {

	@Override
	public void conectart() {
		System.out.println("Conectando no PostgreSQL");
	}

	@Override
	public void desconectart() {
		
	}

}
