package matrix.impl;

import java.util.Arrays;

import matrix.interfaces.Matrix;

public class ArrayMatrix extends AbstractMatrix {
	
	private double[][] repr; //Speichert die elemente

	
	public ArrayMatrix(int n) {
		super(n);
		repr = new double[n][n]; //array auf die größe initialisieren und mit nullen befüllen.
	}

	@Override
	public Matrix nullMatrix() {
		return new ArrayMatrix(n);
	}

	@Override
	public double get(int i, int j) {
		return repr[i][j];
	}

	@Override
	public void set(int i, int j, double val) {
		repr[i][j] = val;
	}
	
	@Override
	public String toString() {
		return "ArrayMatrix(dim=" + super.n + " , " + "repr="  + Arrays.deepToString(repr) + ")";  
	}
	
	@Override 
	public boolean equals(Object o) {
		if(this == o) return true; 
		else 
			if(!(o instanceof ArrayMatrix)) return false; 
			else {
				ArrayMatrix that = (ArrayMatrix) o;
				return this.n == that.n && Arrays.deepEquals(repr, that.repr);
			}
	}

}
