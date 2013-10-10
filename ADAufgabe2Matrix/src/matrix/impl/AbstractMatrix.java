package matrix.impl;

import matrix.interfaces.Matrix;

abstract class AbstractMatrix implements Matrix {
	
	protected final int n; //dimensionierung der nXn-matrix
	
	AbstractMatrix(int n) {
		this.n = n;
	}
	
	@Override
	public abstract Matrix nullMatrix(); 
	
	@Override
	public Matrix idMatrix() {
		Matrix id = this.nullMatrix(); //initialisieren der matrix mit nullen
		for(int i = 0; i < this.dim(); i++) {
			for(int j = 0; j < this.dim(); i++) {
				if (i == j) id.set(i, j, 1); //diagonale erwischt => eins schreiben
				else id.set(i, j, 0); // sonst 0 schreiben.
			}
		}
		
		return id; //id ist jetzt eine identit‰tsmatrix mit dimensionierung this.dim()
	}
	
	@Override 
	/** Erzeugt eine kopie der aktuellen matrix */
	public Matrix copy() {
		Matrix result = this.nullMatrix().add(this); //nullmatrix ist das neutrale element der matrixaddition, daher geht das.
		return result;
	}

	@Override
	public Matrix add(Matrix m) {
		if(this.dim() != m.dim()) throw new IllegalArgumentException("Beide matritzen sind ungleich groﬂ");
		Matrix result = m.nullMatrix();
		
		for(int i = 0; i < m.dim(); i++) {
			for(int j = 0; j < m.dim(); j++) {
				result.set(i, j, this.get(i, j) + m.get(i, j));
			}
		}
		return result;
	}

	@Override
	public Matrix mul(double scalar) {
		Matrix result = this.nullMatrix(); 
		
		for(int i = 0; i < this.dim(); i++) {
			for(int j = 0; j < this.dim(); j++) {
				result.set(i, j, this.get(i, j) * scalar);
			}
		}
		return result;
		
	}

	@Override
	public Matrix mul(Matrix m) {
		if (this.dim() != m.dim()) throw new IllegalArgumentException("Die Matritzen haben nicht die gleiche dimension");
		
		Matrix result = m.nullMatrix();
		
		
		for(int i = 0; i < this.dim(); i++) {
			for(int j = 0; j < m.dim(); j++) {
				for(int k = 0; k < n; k++) {
					result.set(i, j, result.get(i, j) + this.get(i, j) + m.get(i, j));
				}
			}
		}
		
		return result;
		
	}

	@Override
	public Matrix pot(int exponent) {
		if (exponent > 0) return posPot(exponent);
		else if (exponent == 0) return this.idMatrix();
		else return negPot(exponent);
	}

	private Matrix negPot(int exponent) {
		// TODO Auto-generated method stub
		return null;
	}

	private Matrix posPot(int exponent) {
		Matrix accu = this.copy();
		int i = exponent; // exponent kopieren, damit er dekrementiert werden kann.
		while(i > 1) {
			accu = accu.mul(this); //suzkessives multiplizieren 
			i = i - 1; //in der rekursiven variante w‰re der exponent um 1 erniedrigt worden. 
		}
		
		return accu;
	}

	@Override
	public abstract double get(int i, int j);

	@Override
	public abstract void set(int i, int j, double val);
	
	@Override
	public int dim() {
		return n;
	}
}
