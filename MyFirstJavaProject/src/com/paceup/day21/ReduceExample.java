package com.paceup.day21;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1,2,3,14,5,6,7,8);

		int sumInt = numbers.stream()
				.reduce(0, Integer::sum); //intial value 0, 

		System.out.println("Sum: "+sumInt);		
		
		int max = numbers.stream()
				.reduce(Integer.MIN_VALUE, Integer::max);
		
		System.out.println("Max Value: "+max);
		
		List<String> words = Arrays.asList(" Mumbai", "is","capital", " of", "Maharashtra,", "India. ");
		
		String sentence = words.stream()
				.reduce("", (a,b)->a+" "+b).trim();
		
		String sentence1 = words.stream()
				.reduce("", (a,b)->a+" "+b)
				.replaceFirst(" ", "*");
		
		System.out.println("Sentence:"+sentence);
		System.out.println("Sentence:"+sentence1);
	}

}
/*
 * sumInt = 0
 * sumInt = sumInt + 1
 * sumInt = sumInt + 2
 * 
 * Identity : Starting value for reduction
 * Accumulator: Function that combine two elements
 * Associativity/Combiner: Operation must be associative to ensure consistent results in parallel streams
 */