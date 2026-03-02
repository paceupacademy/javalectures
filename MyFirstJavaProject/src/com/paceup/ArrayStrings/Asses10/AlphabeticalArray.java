//4. Sort a string array alphabetically using Arrays.sort().

package com.paceup.ArrayStrings.Asses10;

import java.util.Arrays;

public class AlphabeticalArray {

	public static void main(String[] args) {
		String[] Bike = { "Jupiter", "Ola", "Ather", "Activa", "Chetak" };
		Arrays.sort(Bike);
		System.out.println("Sorted String Array: " + Arrays.toString(Bike));
	}

}
