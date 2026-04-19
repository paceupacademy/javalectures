package com.paceup.Collections;

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

        System.out.println("=========== PRIORITY QUEUE ===========");

        /**
         * PriorityQueue with custom comparator
         * ------------------------------------
         * Sorting logic:
         * - Smaller priority value → Higher priority
         * - Example: priority 1 > priority 3
         */
        PriorityQueue<Student> pq = new PriorityQueue<>(
            (s1, s2) -> Integer.compare(s1.priority, s2.priority)
        );

        System.out.println("\n--- Adding Elements ---");

        // Adding students
        pq.add(new Student("Alice", 3));
        pq.add(new Student("Bob", 1));
        pq.add(new Student("Charlie", 2));
        pq.add(new Student("Demon", 5));
        pq.add(new Student("Eva", 4));

        /**
         * NOTE:
         * Printing PriorityQueue directly does NOT guarantee sorted order
         * because internal structure is a heap, not a sorted list.
         */
        System.out.println("PriorityQueue (Heap View): " + pq);

        System.out.println("\n--- Peek Operation ---");

        // Peek at head element (highest priority)
        System.out.println("Peek (highest priority): " + pq.peek());

        System.out.println("\n--- Polling Elements (Sorted Output) ---");

        /**
         * Poll removes elements in correct priority order
         * This is the ONLY way to guarantee sorted output
         */
        while (!pq.isEmpty()) {
            System.out.println("Removed: " + pq.poll());
        }

        System.out.println("\n--- Refill Queue ---");

        // Refill queue for iteration example
        pq.addAll(Arrays.asList(
            new Student("X", 10),
            new Student("Y", 7),
            new Student("Z", 8)
        ));

        System.out.println("Queue after refill: " + pq);

        System.out.println("\n--- Iteration (Not Sorted) ---");

        /**
         * IMPORTANT:
         * Iterator does NOT return elements in sorted order
         * It returns elements in heap structure order
         */
        Iterator<Student> itr = pq.iterator();
        while (itr.hasNext()) {
            System.out.println("Element: " + itr.next());
        }

        System.out.println("\n--- Queue Info ---");

        // Size of queue
        System.out.println("Size of queue: " + pq.size());

        System.out.println("\n--- Clearing Queue ---");

        // Clear queue
        pq.clear();
        System.out.println("After clear: " + pq);
        System.out.println("Is Empty? " + pq.isEmpty());

        System.out.println("\n=========== END OF CLASS ===========");
    }
}