package com.paceup.ArraysStrings;
//Compute Sum and Average of Array Elements
public class ArrayExample4 {
	public static void main(String[] args) {

		int[] numbers = {2, -9, 0, 5, 12, -25, 22, 9, 8, 12};
		int sum = 0;
		Double average = 0.0;
		System.out.println("Sum value is "+sum+ " Average value is "+average+"\n");
		
		System.out.println("Sum Value after each element addition:");
		// access all elements using for each loop
		// add each element in sum
		for (int number: numbers) {
			System.out.println("Sum value: "+sum+" = "+sum+"+"+number);
			sum += number; //sum = sum + number			
		}
		System.out.println();

		// get the total number of elements
		int arrayLength = numbers.length; //sum/size
		System.out.println("Length of Array: "+arrayLength+"\n");
		// calculate the average
		// convert the average from int to double
		average =  ((double)sum / (double)arrayLength);
		int avg1 = sum/arrayLength;
		System.out.println("Sum = " + sum);
		System.out.println("Average = " + average);
		System.out.println("Average without typecasting: "+avg1);
	}
}
