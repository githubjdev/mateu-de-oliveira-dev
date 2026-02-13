package mat.dev.solid.dip;

public class MySQL implements Banco {

	@Override
	public void conectart() {
		System.out.println("Conectando no Mysql");
		
	}

	@Override
	public void desconectart() {
		
	}

}
