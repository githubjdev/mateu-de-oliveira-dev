package mat.dev.interfaces;

public class Cachorro implements Animal {

	/* Aqui dentro vai toda a regra de negocio */
	@Override
	public void emitirSom() {
		System.out.println("Cachorro faz au au");
	}

	@Override
	public void correr() {
		System.out.println("Cachorro correndo");
	}
	
	@Override
	public void dormir() {
		System.out.println("Cachorro está dormindo");
	}

	@Override
	public void comer() {
		  System.out.println("Cachorro está comendo");
	}

}
