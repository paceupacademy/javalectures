package com.paceup.collections;

import java.util.Collections;
import java.util.Stack;

/**
 * 
 * Stack is a legacy class that extends Vector:
 * - Follows LIFO (Last-In-First-Out) principle.
 * - push() → add element to top
 * - pop() → remove element from top
 * - peek() → view top element without removing
 * - search() → find position of element (1-based from top)
 * - isEmpty() → check if stack is empty
 */
public class StackExample {
    public static void main(String[] args) {
        
        // Create a Stack of Integers
        Stack<Integer> stack = new Stack<>();
        
        // Push elements onto the stack (adds to top)
        stack.push(10);
        stack.push(20);
        stack.push(10);   // duplicate allowed
        stack.push(30);
        stack.push(50);
        stack.push(100);

        // Print stack (Vector’s toString shows elements in insertion order)
        System.out.println("Stack: " + stack);

        // Peek at the top element without removing it
        System.out.println("Top element (peek): " + stack.peek());

        // Pop removes and returns the top element
        System.out.println("Popped element: " + stack.pop());

        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        /*
         * Search method:
         * - Returns 1-based position from the top of stack.
         * - If element not found, returns -1.
         */
        System.out.println("Position of 11: " + stack.search(11)); // not present → -1
        System.out.println("Position of 40: " + stack.search(40)); // not present → -1

        // Frequency of an element using Collections utility
        System.out.println("Frequency of 10: " + Collections.frequency(stack, 10));

        // Final stack after operations
        System.out.println("Final Stack: " + stack);
    }
}
