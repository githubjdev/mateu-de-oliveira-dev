package atividadeArray2_0;

import java.util.Scanner;

public class CBancariaExe {

	public static void main(String[] args) {

		ContaBancaria minhaContaBancaria = new ContaBancaria("Mateus");

		double[] transacoes = new double[6];


		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < transacoes.length; i++) {
			System.out.println("Digite o valor gasto na: " + minhaContaBancaria.getDiaSemana()[i]);
			transacoes[i] = scanner.nextDouble();
		}


		minhaContaBancaria.preencherTransacoes(transacoes);
		System.out.println(minhaContaBancaria.mostrarTransacoes());


	}

}
