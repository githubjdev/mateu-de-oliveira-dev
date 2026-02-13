package mat.dev.solid.ocp;

public class DescontoDiaMae implements Desconto {

	@Override
	public double calcular(double valor) {
		return valor * 0.15;
	}

}
