package matrix.impl;

import matrix.interfaces.Matrix;

abstract class AbstractMatrix implements Matrix {

	@Override
	public Matrix add(Matrix m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix mul(double scalar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix mul(Matrix m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix pot(Matrix m, int exponent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public abstract double get(int i, int j);

	@Override
	public abstract void set(int i, int j, double val);
}
