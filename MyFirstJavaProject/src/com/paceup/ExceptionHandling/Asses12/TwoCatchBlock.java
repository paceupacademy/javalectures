//1. Write a Java program to handle ArithmeticException and ArrayIndexOutOfBoundsException using two catch blocks
package com.paceup.ExceptionHandling.Asses12;

public class TwoCatchBlock {

	public static void main(String[] args) {
		try {
			int arr[] = { 10, 20, 30 };
			System.out.println(arr[4]); // ArrayIndexOutOfBound

			int div = 10 / 0; // ArithmeticException

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index out of bound Exception occured");
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception");
		}

	}

}
//note: result will be only first exception handled if more than 2 exception occured in program.