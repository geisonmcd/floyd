package main;

public class Main {
	
	public static void main (String [] args) {
		double [][] matriz = Util.matriz;
		DistanceCalculator dc = new DistanceCalculator(matriz.length);
		dc.calcula(matriz);
	}

}