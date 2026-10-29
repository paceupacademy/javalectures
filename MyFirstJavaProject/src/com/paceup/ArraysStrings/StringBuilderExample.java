package com.paceup.ArraysStrings;

public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(7);
		sb.append("Welcome");
		StringBuilder sb2 =  new StringBuilder(50);
		CharSequence cs =  "Java";
		StringBuilder sb1 =  new StringBuilder(cs);

		System.out.println(sb.capacity());
		// Append
		sb.append(" to Java");
		System.out.println(sb); // Output: Welcome to Java
		System.out.println(sb.capacity());
		//New Capacity = (23 *2) +2
		// Insert
		sb.insert(7, " Everyone");
		System.out.println(sb); // Output: Welcome Everyone to Java
		System.out.println(sb.capacity());
		// Replace
		sb.replace(8, 16, "All");
		System.out.println(sb); // Output: Welcome All to Java
		System.out.println(sb.capacity());
		// Delete
		sb.delete(7, 11);
		System.out.println(sb); // Output: Welcome to Java
		System.out.println(sb.capacity());
		// Reverse
		sb.reverse();
		System.out.println(sb); // Output: avaJ ot emocleW
		
		System.out.println(sb.capacity());
		
	}
}

