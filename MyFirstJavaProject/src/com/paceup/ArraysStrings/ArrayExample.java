package com.paceup.ArraysStrings;
/*
 * dataType[] arrayName
 * dataType arrayName[]
 * dataType arrayName[]=new dataType[size]
 * 
 * 0 <= index <= (size-1) 
 */
public class ArrayExample {
	public static void main(String[] args) {
		Integer i = 78;
		// create an array
		int[] age = {12, 4, 5, 2, 5};
		
		int arr[] = {2,5,343,343};
		
		age[4] = 56;
		
		int arr1[]= new int[56]; //size

		// access each array elements
		System.out.println("Accessing Elements of Array:");
		System.out.println("First Element: " + age[0]);
		System.out.println("Second Element: " + age[1]);
		System.out.println("Third Element: " + age[2]);
		System.out.println("Fourth Element: " + age[3]);
		System.out.println("Fifth Element: " + age[4]);
	}
}
