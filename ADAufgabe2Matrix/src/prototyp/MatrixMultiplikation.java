/** Lizensiert unter WTFPL /Licensed under the WTFPL.  http://www.wtfpl.net/*/
package prototyp;

import java.util.Arrays;

public class MatrixMultiplikation {
	public static void main(String[] args) {
		double[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		double[][] matrix2 = {{2,0,3},{1,2,4},{1,0,1}};
		
		double[][] result = {{7,4,14},{19,10,38},{31,16,62}};
		
		System.out.println("mult");
		
		System.out.println(Arrays.deepToString(mult(matrix2,matrix)));
		System.out.println(Arrays.deepToString(result));
		
		System.out.println("add");
		
		System.out.println(Arrays.deepToString(add(matrix,matrix2)));
		System.out.println(Arrays.deepToString(add(matrix2,matrix)));
		System.out.println(Arrays.deepToString(new double[][]{{3,2,6},{5,7,10},{8,8,10}}));
		
		System.out.println("mult scalar"); 
		
		System.out.println(Arrays.deepToString(mult(new double[][]{{5,2},{9,12}},2)));
		System.out.println(Arrays.deepToString(new double[][]{{10,4},{18,24}}));
		
		
		
	}
	
	public static double[][] mult(double[][] a,double[][] b) {
		if(a.length != a[0].length || b.length != b[0].length) throw new IllegalArgumentException("Eine der beiden Matritzen ist nicht quadratisch");
		if(a.length != b.length) throw new IllegalArgumentException("Die matritzen haben nicht die gleiche dimension");
		
		double[][] c = new double[a.length][b.length]; //ist wayne ob jetzt a.length oder b.length, da a.length == b.length

		int n = a[0].length; //oder b.length 
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				for(int k = 0; k < n; k++) {
					c[i][j] = c[i][j] + a[i][k]*b[k][j];
				}
			}
		}
		
		return c;
		
	}
	
	// Ist diese operation quadratisch oder linear? 
	public static double[][] add(double[][] a, double[][] b) { 
		if(a.length != b.length || a[0].length != b[0].length) throw new IllegalArgumentException("Matrix A und B müssen die gleiche anzahl von spalten und zeilen haben");
		
		double[][] c = new double[a.length][b[0].length]; 
		
		for(int i = 0; i < a.length; i++ ) {
			for(int j = 0; j < a[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		} 
		
		return c;
		
	}
	
	// Ist diese operation quadratisch oder linear? 
	public static double[][] mult(double[][] m, double scalar) {
		double[][] result = new double[m.length][m[0].length];
		
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				result[i][j] = m[i][j] * scalar;
			}
		}
		
		return result;
	}
	/** Exponieren */
	public static double[][] power(double[][] m, int exponent) {
		if (exponent > 0 ) 	{return posPow(m,exponent);} // exponent ist größer 0
		else if (exponent == 0) {return identityMatrix(m);} // exponent ist 0
		else {return negPow(m,exponent);} // exponent ist negativ
	}
	
	private static double[][] posPow(double[][] m, int exponent) {
		double[][] accu = new double[m.length][m[0].length];
		accu = add(m,accu);
		int i = exponent;
		while(i > 1)  {
			accu = mult(accu,m);
			i = i - 1;
		}
		
		return accu;
		
		//return posPow(m,m,exponent);
	}
	
	private static double[][] posPow(double[][] accu, double[][] m, int exponent) {
		if (exponent <= 1) return accu;
		else return posPow(mult(m,accu),m,exponent-1);
	}
	
	public static double[][] identityMatrix(double[][] m) {
		if(!istNxnMatrix(m)) throw new IllegalArgumentException("Matrix muss quadratisch sein, um die einheitsmatrix davon bilden zu können");
		double[][] id = new double[m.length][m[0].length];
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m.length; j++) {
				if (i == j) id[i][j] = 1; //diagonale erwischt => eins schreiben
				else id[i][j] = 0; //sonst 0
 			}
		}
		
		return id;
	}
	
	private static double[][] negPow(double[][] m,int exponent) {
		//TODO implementieren
		return null;
	}
	/** Prüft ob quadratische matrix oder nicht */
	public static boolean istNxnMatrix(double[][] m) {
		//prüfen auf dem ersten und letzten index, ob die innere länge(spaltenlänge) der äußeren länge (zeilenlänge) entspricht
		return m.length == m[0].length && m.length == m[m.length-1].length; 
	}
	
	
	
	
	
	

}
