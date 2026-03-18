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
        return name + " (" + age + ", " + (isMale ? "Male" : "Female") + ")";
    }
}

public class GroupingExample {
    public static void main(String[] args) {
        List<PersonData> people = Arrays.asList(
            new PersonData("Aishwarya", 25, false),
            new PersonData("Rahul", 30, true),
            new PersonData("Sneha", 28, false),
            new PersonData("Vikram", 35, true),
            new PersonData("Meera", 40, false)
        );

        // Example 1: Filter people older than 30
        /*
         * Stream<PersonData> → filter(p.age > 30) → collect(toList)
         * Result: [Vikram (35, Male), Meera (40, Female)]
         */
        List<PersonData> olderThan30 = people.stream()
                                             .filter(p -> p.age > 30)
                                             .collect(Collectors.toList());
        System.out.println("People older than 30: " + olderThan30);

        // Example 2: Map names into a list
        /*
         * Stream<PersonData> → map(p.name) → collect(toList)
         * Result: [Aishwarya, Rahul, Sneha, Vikram, Meera]
         */
        List<String> names = people.stream()
                                   .map(p -> p.name)
                                   .collect(Collectors.toList());
        System.out.println("Names: " + names);

        // Example 3: Group people by gender
        /*
         * Stream<PersonData> → collect(groupingBy(p.isMale))
         * Result: Map<Boolean, List<PersonData>>
         *   true → [Rahul, Vikram]
         *   false → [Aishwarya, Sneha, Meera]
         */
        Map<Boolean, List<PersonData>> groupedByGender = people.stream()
                                                               .collect(Collectors.groupingBy(p -> p.isMale));
        System.out.println("Grouped by gender: " + groupedByGender);

        // Example 4: Calculate average age
        /*
         * Stream<PersonData> → mapToInt(p.age) → average()
         * Result: OptionalDouble = 31.6
         */
        OptionalDouble avgAge = people.stream()
                                      .mapToInt(p -> p.age)
                                      .average();
        System.out.println("Average age: " + avgAge.orElse(0));

        // Example 5: Summary statistics
        /*
         * Stream<PersonData> → mapToInt(p.age) → summaryStatistics()
         * Result: count=5, min=25, max=40, sum=158, average=31.6
         */
        IntSummaryStatistics stats = people.stream()
                                           .mapToInt(p -> p.age)
                                           .summaryStatistics();
        System.out.println("Age statistics: " + stats);

        // Example 6: Find the oldest person
        /*
         * Stream<PersonData> → max(Comparator.comparingInt(p.age))
         * Result: Optional<PersonData> = Meera (40, Female)
         */
        Optional<PersonData> oldest = people.stream()
                                            .max(Comparator.comparingInt(p -> p.age));
        System.out.println("Oldest person: " + oldest.orElse(null));
    }
}
