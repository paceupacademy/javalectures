//3. Write a method to reverse the elements of an array.

package com.paceup.ArrayStrings.Asses10;

import java.util.Arrays;
import java.util.Comparator;

public class ReverseArray {

	public static void main(String[] args) {
		Integer arr[] = {4,6,2,7,1,0};
		Arrays.sort(arr, Comparator.reverseOrder());
		System.out.println("Reverse Elements of Arrays: "+ Arrays.toString(arr));
		
	}

}
