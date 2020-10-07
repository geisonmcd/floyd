package main;

import java.util.Arrays;

public class Main {
	
	public static void main (String [] args) {
		final int INF = 99999;
		double[][] matriz = { 
				{ 0,	6,		INF,	10,		4 }, 
				{ INF, 	0,		9,   	INF,	INF }, 
				{ INF,	INF,	0,		INF,  	2 }, 
				{ 5, 	INF, 	3, 		0, 		1 }, 
				{ INF, 	1, 		INF, 	2, 		0 } 
				}; 
		double [][] matriz2 = { 
				{ 0,	1,		INF,	0.5,	INF }, 
				{ INF, 	0,		1,   	INF,	1 	}, 
				{ INF,	INF,	0,		INF,	5	}, 
				{ 1,	3,		INF, 	0,		1 	}, 
				{ INF, INF, 	INF, 	1, 		0 	} 
		}; 
		DistanceCalculator dc = new DistanceCalculator();
		dc.calculate(matriz2);
	}
	
	public static void printMatrix (int [][] array) {
		System.out.println(Arrays.deepToString(array).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
		System.out.println("------------");
//		for (int[] x : array) {
//		   for (int y : x) {
//		        System.out.print(y + ", ");
//		   }
//		   System.out.println("");
//		}
	}

}