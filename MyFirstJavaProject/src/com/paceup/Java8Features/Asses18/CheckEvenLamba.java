//1. Write a lambda expression to check if a number is even.
package com.paceup.Java8Features.Asses18;

import java.util.function.Predicate;

public class CheckEvenLamba {

	public static void main(String[] args) {
		Predicate<Integer> even = n -> n % 2 == 0;
		System.out.println("Given number is Even? " + even.test(20));
		System.out.println("Given number is Even? " + even.test(17));


	}

}
