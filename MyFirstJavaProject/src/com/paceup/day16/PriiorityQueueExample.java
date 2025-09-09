package com.paceup.day16;

import java.util.PriorityQueue;

class Student {
	String name;
	int priority; //smaller = higher priority
	
	Student (String name, int priority){
		this.name = name;
		this.priority= priority;
	}
	
	@Override
	public String toString() {
		return "Student name:"+this.name+" priority:"+this.priority;
	}
}

public class PriiorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(5);
        System.out.println("PriorityQueue: " + pq); 
        pq.add(20);
        pq.add(1);
        System.out.println("PriorityQueue: " + pq);
        pq.add(100);
        System.out.println("PriorityQueue: " + pq);
        pq.add(-1);
        System.out.println("PriorityQueue: " + pq);
        pq.add(-2);

        System.out.println("PriorityQueue: " + pq); 

        System.out.println("Poll: " + pq.poll());  // Removes and returns -2 (smallest element)
        System.out.println("PriorityQueue: " + pq);
        pq.add(1);
        System.out.println("PriorityQueue: "+pq);
        System.out.println("Peek: " + pq.peek());  // Returns -1 (next smallest element)
        System.out.println("PriorityQueue: "+pq);
        
        pq.add(50);
        pq.add(12);
        pq.add(7);
        System.out.println("PriorityQueue: "+pq);
        
        System.out.println("\n\n *** Using Comparator ***\n\n");
        
        PriorityQueue<Student> spq = new PriorityQueue<>(
        			(s1,s2) -> Integer.compare(s1.priority, s2.priority)
        		);
        
        spq.add(new Student("Aishwarya",3));
        spq.add(new Student("Rahul", 1));
        System.out.println(spq);
        spq.add(new Student("Neha",2));
        System.out.println(spq);
        spq.add(new Student("Asha",5));
        System.out.println(spq);
        spq.add(new Student("Danny",-1));
        System.out.println(spq);
        spq.add(new Student("Daniel",-5));
        System.out.println(spq);
        
        
    }
}

