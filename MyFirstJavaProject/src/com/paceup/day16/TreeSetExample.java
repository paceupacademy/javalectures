package com.paceup.day16;

import java.util.TreeSet;
import java.util.Arrays;
import java.util.Comparator;

/**
 * TreeSet->NavigableSet=>SortedSet=>Set=>Collection=>Iterable
 * NavigableSet Interface : Navigation methods higher(), lower(), ceiling() and floor()
 * Performs operations like getting a closest match for a given element,descending order iteration
 * 
 * TreeSet:
 * - Implements Set interface.
 * - Stores elements in sorted order (natural ordering or custom comparator).
 * - Does not allow duplicates.
 * - Backed internally by a TreeMap (Red-Black Tree).
 * 
 * Representation:
 * - Each element is stored as a key in TreeMap with a dummy constant value.
 * - TreeMap maintains a balanced binary search tree.
 * - After each insertion, the tree rebalances to maintain O(log n) operations.
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

    @Override
    public int compareTo(Employee e) {
        return Integer.compare(this.id, e.id); // sort by id
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}

public class TreeSetExample {
    public static void main(String[] args) {
        
        TreeSet<Employee> employees = new TreeSet<>();
        
        //TreeSet<Employee> emp2 = new TreeSet<>(SortedSet s);
        
        //TreeSet<Employee> emp1 = new TreeSet<>(Comparator.comparingInt(Employee::getId));
        
        //TreeSet<E> ts = new TreeSet<>(Collection o);
        TreeSet<Employee> emp3 = new TreeSet<>(Arrays.asList(new Employee(110,"Ram"), new Employee(111,"Sita")));

        // Add Employee with id=103
        employees.add(new Employee(103, "Alice"));
        // Representation:
        // TreeMap:
        //   (103, DUMMY)
        System.out.println("After adding Alice: " + employees);

        // Add Employee with id=101
        employees.add(new Employee(101, "Bob"));
        // Representation:
        //       (101, DUMMY)
        //             \
        //             (103, DUMMY)
        System.out.println("After adding Bob: " + employees);

        // Add Employee with id=105
        employees.add(new Employee(105, "Charlie"));
        // Representation:
        //       (101, DUMMY)
        //             \
        //             (103, DUMMY)
        //                   \
        //                   (105, DUMMY)
        System.out.println("After adding Charlie: " + employees);

        // Add Employee with id=102
        employees.add(new Employee(102, "Demon"));
        // Representation:
        //       (101, DUMMY)
        //             \
        //             (103, DUMMY)
        //            /       \
        //   (102, DUMMY)   (105, DUMMY)
        System.out.println("After adding Demon: " + employees);

        // Add Employee with id=104
        employees.add(new Employee(104, "Eva"));
        // Representation:
        //       (101, DUMMY)
        //             \
        //             (103, DUMMY)
        //            /       \
        //   (102, DUMMY)   (105, DUMMY)
        //                  /
        //           (104, DUMMY)
        System.out.println("After adding Eva: " + employees);

        // Attempt to add duplicate id=101
        employees.add(new Employee(106, "Bob"));
        // Representation unchanged (duplicate ignored)
        System.out.println("After adding DuplicateBob: " + employees);
        
        Employee e = new Employee(106, "Bob");
        boolean b = employees.contains(new Employee(106, "Bob"));
        System.out.println(b);

        employees.remove(e);
        
        //ceiling(),floor(), higher(),lower()
        
        
        
        // Final TreeSet (sorted by id)
        System.out.println("Final Employees (sorted): " + employees);
    }
}
