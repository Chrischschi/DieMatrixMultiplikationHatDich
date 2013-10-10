package matrix.interfaces;

public interface Matrix {
	/** Die Grundoperationen einer Matrix sind die Initialisierung (wie), die Addition,
	 * die skalare Multiplikation, die (Matrix-)Multiplikation und die Potenzierung.
	 */
	
	/** es gibt drei arten der initialisierung einer neuen matrix basierend auf einer anderen,
	 * nullMatrix, idMatrix und copy
	 */
	
	/** nullMatrix liefert eine matrix von nullen, welche die gleiche dimensionierung wie die reciever-matrix hat  */
	abstract Matrix nullMatrix(); 
	
	/** idMatrix liefert die der aktuellen matrix zu grunde liegende identit�tsmatrix. */
	Matrix idMatrix();
	
	
	/** copy liefert eine kopie der aktuellen matrix, pseudoinitialisierung */
	abstract Matrix copy();
	
	Matrix add(Matrix m);
	
	Matrix mul(double scalar);
	
	Matrix mul(Matrix m);
	
	Matrix pot(int exponent);
	
	/** Au�erdem habe ich zugriff �ber indizes und �nderung �ber indizes definiert **/
	abstract double get(int i, int j); 
	
	abstract void set(int i, int j, double val);
	
	/** und die gr��e/dimensionierung der quadratischen matrix */
	int dim();
	

}
