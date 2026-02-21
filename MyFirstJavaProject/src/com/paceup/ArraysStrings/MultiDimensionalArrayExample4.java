package com.paceup.ArraysStrings;

import java.util.Arrays;

//Print all elements of 3d array Using for-each loop
public class MultiDimensionalArrayExample4 {
	public static void main(String[] args) {

		// create a 3d array
		int[][][] test = {
				{
					{1, -2, 3}, 
					{2, 3, 4}
				}, 
				{ 
					{-4, -5, 6, 9}, 
					{1}, 
					{2, 3}
				} 
		};
		System.out.println("Printing 3D Array");
		// for..each loop to iterate through elements of 3d array
		for (int[][] array2D: test) {  //2D Array
			for (int[] array1D: array2D) { //Row of 2D Array
				for(int item: array1D) {  // Element of row of 2D Array
					System.out.print(item+"\t");
				}
				System.out.println("");
			}
			System.out.println();
		}
		
		System.out.println("\n3D Array Representation:");
		
		System.out.println(Arrays.deepToString(test));
	}
}
