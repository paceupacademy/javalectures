package com.paceup.ArraysStrings;
//Print all elements of 2d array Using Loop
public class MultiDimensionalArrayExample2 {
	public static void main(String[] args) {

		int[][] a = {
				{1, -2, 3}, 
				{-4, -5, 6, 9}, 
				{7}, 
		};

		System.out.println("Number of rows: "+a.length);
		// calculate the length of each row
		System.out.println("Length of row 1: " + a[0].length);
		System.out.println("Length of row 2: " + a[1].length);
		System.out.println("Length of row 3: " + a[2].length);
		System.out.println();
		for (int i = 0; i < a.length; ++i) {
			for(int j = 0; j < a[i].length; ++j) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("\n");
		}


	}
}
