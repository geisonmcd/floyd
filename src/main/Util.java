package main;

import java.util.Arrays;

/**
 * Classe utilitária que tem as constantes usadas no programa
 * como as matrizes usadas para teste, a matriz de distâncias das cidades, 
 * métodos de impressão e cópia, entre outros
 * 
 */
public class Util {
	
	//Valor a ser usado como infinito
	static final int INF = 1000;

	//Matriz do exemplo 1 da apostila
	static double[][] matriz = { 
			{ 0,	6,		INF,	10,		4 }, 
			{ INF, 	0,		9,   	INF,	INF }, 
			{ INF,	INF,	0,		INF,  	2 }, 
			{ 5, 	INF, 	3, 		0, 		1 }, 
			{ INF, 	1, 		INF, 	2, 		0 } 
			};
	
	//Matriz do exemplo 2 da apostila
	static double [][] matriz2 = { 
			{ 0,	1,		INF,	0.5,	INF }, 
			{ INF, 	0,		1,   	INF,	1 	}, 
			{ INF,	INF,	0,		INF,	5	}, 
			{ 1,	3,		INF, 	0,		1 	}, 
			{ INF, INF, 	INF, 	1, 		0 	} 
	}; 
	
	static double[][] matrizRoteamento = { 
		{ INF,	INF,	INF,	INF,	INF }, 
		{ INF,	INF,	INF,	INF,	INF }, 
		{ INF,	INF,	INF,	INF,	INF }, 
		{ INF,	INF,	INF,	INF,	INF }, 
		{ INF,	INF,	INF,	INF,	INF }, 
	};

	/**
	 * Imprime o array bidimensional no console.
	 * @param array a ser impresso
	 * @param nome do array
	 */
	static void imprimeMatriz (double [][] array, String  nome) {
		System.out.println("------- " + nome + " ------- ");
		System.out.println(Arrays.deepToString(array).replace("], ", "]\n").replace("[[", "[").replace("]]", "]").replace("99999.0", "INF"));
		System.out.println();
	}
	
	/**
	 * Método que retornar uma matriz que é cópia da matriz passada como parâmetro
	 * @param matriz
	 * @return
	 */
	static double[][] copiaMatriz(double[][] matriz) {
		double[][] novaMatriz = new double[matriz.length][matriz.length];
		for (int linha = 0; linha < matriz.length; linha++) {
			for (int coluna = 0; coluna < matriz.length; coluna++) {
				novaMatriz[linha][coluna] = matriz[linha][coluna];
			}
		}
		return novaMatriz;
	}
	
	/**
	 * Soma 1 ao vértice passado como parâmetro para retornar o valor da cidade
	 * @param vertice
	 * @return
	 */
	static int getCidade(int vertice) {
		return vertice + 1;
	}
	
}