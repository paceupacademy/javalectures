package com.paceup.day10;

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
		for (int[][] array2D: test) { //iterates over 2D array element
			for (int[] array1D: array2D) { //iterates over row of each 2D array
				for(int item: array1D) { //iterates over element of each row
					System.out.print(item+"\t");
				}
				System.out.println("");
			}
			System.out.println(",\n");
		}
		
		System.out.println("\n3D Array Representation:");
		
		System.out.println(Arrays.deepToString(test));
	}
}
