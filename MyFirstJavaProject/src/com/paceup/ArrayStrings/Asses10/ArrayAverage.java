//2. Create a program that takes 5 numbers from the user and stores them in an array. Then print their average.

package com.paceup.ArrayStrings.Asses10;

import java.util.Scanner;

public class ArrayAverage {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[5];
		int sum = 0;
		double Avr;

		System.out.println("Enter the 5 Numbers:");
		for (int i = 0; i < 5; i++) {
			sum += scanner.nextInt();
		}

		Avr = sum / 5;
		System.out.println("Averange: " + Avr);

	}

}
