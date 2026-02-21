package com.paceup.Java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * ReduceVariant:
 * --------------
 * 
 * Key Concepts:
 * -------------
 * 1. **reduce(identity, accumulator)**:
 *    - Takes an identity (initial value) and a BinaryOperator.
 *    - Applies the accumulator repeatedly to combine elements.
 *    - Example: sum of integers.
 *
 * 2. **reduce(accumulator)**:
 *    - No identity provided.
 *    - Returns an Optional<T> because the stream may be empty.
 *    - Example: finding maximum value.
 *
 * 3. **reduce(identity, accumulator, combiner)**:
 *    - Used in parallel streams.
 *    - Identity: initial value.
 *    - Accumulator: combines stream elements.
 *    - Combiner: merges partial results from parallel threads.
 *    - Example: summing salaries of employees.
 *
 * Use Cases:
 * ----------
 * - Summation, maximum/minimum, aggregation.
 * - Custom reduction logic for objects (like Employee salary).
 */
class Employee2 {
    String name;
    int salary;

    Employee2(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class ReduceVariant {
    public static void main(String[] args) {
        // Example 1: reduce(identity, accumulator) → sum of integers
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = nums.stream()
                      .reduce(0, (a, b) -> a + b); 
        // ((((0+1)+2)+3)+4)+5+6
        System.out.println("Sum of Elements: " + sum);

        // Example 2: reduce(accumulator) → maximum value
        Optional<Integer> max = nums.stream()
                                    .reduce((a, b) -> a > b ? a : b);
        System.out.println("Maximum value using reduce(): " + max.get());

        // Example 3: reduce(identity, accumulator, combiner) → total salary
        List<Employee2> emp = Arrays.asList(
            new Employee2("Akash", 473948),
            new Employee2("Ajay", 3874983),
            new Employee2("Rahul", 49837)
        );

        long totalSalary = emp.stream()
                              .reduce(0L, 
                                      (acc, e) -> acc + e.salary, // accumulator
                                      Long::sum);                 // combiner
        System.out.println("Total Salary: " + totalSalary);
    }
}
