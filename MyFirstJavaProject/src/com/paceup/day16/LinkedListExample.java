package com.paceup.day16;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add(1, "Mango"); // Inserts the element at the specified position.
        list.addFirst("Orange"); //Adds the element at the beginning.
        list.addLast("Grapes"); // Adds the element at the end.
        
        // Accessing elements
        System.out.println("First Element: " + list.getFirst()); //Retrieves the first element.
        System.out.println("Last Element: " + list.getLast()); //Retrieves the last element.
        System.out.println("Element at 2 Index is : "+ list.get(2));

        System.out.println(list);
        // Checking size
        System.out.println("Size: " + list.size());
        
        // Removing elements
        list.add("X");
        list.add("Y");
        list.add("Z");
        list.remove(); // Removes the first element
        System.out.println("After removing first: " + list);

        System.out.println("Value at 1st index element: "+ list.get(1));
        
        list.remove(1); //  Removes the element at the specified index.
        
        
        System.out.println("After 1st index first: " + list);
        
        //Checking Elements
        System.out.println("List contains 10? "+list.contains(10)); //Checks if the list contains the specified element.
        System.out.println("Is list empty:"+list.isEmpty()); //Checks if the list is empty.
        
        // Iterating Through the List
        // Using for-each loop
        for (String item : list) {
            System.out.print(item+ " ");
        }
        
        System.out.println();

        // Using Iterator
        list.iterator().forEachRemaining(System.out::println); //creates Iterator object: to traverse through collection one element at a time
        
        // Useful Methods
        System.out.println("Retrieving first element using peek(): "+list.peek()); // Retrieves the first element without removing it.
        System.out.println("Retrieving first element using poll(): "+list.poll()); // Retrieves and removes the first element.
        System.out.println(list);        
        System.out.println(list+ " Is Empty? "+list.isEmpty());
        list.clear(); //Removes all elements.
        System.out.println(list+ " Is Empty? "+list.isEmpty());
        /*
         * LinkedList with Queue Interface
         * 
         */
        Queue<String> q = new LinkedList<>();
        q.add("Alice");
        q.add("Bob");
        q.add("Demon");
        
        System.out.println("First Element: "+q.peek());
        LinkedList<String> list5 = (LinkedList<String>) q;
        for(String item:q) {
        	int index = list5.indexOf(item);
        	System.out.println("Index: "+ index +" Value: "+ item);        	
        }
        System.out.println("Removed: "+q.poll());
        LinkedList<String> list6 = (LinkedList<String>) q;
        System.out.println(" "+ list6.indexOf("Demon"));
        
        System.out.println("Queue: "+q);
        
		/*
		 * Field firstField; try {
		 * 
		 * //Get LinkedList class "first" field firstField =
		 * LinkedList.class.getDeclaredField("first"); firstField.setAccessible(false);
		 * 
		 * Object firstNode = firstField.get(list); //firstNode (Apple)
		 * 
		 * //Access the nextfield element Field nextfield =
		 * firstNode.getClass().getDeclaredField("next"); nextfield.setAccessible(true);
		 * 
		 * Object secondNode = nextfield.get(firstNode); //node for Banana
		 * 
		 * Field itemField = firstNode.getClass().getDeclaredField("item");
		 * itemField.setAccessible(true);
		 * 
		 * System.out.println("First Element: " + itemField.get(firstNode));
		 * System.out.println("Second Element: "+ itemField.get(secondNode)); } catch
		 * (NoSuchFieldException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SecurityException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } catch (IllegalArgumentException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (IllegalAccessException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
        
    }
}

