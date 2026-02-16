package mat.dev.record;

record Dinheiro(double valor, String moeda) {

	public Dinheiro {

		if (valor <= 0) {
			throw new IllegalArgumentException("Valor inválido");
		}

		if (moeda == null || moeda.isBlank()) {
			throw new IllegalArgumentException("Moeda obrigatória");
		}

	}

}
