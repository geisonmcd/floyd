package main;

import java.util.Scanner;

/**
 * Classe que inicializa o programa, lẽ os dois inteiros que correspondem as cidades
 * e chama o método que aplica Floyd e imprime as matrizes
 */
public class Main {
	
	public static void main (String [] args) {
		int cidadeUm;
		int cidadeDois;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Digite a primeira cidade (Um número inteiro de 1 a 20)");
    		cidadeUm = scanner.nextInt();
        	System.out.println("Digite a segunda cidade (Um número inteiro de 1 a 20)");
    		cidadeDois = scanner.nextInt();
        }
		System.out.println();
		//Matriz a ser escolhid para o cálculo
		double [][] matriz = Util.matriz;
		DistanceCalculator dc = new DistanceCalculator(matriz.length);
		dc.calcula(matriz, Util.getVertice(cidadeUm), Util.getVertice(cidadeDois));
	}
	
}