package mat.dev.interfaces;

public class MainInterface {
	
	public static void main(String[] args) {
		
		
		Animal cachorro = new Cachorro();
		Animal gato = new Gato();
		
		/*cachorro.emitirSom();
		cachorro.correr();
		cachorro.dormir();*/
		
		System.out.println("-----------------------------------------------");
		
		/*gato.emitirSom();
		gato.correr();
		gato.dormir();*/
		
		Zoologico zoologico = new Zoologico();
		zoologico.iteragirComAnimal(gato);
		zoologico.iteragirComAnimal(cachorro);
		
		
		
	}

}
