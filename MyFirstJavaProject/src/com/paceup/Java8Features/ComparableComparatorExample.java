package com.paceup.Java8Features;

import java.util.*;
import java.util.stream.Collectors;

/**
 * StudentData Comparable & Comparator Example:
 * --------------------------------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Comparable Interface**:
 *    - Defines the natural ordering of objects.
 *    - Requires implementing the `compareTo()` method.
 *    - Example: Sorting students by age.
 *
 * 2. **Comparator Interface**:
 *    - Defines custom ordering separate from natural ordering.
 *    - Requires implementing the `compare()` method.
 *    - Example: Sorting students by name or ID.
 *
 * 3. **Collections.sort() & Stream.sorted()**:
 *    - Collections.sort(list): Sorts using Comparable or a given Comparator.
 *    - Stream.sorted(): Sorts elements in a stream (functional style).
 *
 * 4. **Optional & Collectors**:
 *    - Optional: Represents a value that may or may not be present.
 *    - Collectors: Used with streams to collect results (e.g., toList, toSet).
 *
 * Use Cases:
 * ----------
 * - Sorting student records by age, name, or ID.
 * - Using streams for functional-style sorting and filtering.
 * - Demonstrating both traditional and modern Java 8+ approaches.
 */
class StudentData implements Comparable<StudentData> {
    int id;
    String name;
    int age;

    public StudentData(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Natural ordering: by age (ascending)
    @Override
    public int compareTo(StudentData o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return name + "(ID: " + id + ", Age: " + age + ")";
    }
}

// Custom comparator: by name
class NameComparator implements Comparator<StudentData> {
    @Override
    public int compare(StudentData s1, StudentData s2) {
        return s1.name.compareToIgnoreCase(s2.name);
    }
}

// Custom comparator: by ID
class IdComparator implements Comparator<StudentData> {
    @Override
    public int compare(StudentData s1, StudentData s2) {
        return Integer.compare(s1.id, s2.id);
    }
}

public class ComparableComparatorExample {
    public static void main(String[] args) {
        List<StudentData> students = Arrays.asList(
            new StudentData(101, "Aishwarya", 28),
            new StudentData(102, "Suraj", 25),
            new StudentData(103, "Bhavesh", 30),
            new StudentData(104, "Chirag", 22)
        );

        System.out.println("Original List:");
        students.forEach(System.out::println);

        // Sorting using Comparable (by age)
        Collections.sort(students);
        System.out.println("\nSorted by Age (Comparable):");
        students.forEach(System.out::println);

        // Sorting using Comparator (by name)
        Collections.sort(students, new NameComparator());
        System.out.println("\nSorted by Name (Comparator):");
        students.forEach(System.out::println);

        // Sorting using Comparator (by ID)
        Collections.sort(students, new IdComparator());
        System.out.println("\nSorted by ID (Comparator):");
        students.forEach(System.out::println);

        // Using Streams API (Java 8+)
        System.out.println("\nSorted by Age using Streams:");
        students.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nSorted by Name using Streams:");
        students.stream()
                .sorted(new NameComparator())
                .forEach(System.out::println);

        // Filtering with Streams
        System.out.println("\nStudents older than 25:");
        students.stream()
                .filter(s -> s.age > 25)
                .forEach(System.out::println);

        // Collecting names into a Set
        Set<String> names = students.stream()
                                    .map(s -> s.name)
                                    .collect(Collectors.toSet());
        System.out.println("\nCollected Names: " + names);

        // Using Optional to find a student by ID
        Optional<StudentData> studentOpt = students.stream()
                                                   .filter(s -> s.id == 102)
                                                   .findFirst();
        studentOpt.ifPresent(s -> System.out.println("\nFound Student: " + s));
    }
}
