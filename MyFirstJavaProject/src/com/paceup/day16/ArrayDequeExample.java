package com.paceup.day16;

import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.add("P");
        deque.add("Q");
        deque.add("O");
        deque.add("a");
        System.out.println(deque);
        // Adding elements
        deque.addFirst("A");
        
        deque.addLast("B");
        System.out.println(deque);
        
        

        System.out.println("Deque after additions: " + deque);

        // Accessing elements
        System.out.println("First Element: " + deque.getFirst());
        System.out.println("Last Element: " + deque.getLast());

        // Removing elements
        deque.removeFirst();
        System.out.println("Deque after removals: " + deque);
        deque.removeLast();
        System.out.println("Deque after removals: " + deque);
        deque.pollLast();
        System.out.println("Deque after removals: " + deque);
        
        deque.remove("P");

        System.out.println("Deque after removals: " + deque);
        
        deque.clear();
        deque.offerFirst("");
        deque.offerLast("D");
        
        System.out.println(deque);
        
        //Deque Example
        
        
    }
}

