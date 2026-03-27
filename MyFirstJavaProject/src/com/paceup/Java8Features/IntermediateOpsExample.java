package com.paceup.Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * IntermediateOpsExample:
 * -----------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Intermediate Operations**:
 *    - Transform or filter elements in a stream.
 *    - Examples: filter(), map(), distinct(), sorted(), limit(), skip(), flatMap(), peek().
 *    - They are *lazy* → they build a pipeline but do not execute until a terminal operation is called.
 *
 * 2. **Terminal Operations**:
 *    - Produce a result or side-effect from the stream.
 *    - Examples: forEach(), reduce(), count(), min(), max(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny().
 *    - They *trigger* the execution of the pipeline.
 *
 * 3. **Parallel Streams**:
 *    - Streams can be processed in parallel using multiple threads.
 *    - Example: parallelStream() → splits data into chunks for concurrent processing.
 */
public class IntermediateOpsExample {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(55, 10, 35, 15, 20, 25, 15, 30));
        nums.add(45);

        // filter(): keeps only elements that satisfy a condition
        // Backend visualization:
        // Stream pipeline: [55,10,35,15,20,25,15,30,45]
        // Each element flows through filter(x -> x > 12)
        // Elements failing condition are dropped, others continue downstream.
        List<Integer> result = nums.stream()
                                   .filter(x -> x > 22)
                                   .collect(Collectors.toList());
        System.out.println("Original List: " + nums);
        System.out.println("Filtered List: " + result);

        // map(): transforms each element
        // Backend visualization:
        // Each element passes through map(x -> x/5)
        // Original stream [55,10,35...] → transformed stream [11,2,7...]
        List<Integer> dby5 = nums.stream()
                                 .map(x -> x / 5)
                                 .collect(Collectors.toList());
        System.out.println("Divide by 5 result: " + dby5);

        // distinct(): removes duplicate elements
        // Backend visualization:
        // Stream maintains a set of "seen" elements.
        // If element already exists in set → skipped.
        List<Integer> distinctList = nums.stream()
                                         .distinct()
                                         .collect(Collectors.toList());
        System.out.println("Unique Elements: " + distinctList);

        // sorted(): sorts elements
        // Backend visualization:
        // Stream collects all elements → applies Comparator → outputs sorted stream.
        List<Integer> sortedList = nums.stream()
                                       .sorted((a, b) -> b.compareTo(a))
                                       .collect(Collectors.toList());
        System.out.println("Sorted List: " + sortedList);

        // limit(): takes only first N elements
        // Backend visualization:
        // Stream counter tracks how many elements passed.
        // Once N elements are emitted, pipeline stops.
        List<Integer> limitList = nums.stream()
                                      .limit(4)
                                      .collect(Collectors.toList());
        System.out.println("Limit List to 4 has: " + limitList);

        // skip(): skips first N elements
        // Backend visualization:
        // Stream counter discards first N elements, then passes remaining downstream.
        List<Integer> skipList = nums.stream()
                                     .skip(3)
                                     .collect(Collectors.toList());
        System.out.println("Skipped first 3 elements: " + skipList);

        // flatMap(): flattens nested structures
        // Backend visualization:
        // Each element of outer stream is itself a list.
        // flatMap(list -> list.stream()) merges all inner streams into one continuous stream.
        List<List<String>> listofLists = Arrays.asList(
            Arrays.asList("Java", "Spring"),
            Arrays.asList("Docker", "Kubernetes")
        );
        List<String> flatMapResult = listofLists.stream()
                                                .flatMap(list -> list.stream())
                                                .collect(Collectors.toList());
        System.out.println("Converted nested list: " + flatMapResult);

        // peek(): allows inspection/debugging
        // Backend visualization:
        // Each element flows through peek() → executes side-effect (print/log) → continues downstream unchanged.
        List<String> peekList = flatMapResult.stream()
                                             .peek(n -> System.out.println("Learning: " + n))
                                             .map(String::toUpperCase)
                                             .collect(Collectors.toList());
        System.out.println("Peeked List: " + peekList);

        /********************************/
        /**** Terminal Operations ********/
        /********************************/

        // forEach(): consumes stream elements one by one
        // Backend visualization:
        // Terminal operation pulls elements from pipeline → executes action for each.
        flatMapResult.stream().forEach(System.out::println);

        // reduce(): combines elements into a single result
        // Backend visualization:
        // Accumulator starts with identity (0).
        // Each element added sequentially → final sum produced.
        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println("Sum of addition of all elements is: " + sum);

        // count(): counts number of elements
        // Backend visualization:
        // Counter increments for each element flowing through pipeline.
        long cnt = nums.stream().count();
        System.out.println("Total number of elements is: " + cnt);

        // min() and max(): find smallest and largest values
        // Backend visualization:
        // Comparator applied across all elements → keeps track of min/max seen so far.
        int minVal = nums.stream().min(Integer::compare).get();
        int maxVal = nums.stream().max(Integer::compare).get();
        System.out.println("Minimum value: " + minVal + ", Maximum value: " + maxVal);

        // anyMatch(), allMatch(), noneMatch(): conditional checks
        // Backend visualization:
        // Short-circuiting operations:
        // - anyMatch → stops once condition true.
        // - allMatch → stops once condition false.
        // - noneMatch → stops once condition true.
        boolean any = nums.stream().anyMatch(x -> x > 25);
        boolean all = nums.stream().allMatch(x -> x > 5);
        boolean none = nums.stream().noneMatch(x -> x < 0);
        System.out.println("Values more than 25? " + any +
                           "\nValues greater than 5? " + all +
                           "\nNo values less than 0? " + none);

        // findFirst(): returns first element
        // Backend visualization:
        // Stream pulls first element → stops immediately.
        String first = flatMapResult.stream().findFirst().get();

        // findAny(): returns any element
        // Backend visualization:
        // In sequential stream → behaves like findFirst.
        // In parallel stream → may return whichever element is found first by any thread.
        String findAny = flatMapResult.parallelStream().findAny().get();
        System.out.println("First element: " + first + " Any Element: " + findAny);
    }
}

/*
 * Visualizing Streams Backend:
 * ----------------------------
 * Stream -> [1,2,3,4,5,6,7] -> pipeline of operations (filter/map/etc.) -> processed one-by-one -> Final Result
 *
 * ParallelStream -> [1,2,3,4,5,6,7,8]
 * Split into chunks: [1,2] [3,4] [5,6] [7,8]
 * Each chunk processed by separate thread
 * Results merged → Final Result
 *
 * Key: Intermediate ops build pipeline, terminal ops pull data through pipeline.
 */
