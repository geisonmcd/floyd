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

	/**
	 * Construtor
	 * @param numeroDeVertices
	 */
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
	public void calcula(double[][] d1, int verticeOrigem, int verticeDestino) {
		inicializaMatrizes(d1);
		Util.imprimeMatriz(d1, "D1");
		Util.imprimeMatriz(matrizRoteamento, "R1");
		for (int iteracao = 0; iteracao < d1.length - 2; iteracao++) {
			System.out.println("--------------- Cálculo  D" + (iteracao + 2) + " ---------------  \n");
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
			matrizDistanciaAnterior = Util.copiaMatriz(matrizDistancia);
			Util.imprimeMatriz(matrizDistancia, "D" + (iteracao + 2));
			Util.imprimeMatriz(matrizRoteamento, "R" + (iteracao + 2));
		}
		System.out.println("Custo para ir da cidade " + Util.getCidade(verticeOrigem) + " até a cidade " + Util.getCidade(verticeDestino)  + ": " + matrizDistancia[verticeOrigem][verticeDestino]);
		imprimeCidadesDoCaminho(verticeOrigem, verticeDestino);
	}

	/**
	 * Imprime o caminho que terá que ser passadao para ir da cidade origem até a destino
	 * @param verticeOrigem
	 * @param verticeDestino
	 */
	private void imprimeCidadesDoCaminho(int verticeOrigem, int verticeDestino) {
		System.out.println();
		System.out.println("Caminho que terá que ser passado para ir da cidade origem até a destino:");
		int novoVerticeOrigem = verticeOrigem;
		while (novoVerticeOrigem != verticeDestino) {
			System.out.print(Util.getCidade(novoVerticeOrigem)+ " --> ");
			novoVerticeOrigem = (int) matrizRoteamento[novoVerticeOrigem][verticeDestino];
		}
		System.out.println(Util.getCidade(verticeDestino));
	}

	/**
	 * Inicializa a matrizDistancia e a matrizDistanciaAnterior deixando elas iguais à D1.
	 * Cria a R1 colocando o valor da coluna onde é diferente de infinito
	 * @param d1
	 */
	private void inicializaMatrizes(double[][] d1) {
		for (int linha = 0; linha < d1.length; linha++) {
			for (int coluna = 0; coluna < d1.length; coluna++) {
				matrizDistancia[linha][coluna] = d1[linha][coluna];
				matrizDistanciaAnterior[linha][coluna] = d1[linha][coluna];
				if (d1[linha][coluna] < Util.INF) {
					matrizRoteamento[linha][coluna] = coluna;
				}
			}
		}
	}
	
}