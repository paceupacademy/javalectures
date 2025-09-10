package com.paceup.day20;

import java.util.function.Function;

public class FunctionInterfaceExample {

	public static void main(String[] args) {
		Function<String,Integer> strLength = s -> s.length();
		
		System.out.println("Length of aishwarya : "+strLength.apply("Aishwarya"));
		System.out.println("Length of Java: "+strLength.apply("Java"));

		
		/***Transformation***/
		
		Function<Integer,Integer> square = n -> n*n;
		System.out.println("Square or 23: "+square.apply(23));
		System.out.println("Square of 12: "+square.apply(12));
		
		/***Chaining Functions***/
		
		Function<Integer,Integer> multiBy3 = n -> n*3;
		Function<Integer,Integer> add10 = n -> n+10;
		
		//First multiply by 3 then add 10 to the result
		System.out.println(multiBy3.andThen(add10).apply(78));
		//First add 10 and then multiply by 3 to the result
		System.out.println(add10.andThen(multiBy3).apply(78));
		
		//First add 10 and then multiply by 3 to the result
		System.out.println(multiBy3.compose(add10).apply(78));
	}

}
