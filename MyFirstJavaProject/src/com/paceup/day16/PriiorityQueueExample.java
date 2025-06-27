package com.paceup.day16;

import java.util.PriorityQueue;

public class PriiorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(5);
        pq.add(20);

        System.out.println("PriorityQueue: " + pq); // Output: [5, 10, 20]

        System.out.println("Poll: " + pq.poll());  // Removes and returns 5 (smallest element)
        
        pq.add(1);
        System.out.println("PriorityQueue: "+pq);
        System.out.println("Peek: " + pq.peek());  // Returns 1 (next smallest element)
        System.out.println("PriorityQueue: "+pq);
        
        pq.add(50);
        pq.add(12);
        pq.add(7);
        System.out.println("PriorityQueue: "+pq);
        
        
    }
}

