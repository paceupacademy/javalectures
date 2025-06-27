package com.paceup.day16;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Create a Queue
        Queue<String> queue = new LinkedList<>();

        // Add elements to the Queue
        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");

        // Display the Queue
        System.out.println("Queue: " + queue);

        // Peek at the head of the Queue
        System.out.println("Head of Queue: " + queue.peek());

        // Remove elements from the Queue
        System.out.println("Removed: " + queue.poll());
        System.out.println("Queue after removal: " + queue);

        // Check if the Queue is empty
        System.out.println("Is Queue empty? " + queue.isEmpty());
    }
}

