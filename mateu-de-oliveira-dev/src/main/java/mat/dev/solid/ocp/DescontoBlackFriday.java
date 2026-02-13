package mat.dev.solid.ocp;

public class DescontoBlackFriday implements Desconto {

	@Override
	public double calcular(double valor) {
		return valor * 0.5;
	}

}
