package com.paceup.collections;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
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

        // Create LinkedList instances
        List<String> list1 = new LinkedList<>(); // Using List reference
        LinkedList<String> list = new LinkedList<>(); // Using LinkedList directly

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add(1, "Mango");       // Insert at index 1
        list.addFirst("Orange");    // Insert at beginning
        list.addLast("Grapes");     // Insert at end
        list.add(3, "Berry");       // Insert at index 3

        // Accessing elements
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("List: " + list);

        // Updating element at index 0
        list.set(0, "Guava");
        System.out.println("After update: " + list);

        // Checking size
        System.out.println("Size: " + list.size());

        // Removing elements
        list.add("X");
        list.add("Y");
        list.add("Z");
        list.remove(); // Removes first element
        System.out.println("After remove(): " + list);

        System.out.println("Element at index 1: " + list.get(1));

        list.remove(5); // Removes element at index 5
        list.remove("A"); // Removes element by value (no effect if not found)
        System.out.println("After removals: " + list);

        // Checking elements
        System.out.println("Contains 10? " + list.contains(10)); // false
        System.out.println("Is list empty? " + list.isEmpty());

        // Iterating using for loop
        System.out.print("Using for loop: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // Iterating using for-each loop
        System.out.println("\nUsing for-each:");
        for (String item : list) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Iterating using Iterator with forEachRemaining
        System.out.println("Using Iterator:");
        list.iterator().forEachRemaining(System.out::println);

        // Iterating using lambda expression
        System.out.print("Using lambda: ");
        list.forEach(l -> System.out.print(" " + l));
        System.out.println();

        // Useful methods
        System.out.println("Peek Last (no removal): " + list.peekLast());
        System.out.println("Poll Last (removes last): " + list.pollLast());
        System.out.println("List after pollLast: " + list);

        /*
         * Reflection Example (Advanced)
         * Accessing internal fields of LinkedList nodes.
         * NOTE: This is for demonstration only and not recommended in practice.
         * IMPORTANT: Only works if list is NOT empty.
         */
        if (!list.isEmpty()) {
            try {
                // Access private field "first" of LinkedList
                Field firstField = LinkedList.class.getDeclaredField("first");
                firstField.setAccessible(true);

                Object firstNode = firstField.get(list); // First node object

                // Access "next" field of node
                Field nextField = firstNode.getClass().getDeclaredField("next");
                nextField.setAccessible(true);
                Object secondNode = nextField.get(firstNode);

                // Access "item" field of node
                Field itemField = firstNode.getClass().getDeclaredField("item");
                itemField.setAccessible(true);

                System.out.println("First Element via reflection: " + itemField.get(firstNode));
                System.out.println("Second Element via reflection: " + itemField.get(secondNode));

            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("List is empty, skipping reflection access.");
        }

        // Clear list AFTER reflection to avoid NullPointerException
        list.clear();
        System.out.println("After clear: " + list + " | Is Empty? " + list.isEmpty());

        /*
         * LinkedList as Queue
         * - FIFO behavior (First-In-First-Out).
         * - Methods: add(), poll(), peek().
         */
        System.out.println("\n*** Queue Examples ***");
        Queue<String> q = new LinkedList<>();
        q.add("Alice");
        q.add("Bob");
        q.add("Demon");
        q.add("Asha");

        System.out.println("First Element (peek): " + q.peek());

        // Casting back to LinkedList to access indexOf
        LinkedList<String> list5 = (LinkedList<String>) q;
        for (String item : q) {
            int index = list5.indexOf(item);
            System.out.println("Index: " + index + " | Value: " + item);
        }

        System.out.println("Removed (poll): " + q.poll());
        LinkedList<String> list6 = (LinkedList<String>) q;
        System.out.println("Index of Demon: " + list6.indexOf("Demon"));

        System.out.println("Removed Bob? " + q.remove("Bob"));
        System.out.println("Queue after removals: " + q);
    }
}
