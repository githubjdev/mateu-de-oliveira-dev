package mat.dev.solid.dip;

public class BancoMain {
	
	
	public static void main(String[] args) {
		
		Sistema sistema = new Sistema(new MySQL());
		sistema.conectar();
		
		
	}

}
