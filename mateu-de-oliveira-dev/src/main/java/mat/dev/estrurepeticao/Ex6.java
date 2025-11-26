package mat.dev.estrurepeticao;

import java.util.Scanner;

public class Ex6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] valores = new int[5];

		for (int i = 0; i < valores.length; i++) {
			System.out.println("QUal o numero: " + i + " ?");
			valores[i] = sc.nextInt();
		}

		System.out.println("=================================");
		System.out.println("Valores digitados");

		for (int v : valores) {
			System.out.println(v);
		}
		
		
		int soma = 0;
		
		for (int v : valores) {
			soma += v;
		}
		
		System.out.println("Total da soma: " + soma);
		System.out.println("Média: " + soma / valores.length);
		
		
		int maior = valores[0];
		
		for (int v : valores) {
			if (v > maior) {
				maior = v;
			}
		}
		
		System.out.println("Maior numero: " + maior);

	}

}
