package mat.dev.interfaces;

public interface Animal extends SerVivo, Planeta {

	/* Cada animal vai emitir seu próprio som */
	public void emitirSom();
	
	public void correr();

	default void dormir() {
		System.out.println("Animal dormindo.");
	}

}
