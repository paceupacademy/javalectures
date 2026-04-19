package com.paceup.Collections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Queue:
 * - Follows FIFO (First-In-First-Out) principle
 * - Elements are added at the rear and removed from the front
 * - Common methods:
 *     add()  → inserts element (throws exception if fails)
 *     offer()→ inserts element (returns false if fails)
 *     peek() → retrieves head without removing
 *     poll() → retrieves and removes head
 */
public class QueueExample {
    public static void main(String[] args) {

        System.out.println("=========== QUEUE ===========");

        // Create a Queue (LinkedList implementation)
        Queue<String> queue = new LinkedList<>();

        System.out.println("\n--- Adding Elements ---");

        // Add elements to the Queue
        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");

        // Display Queue
        System.out.println("Queue after adding elements: " + queue);

        System.out.println("\n--- Peek Operation ---");

        /**
         * peek():
         * - Returns head element
         * - Does NOT remove it
         */
        System.out.println("Head of Queue (peek): " + queue.peek());

        System.out.println("\n--- Poll Operation ---");

        /**
         * poll():
         * - Removes and returns head element
         * - Follows FIFO order
         */
        System.out.println("Removed element (poll): " + queue.poll());

        // Queue after removal
        System.out.println("Queue after removal: " + queue);

        System.out.println("\n--- Clearing Queue ---");

        // Clear queue
        queue.clear();

        System.out.println("Queue after clear: " + queue);

        System.out.println("\n--- Check Empty ---");

        // Check if the Queue is empty
        System.out.println("Is Queue empty? " + queue.isEmpty());

        System.out.println("\n=========== END OF CLASS ===========");
    }
}