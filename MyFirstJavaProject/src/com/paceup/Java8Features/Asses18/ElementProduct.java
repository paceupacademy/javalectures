//5. Find the product of all elements in a list using reduce().
package com.paceup.Java8Features.Asses18;

import java.util.Arrays;
import java.util.List;

public class ElementProduct {

	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		long product = num.stream().reduce(1, (a, b) -> a * b); //identity: 1, accumulator: (a, b) -> a * b
		System.out.println("Product of Elements : " + product);

	}

}
