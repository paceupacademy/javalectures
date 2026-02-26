//Create PriorityQueue of integers and show how it maintain order.
package com.paceup.Collections.Asse16;
import java.util.PriorityQueue;

public class CollectionExample5 {

	public static void main(String[] args) {
		/*
		 * The smallest element has the highest priority
		 * The smallest element is always at the head (root)
		 * The internal order is not sorted
		 * Printing the queue does NOT guarantee sorted order
		 * 
		 */
		PriorityQueue<Integer> pq = new PriorityQueue<>(); //Creates an empty min-heap.
		pq.add(3);	//Added 3  => 3
		pq.add(2);	//Since 2 < 3, it moves up (heap reorders)	 => 2, 3
		pq.add(8);	//8 is larger than 2, so it stays as a child.	=> 2,3,8
		System.out.println("PriorityQueue order 1st Three element: "+ pq); //Result	=> 2,3,8 This is heap order, not sorted order.
		
		pq.add(4);	//1 is smallest → moves to top.
		/*
		 *         2
      			 /   \
     			3     8
    		   /
   			  4
   			  
   			  Internal Array: [2, 3, 8, 4]
		 */
		System.out.println("PriorityQueue order added 4: "+ pq);
		
		pq.add(7);
		
		/* 		Before heap: [2, 3, 8, 4, 7]
		 * 
		 * 
		 *         	  2
      				/   \
     			   3     8
    			  / \
   				 4   7
   				 
   				Heapify (bubble up if needed)
				Compare 7 with its parent (3):
				7 > 3 = No swap needed
		 * 
		 * 		After Heap: [2, 3, 8, 4, 7]
		 * 
		 * 
		 */
		System.out.println("PriorityQueue order added 7: "+ pq);
		
		pq.add(6);
		
		/*
		 * Before Heap = [2, 3, 8, 4, 7, 6]
		 *		
		 *		After Heap Fix:
		 *		        2
      				  /   \
     				 3     6
    				/ \	   /
   				   4   7  8	 
   				 
   				 Compare 6 with its parent (8);
   				 6 < 8 -> swap needed
   				  
   			After array:  [2, 3, 6, 4, 7, 8]  				  
		 *
		 */
		System.out.println("PriorityQueue order added 6: "+ pq);
		
		pq.add(1);	//1 is smallest → moves to top.
		/*
		 * Before Heap = [2, 3, 6, 4, 7, 8, 1]  	
		 *		
		 *		After Heap Fix:
		 *		1 < 6 → swap, => [2, 3, 1, 4, 7, 8, 6]
		 *		1 < 2 → swap again =>  [1, 3, 2, 4, 7, 8, 6]
		 *		
		 *		        1						
      				  /   \
     				 3     2
    				/ \	  / \
   				   4   7 8	 6
   				  
   			After array:  [1, 3, 2, 4, 7, 8, 6]			  
		 *
		 */
		
		System.out.println("PriorityQueue order added 1: "+ pq);

	}

}
