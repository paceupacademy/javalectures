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
        // Integer::toHexString → converts integer to hex string
        /*
         * Input: 255
         * Integer::toHexString → "ff"
         *
         * 255 ---> [Integer::toHexString] ---> "ff"
         */
        Function<Integer, String> f = Integer::toHexString;
        System.out.println("Integer to HexString for 255: " + f.apply(255));

        /*** Bound Instance Method Reference ***/
        Greet g = new Greet("Neha");
        // g::greet → bound to specific object g
        /*
         * Input: () (no args)
         * g.greet() → "Hello Neha"
         *
         * () ---> [g::greet] ---> "Hello Neha"
         */
        Supplier<String> s = g::greet;
        System.out.println(s.get());

        /*** Unbound Instance Method Reference ***/
        // String::length → unbound, takes any String
        /*
         * Input: "Java"
         * "Java".length() → 4
         *
         * "Java" ---> [String::length] ---> 4
         */
        Function<String, Integer> len = String::length;
        System.out.println("Length of Java: " + len.apply("Java"));

        List<String> names = Arrays.asList("Neha", "Ananaya", "PUJA", "akash", "AKASH");
        // String::compareToIgnoreCase → comparator
        /*
         * Input: List of names
         * sort using compareToIgnoreCase
         * Output: [AKASH, akash, Ananaya, Neha, PUJA]
         *
         * names ---> [String::compareToIgnoreCase] ---> sorted list
         */
        Comparator<String> sample = String::compareToIgnoreCase;
        names.sort(sample);
        System.out.println("Sorted Names (Ignore Case): " + names);

        /*** Constructor Reference ***/
        // ArrayList::new → creates new ArrayList
        /*
         * Input: ()
         * new ArrayList() → empty list
         * add elements → ["Hello","World"]
         *
         * () ---> [ArrayList::new] ---> []
         * [] ---> [add] ---> ["Hello","World"]
         */
        Supplier<List<String>> newList = ArrayList::new;
        List<String> createdList = newList.get();
        createdList.add("Hello");
        createdList.add("World");
        System.out.println("Created List using Constructor Reference: " + createdList);

        /*** Array Constructor Reference ***/
        // int[]::new → creates array of given size
        /*
         * Input: 5
         * new int[5] → array length = 5
         *
         * 5 ---> [int[]::new] ---> int[5]
         */
        Function<Integer, int[]> makeIntArray = int[]::new;
        int[] arr = makeIntArray.apply(5);
        System.out.println("Array length created: " + arr.length);

        /*** Method Reference with Streams ***/
        List<String> id = List.of("101", "102", "103", "104");
        // Integer::valueOf → converts String to Integer
        /*
         * Stream<String> → map(Integer::valueOf) → collect(toList)
         * Input: ["101","102","103","104"]
         * Output: [101,102,103,104]
         *
         * ["101","102","103","104"] ---> [Integer::valueOf] ---> [101,102,103,104]
         */
        Function<String, Integer> toInt = Integer::valueOf;
        List<Integer> ints = id.stream()
                               .map(toInt)
                               .toList();
        System.out.println("Converted IDs to Integers: " + ints);

        /*** PrintStream Method Reference Example ***/
        // System.out::println → prints each element
        /*
         * Stream<String> → forEach(System.out::println)
         * Output: prints each name
         *
         * names ---> [System.out::println] ---> console output
         */
        System.out.println("\nPrintStream Method Reference:");
        names.forEach(System.out::println);
    }
}
