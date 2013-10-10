package matrix.interfaces;

public interface Matrix {
	/** Die Grundoperationen einer Matrix sind die Initialisierung (wie), die Addition,
	 * die skalare Multiplikation, die (Matrix-)Multiplikation und die Potenzierung.
	 */
	
	Matrix add(Matrix m);
	
	Matrix mul(double scalar);
	
	Matrix mul(Matrix m);
	
	Matrix pot(Matrix m,int exponent);
	
	/** Au�erdem habe ich zugriff �ber indizes und �nderung �ber indizes definiert **/
	double get(int i, int j); 
	
	void set(int i, int j, double val);

}
