package com.paceup.ArraysStrings;

import java.util.Arrays;
//Copying Arrays Using arraycopy() method
public class CopyingArrayExample3 {
	public static void main(String[] args) {
		int[] n1 = {2, 3, 12, 4, 12, -2};

		int[] n3 = new int[5];

		// Creating n2 array of having length of n1 array
		int[] n2 = new int[n1.length];

		System.out.println("n1 = "+ Arrays.toString(n1));
		// copying entire n1 array to n2
		System.arraycopy(n1, 0, n2, 0, n1.length);
		System.out.println("n2 = " + Arrays.toString(n2));  

		// copying elements from index 2 on n1 array
		// copying element to index 1 of n3 array
		// 2 elements will be copied
		System.out.println("\nn3 before copying: "+Arrays.toString(n3));
		System.arraycopy(n1, 2, n3, 1, 2);
		System.out.println("n3 = " + Arrays.toString(n3));  

		//Copying 2d Jagged Arrays using arraycopy()

		int[][] source = {
				{1, 2, 3, 4}, 
				{5, 6},
				{0, 2, 42, -4, 5}
		};

		int[][] destination = new int[source.length][]; //destiantion[3][]

		for (int i = 0; i < source.length; ++i) {

			// allocating space for each row of destination array
			destination[i] = new int[source[i].length]; //destination[2]=source[2].length (5)
			System.arraycopy(source[i], 1, destination[i], 1, 1);
		}

		// displaying destination array
		System.out.println("\n\nCopied 2D Array\n"+Arrays.deepToString(destination)); 
	}
}
