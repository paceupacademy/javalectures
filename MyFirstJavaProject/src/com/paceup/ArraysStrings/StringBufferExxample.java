package com.paceup.ArraysStrings;

public class StringBufferExxample {
	public static void main(String[] args) {
		StringBuffer s =  new StringBuffer();
		StringBuffer sb = new StringBuffer("Everyone ");

		StringBuffer sb1 =  new StringBuffer(50);
		System.out.println(sb1.append(sb));
		sb1.append("World");
		//Capacity - Returns allocated capacity
		//New Capacity = (Old Capacity * 2) + 2
		System.out.println(sb1+" "+sb1.capacity());
		
		//Length
		System.out.println("Length of String Builder "+sb1.length());
		
		// Append - Adds at the end
		sb1.append(" to Java");
		System.out.println("After append: " + sb1);

		// Insert - Inserts at a index
		sb1.insert(8, " Welcome");
		System.out.println("After insert: " + sb1); //Welcome Everyone to Java

		// Replace - replace a range
		sb1.replace(8, 16, " All");
		System.out.println("After replace: " + sb1); 

		// Delete - deletes a range
		sb1.delete(8, 12);
		System.out.println("After delete: " + sb1); //Welcome to Java

		// Reverse - reverses characters
		sb1.reverse();
		System.out.println("After reverse: " + sb1);
	}
}
