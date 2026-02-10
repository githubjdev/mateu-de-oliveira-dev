package mat.dev.interfaces;

public class Gato implements Animal {

	@Override
	public void emitirSom() {
		System.out.println("Gato faz miau");
	}

	@Override
	public void correr() {

		System.out.println("Gato correndo");

	}

	@Override
	public void comer() {
		System.out.println("Gato está comendo");

	}

}
