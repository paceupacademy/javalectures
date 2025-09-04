package com.paceup.day16;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Create a Stack
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(10);
        stack.push(30);

        System.out.println("Stack: " + stack);

        // Peek at the top element without removing it
        System.out.println("Top element: " + stack.peek());

        // Retrieve and remove top element of stack
        System.out.println("Popped element: " + stack.pop());

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Search for an element
        System.out.println("Position of 10: " + stack.search(10));
        System.out.println("Position of 40: " + stack.search(40));
        
        System.out.println("Stack: "+stack);
    }
}

