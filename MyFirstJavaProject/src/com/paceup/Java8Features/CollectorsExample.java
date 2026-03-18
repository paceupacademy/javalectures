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

	@Override
	public String toString() {
		return name + " (" + age + ")";
	}
}

public class CollectorsExample {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee("Aishwarya", 25),
				new Employee("Rahul", 30),
				new Employee("Sneha", 28),
				new Employee("Vikram", 35),
				new Employee("Meera", 40)
				);

		// Example 1: Filter employees older than 30
		/*
		 * Input: [All employees]
		 * Output: [Vikram (35), Meera (40)]
		 *
		 * employees ---> [filter(age>30)] ---> [Vikram, Meera]
		 */
		List<Employee> olderThan30 = employees.stream()
				.filter(e -> e.age > 30)
				.collect(Collectors.toList());
		System.out.println("Employees older than 30: " + olderThan30);

		// Example 2: Map employee names into a list
		/*
		 * Input: [All employees]
		 * Output: ["Aishwarya","Rahul","Sneha","Vikram","Meera"]
		 *
		 * employees ---> [map(name)] ---> names list
		 */
		List<String> names = employees.stream()
				.map(e -> e.name)
				.collect(Collectors.toList());
		System.out.println("Employee Names: " + names);

		// Example 3: Group employees by age
		/*
		 * Input: [All employees]
		 * Output: Map<Age,List<Employee>>
		 *
		 * employees ---> [groupingBy(age)] ---> {25=[Aishwarya],30=[Rahul],...}
		 */
		Map<Integer, List<Employee>> groupedByAge = employees.stream()
				.collect(Collectors.groupingBy(e -> e.age));
		System.out.println("Grouped by Age: " + groupedByAge);

		// Example 4: Find oldest employee
		/*
		 * Input: [All employees]
		 * Output: Optional<Employee> = Meera (40)
		 *
		 * employees ---> [max(by age)] ---> Meera
		 */
		Optional<Employee> oldest = employees.stream()
				.max(Comparator.comparingInt(e -> e.age));
		System.out.println("Oldest Employee: " + oldest.orElse(null));

		// Example 5: Calculate average age
		/*
		 * Input: [All employees]
		 * Output: 31.6
		 *
		 * employees ---> [averagingInt(age)] ---> 31.6
		 */
		double avgAge = employees.stream()
				.collect(Collectors.averagingInt(e -> e.age));
		System.out.println("Average Age: " + avgAge);
	}
}

/*
============================================================================================
Quick Reference: Employee Stream Operations
============================================================================================
| Example        | Pipeline                          | Output                               |
|----------------|-----------------------------------|--------------------------------------|
| Filter         | employees → filter(age>30)        | [Vikram (35), Meera (40)]            |
| Map            | employees → map(name)             | [Aishwarya,Rahul,Sneha,Vikram,Meera] |
| Grouping       | employees → groupingBy(age)       | {25=[Aishwarya],30=[Rahul],...}      |
| Max            | employees → max(by age)           | Meera (40)                           |
| Average        | employees → averagingInt(age)     | 31.6                                 |
=============================================================================================
 */
