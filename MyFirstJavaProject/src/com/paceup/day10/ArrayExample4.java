package com.paceup.day10;
//Compute Sum and Average of Array Elements
public class ArrayExample4 {
	public static void main(String[] args) {

		int[] numbers = {2, -9, 0, 5, 12, -25, 22, 9, 8, 12};
		int sum = 0;
		Double average;
		System.out.println("Sum Value: ");
		// access all elements using for each loop
		// add each element in sum
		for (int number: numbers) {
			sum += number; // sum = sum +number 2
			
			System.out.print(" "+sum);
		}

		// get the total number of elements
		int arrayLength = numbers.length; //sum/size
		System.out.println("Length of Array: "+arrayLength);
		// calculate the average
		// convert the average from int to double
		average =  ((double)sum / (double)arrayLength);

		int avg1 = sum/arrayLength;
		System.out.println("Sum = " + sum);
		System.out.println("Average = " + average);
		System.out.println("Average without typecasting: "+avg1);
	}
}
