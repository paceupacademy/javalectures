package com.paceup.Java8Features;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Employee Stream Example:
 * ------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Custom Objects in Streams**:
 *    - Streams can process lists of user-defined classes just like primitive types.
 *    - Useful for filtering, mapping, grouping, and aggregating data.
 *
 * 2. **Collectors**:
 *    - Collect results into lists, sets, maps, or perform summarization.
 *    - Examples: Collectors.toList(), Collectors.groupingBy(), Collectors.averagingInt().
 *
 * 3. **Optional**:
 *    - Represents a value that may or may not be present.
 *    - Useful for safe handling of results like max(), min(), findFirst().
 *
 * Use Cases:
 * ----------
 * - Filtering employees by age.
 * - Mapping employee names into a list.
 * - Grouping employees by age.
 * - Finding oldest/youngest employee.
 * - Calculating average age.
 */
class Employee {
    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ")";
    }
}

public class CollectorsExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aishwarya", 28),
            new Employee("Suraj", 25),
            new Employee("Bhavesh", 30),
            new Employee("Chirag", 22),
            new Employee("Priya", 27)
        );

        // Example 1: Filter employees older than 25
        System.out.println("Employees older than 25:");
        employees.stream()
                 .filter(e -> e.age > 25)
                 .forEach(System.out::println);

        // Example 2: Collect employee names into a List
        List<String> names = employees.stream()
                                      .map(e -> e.name)
                                      .collect(Collectors.toList());
        System.out.println("\nCollected Names: " + names);

        // Example 3: Group employees by age
        Map<Integer, List<Employee>> groupedByAge = employees.stream()
                                                             .collect(Collectors.groupingBy(e -> e.age));
        System.out.println("\nGrouped by Age: " + groupedByAge);

        // Example 4: Find the oldest employee
        Optional<Employee> oldest = employees.stream()
                                             .max(Comparator.comparingInt(e -> e.age));
        oldest.ifPresent(e -> System.out.println("\nOldest Employee: " + e));

        // Example 5: Calculate average age
        double avgAge = employees.stream()
                                 .collect(Collectors.averagingInt(e -> e.age));
        System.out.println("\nAverage Age: " + avgAge);

        // Example 6: Summary statistics
        IntSummaryStatistics stats = employees.stream()
                                              .collect(Collectors.summarizingInt(e -> e.age));
        System.out.println("\nAge Statistics: " + stats);
    }
}
