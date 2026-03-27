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
        return "["+name + ", " + age + ", " + (isMale ? "Male" : "Female")+"]" ;
    }
}

public class GroupingExample {
    public static void main(String[] args) {

        List<PersonData> people = Arrays.asList(
            new PersonData("Neha", 25, false),
            new PersonData("Ananya", 30, false),
            new PersonData("Puja", 28, false),
            new PersonData("Akash", 35, true),
            new PersonData("Ravi", 30, true)
        );

        /*** 1. Filtering People by Age ***/
        System.out.println("=== 1. Filtering People (age > 28) ===");
        List<PersonData> filtered = people.stream()
                                          .filter(p -> p.age > 28)
                                          .collect(Collectors.toList());
        System.out.println("Result: " + filtered);

        /*** 2. Mapping Names into List ***/
        System.out.println("\n=== 2. Mapping Names ===");
        List<String> names = people.stream()
                                   .map(p -> p.name)
                                   .collect(Collectors.toList());
        System.out.println("Result: " + names);

        /*** 3. Grouping People by Gender ***/
        System.out.println("\n=== 3. Grouping by Gender ===");
        Map<Boolean, List<PersonData>> groupedByGender = people.stream()
                                                               .collect(Collectors.groupingBy(p -> p.isMale));
        System.out.println("Result: " + groupedByGender);

        /*** 4. Finding Oldest Person ***/
        System.out.println("\n=== 4. Finding Oldest Person ===");
        Optional<PersonData> oldest = people.stream()
                                            .max(Comparator.comparingInt(p -> p.age));
        System.out.println("Result: " + oldest.orElse(null));

        /*** 5. Finding Youngest Person ***/
        System.out.println("\n=== 5. Finding Youngest Person ===");
        Optional<PersonData> youngest = people.stream()
                                              .min(Comparator.comparingInt(p -> p.age));
        System.out.println("Result: " + youngest.orElse(null));

        /*** 6. Calculating Average Age ***/
        System.out.println("\n=== 6. Calculating Average Age ===");
        double avgAge = people.stream()
                              .collect(Collectors.averagingInt(p -> p.age));
        System.out.println("Result: " + avgAge);

        /*** 7. Summary Statistics of Age ***/
        System.out.println("\n=== 7. Summary Statistics of Age ===");
        IntSummaryStatistics stats = people.stream()
                                           .collect(Collectors.summarizingInt(p -> p.age));
        System.out.println("Count: " + stats.getCount());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Sum: " + stats.getSum());

        /*** 8. Joining Names into String ***/
        System.out.println("\n=== 8. Joining Names into String ===");
        String joinedNames = people.stream()
                                   .map(p -> p.name)
                                   .collect(Collectors.joining(", "));
        System.out.println("Result: " + joinedNames);
    }
}
