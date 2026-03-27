package com.paceup.Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * ConsumerInterfaceExample:
 * -------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Consumer<T>**:
 *    - A functional interface introduced in Java 8.
 *    - Represents an operation that takes a single input argument and returns no result.
 *    - Method: `accept(T t)` → performs the operation on the given argument.
 *
 * 2. **andThen()**:
 *    - Allows chaining multiple Consumers.
 *    - Executes them in sequence on the same input.
 *
 * 3. **Use Cases**:
 *    - Printing/logging values.
 *    - Performing side effects (e.g., updating state, saving data).
 *    - Iterating collections with `forEach`.
 *
 * 4. **Difference from Function<T,R>**:
 *    - Consumer<T> → takes input, produces no output.
 *    - Function<T,R> → takes input, produces output.
 */
public class ConsumerInterfaceExample {
	public static void main(String[] args) {
		// Example 1: Simple Consumer with lambda
		Consumer<String> printMessage = message -> System.out.println("Message: " + message);
		printMessage.accept("Welcome to Java Lambdas!");

		// Example 2: Chaining Consumers using andThen()
		printMessage.andThen(s -> System.out.println("Length of message: " + s.length()))
		.accept("Welcome to andThen methods in Consumer!");

		//Consumer NullPointerException
		Consumer<List<Integer>> modify =  list-> {
			for(int i=0; i<list.size();i++) {
				list.set(i, 2 * list.get(i));
			}
		};
		Consumer<List<Integer>> displayList =  list -> list.forEach(a->System.out.println(a+ " "));

		List<Integer> list =  new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(3);


		try {
			modify.andThen(displayList).accept(list);
		} catch(Exception e) {
			System.out.println("Exception: "+e);
		}

		// Example 3: Using Consumer with a List (lambda inline)
		List<String> names = Arrays.asList("Alice", "Charlie", "Bob", "David", "Arjun");
		System.out.println("\nUsing lambda with forEach:");
		names.forEach(n -> System.out.print(n + " "));

		// Example 4: Using Consumer explicitly
		Consumer<String> display = n -> System.out.print(n + " ");
		System.out.println("\n\nUsing Consumer explicitly with forEach:");
		names.forEach(display);

		System.out.println();
		
		// Example 5: Chaining Consumers for transformation
		Consumer<String> upperCasePrinter = s -> System.out.println(s.toUpperCase());
		Consumer<String> lowerCasePrinter = s -> System.out.println(s.toLowerCase());
		System.out.println("\nChained Consumers (upper + lower):");
		upperCasePrinter.andThen(lowerCasePrinter).accept("Java8Features");

		// Example 6: Consumer with custom logic
		Consumer<Integer> checkEvenOdd = num -> {
			if (num % 2 == 0) {
				System.out.println(num + " is Even");
			} else {
				System.out.println(num + " is Odd");
			}
		};
		System.out.println("\nConsumer with custom logic:");
		Arrays.asList(10, 15, 22, 33).forEach(checkEvenOdd);
	}
}
