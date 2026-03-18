package com.paceup.Java8Features; 
import java.util.*;
import java.util.function.*;

/**
 * SupplierExample:
 * ----------------
 * Theoretical Notes:
 * ------------------
 * 1. Supplier<T>:
 *    - Functional interface in java.util.function.
 *    - Represents a supplier of results (no input, only output).
 *    - Method: get() → returns a value of type T.
 *
 * 2. Primitive Suppliers:
 *    - BooleanSupplier → getAsBoolean()
 *    - IntSupplier → getAsInt()
 *    - LongSupplier → getAsLong()
 *    - DoubleSupplier → getAsDouble()
 *
 * 3. Use Cases:
 *    - Supplying constant values.
 *    - Generating random numbers.
 *    - Creating new objects (constructor references).
 *    - Providing default values.
 *    - Supplying primitive values without boxing overhead.
 */
public class SupplierExample {
    public static void main(String[] args) {
        // Example 1: Supplier returning a fixed string
        // Input: () → no arguments
        // Output: "Hello Aishwarya!!"
        Supplier<String> supplier = () -> "Hello Aishwarya!!";
        System.out.println(supplier.get());

        // Example 2: Supplier generating random numbers
        // Input: () → no arguments
        // Output: Random integer between 0–99
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        System.out.println("Random Number: " + randomSupplier.get());

        // Example 3: Supplier with constructor reference
        // Input: () → no arguments
        // Output: NewEmployee("Raj", 50000)
        Supplier<NewEmployee> empSupplier = () -> new NewEmployee("Raj", 50000);
        NewEmployee e = empSupplier.get();
        System.out.println("Name: " + e.name + ", Salary: " + e.salary);

        // Example 4: Supplier for default values
        // Input: () → no arguments
        // Output: "Unknown"
        Supplier<String> defaultName = () -> "Unknown";
        System.out.println("Default Name: " + defaultName.get());

        // Example 5: BooleanSupplier
        // Input: () → no arguments
        // Output: true or false (random)
        BooleanSupplier boolSupplier = () -> new Random().nextBoolean();
        System.out.println("Boolean Value: " + boolSupplier.getAsBoolean());

        // Example 6: IntSupplier
        // Input: () → no arguments
        // Output: Random integer between 0–49
        IntSupplier intSupplier = () -> new Random().nextInt(50);
        System.out.println("Int Value: " + intSupplier.getAsInt());

        // Example 7: LongSupplier
        // Input: () → no arguments
        // Output: Current system time in milliseconds
        LongSupplier longSupplier = () -> System.currentTimeMillis();
        System.out.println("Current Time (ms): " + longSupplier.getAsLong());

        // Example 8: DoubleSupplier
        // Input: () → no arguments
        // Output: Random double between 0.0–1.0
        DoubleSupplier doubleSupplier = () -> Math.random();
        System.out.println("Double Value: " + doubleSupplier.getAsDouble());
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
