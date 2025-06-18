package com.paceup.day10;
//Looping Through Array Elements
class ArrayExample2 {
	public static void main(String[] args) {

		// create an array
		int[] age = {12, 4, 5};

		// loop through the array
		// using for loop
		System.out.println("Using for Loop:");
		for(int i = 0; i < age.length; i++) { //array.length =3
			System.out.println(age[i]);
		}
		System.out.println("Length of Array:"+age.length);
	}
}