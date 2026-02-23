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
 *    - They are lazy and only executed when a terminal operation is invoked.
 *
 * 2. **Terminal Operations**:
 *    - Produce a result or side-effect from the stream.
 *    - Examples: forEach(), reduce(), count(), min(), max(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny().
 *    - They trigger the execution of the pipeline.
 *
 * 3. **Parallel Streams**:
 *    - Streams can be processed in parallel using multiple threads.
 *    - Example: parallelStream() → splits data into chunks for concurrent processing.
 */
public class IntermediateOpsExample {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(55, 10, 35, 15, 20, 25, 15, 30));
        nums.add(45);

        // filter(): keep only numbers greater than 12
        List<Integer> result = nums.stream()
                                   .filter(x -> x > 12)
                                   .collect(Collectors.toList());
        System.out.println("Original List: " + nums);
        System.out.println("Filtered List: " + result);

        // map(): transform each element (divide by 5)
        List<Integer> dby5 = nums.stream()
                                 .map(x -> x / 5)
                                 .collect(Collectors.toList());
        System.out.println("Divide by 5 result: " + dby5);

        // distinct(): remove duplicates
        List<Integer> distinctList = nums.stream()
                                         .distinct()
                                         .collect(Collectors.toList());
        System.out.println("Unique Elements: " + distinctList);

        // sorted(): sort in descending order
        List<Integer> sortedList = nums.stream()
                                       .sorted((a, b) -> b.compareTo(a))
                                       .collect(Collectors.toList());
        System.out.println("Sorted List: " + sortedList);

        // limit(): take first 4 elements
        List<Integer> limitList = nums.stream()
                                      .limit(4)
                                      .collect(Collectors.toList());
        System.out.println("Limit List to 4 has: " + limitList);

        // skip(): skip first 3 elements
        List<Integer> skipList = nums.stream()
                                     .skip(3)
                                     .collect(Collectors.toList());
        System.out.println("Skipped first 3 elements: " + skipList);

        // flatMap(): flatten nested lists
        List<List<String>> listofLists = Arrays.asList(
            Arrays.asList("Java", "Spring"),
            Arrays.asList("Docker", "Kubernetes")
        );
        List<String> flatMapResult = listofLists.stream()
                                                .flatMap(list -> list.stream())
                                                .collect(Collectors.toList());
        System.out.println("Converted nested list: " + flatMapResult);

        // peek(): debug/inspect elements during processing
        List<String> peekList = flatMapResult.stream()
                                             .peek(n -> System.out.println("Learning: " + n))
                                             .map(String::toUpperCase)
                                             .collect(Collectors.toList());
        System.out.println("Peeked List: " + peekList);

        /********************************/
        /**** Terminal Operations ********/
        /********************************/

        // forEach(): iterate and print
        flatMapResult.stream().forEach(System.out::println);

        // reduce(): sum of all elements
        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println("Sum of addition of all elements is: " + sum);

        // count(): number of elements
        long cnt = nums.stream().count();
        System.out.println("Total number of elements is: " + cnt);

        // min() and max(): find smallest and largest values
        int minVal = nums.stream().min(Integer::compare).get();
        int maxVal = nums.stream().max(Integer::compare).get();
        System.out.println("Minimum value: " + minVal + ", Maximum value: " + maxVal);

        // anyMatch(), allMatch(), noneMatch(): conditional checks
        boolean any = nums.stream().anyMatch(x -> x > 25);
        boolean all = nums.stream().allMatch(x -> x > 5);
        boolean none = nums.stream().noneMatch(x -> x < 0);
        System.out.println("Values more than 25? " + any +
                           "\nValues greater than 5? " + all +
                           "\nNo values less than 0? " + none);

        // findFirst(): get first element
        String first = flatMapResult.stream().findFirst().get();

        // findAny(): get any element (parallel stream may return different results)
        String findAny = flatMapResult.parallelStream().findAny().get();
        System.out.println("First element: " + first + " Any Element: " + findAny);
    }
}

/*
 * Stream -> [1,2,3,4,5,6,7] -> Processed one-by-one -> Final Result
 *
 * ParallelStream -> [1,2,3,4,5,6,7,8] -> [1,2] [3,4] [5,6] [7,8] (Splitting into chunks)
 * Each chunk -> processed using one thread
 * Multi-threading completed -> Final Result
 */
