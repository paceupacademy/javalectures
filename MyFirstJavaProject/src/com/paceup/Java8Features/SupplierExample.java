package com.paceup.Java8Features;

import java.util.Random;
import java.util.function.Supplier;

/**
 * SupplierExample:
 * ----------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Supplier<T>**:
 *    - A functional interface introduced in Java 8.
 *    - Represents a supplier of results (no input, only output).
 *    - Method: `get()` → returns a value of type T.
 *
 * 2. **Use Cases**:
 *    - Object creation (constructor references).
 *    - Supplying default values.
 *    - Generating random values.
 *    - Lazy evaluation (value generated only when needed).
 *
 * 3. **Difference from Other Interfaces**:
 *    - Supplier<T> → no input, produces output.
 *    - Consumer<T> → takes input, no output.
 *    - Function<T,R> → takes input, produces output.
 *    - Predicate<T> → takes input, returns boolean.
 */
public class SupplierExample {
    public static void main(String[] args) {
        // Example 1: Supplier returning a fixed string
        Supplier<String> supplier = () -> "Hello Aishwarya!!";
        System.out.println(supplier.get());

        // Example 2: Supplier generating random numbers
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100); // 0–99
        System.out.println("Random Number: " + randomSupplier.get());

        // Example 3: Supplier with constructor reference
        Supplier<NewEmployee> empSupplier = () -> new NewEmployee("Raj", 50000);
        NewEmployee e = empSupplier.get();
        System.out.println("Name: " + e.name + ", Salary: " + e.salary);

        // Example 4: Supplier for default values
        Supplier<String> defaultName = () -> "Unknown";
        System.out.println("Default Name: " + defaultName.get());
    }
}

// Helper class for demonstration
class NewEmployee {
    String name;
    int salary;

    NewEmployee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
