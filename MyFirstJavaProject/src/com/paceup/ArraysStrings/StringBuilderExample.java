package com.paceup.ArraysStrings;

public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Welcome");
		StringBuilder sb2 =  new StringBuilder(50);
		CharSequence cs =  "Java";
		StringBuilder sb1 =  new StringBuilder(cs);

		// Append
		sb.append(" to Java");
		System.out.println(sb); // Output: Welcome to Java

		// Insert
		sb.insert(7, " Everyone");
		System.out.println(sb); // Output: Welcome Everyone to Java

		// Replace
		sb.replace(8, 16, "All");
		System.out.println(sb); // Output: Welcome All to Java

		// Delete
		sb.delete(7, 11);
		System.out.println(sb); // Output: Welcome to Java

		// Reverse
		sb.reverse();
		System.out.println(sb); // Output: avaJ ot emocleW
		
		System.out.println(sb.capacity());
		
	}
}

