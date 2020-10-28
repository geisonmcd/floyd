package main;

import java.util.Scanner;

/**
 * Classe que inicializa o programa, lẽ os dois inteiros que correspondem as
 * cidades e chama o método que aplica Floyd e imprime as matrizes
 */
public class Main {
	
	public static void main (String [] args) {
		
		//Cidades inicializadas com -1 para jogar exceção caso dê algum erro pegando a entrada do usuário.
		int cidadeUm = -1;
		int cidadeDois = -1;
		
		//Pede para o usuário digitar as duas cidades que terão as distância calculadas
		try (Scanner scanner = new Scanner(System.in)) {
			
			System.out.println("Digite a primeira cidade (Um número inteiro de 1 a 20)");
    		cidadeUm = scanner.nextInt();
        	System.out.println("Digite a segunda cidade (Um número inteiro de 1 a 20)");
    		cidadeDois = scanner.nextInt();
    		
    		//Se o usuário digitou algum número não inteiro menor que 1 ou maior que 20 dá erro e fecha o programa.
    		if (cidadeUm < 1 || cidadeUm > 20 || cidadeDois < 1 || cidadeDois > 20) throw new Exception();
        } catch (Exception e) {
        	System.out.println("Erro: certifique-se que você inseriu números inteiros de 1 a 20");
        	System.exit(1);
        }
		System.out.println();
		//Passa no construtora a matriz D1 a ser usada para o cálculo. Fiz isso porque testei com as matrizes de exemplo usadas no slide.
		CalculadoraDistancia cd = new CalculadoraDistancia(Util.matrizCidades);
		
		//Chama o método que calcula a distância passando as cidades
		cd.calculaDistancia(Util.getVertice(cidadeUm), Util.getVertice(cidadeDois));
	}
	
}