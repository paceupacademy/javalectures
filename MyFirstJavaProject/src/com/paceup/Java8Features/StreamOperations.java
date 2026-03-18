package com.paceup.Java8Features;

import java.util.*;
import java.util.stream.*;

/**
 * StreamOperations:
 * -----------------
 * Theoretical Notes:
 * ------------------
 * 1. **Stream API**:
 *    - Introduced in Java 8 for functional-style operations on collections.
 *    - Allows processing of data in a pipeline (sequence of operations).
 *    - Two types of operations:
 *      a) Intermediate → return a Stream (e.g., filter, map, flatMap, distinct, sorted, peek).
 *      b) Terminal → produce a result (e.g., collect, reduce, forEach, findFirst).
 *
 * 2. **flatMap()**:
 *    - Flattens nested collections into a single stream.
 *    - Example: List<List<String>> → Stream<String>.
 *
 * 3. **filter()**:
 *    - Selects elements based on a condition.
 *    - Example: keep only strings starting with "S".
 *
 * 4. **map()**:
 *    - Transforms each element.
 *    - Example: convert strings to uppercase.
 *
 * 5. **distinct()**:
 *    - Removes duplicate elements.
 *
 * 6. **sorted()**:
 *    - Sorts elements in natural or custom order.
 *
 * 7. **peek()**:
 *    - Allows inspection of elements during processing without modifying the stream.
 *
 * 8. **collect()**:
 *    - Terminal operation that gathers results into a collection (List, Set, Map).
 *
 * 9. **reduce()**:
 *    - Terminal operation that combines elements into a single result (sum, concatenation).
 *
 * 10. **findFirst()**:
 *     - Terminal operation that returns the first element in the stream (wrapped in Optional).
 *
 * Interrelation:
 * --------------
 * - Intermediate operations build a pipeline of transformations.
 * - Terminal operations trigger execution of the pipeline and produce results.
 * - This class demonstrates how intermediate operations (flatMap, filter, map, distinct, sorted, peek)
 *   work together with terminal operations (collect, reduce, findFirst, forEach).
 * - It shows both intermediate inspection (via peek) and final results.
 *
 * Purpose of this Class:
 * ----------------------
 * - Flatten nested lists of strings.
 * - Apply filters and transformations.
 * - Inspect intermediate results.
 * - Collect final results into a list.
 * - Demonstrate reduce() for concatenation.
 * - Demonstrate findFirst() for element retrieval.
 */
public class StreamOperations {

    public static void main(String[] args) {
        List<List<String>> listofLists = Arrays.asList(
            Arrays.asList("Reflection","Annotation","Stream"),
            Arrays.asList("String","Array","Object"),
            Arrays.asList("Sorting","Searching","Reduction","Stream")
        );

        Set<String> intermediateResults = new HashSet<>();

        // Stream Intermediate Operations
        /*
         * Input: Nested lists of strings
         * Pipeline:
         * Stream<List<String>> 
         *   → flatMap(List::stream) → Stream<String>
         *   → filter(s.startsWith("S"))
         *   → map(String::toUpperCase)
         *   → distinct()
         *   → sorted()
         *   → peek(add to intermediateResults)
         *   → collect(toList)
         *
         * Result: ["SEARCHING","SORTING","STREAM","STRING"]
         */
        List<String> result = listofLists.stream()
                                         .flatMap(List::stream)
                                         .filter(s -> s.startsWith("S"))
                                         .map(String::toUpperCase)
                                         .distinct()
                                         .sorted()
                                         .peek(s -> intermediateResults.add(s))
                                         .collect(Collectors.toList());

        /*
         * Input: Nested lists of strings
         * Pipeline:
         * Stream<List<String>> 
         *   → flatMap(List::stream) → Stream<String>
         *   → filter(s.startsWith("S"))
         *   → collect(toList)
         *
         * Result: ["Stream","String","Sorting","Searching","Stream"]
         */
        List<String> result1 = listofLists.stream()
                                          .flatMap(List::stream)
                                          .filter(s -> s.startsWith("S"))
                                          .collect(Collectors.toList());

        // Reduce operation: concatenate names
        /*
         * Input: ["SEARCHING","SORTING","STREAM","STRING"]
         * Pipeline:
         * Stream<String> → reduce("", (partial, element) -> partial + " " + element)
         * Result: "SEARCHING SORTING STREAM STRING"
         */
        String concatenatedNames = result.stream()
                                         .reduce("", (partialString, element) -> partialString + " " + element);

        System.out.println("\nConcatenated String: " + concatenatedNames.trim());

        // FindFirst operation
        /*
         * Input: ["SEARCHING","SORTING","STREAM","STRING"]
         * Pipeline:
         * Stream<String> → findFirst()
         * Result: Optional["SEARCHING"]
         */
        Optional<String> firstElement = result.stream().findFirst();
        System.out.println("\nFirst Element is " + firstElement);

        System.out.println("\n filterMap result is: ");
        result1.forEach(System.out::println);

        System.out.println("\nIntermediate Operations Result:");
        intermediateResults.forEach(System.out::println);

        System.out.println("\nFinal Result: ");
        result.forEach(System.out::println);
    }
}
