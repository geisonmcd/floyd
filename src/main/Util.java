package main;

/**
 * Classe utilitária que tem as constantes usadas no programa
 * como as matrizes usadas para teste, a matriz de distâncias das cidades, 
 * métodos de impressão e cópia, entre outros
 * 
 */
public class Util {
	
	//Valor a ser usado como infinito
	static final int INF = 99999;

	//Matriz do exemplo 1 da apostila
	static int[][] matriz = { 
			{ 0,	6,		INF,	10,		4 }, 
			{ INF, 	0,		9,   	INF,	INF }, 
			{ INF,	INF,	0,		INF,  	2 }, 
			{ 5, 	INF, 	3, 		0, 		1 }, 
			{ INF, 	1, 		INF, 	2, 		0 } 
	};
	
	//Matriz do exemplo 2 da apostila 
	//(double, tem que mudar todos os tipos para double para funcionar)
	static double [][] matriz2 = { 
			{ 0,	1,		INF,	0.5,	INF }, 
			{ INF, 	0,		1,   	INF,	1 	}, 
			{ INF,	INF,	0,		INF,	5	}, 
			{ 1,	3,		INF, 	0,		1 	}, 
			{ INF, INF, 	INF, 	1, 		0 	} 
	}; 
	
	/**
	 * Matriz da distância entre as cidades
	 */
	static int [][] matrizCidades = { 
		//1    2	3	 4    5    6    7    8    9    10   11   12   13   14   15   16   17   18   19   20	
		{ 000, INF, INF, 861, INF, 211,	INF, INF, INF, 586,	INF, 753, 382, 896, INF, INF, INF, INF, INF, INF }, 
		{ INF, 000,	423, 617, 365, INF,	INF, INF, INF, 357,	INF, INF, 806, INF, INF, INF, INF, INF, INF, INF }, 
		{ INF, 423,	000, 554, 359, INF,	INF, INF, INF, 306,	INF, INF, INF, INF, INF, INF, INF, INF, INF, INF }, 
		{ 861, 617,	554, 000, INF, INF,	INF, INF, INF, 656,	INF, INF, INF, INF, INF, INF, INF, INF, INF, INF }, 
		{ INF, 365,	359, INF, 000, INF,	INF, INF, INF, INF,	INF, INF, INF, INF, INF, INF, INF, INF, INF, INF },
		{ 211, INF,	INF, INF, INF, 000,	988, INF, 293, 102,	INF, 870, 399, INF, INF, INF, INF, INF, INF, INF },
		{ INF, INF,	INF, INF, INF, 988,	000, 228, 043, INF,	573, 663, INF, INF, INF, INF, INF, INF, INF, INF }, 
		{ INF, INF,	INF, INF, INF, INF,	228, 000, 801, INF,	031, INF, INF, INF, INF, INF, INF, INF, INF, INF }, 
		{ INF, INF,	INF, INF, INF, 293,	043, 801, 000, 724,	927, 936, INF, INF, 696, INF, INF, INF, INF, INF }, 
		{ 586, 357,	306, 656, INF, 102,	INF, INF, 724, 000,	INF, 736, 672, 804, INF, INF, INF, INF, INF, INF },
		{ INF, INF,	INF, INF, INF, INF,	573, 031, 927, INF,	000, 634, INF, INF, 927, INF, INF, INF, INF, INF }, 
		{ 753, INF,	INF, INF, INF, 870,	663, INF, 936, 736,	634, 000, 844, 071, 798, INF, 713, INF, INF, INF }, 
		{ 382, 806,	INF, INF, INF, 399,	INF, INF, INF, 672,	INF, 844, 000, 021, INF, 299, INF, INF, INF, INF }, 
		{ 896, INF,	INF, INF, INF, INF,	INF, INF, INF, 804,	INF, 071, 021, 000, 244, 447, 726, INF, INF, INF }, 
		{ INF, INF,	INF, INF, INF, INF,	INF, INF, 696, INF,	927, 798, INF, 244, 000, INF, 387, INF, INF, INF }, 
		{ INF, INF,	INF, INF, INF, INF,	INF, INF, INF, INF,	INF, INF, 299, 447, INF, 000, 503, 113, 431, INF }, 
		{ INF, INF,	INF, INF, INF, INF,	INF, INF, INF, INF,	INF, 713, INF, 726, 387, 503, 000, 916, 490, INF }, 
		{ INF, INF,	INF, INF, INF, INF,	INF, INF, INF, INF,	INF, INF, INF, INF, INF, 113, 916, 000, 980, 326 }, 
		{ INF, INF,	INF, INF, INF, INF,	INF, INF, INF, INF,	INF, INF, INF, INF, INF, 431, 490, 980, 000, 455 }, 
		{ INF, INF,	INF, INF, INF, INF,	INF, INF, INF, INF,	INF, INF, INF, INF, INF, INF, INF, 326, 455, 000 }
	}; 

	/**
	 * Imprime o array bidimensional no console.
	 * @param array a ser impresso
	 * @param nome do array
	 */
	static void imprimeMatriz (int[][] array, String  nome) {
		System.out.println("--------------------------------------------------------- " + nome + " ---------------------------------------------------------");
		for (int linha = 0; linha < array.length; linha++) {
			for (int coluna = 0; coluna < array.length; coluna++) {
				String valor;
				if (nome.charAt(0) == 'D') {
					valor = String.format("%04d", array[linha][coluna]);
					if (valor.equals(Util.INF+"")) valor = "INFI";
				} else {
					valor = String.format("  %02d", array[linha][coluna]);
					if (valor.equals("  " + Util.INF)) valor = "    ";
				}
				System.out.print(valor);
				if (coluna != array.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Método que retornar uma matriz que é cópia da matriz passada como parâmetro
	 * @param matriz
	 * @return
	 */
	static int[][] copiaMatriz(int[][] matriz) {
		int[][] novaMatriz = new int[matriz.length][matriz.length];
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
	
	/**
	 * Subtrai 1 da cidade passada como parâmetro para retornar o valor do vértice
	 * @param cidade
	 * @return
	 */
	static int getVertice(int cidade) {
		return cidade -1;
	}

}