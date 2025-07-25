package com.paceup.day10;

import java.util.Arrays;

//Program to Add Two Matrices
public class SumOfMatrices {
	public static void main(String[] args) {
		int rows = 2, columns = 3;
		int[][] firstMatrix = { {2, 3, 4}, {5, 2, 3} };
		int[][] secondMatrix = { {-4, 5, 3}, {5, 6, 3} };

		
		// Adding Two matrices using for loop
		int[][] sum = new int[rows][columns];
		
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sum[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
			}
		}
		
		System.out.println("First Matrix:" );
		System.out.println(Arrays.deepToString(firstMatrix));
		System.out.println("Second Matrix");
		System.out.println(Arrays.deepToString(secondMatrix));

		// Displaying the result using for each
		System.out.println("Sum of two matrices is: ");
		for(int[] row : sum) {
			for (int column : row) {
				System.out.print(column + "    ");
			}
			System.out.println();
		}
	}
}
