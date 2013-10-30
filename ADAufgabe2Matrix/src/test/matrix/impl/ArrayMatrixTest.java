package test.matrix.impl;

import static org.junit.Assert.*;

import matrix.impl.ArrayMatrix;
import matrix.interfaces.Matrix;

import org.junit.Test;

public class ArrayMatrixTest {

	@Test
	public void testNullMatrix() {
		Matrix nullMatrix = new ArrayMatrix(2);
		Matrix clone = nullMatrix.nullMatrix();
		assertEquals("Nullmatrix aus neu erzeugter Matrix",nullMatrix,clone);
		
		double[][] clearArray = {{1,2},{4,5}}; //soll von nullMatrix ausgehend mit nullen "befüllt" werden.
		
		
		for(int i = 0; i < nullMatrix.dim(); i++) {
			for(int j = 0; j < nullMatrix.dim(); j++) {
				clearArray[i][j] = nullMatrix.get(i, j);
			}
		}
		
		
		assertArrayEquals("NullMatrix hat einträge aus clearArray gelöscht", new double[][]{{0,0},{0,0}}, clearArray);
		
	}

	@Test
	public void testGet() {
		Matrix one = new ArrayMatrix(1);
		assertEquals("Test Get erfolgreich herausgeholt",0.0,one.get(0, 0),1e-8);
	}

	@Test
	public void testSet() {
		Matrix one = new ArrayMatrix(1); 
		one.set(0, 0, Double.POSITIVE_INFINITY);
		
		assertEquals("Test Set erfolgreich gesetzt",Double.POSITIVE_INFINITY,one.get(0, 0),1e-8);
		
	}

	@Test
	public void testIdMatrix() {
		Matrix _2x2 = new ArrayMatrix(3);
		Matrix _2x2id = _2x2.idMatrix();
		
		assertEquals("Test IdMatrix: Die ursprüngliche matrix und die identitätsmatrix haben die gleiche dimension",
				_2x2.dim(),_2x2id.dim());
		for(int i = 0; i < _2x2.dim(); i++) {
			for(int j = 0; j < _2x2.dim(); j++) {
				if (i == j) {assertEquals(_2x2id.get(i, j), 1, 1e-16);}
				else assertEquals(_2x2id.get(i, j), _2x2.get(i, j), 1e-16);
			}
		}
	}

	@Test
	public void testCopy() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testMulDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testMulMatrix() {
		fail("Not yet implemented");
	}

	@Test
	public void testPot() {
		fail("Not yet implemented");
	}

	@Test
	public void testDim() {
		fail("Not yet implemented");
	}

}
