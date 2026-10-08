package com.paceup.ArraysStrings;
//for-each Loop
public class ArrayExample3 {
	public static void main(String[] args) {

		// create an array
		int[] age = {12, 4, 5};

		// loop through the array
		// using for loop
		System.out.println("Using for-each Loop:");
		/*
		 * for (type variable: arrayName){
		 * 
		 * }
		 */
				
		for(int a : age) {
			System.out.print(a+" ");
		}
		
		int[] uarr=incrementData(age);
		System.out.println("\nUpdated array: ");
		for(int a:uarr) {
			System.out.print(a+" ");
		}
		System.out.println();
		avg(age);
	}
		
		public static void avg(int[] arr) {
			int sum = 0;
			for(int i=0;i<arr.length;i++) {
				sum += arr[i];				
			}
			System.out.println("Average age is "+(sum/arr.length));
		}
		
		public static int[] incrementData(int[] arr) {
			for(int i=0; i<arr.length;i++) {
				arr[i]+=5;
			}
			return arr;
			
		}
}
