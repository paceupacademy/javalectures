package com.paceup.day10;

import java.util.Arrays;

//Using Looping Construct to Copy Arrays
public class CopyingArrayExample2 {
	public static void main(String[] args) {

		int [] source = {1, 2, 3, 4, 5, 6};
		int [] destination = new int[6];

		// iterate and copy elements from source to destination
		for (int i = 0; i < source.length; ++i) {
			destination[i] = source[i];
		}

		// converting array to string
		System.out.println(Arrays.toString(destination));

		//Copying 2d Arrays Using Loop
		int[][] source2 = {
				{1, 2, 3, 4}, 
				{5, 6},
				{0, 2, 42, -4, 5}
		};

		int[][] destination2 = new int[source2.length][];

		for (int i = 0; i < destination2.length; ++i) {

			// allocating space for each row of destination array
			destination2[i] = new int[source2[i].length];

			for (int j = 0; j < destination2[i].length; ++j) {
				destination2[i][j] = source2[i][j];
			}
		}

		// displaying destination array
		System.out.println("\n\nCopied 2D Array\n"+Arrays.deepToString(destination2));

	}
}
