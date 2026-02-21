package com.paceup.Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * MethodReferenceExample:
 * -----------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Method References**:
 *    - Provide a shorthand for writing lambda expressions.
 *    - Types:
 *      a) Static Method Reference → ClassName::staticMethod
 *      b) Bound Instance Method Reference → object::instanceMethod
 *      c) Unbound Instance Method Reference → ClassName::instanceMethod
 *      d) Constructor Reference → ClassName::new or Type[]::new
 *
 * 2. **Functional Interfaces**:
 *    - Method references work with functional interfaces like Function, Supplier, Consumer, Comparator.
 *
 * 3. **Use Cases**:
 *    - Simplify lambda expressions.
 *    - Improve readability by directly referencing existing methods.
 */
class Greet {
    private String name;

    Greet(String name) {
        this.name = name;
    }

    public String greet() {
        return "Hello " + name;
    }
}

public class MethodReferenceExample {
    public static void main(String[] args) {
        /*** Static Method Reference ***/
        Function<Integer, String> f = Integer::toHexString; // Equivalent to x -> Integer.toHexString(x)
        System.out.println("Integer to HexString for 255: " + f.apply(255)); // Output: ff

        /*** Bound Instance Method Reference ***/
        Greet g = new Greet("Neha");
        Supplier<String> s = g::greet; // Equivalent to () -> g.greet()
        System.out.println(s.get());

        /*** Unbound Instance Method Reference ***/
        Function<String, Integer> len = String::length; // Equivalent to str -> str.length()
        System.out.println("Length of Java: " + len.apply("Java"));

        List<String> names = Arrays.asList("Neha", "Ananaya", "PUJA", "akash", "AKASH");
        Comparator<String> sample = String::compareToIgnoreCase; // Equivalent to (a,b) -> a.compareToIgnoreCase(b)
        names.sort(sample);
        System.out.println("Sorted Names (Ignore Case): " + names);

        /*** Constructor Reference ***/
        Supplier<List<String>> newList = ArrayList::new; // Equivalent to () -> new ArrayList()
        List<String> createdList = newList.get();
        createdList.add("Hello");
        createdList.add("World");
        System.out.println("Created List using Constructor Reference: " + createdList);

        /*** Array Constructor Reference ***/
        Function<Integer, int[]> makeIntArray = int[]::new; // Equivalent to n -> new int[n]
        int[] arr = makeIntArray.apply(5);
        System.out.println("Array length created: " + arr.length);

        /*** Method Reference with Streams ***/
        List<String> id = List.of("101", "102", "103", "104");
        Function<String, Integer> toInt = Integer::valueOf; // Equivalent to str -> Integer.valueOf(str)
        List<Integer> ints = id.stream()
                               .map(toInt)
                               .toList();
        System.out.println("Converted IDs to Integers: " + ints);

        /*** PrintStream Method Reference Example ***/
        System.out.println("\nPrintStream Method Reference:");
        names.forEach(System.out::println); // Equivalent to name -> System.out.println(name)
    }
}
