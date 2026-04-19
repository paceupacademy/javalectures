package com.paceup.Collections;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

/**
 * 
 * LinkedList:
 * - Implements List, Deque, and Queue interfaces.
 * - Stores elements in a doubly-linked list structure.
 * - Allows fast insertions/removals at both ends.
 * - Can be used as a List (index-based), Deque (double-ended queue), or Queue (FIFO).
 * 
 * Internal Representation:
 * ------------------------
 * Each node contains:
 *   [prev | item | next]
 * - prev → reference to previous node
 * - item → actual data
 * - next → reference to next node
 * 
 * Example:
 *   Head → [Orange] → [Apple] → [Mango] → [Berry] → [Banana] → [Grapes] → Tail
 * 
 * Reflection Note:
 * - Internally, LinkedList maintains "first" and "last" node references.
 * - Reflection can be used to access these private fields, but this is for demonstration only.
 */
public class LinkedListExample {
    public static void main(String[] args) {

        System.out.println("=========== LINKED LIST DEMO ===========");

        // Create LinkedList instances
        List<String> list1 = new LinkedList<>(); // Using List reference
        LinkedList<String> list = new LinkedList<>(); // Using LinkedList directly

        System.out.println("\n--- Adding Elements ---");

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add(1, "Mango");       // Insert at index 1
        list.addFirst("Orange");    // Insert at beginning
        list.addLast("Grapes");     // Insert at end
        list.add(3, "Berry");       // Insert at index 3

        System.out.println("List after additions: " + list);

        System.out.println("\n--- Accessing Elements ---");

        // Accessing elements
        System.out.println("First Element : " + list.getFirst());
        System.out.println("Last Element  : " + list.getLast());
        System.out.println("Index 2 Value : " + list.get(2));

        System.out.println("\n--- Updating Elements ---");

        // Updating element at index 0
        list.set(0, "Guava");
        System.out.println("After update: " + list);

        System.out.println("\n--- Size ---");
        System.out.println("Size: " + list.size());

        System.out.println("\n--- Removing Elements ---");

        // Removing elements
        list.add("X");
        list.add("Y");
        list.add("Z");

        list.remove(); // Removes first element
        System.out.println("After remove(): " + list);

        list.remove(5); // Removes element at index 5
        list.remove("A"); // Removes element by value (no effect if not found)

        System.out.println("After removals: " + list);

        System.out.println("\n--- Checking Elements ---");

        // Checking elements
        System.out.println("Contains 10? " + list.contains(10)); // false
        System.out.println("Is list empty? " + list.isEmpty());

        System.out.println("\n--- Iteration Techniques ---");

        // Iterating using for loop
        System.out.print("For Loop      : ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // Iterating using for-each loop
        System.out.print("\nFor-Each Loop : ");
        for (String item : list) {
            System.out.print(item + " ");
        }

        // Iterator
        System.out.print("\nIterator      : ");
        list.iterator().forEachRemaining(item -> System.out.print(item + " "));

        // Lambda
        System.out.print("\nLambda        : ");
        list.forEach(l -> System.out.print(l + " "));
        System.out.println();

        System.out.println("\n--- Useful Methods ---");

        // Useful methods
        System.out.println("Peek Last (no removal): " + list.peekLast());
        System.out.println("Poll Last (removes last): " + list.pollLast());
        System.out.println("List after pollLast: " + list);

        /**
         * ✅ UPDATED ITERATION LOGIC (Formatted Output)
         * --------------------------------------------
         * Goal:
         * - Print Current, Previous, Next in structured format
         * - Avoid disturbing iterator position
         */
        System.out.println("\n--- Traversal (Prev | Current | Next) ---");

        ListIterator<String> it = list.listIterator();

        while (it.hasNext()) {

            int index = it.nextIndex();
            String current = it.next();

            System.out.println("Node Index : " + index);
            System.out.println("Current    : " + current);

            // Previous element
            if (index > 0) {
                System.out.println("Previous   : " + list.get(index - 1));
            } else {
                System.out.println("Previous   : None");
            }

            // Next element
            if (it.hasNext()) {
                System.out.println("Next       : " + list.get(index + 1));
            } else {
                System.out.println("Next       : None");
            }

            System.out.println("----------------------------------");
        }

        /*
         * Reflection Example (Advanced)
         * Accessing internal fields of LinkedList nodes.
         * NOTE: This is for demonstration only and not recommended in practice.
         * IMPORTANT: Only works if list is NOT empty.
         */
        System.out.println("\n--- Reflection Example ---");

        if (!list.isEmpty()) {
            try {
                Field firstField = LinkedList.class.getDeclaredField("last");
                firstField.setAccessible(true);

                Object firstNode = firstField.get(list);

                Field nextField = firstNode.getClass().getDeclaredField("prev");
                nextField.setAccessible(true);
                Object secondNode = nextField.get(firstNode);

                Field itemField = firstNode.getClass().getDeclaredField("item");
                itemField.setAccessible(true);

                System.out.println("First Element via reflection : " + itemField.get(firstNode));
                System.out.println("Second Element via reflection: " + itemField.get(secondNode));

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("List is empty, skipping reflection access.");
        }

        // Clear list AFTER reflection to avoid NullPointerException
        list.clear();
        System.out.println("\nAfter clear: " + list + " | Is Empty? " + list.isEmpty());

        /*
         * LinkedList as Queue
         * - FIFO behavior (First-In-First-Out).
         * - Methods: add(), poll(), peek().
         */
        System.out.println("\n=========== QUEUE EXAMPLE ===========");

        Queue<String> q = new LinkedList<>();
        q.add("Alice");
        q.add("Bob");
        q.add("Demon");
        q.add("Asha");

        System.out.println("Queue: " + q);
        System.out.println("Peek: " + q.peek());

        LinkedList<String> list5 = (LinkedList<String>) q;

        System.out.println("\n--- Queue Elements with Index ---");
        for (String item : q) {
            int index = list5.indexOf(item);
            System.out.println("Index: " + index + " | Value: " + item);
        }

        System.out.println("\nRemoved (poll): " + q.poll());
        System.out.println("Index of Demon: " + list5.indexOf("Demon"));

        System.out.println("Removed Bob? " + q.remove("Bob"));
        System.out.println("Queue after removals: " + q);
    }
}