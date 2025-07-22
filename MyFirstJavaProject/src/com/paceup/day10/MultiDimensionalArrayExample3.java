package com.paceup.day10;
//Print all elements of 2d array Using for-each loop
public class MultiDimensionalArrayExample3 {
	public static void main(String[] args) {

		// create a 2d array
		int[][] a = {
				{1, -2, 3}, 
				{-4, -5, 6, 9}, 
				{7}, 
		};

		// first for...each loop access the individual array
		// inside the 2d array
		// 1st iteration innerArray = {1, -2, 3}, 2nd iteration innerArray = {-4, -5, 6, 9}
		for (int[] innerArray: a) {
			// second for...each loop access each element inside the row
			//1st iteration data = 1, 2nd iteration data=-2, 3rd Iteration data =3
			for(int data: innerArray) {
				System.out.print(data+" ");
			}
			System.out.println("\n");
		}
	}
}
