/** Lizensiert unter WTFPL /Licensed under the WTFPL.  http://www.wtfpl.net/*/
package prototyp;


import static org.junit.Assert.*;
import static prototyp.MatrixMultiplikation.*;

import org.junit.Test;

public class MatrixMultiplikationTest {
	
	@Test
	public void testMult3Times() {
		double[][] m1 = {{1,2},{3,4}};
		double[][] expected = {{37, 54}, {81, 118}};
		assertArrayEquals(
				"{{1,2},{3,4}}*{{1,2},{3,4}}*{{1,2},{3,4}} = {{37, 54}, {81, 118}}",
				expected, mult(mult(m1,m1),m1)
				);
	}

	@Test
	public void testPower1Pos() {
		double[][] m1 = {{1,2},{3,4}};
		double[][] expected = {{37, 54}, {81, 118}};
		assertArrayEquals("{{1,2},{3,4}}^3 = {{37, 54}, {81, 118}}",expected,power(m1,3));
	}
	
	@Test
	public void testPower2Pos() {
		double[][] oneXone = {{3}};
		double[][] expected = {{9}};
		assertArrayEquals("{{3}}^2 = {{9}}",expected,power(oneXone,2));
	}

	@Test
	public void testIdentityMatrix2() {
		double[][] m1 = new double[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		double[][] identity4x4 = new double[][] {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		assertArrayEquals(MatrixMultiplikation.identityMatrix(m1), identity4x4);
	}
	
	@Test
	public void testIdentityMatrix() {
		double[][] m1 = new double[2][2];
		double[][] identity2x2 = new double[][] {{1,0},{0,1}};
		assertArrayEquals(MatrixMultiplikation.identityMatrix(m1), identity2x2);
	}

}
