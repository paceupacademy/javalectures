package com.paceup.Java8Features;

import java.util.function.BiFunction;

public class BiFunctionExample {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> add = (a,b) -> a+b;
		System.out.println("Sum= "+add.apply(2, 3));
		
		BiFunction<Integer, Double, Double> multiply = (a,b) -> a*b;
		System.out.println("Product= "+multiply.apply(6, 4398.42348));
	}

}
