package mat.dev.solid.ocp;

public class DescontoNatal implements Desconto {

	@Override
	public double calcular(double valor) {
		return valor * 0.9;
	}

}
