package main;

import java.util.Arrays;

public class DistanceCalculator {

	private double dn[][];
	private double preDn[][];
	final int INF = 1000;
	private double matrizRoteamento[][] =  { 
			{ INF,	INF,	INF,	INF,	INF }, 
			{ INF,	INF,	INF,	INF,	INF }, 
			{ INF,	INF,	INF,	INF,	INF }, 
			{ INF,	INF,	INF,	INF,	INF }, 
			{ INF,	INF,	INF,	INF,	INF }, 
	}; ;
	public static final int VERTICES = 5;

	public DistanceCalculator() {
		dn = new double[VERTICES][VERTICES];
		preDn = new double[VERTICES][VERTICES];
	}

	public void calculate(double[][] d1) {
		//Inicializa a matriz
		for (int i = 0; i < VERTICES; i++) {
			for (int j = 0; j < VERTICES; j++) {
				dn[i][j] = d1[i][j];
				preDn[i][j] = d1[i][j];
			}
		}
		//Inicializa matriz de roteamento
		for (int linha = 0 ; linha < VERTICES ; linha++) {
			for (int coluna = 0 ; coluna < VERTICES; coluna++) {
				if (d1[linha][coluna] < INF) {
					matrizRoteamento[linha][coluna] = coluna;
				}
			}
		}
		printMatrix(d1, "D1");
		printMatrix(matrizRoteamento, "R1");

		for (int iteracao = 0; iteracao < VERTICES - 2; iteracao++) { //-2
			System.out.println("--------------- Iteração " + (iteracao + 1) + "--------------- ");
			for (int linhaD1 = 0; linhaD1 < VERTICES; linhaD1++) {
				for (int colunaDn = 0; colunaDn < VERTICES; colunaDn++) {
					for (int colunaD1LinhaDn = 0; colunaD1LinhaDn < VERTICES; colunaD1LinhaDn++) {
//						if (iteracao == 0 && linhaD1 == 3) {
//							System.out.println(d1[linhaD1][colunaD1LinhaDn] + " + " + dn[colunaD1LinhaDn][colunaDn]+ " é menor que " + dn[linhaD1][colunaDn]);
//						}
						if (d1[linhaD1][colunaD1LinhaDn] + preDn[colunaD1LinhaDn][colunaDn] < dn[linhaD1][colunaDn]) {
							dn[linhaD1][colunaDn] = d1[linhaD1][colunaD1LinhaDn] + preDn[colunaD1LinhaDn][colunaDn];
							if (dn[linhaD1][colunaDn] != preDn[linhaD1][colunaDn]) {
								matrizRoteamento[linhaD1][colunaDn] = colunaD1LinhaDn;							
							}
						}
					}
				}
			}
			printMatrix(preDn, "D" + (iteracao + 1));
			//agora a dn vira pre
			for (int i = 0; i < VERTICES; i++) {
				for (int j = 0; j < VERTICES; j++) {
					preDn[i][j] = dn[i][j];
				}
			}
			printMatrix(dn, "D" + (iteracao + 2));
			printMatrix(matrizRoteamento, "R" + (iteracao + 2));
		}
//		printMatrix(matrizRoteamento, "R2");
	}
	
	//itera sobre a dn
	//se dn[colunaD1LinhaDn][colunaDn] for menor que 9999 coloca na matriz de roteamento [colunaD1LinhaDn][colunaDn] = colunaDn 
	//

	public static void printMatrix (double [][] array, String  nome) {
		System.out.println("------- " + nome + " ------- ");
		System.out.println(Arrays.deepToString(array).replace("], ", "]\n").replace("[[", "[").replace("]]", "]").replace("99999.0", "INF"));
		System.out.println();
	}

}