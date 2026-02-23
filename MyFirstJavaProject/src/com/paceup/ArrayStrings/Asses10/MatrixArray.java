//9. Create a 2D array (matrix) of integers and print the diagonal elements.
package com.paceup.ArrayStrings.Asses10;

public class MatrixArray {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Digonal Array Elements:");
		/*
		 * System.out.println(a[0][0]); 
		 * System.out.println(a[1][1]);
		 * System.out.println(a[2][2]);
		 */
		for(int i = 0 ; i <a.length; i++) {
			System.out.println(a[i][i]);
		}
	}

}
