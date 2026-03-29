//3. Use stream() to convert a list of strings to uppercase.

package com.paceup.Java8Features.Asses18;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UppercaseStream {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Amar", "Jyoti", "Divya", "Vikram", "Rakesh");
		
		List <String> result = list.stream()
		.map(String::toUpperCase)
		.collect(Collectors.toList());
		
		System.out.println("List converted to Uppercase using stream: " + result);
					

	}

}
