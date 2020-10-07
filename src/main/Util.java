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

	//Número de vértices da matriz
	public static final int VERTICES = 5;
	
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
	
}