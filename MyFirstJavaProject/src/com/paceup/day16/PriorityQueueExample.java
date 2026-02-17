package com.paceup.day16;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * 
 * PriorityQueue:
 * - Stores elements according to their priority (natural ordering or custom comparator).
 * - By default, smaller values have higher priority.
 * - Does not guarantee FIFO order like a normal queue.
 */
class Student {
    String name;
    int priority; // smaller = higher priority

    // Constructor
    Student(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    // Override toString() for readable output
    @Override
    public String toString() {
        return name + " (priority=" + priority + ")";
    }
}

public class PriorityQueueExample {
    public static void main(String[] args) {

        /*
         * PriorityQueue with custom comparator:
         * - Compare students based on their priority field.
         * - Lower priority value = higher priority in queue.
         */
        PriorityQueue<Student> pq = new PriorityQueue<>(
            (s1, s2) -> Integer.compare(s1.priority, s2.priority)
        );

        // Adding students
        pq.add(new Student("Alice", 3));
        pq.add(new Student("Bob", 1));
        pq.add(new Student("Charlie", 2));
        pq.add(new Student("Demon", 5));
        pq.add(new Student("Eva", 4));

        // Printing queue (order not guaranteed in toString)
        System.out.println("PriorityQueue: " + pq);

        // Accessing head element (highest priority)
        System.out.println("Peek (head element): " + pq.peek());

        // Removing elements in priority order
        System.out.println("\nPolling elements (removes head each time):");
        while (!pq.isEmpty()) {
            System.out.println("Removed: " + pq.poll());
        }

        /*
         * Refill queue for iteration example
         */
        pq.addAll(Arrays.asList(
            new Student("X", 10),
            new Student("Y", 7),
            new Student("Z", 8)
        ));

        // Iterating using Iterator (order not guaranteed)
        System.out.println("\nIterating elements (not in priority order):");
        Iterator<Student> itr = pq.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Size of queue
        System.out.println("Size of queue: " + pq.size());

        // Clear queue
        pq.clear();
        System.out.println("After clear: " + pq + " | Is Empty? " + pq.isEmpty());
    }
}
