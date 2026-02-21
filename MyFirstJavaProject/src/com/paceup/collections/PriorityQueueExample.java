package com.paceup.collections;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * 
 * PriorityQueue:
 * - Implements Queue interface.
 * - Stores elements according to their priority (natural ordering or custom comparator).
 * - By default, smaller values have higher priority.
 * - Does not guarantee FIFO order like a normal queue.
 * - Internally backed by a binary heap (complete binary tree).
 * 
 * Internal Working:
 * -----------------
 * - Elements are arranged in a heap structure.
 * - Root of the heap always contains the smallest (or highest priority) element.
 * - Insertion (offer/add) and removal (poll) operations take O(log n).
 * - Iteration does NOT guarantee sorted order; only repeated poll() ensures priority order.
 * 
 * Representation Example:
 * -----------------------
 * Adding Students with priorities:
 *   Insert (Alice, 3) → Heap root
 *   Insert (Bob, 1) → Bob becomes new root (smaller priority)
 *   Insert (Charlie, 2) → Heap adjusts
 * 
 * Final Heap (min-heap by priority):
 *            (Bob,1)
 *           /      \
 *     (Alice,3)   (Charlie,2)
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

        // PriorityQueue with custom comparator (sort by priority field)
        PriorityQueue<Student> pq = new PriorityQueue<>(
            (s1, s2) -> Integer.compare(s1.priority, s2.priority)
        );

        // Adding students
        pq.add(new Student("Alice", 3));
        pq.add(new Student("Bob", 1));
        pq.add(new Student("Charlie", 2));
        pq.add(new Student("Demon", 5));
        pq.add(new Student("Eva", 4));

        // Print queue (heap order, not guaranteed sorted in toString)
        System.out.println("PriorityQueue: " + pq);

        // Peek at head element (highest priority, smallest number)
        System.out.println("Peek (head element): " + pq.peek());

        // Poll elements (removes head each time, ensures priority order)
        System.out.println("\nPolling elements:");
        while (!pq.isEmpty()) {
            System.out.println("Removed: " + pq.poll());
        }

        // Refill queue for iteration example
        pq.addAll(Arrays.asList(
            new Student("X", 10),
            new Student("Y", 7),
            new Student("Z", 8)
        ));

        // Iterating using Iterator (order not guaranteed)
        System.out.println("\nIterating elements (heap order, not sorted):");
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
