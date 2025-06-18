package com.paceup.day10;
//for-each Loop
public class ArrayExample3 {
	public static void main(String[] args) {

		// create an array
		int[] age = {12, 4, 5};

		// loop through the array
		// using for loop
		System.out.println("Using for-each Loop:");
		for(int a : age) {
			System.out.println(a);
		}
	}
}
