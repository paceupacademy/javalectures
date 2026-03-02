package com.paceup.Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Greeting Functional Interface Example:
 * --------------------------------------
 * In Java 8, **Functional Interfaces** are interfaces that contain exactly one abstract method.
 * They are the foundation of **Lambda Expressions** and **Method References**.
 * 
 * Key Concepts:
 * -------------
 * 1. **Functional Interface**:
 *    - An interface with a single abstract method (SAM).
 *    - Can have default and static methods, but only one abstract method.
 *    - Annotated with `@FunctionalInterface` (optional but recommended).
 * 
 * 2. **Lambda Expressions**:
 *    - Provide a concise way to implement functional interfaces.
 *    - Syntax: `(parameters) -> expression` or `(parameters) -> { statements }`.
 * 
 * 3. **Method References**:
 *    - Shortcut to refer to existing methods instead of writing lambdas.
 *    - Types: `object::instanceMethod`, `Class::staticMethod`, `Class::new` (constructor reference).
 * 
 * 4. **Use Cases**:
 *    - Event handling (e.g., button clicks).
 *    - Iterating collections with `forEach`.
 *    - Passing behavior as parameters (strategy pattern).
 *    - Simplifying code in streams API.
 */
//Zero Param FI
@FunctionalInterface
interface ZeroParameter{
	void display();
}

//One Param FI
@FunctionalInterface
interface Greeting {
	void sayHello(String name); // Single Abstract Method (SAM)
}

//Multi Param FI
@FunctionalInterface
interface MultiParam{
	int operation(int a,int b);
}


public class BasicLambdaExample {
	public static void main(String[] args) {

		ZeroParameter zeroParamLambda = () -> System.out.println("Zero param lambda expression called!!!");

		zeroParamLambda.display();

		// Example 1: Lambda Expression
		Greeting greetLambda = (name) -> System.out.println("Hello, " + name + "!");
		greetLambda.sayHello("Aishwarya");

		MultiParam add = (a,b) -> a + b;

		MultiParam multiply = (a,b) -> a * b;

		System.out.println("Addition of 7 and 13 = "+add.operation(7, 13));

		System.out.println("Multiplication of 7 and 13 = "+multiply.operation(7, 13));

		// Example 2: Method Reference (using a static method)
		//Greeting greetStatic = (name)-> BasicLambdaExample.staticHello(name)
		/*
		 * @Override
		 * void sayHello(String name) {
		 * 	BasicLambdaExample.staticHello(name);
		 * }
		 * 
		 * sayHello(name);
		 */

		//Reference Variable for Greeting OR Functional Interface Reference 

		Greeting greetStatic = BasicLambdaExample::staticHello;
		greetStatic.sayHello("Suraj");

		// Example 3: Method Reference (using an instance method)
		BasicLambdaExample example = new BasicLambdaExample();
		Greeting greetInstance = example::instanceHello;
		greetInstance.sayHello("Java Developer");

		// Example 4: Inline Lambda with more logic
		Greeting greetLogic = (name) -> {
			if (name.isEmpty()) {
				System.out.println("Hello, Stranger!");
			} else {
				System.out.println("Hello, " + name + "! Welcome to Java 8 Features.");
			}
		};
		
		
		greetLogic.sayHello("Paceup");
		greetLogic.sayHello("");
		
		List<String> l = Arrays.asList("David","Pete","Diana","","George","");
		/*
		 * for(String name: l){ if(name.isEmpty()) { System.out.print("EmptyElement ");
		 * } else { System.out.print(name+" "); } }
		 */
		l.forEach(name -> {
			if(name.isEmpty()) {
				System.out.print("EmptyElement ");
			} else {
				System.out.print(name+" ");
			}
		});
	}

	// Static method for method reference
	public static void staticHello(String name) {
		System.out.println("Static Hello to " + name);
	}

	// Instance method for method reference
	public void instanceHello(String name) {
		System.out.println("Instance Hello to " + name);
	}
}
