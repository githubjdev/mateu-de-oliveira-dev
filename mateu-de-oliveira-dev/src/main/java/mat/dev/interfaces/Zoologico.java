package mat.dev.interfaces;

public class Zoologico {

	/*Processa qualquer tipo de animal ou (ex: pagamento)*/
	public void iteragirComAnimal(Animal animal) {
		
		animal.emitirSom();
		animal.correr();
		animal.dormir();
		animal.comer();
		
		System.out.println("-----------------------------------------------");
	}

}
