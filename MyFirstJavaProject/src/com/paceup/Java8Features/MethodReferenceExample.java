package com.paceup.Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * MethodReferenceExample:
 * -----------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Method References**:
 *    - Shorthand for lambda expressions.
 *    - Types:
 *      a) Static Method Reference → ClassName::staticMethod
 *      b) Bound Instance Method Reference → object::instanceMethod
 *      c) Unbound Instance Method Reference → ClassName::instanceMethod
 *      d) Constructor Reference → ClassName::new or Type[]::new
 *
 * 2. **Functional Interfaces**:
 *    - Method references work with Function, Supplier, Consumer, Comparator, etc.
 *
 * 3. **Use Cases**:
 *    - Simplify lambdas.
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

        /*** 1. Static Method Reference ***/
        // Integer::toHexString → converts integer to hex string
        /*
         * Input: 255
         * Integer::toHexString → "ff"
         *
         * 255 ---> [Integer::toHexString] ---> "ff"
         */
        System.out.println("=== 1. Static Method Reference ===");
        Function<Integer, String> f = Integer::toHexString;
        System.out.println("Input: 255 → Output: " + f.apply(255));

        /*** 2. Bound Instance Method Reference ***/
        Greet g = new Greet("Neha");
        // g::greet → bound to specific object g
        /*
         * Input: () (no args)
         * g.greet() → "Hello Neha"
         *
         * () ---> [g::greet] ---> "Hello Neha"
         */
        System.out.println("\n=== 2. Bound Instance Method Reference ===");
        Supplier<String> s = g::greet;
        System.out.println("Input: () → Output: " + s.get());

        /*** 3. Unbound Instance Method Reference ***/
        // String::length → unbound, takes any String
        /*
         * Input: "Java"
         * "Java".length() → 4
         *
         * "Java" ---> [String::length] ---> 4
         */
        System.out.println("\n=== 3. Unbound Instance Method Reference ===");
        Function<String, Integer> len = String::length;
        System.out.println("Input: \"Java\" → Output: " + len.apply("Java"));

        /*** 4. Comparator with Method Reference ***/
        List<String> names = Arrays.asList("Neha", "Ananaya", "PUJA", "akash", "AKASH");
        // String::compareToIgnoreCase → comparator
        /*
         * Input: List of names
         * sort using compareToIgnoreCase
         * Output: [AKASH, akash, Ananaya, Neha, PUJA]
         *
         * names ---> [String::compareToIgnoreCase] ---> sorted list
         */
        System.out.println("\n=== 4. Comparator with Method Reference ===");
        Comparator<String> sample = String::compareToIgnoreCase;
        names.sort(sample);
        System.out.println("Sorted Names (Ignore Case): " + names);

        /*** 5. Constructor Reference (ArrayList) ***/
        // ArrayList::new → creates new ArrayList
        /*
         * Input: ()
         * new ArrayList() → empty list
         * add elements → ["Hello","World"]
         *
         * () ---> [ArrayList::new] ---> []
         * [] ---> [add] ---> ["Hello","World"]
         */
        System.out.println("\n=== 5. Constructor Reference (ArrayList) ===");
        Supplier<List<String>> newList = ArrayList::new;
        List<String> createdList = newList.get();
        createdList.add("Hello");
        createdList.add("World");
        System.out.println("Created List: " + createdList);

        /*** 6. Array Constructor Reference ***/
        // int[]::new → creates array of given size
        /*
         * Input: 5
         * new int[5] → array length = 5
         *
         * 5 ---> [int[]::new] ---> int[5]
         */
        System.out.println("\n=== 6. Array Constructor Reference ===");
        Function<Integer, int[]> makeIntArray = int[]::new;
        int[] arr = makeIntArray.apply(5);
        System.out.println("Array length created: " + arr.length);

        /*** 7. Method Reference with Streams ***/
        List<String> id = List.of("101", "102", "103", "104","102","101","105");
        // Integer::valueOf → converts String to Integer
        /*
         * Stream<String> → map(Integer::valueOf) → collect(toList)
         * Input: ["101","102","103","104"]
         * Output: [101,102,103,104]
         *
         * ["101","102","103","104"] ---> [Integer::valueOf] ---> [101,102,103,104]
         */
        System.out.println("\n=== 7. Method Reference with Streams ===");
        Function<String, Integer> toInt = Integer::valueOf;
        List<Integer> ints = id.stream()
                               .map(toInt)
                               .toList();
        System.out.println("Converted IDs to Integers: " + ints);

        /*** 8. Constructor Reference (HashSet) ***/
        // HashSet::new → creates a new HashSet
        /*
         * Input: List of integers [101,102,103,104,101]
         * Process: Collect into HashSet using HashSet::new
         * Output: [101,102,103,104] (duplicates removed)
         *
         * [101,102,103,104,101] ---> [Collectors.toCollection(HashSet::new)] ---> [101,102,103,104]
         */
        System.out.println("\n=== 8. Constructor Reference (HashSet) ===");
        Set<Integer> uniqueIds = id.stream()
                                   .map(Integer::valueOf)
                                   .collect(Collectors.toCollection(HashSet::new));
        System.out.println("Unique IDs (duplicates removed): " + uniqueIds);

        /*** 9. Constructor Reference (HashMap) ***/
        // HashMap::new → creates a new HashMap
        /*
         * Input: List of names ["Neha","Ananya","Puja"]
         * Process: Collect into HashMap with name as key and length as value
         * Output: {Neha=4, Ananya=6, Puja=4}
         *
         * ["Neha","Ananya","Puja"] ---> [Collectors.toMap(name, name::length, HashMap::new)] ---> {Neha=4, Ananya=6, Puja=4}
         * toMap(Function keyMappper, Function valueMapper, BinaryOperator<U> mergeFunction, Supplier<M> mapSupplier)
         */
        System.out.println("\n=== 9. Constructor Reference (HashMap) ===");
        Map<String, Integer> nameLengthMap = names.stream()
                                                  .collect(java.util.stream.Collectors.toMap(
                                                      Function.identity(),   // key = name 
                                                      String::length,       // value = length
                                                      (v1, v2) -> v1,       // merge function (keep first if duplicate)
                                                      TreeMap::new          // constructor reference
                                                  ));
        System.out.println("Name-Length Map: " + nameLengthMap);
        
        List<String> source = Arrays.asList("Apple","Banana","Cherry","Dates");
        
        LinkedList<String> linkedList = source.stream()
        									.filter(s1->s1.length()>4)
        									.collect(Collectors.toCollection(LinkedList::new));
        System.out.println("SourceList: "+source);
        System.out.println("LinkedList: "+linkedList);
        

        /*** 10. PrintStream Method Reference Example ***/
        // System.out::println → prints each element
        /*
         * Stream<String> → forEach(System.out::println)
         * Output: prints each name
         *
         * names ---> [System.out::println] ---> console output
         */
        System.out.println("\n=== 10. PrintStream Method Reference ===");
        names.forEach(System.out::println);
    }
}
