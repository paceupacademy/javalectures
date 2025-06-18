package com.paceup.day10;

public class StringBufferExxample {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Welcome");

		// Append
		sb.append(" to Java");
		System.out.println("After append: " + sb);

		// Insert
		sb.insert(7, " Everyone");
		System.out.println("After insert: " + sb); //Welcome Everyone to Java

		// Replace
		sb.replace(7, 16, " All");
		System.out.println("After replace: " + sb); 

		// Delete
		sb.delete(7, 11);
		System.out.println("After delete: " + sb); //Welcome to Java

		// Reverse
		sb.reverse();
		System.out.println("After reverse: " + sb);
	}
}
