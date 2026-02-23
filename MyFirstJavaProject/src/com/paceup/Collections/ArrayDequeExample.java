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
        
        // Create an ArrayDeque of Strings
        ArrayDeque<String> deque = new ArrayDeque<>();

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

        // Offer methods return boolean (true if successful)
        boolean flag = deque.offer("J"); // Adds at tail
        System.out.println("After offer (tail) -> " + flag + ": " + deque);

        boolean flag2 = deque.offerLast("K"); // Adds at tail
        System.out.println("After offerLast -> " + flag2 + ": " + deque);

        // Peek methods (safe access, return null if empty)
        System.out.println("Peek (head): " + deque.peek());
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());

        // Push adds element at head (like stack)
        deque.push("K");
        System.out.println("After push at head: " + deque);

        // Get methods (strict access, throw exception if empty)
        System.out.println("Get First: " + deque.getFirst());
        System.out.println("Get Last: " + deque.getLast());

        // Find index of element "a" manually
        int index = 0;
        for (String val : deque) {
            if (val.equals("a")) {
                System.out.println("Index of 'a': " + index);
                break;
            }
            index++;
        }

        // Iterating using Iterator
        /*
         * if(itr.next().equals("P")) {
        		System.out.println("P found");
        	}
        	
         */
        Iterator<String> itr = deque.iterator();
        System.out.print("Iterating elements: ");
        while (itr.hasNext()) {
        	System.out.print(itr.next() + " ");
        }
        System.out.println();

        // Remove last element using iterator safely
        
        System.out.println("After iterator.remove(): " + deque);

        // Removing elements from both ends
        deque.removeFirst();   // Removes head
        System.out.println("After removeFirst: " + deque);

        deque.removeLast();    // Removes tail
        System.out.println("After removeLast: " + deque);

        deque.pollLast();      // Safe remove tail (returns null if empty)
        System.out.println("After pollLast: " + deque);

        // Remove specific element
        deque.remove("P");
        System.out.println("After remove(\"P\"): " + deque);

        // Clear deque
        deque.clear();
        System.out.println("After clear: " + deque);

        // OfferFirst adds at head (returns true if successful)
        System.out.println("OfferFirst empty string: " + deque.offerFirst(""));

        // getLast() throws exception if deque is empty
        try {
            System.out.println("Get Last: " + deque.getLast());
        } catch (Exception e) {
            System.out.println("Exception on getLast(): " + e);
        }

        System.out.println("Final Deque: " + deque);
    }
}
