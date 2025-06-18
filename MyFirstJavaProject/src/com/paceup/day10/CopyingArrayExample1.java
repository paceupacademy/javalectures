package com.paceup.day10;
//Copying Arrays Using Assignment Operator
public class CopyingArrayExample1 {
	public static void main(String[] args) {

		int [] numbers = {1, 2, 3, 4, 5, 6};
		int [] positiveNumbers = numbers;    // copying arrays

		for (int number: positiveNumbers) {
			System.out.print(number + ", ");
		}

	}
}
