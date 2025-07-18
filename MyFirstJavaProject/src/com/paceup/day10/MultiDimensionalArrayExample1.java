package com.paceup.day10;
//2-dimensional Array
public class MultiDimensionalArrayExample1 {
	public static void main(String[] args) {

		// create a 2d array
		int[][] a = {
				{1, 2, 3}, 
				{4, 5, 6, 9}, 
				{7}, //trailing comma makes adding more rows simple 
		};

		// calculate the length of each row
		System.out.println("Length of row 1: " + a[0].length);
		System.out.println("Length of row 2: " + a[1].length);
		System.out.println("Length of row 3: " + a[2].length);
	}
}
