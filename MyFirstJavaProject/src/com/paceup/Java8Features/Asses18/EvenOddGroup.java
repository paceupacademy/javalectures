//4. Group a list of integers based on even and odd using Collectors.groupingBy.
package com.paceup.Java8Features.Asses18;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EvenOddGroup {

	public static void main(String[] args) {

		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		Map<Object, List<Integer>> result = num.stream()
				.collect(Collectors.groupingBy(n -> (n % 2 == 0) ? "EVEN" : "ODD"));

		System.out.println("Using List: " + result);

		Map<Object, Set<Integer>> result1 = num.stream()
				.collect(Collectors.groupingBy(n -> (n % 2 == 0) ? "EVEN" : "ODD", Collectors.toSet()));

		System.out.println("Using Set: " + result1);
	}

}
