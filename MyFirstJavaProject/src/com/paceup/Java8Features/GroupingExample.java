package com.paceup.Java8Features;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

/**
 * PersonData Streams Example:
 * ---------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Streams API**:
 *    - Introduced in Java 8 for functional-style operations on collections.
 *    - Supports operations like filter, map, sorted, collect, reduce.
 *
 * 2. **Collectors**:
 *    - Utility class for collecting stream results into lists, sets, maps, etc.
 *    - Examples: Collectors.toList(), Collectors.toSet(), Collectors.groupingBy().
 *
 * 3. **Optional**:
 *    - Represents a value that may or may not be present.
 *    - Useful for safe handling of results from stream operations.
 *
 * 4. **IntSummaryStatistics**:
 *    - Provides summary statistics (count, min, max, average, sum) for integer streams.
 *
 * Use Cases:
 * ----------
 * - Filtering people by age or gender.
 * - Mapping names into a list.
 * - Grouping people by gender.
 * - Calculating average age.
 */
class PersonData {
    String name;
    int age;
    boolean isMale;

    PersonData(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Male: " + isMale + ")";
    }
}

public class GroupingExample {
    public static void main(String[] args) {
        List<PersonData> people = Arrays.asList(
            new PersonData("Aishwarya", 28, false),
            new PersonData("Suraj", 25, true),
            new PersonData("Bhavesh", 30, true),
            new PersonData("Chirag", 22, true),
            new PersonData("Priya", 27, false)
        );

        // Example 1: Filter people older than 25
        System.out.println("People older than 25:");
        people.stream()
              .filter(p -> p.age > 25)
              .forEach(System.out::println);

        // Example 2: Collect names into a List
        List<String> names = people.stream()
                                   .map(p -> p.name)
                                   .collect(Collectors.toList());
        System.out.println("\nCollected Names: " + names);

        // Example 3: Group people by gender
        Map<Boolean, List<PersonData>> groupedByGender = people.stream()
                                                               .collect(Collectors.groupingBy(p -> p.isMale));
        System.out.println("\nGrouped by Gender:");
        System.out.println("Males: " + groupedByGender.get(true));
        System.out.println("Females: " + groupedByGender.get(false));

        // Example 4: Find the oldest person
        Optional<PersonData> oldest = people.stream()
                                            .max(Comparator.comparingInt(p -> p.age));
        oldest.ifPresent(p -> System.out.println("\nOldest Person: " + p));

        // Example 5: Calculate average age
        double avgAge = people.stream()
                              .collect(Collectors.averagingInt(p -> p.age));
        System.out.println("\nAverage Age: " + avgAge);

        // Example 6: Summary statistics
        IntSummaryStatistics stats = people.stream()
                                           .collect(Collectors.summarizingInt(p -> p.age));
        System.out.println("\nAge Statistics: " + stats);
    }
}
