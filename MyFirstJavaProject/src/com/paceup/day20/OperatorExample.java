package com.paceup.day20;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
public class OperatorExample {

	public static void main(String[] args) {
		UnaryOperator<Integer> square = n -> n*n; //Takes one arguments
		System.out.println("Square of 78: "+square.apply(78));
		
		BinaryOperator<Integer> add = (a,b) -> a+b;
		System.out.println("Sum of 7 and 73: "+add.apply(7, 73));
	}

}
