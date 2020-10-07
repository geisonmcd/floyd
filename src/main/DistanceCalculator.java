package main;

public class DistanceCalculator {

	
	/**
	 * Matriz de distância a a ser calculada: D2, D3, D4, etc.
	 */
	private double matrizDistancia[][];
	
	/**
	 * Matriz de distância anterior à matriz de distância. 
	 * Ex.: Se estiver calculando a D3 ela vai conter a D2.
	 */
	private double matrizDistanciaAnterior[][];
	
	/**
	 * Matriz de roteamento a ser calculada: R1, R2, etc.
	 */
	private double matrizRoteamento[][];

	public DistanceCalculator(int numeroDeVertices) {
		matrizDistancia = new double[numeroDeVertices][numeroDeVertices];
		matrizDistanciaAnterior = new double[numeroDeVertices][numeroDeVertices];
		matrizRoteamento = Util.matrizRoteamento;
	}

	/**
	 * Método principal do algorítimo que recebe um array bidimensional e aplica o 
	 * algorítmo de floyd nele calculando as matrizes de distância e de roteamento de todos os passos.
	 * @param d1 um array bidimensional de double
	 */
	public void calcula(double[][] d1) {
		//Inicializa a matriz
		for (int i = 0; i < d1.length; i++) {
			for (int j = 0; j < d1.length; j++) {
				matrizDistancia[i][j] = d1[i][j];
				matrizDistanciaAnterior[i][j] = d1[i][j];
				if (d1[i][j] < Util.INF) {
					matrizRoteamento[i][j] = j;
				}
			}
		}
		Util.imprimeMatriz(d1, "D1");
		Util.imprimeMatriz(matrizRoteamento, "R1");
		for (int iteracao = 0; iteracao < d1.length - 2; iteracao++) { //-2
			System.out.println("--------------- Iteração " + (iteracao + 1) + " --------------- ");
			for (int linhaD1 = 0; linhaD1 < d1.length; linhaD1++) {
				for (int colunaDn = 0; colunaDn < d1.length; colunaDn++) {
					for (int colunaD1LinhaDn = 0; colunaD1LinhaDn < d1.length; colunaD1LinhaDn++) {
						if (d1[linhaD1][colunaD1LinhaDn] + matrizDistanciaAnterior[colunaD1LinhaDn][colunaDn] < matrizDistancia[linhaD1][colunaDn]) {
							matrizDistancia[linhaD1][colunaDn] = d1[linhaD1][colunaD1LinhaDn] + matrizDistanciaAnterior[colunaD1LinhaDn][colunaDn];
							if (matrizDistancia[linhaD1][colunaDn] != matrizDistanciaAnterior[linhaD1][colunaDn]) {
								matrizRoteamento[linhaD1][colunaDn] = colunaD1LinhaDn;							
							}
						}
					}
				}
			}
			for (int i = 0; i < d1.length; i++) {
				for (int j = 0; j < d1.length; j++) {
					matrizDistanciaAnterior[i][j] = matrizDistancia[i][j];
				}
			}
			Util.imprimeMatriz(matrizDistancia, "D" + (iteracao + 2));
			Util.imprimeMatriz(matrizRoteamento, "R" + (iteracao + 2));
		}
	}
	
}