package com.paceup.Collections;

import java.util.TreeSet;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * TreeSet:
 * - Implements NavigableSet → SortedSet → Set → Collection → Iterable.
 * - Stores elements in sorted order (natural ordering or custom comparator).
 * - Does not allow duplicates.
 * - Backed internally by a TreeMap (Red-Black Tree).
 * 
 * NavigableSet Interface:
 * - Provides navigation methods: higher(), lower(), ceiling(), floor().
 * - Useful for finding closest matches and iterating in descending order.
 * 
 * Internal Working:
 * -----------------
 * - Each element is stored as a key in TreeMap with a dummy constant value.
 * - TreeMap maintains a balanced binary search tree (Red-Black Tree).
 * - After each insertion, the tree rebalances to maintain O(log n) operations.
 * 
 * Representation Example:
 * -----------------------
 * Adding Employees by id:
 *   Insert 103 → Root
 *   Insert 101 → Left child of 103
 *   Insert 105 → Right child of 103
 *   Insert 102 → Right child of 101
 *   Insert 104 → Left child of 105
 * 
 * Final Tree (sorted by id):
 *            (103)
 *           /     \
 *       (101)     (105)
 *          \      /
 *         (102) (104)
 */
class Employee implements Comparable<Employee> {
    int id;
    String name;

    public int getId() {
        return this.id;
    }

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Natural ordering: sort by id
    @Override
    public int compareTo(Employee e) {
        return Integer.compare(this.id, e.id);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}

public class TreeSetExample {
    public static void main(String[] args) {
        
        // TreeSet with natural ordering (by id)
        TreeSet<Employee> employees = new TreeSet<>();

        // Adding employees
        employees.add(new Employee(103, "Alice"));
        employees.add(new Employee(101, "Bob"));
        employees.add(new Employee(105, "Charlie"));
        employees.add(new Employee(102, "Demon"));
        employees.add(new Employee(104, "Eva"));

        // Duplicate id ignored (compareTo returns 0)
        employees.add(new Employee(101, "DuplicateBob"));

        // Print TreeSet (sorted by id)
        System.out.println("Employees (sorted by id): " + employees);

        // Access first and last elements
        System.out.println("First Employee: " + employees.first());
        System.out.println("Last Employee: " + employees.last());

        // Navigation methods
        System.out.println("Employee higher than id=102: " + employees.higher(new Employee(102, "Temp")));
        System.out.println("Employee lower than id=104: " + employees.lower(new Employee(104, "Temp")));
        System.out.println("Ceiling (>=102): " + employees.ceiling(new Employee(102, "Temp")));
        System.out.println("Floor (<=104): " + employees.floor(new Employee(104, "Temp")));

        // Subset operations
        System.out.println("HeadSet (id < 104): " + employees.headSet(new Employee(104, "Temp")));
        System.out.println("TailSet (id >= 103): " + employees.tailSet(new Employee(103, "Temp")));
        System.out.println("SubSet (102 <= id < 105): " + employees.subSet(new Employee(102, "Temp"), new Employee(105, "Temp")));

        // Remove element
        employees.remove(new Employee(103, "Alice"));
        System.out.println("After removal: " + employees);

        // Size of TreeSet
        System.out.println("Size: " + employees.size());

        // Clear TreeSet
        employees.clear();
        System.out.println("After clear: " + employees + " | Is Empty? " + employees.isEmpty());

        // TreeSet with custom comparator (sort by name instead of id)
        TreeSet<Employee> employeesByName = new TreeSet<>(Comparator.comparing(e -> e.name));
        employeesByName.addAll(Arrays.asList(
            new Employee(103, "Alice"),
            new Employee(101, "Bob"),
            new Employee(105, "Charlie"),
            new Employee(102, "Demon"),
            new Employee(104, "Eva")
        ));
        System.out.println("Employees (sorted by name): " + employeesByName);
    }
}
