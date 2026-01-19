//5. Write a program to find the maximum and minimum value in an integer array.

package com.paceup.day10.Asses10;

public class MaxMinArray {

	public static void main(String[] args) {
		int arr[] = { 2, 5, 1, 0, 7, 9, 4 };

		int max = arr[0]; //0th index element of array i.e. 2
		int min = arr[0]; //0th index element of array i.e. 2

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("Arrays Maximum Elements: " + max);
		System.out.println("Arrays Minimum Elements: " + min);

	}

}
