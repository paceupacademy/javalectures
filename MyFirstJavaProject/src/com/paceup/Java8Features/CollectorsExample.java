package com.paceup.Java8Features;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Employee Stream Example:
 * ------------------------
 * Theoretical Notes:
 * ------------------
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
 * Interrelation:
 * --------------
 * - Intermediate operations (filter, map) transform the stream.
 * - Terminal operations (collect, max, min, averaging) produce results.
 * - Streams handle both primitive and custom objects seamlessly.
 *
 * Purpose of this Class:
 * ----------------------
 * - Demonstrates how to use Streams with custom Employee objects.
 * - Shows filtering, mapping, grouping, finding extremes, and averaging.
 */
class Employee {
    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    String getName() {
    	return this.name;
    }
    
    int getAge() {
    	return this.age;
    }

    @Override
    public String toString() {
        return name + " ";
    }
}

public class CollectorsExample {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee("Neha", 25),
            new Employee("Ananya", 30),
            new Employee("Puja", 28),
            new Employee("Akash", 35),
            new Employee("Ravi", 30),
            new Employee("Neha", 30),
            new Employee("Puja", 30)
        );

        /*** 1. Filtering Employees ***/
        System.out.println("=== 1. Filtering Employees (age > 28) ===");
        List<Employee> filtered = employees.stream()
                                           .filter(e -> e.age > 28)
                                           .collect(Collectors.toList());
        System.out.println("Result: " + filtered);

        /*** 2. Mapping Employee Names ***/
        System.out.println("\n=== 2. Mapping Employee Names ===");
        List<String> names = employees.stream()
                                      .map(e -> e.name)
                                      .collect(Collectors.toList());
        System.out.println("Result: " + names);

        
        /*** 4. Finding Oldest Employee ***/
        System.out.println("\n=== 4. Finding Oldest Employee ===");
        Optional<Employee> oldest = employees.stream()
                                             .max(Comparator.comparingInt(e -> e.age));
        System.out.println("Result: " + oldest.orElse(null));

        /*** 5. Finding Youngest Employee ***/
        System.out.println("\n=== 5. Finding Youngest Employee ===");
        Optional<Employee> youngest = employees.stream()
                                               .min(Comparator.comparingInt(e -> e.age));
        System.out.println("Result: " + youngest.orElse(null));

        /*** 6. Averaging Age of Employees ***/
        System.out.println("\n=== 6. Averaging Age of Employees ===");
        double avgAge = employees.stream()
                                 .collect(Collectors.averagingInt(e -> e.age));
        System.out.println("Result: " + avgAge);

        /*** 7. Collecting into Set (Unique Names) ***/
        System.out.println("\n=== 7. Collecting into Set (Unique Names) ===");
        Set<String> uniqueNames = employees.stream()
                                           .map(e -> e.name)
                                           .collect(Collectors.toSet());
        System.out.println("Result: " + uniqueNames);

        /*** 8. Joining Names into String ***/
        System.out.println("\n=== 8. Joining Names into String ===");
        String joinedNames = employees.stream()
                                      .map(e -> e.name)
                                      .collect(Collectors.joining(", "));
        System.out.println("Result: " + joinedNames);
        
        /*** 9.Counting ***/
        long count = employees.stream()
        		.count();
        System.out.println("Number of elements: "+count);
        
        
        /*** 3. Grouping Employees by Age ***/
        System.out.println("\n=== 3. Grouping Employees by Age ===");
        Map<Integer, List<Employee>> groupedByAge = employees.stream()
                                                             .collect(Collectors.groupingBy(e -> e.age));
        System.out.println("Result: " + groupedByAge);

        System.out.println("\n=== 3. Grouping Employees by Name and Mapping by Age ===");
        Map<String,List<Integer>> nameExtract = employees.stream()
        		.collect(Collectors.groupingBy(Employee::getName,Collectors.mapping(Employee::getAge, Collectors.toList())));
        
        System.out.println(nameExtract);
    }
}
