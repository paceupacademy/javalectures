package com.paceup.day10;

import java.util.Arrays;

//Using Looping Construct to Copy Arrays
public class CopyingArrayExample2 {
	public static void main(String[] args) {

		int [] source = {1, 2, 3, 4, 5, 6};
		int [] destination = new int[6]; //declaring the size of array 

		// iterate and copy elements from source to destination
		for (int i = 0; i < source.length; ++i) {
			destination[i] = source[i]; //destination[0] =1, destination[1]=2
		}

		// converting array to string
		System.out.println("Copied Destination Array: "+Arrays.toString(destination));

		//Copying 2d Arrays Using Loop
		int[][] source2 = {
				{1,2,3,4}, 
				{5, 6},
				{0, 2, 42, -4, 5}
		};

		int[][] destination2 = new int[source2.length][]; //destination2 = new int[3][];

		for (int i = 0; i < destination2.length; ++i) { //row

			// allocating space for each row of destination array
			destination2[i] = new int[source2[i].length]; //destination[0] = new int[4]

			for (int j = 0; j < destination2[i].length; ++j) { //column
				destination2[i][j] = source2[i][j]; //destination[2][2] = source[2][2]
			}
		}

		// displaying destination array
		System.out.println("\n\nCopied 2D Array\n"+Arrays.deepToString(destination2));

	}
}
