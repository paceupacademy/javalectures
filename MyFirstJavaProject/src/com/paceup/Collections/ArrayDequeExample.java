package com.paceup.Collections;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * 
 * ArrayDeque implements Deque (double-ended queue), allowing insertion 
 * and removal of elements from both ends (head and tail).
 * 
 * Key operations:
 * - Adding/removing at both ends
 * - Accessing elements safely (peek/poll) vs. strictly (get/remove)
 * - Iterating with Iterator
 */
public class ArrayDequeExample {
    public static void main(String[] args) {

        System.out.println("=========== ARRAY DEQUE ===========");

        // Create an ArrayDeque of Strings
        ArrayDeque<String> deque = new ArrayDeque<>();

        System.out.println("\n--- Adding Elements ---");

        // Add elements (default adds at the tail)
        deque.add("P");
        deque.add("Q");
        deque.add("O");
        deque.add("a");
        System.out.println("Initial Deque: " + deque);

        // Add elements explicitly at head and tail
        deque.addFirst("A");   // Insert at front
        deque.addLast("B");    // Insert at end
        System.out.println("After addFirst & addLast: " + deque);

        System.out.println("\n--- Offer Operations ---");

        // Offer methods return boolean (true if successful)
        boolean flag = deque.offer("J"); // Adds at tail
        System.out.println("After offer (tail) -> " + flag + ": " + deque);

        boolean flag2 = deque.offerLast("K"); // Adds at tail
        System.out.println("After offerLast -> " + flag2 + ": " + deque);

        System.out.println("\n--- Peek Operations ---");

        // Peek methods (safe access, return null if empty)
        System.out.println("Peek (head): " + deque.peek());
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());

        System.out.println("\n--- Stack Behavior (Push) ---");

        // Push adds element at head (like stack)
        deque.push("K");
        System.out.println("After push at head: " + deque);

        System.out.println("\n--- Get Operations (Strict) ---");

        // Get methods (strict access, throw exception if empty)
        System.out.println("Get First: " + deque.getFirst());
        System.out.println("Get Last: " + deque.getLast());

        System.out.println("\n--- Find Element Index ---");

        // Find index of element "a" manually
        int index = 0;
        for (String val : deque) {
            if (val.equals("a")) {
                System.out.println("Index of 'a': " + index);
                break;
            }
            index++;
        }

        System.out.println("\n--- Iteration ---");

        // Iterating using Iterator
        Iterator<String> itr = deque.iterator();
        System.out.print("Elements: ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        /**
         * ✅ Proper usage of iterator.remove()
         * -----------------------------------
         * - Removes last returned element from iterator
         * - Must be called AFTER next()
         */
        itr = deque.iterator();
        if (itr.hasNext()) {
            itr.next();   // Move to first element
            itr.remove(); // Remove that element safely
        }
        System.out.println("After iterator.remove(): " + deque);

        System.out.println("\n--- Removal Operations ---");

        // Removing elements from both ends
        deque.removeFirst();   // Removes head
        System.out.println("After removeFirst: " + deque);

        deque.removeLast();    // Removes tail
        System.out.println("After removeLast: " + deque);

        deque.pollLast();      // Safe remove tail (returns null if empty)
        System.out.println("After pollLast: " + deque);

        System.out.println("\n--- Remove Specific Element ---");

        // Remove specific element
        deque.remove("P");
        System.out.println("After remove(\"P\"): " + deque);

        System.out.println("\n--- Clear Deque ---");

        // Clear deque
        deque.clear();
        System.out.println("After clear: " + deque);

        System.out.println("\n--- OfferFirst on Empty Deque ---");

        // OfferFirst adds at head (returns true if successful)
        System.out.println("OfferFirst empty string: " + deque.offerFirst(""));

        System.out.println("\n--- Exception Handling Example ---");

        /**
         * getLast() throws exception if deque is empty
         */
        try {
            System.out.println("Get Last: " + deque.getLast());
        } catch (Exception e) {
            System.out.println("Exception on getLast(): " + e);
        }

        System.out.println("\nFinal Deque: " + deque);
        System.out.println("=========== END OF CLASS ===========");
    }
}