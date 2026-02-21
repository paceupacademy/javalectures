package com.paceup.ArraysStrings;

public class StringBufferExxample {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Everyone ");

		StringBuffer sb1 =  new StringBuffer(50);
		System.out.println(sb1.append(sb));
		sb1.append("World");
		System.out.println(sb1+" "+sb1.capacity());
		// Append
		sb1.append(" to Java");
		System.out.println("After append: " + sb1);

		// Insert
		sb1.insert(8, " Everyone");
		System.out.println("After insert: " + sb1); //Welcome Everyone to Java

		// Replace
		sb1.replace(8, 17, " All");
		System.out.println("After replace: " + sb1); 

		// Delete
		sb1.delete(8, 12);
		System.out.println("After delete: " + sb1); //Welcome to Java

		// Reverse
		sb1.reverse();
		System.out.println("After reverse: " + sb1);
	}
}
