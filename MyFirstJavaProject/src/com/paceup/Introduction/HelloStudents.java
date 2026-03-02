/**
 * Package declaration:
 * --------------------
 * - Packages in Java are like folders that organize classes.
 * - Helps avoid naming conflicts and makes code modular.
 * - Here, the package is com.paceup.Introduction.
 */
package com.paceup.Introduction;

import java.util.Scanner;

/**
 * Class Declaration:
 * ------------------
 * - Every Java program must have at least one class.
 * - The class name should match the filename (HelloStudents.java).
 * - Classes are blueprints for objects, but here we just use it to hold main().
 */
public class HelloStudents {

	/**
	 * main() Method:
	 * --------------
	 * - Entry point of every Java program.
	 * - JVM (Java Virtual Machine) starts execution from here.
	 * - Syntax: public static void main(String[] args)
	 *   -> public: accessible everywhere
	 *   -> static: JVM can call it without creating an object
	 *   -> void: no return value
	 *   -> String[] args: command-line arguments (here named myArgs)
	 */
	public static void main(String myArgs[]) {

		// System.out.println():
		// ---------------------
		// Prints text to console and moves cursor to next line.
		System.out.println("Hello Students");

		// System.out.print():
		// -------------------
		// Prints text but does NOT move cursor to next line.
		System.out.print("Hello");

		// Escape Sequence:
		// ----------------
		// \n → newline character (forces cursor to next line).
		System.out.print("Name\n");

		// Variable Declaration:
		// ---------------------
		// int → primitive data type for integers.
		// d → variable name.
		// 10 → value assigned.
		int d = 10;

		// Note: variable 'd' is declared but not used in output.


		/*
		 * %s -> string
		 * %d -> integer
		 * %n -> newline
		 * %-15s -> first 15 characters
		 * %03d -> 0 = fill leading, 3 = width 
		 * 			7 -> 007, 16 -> 016 , 100 -> 100
		 */
		Scanner sc=new Scanner(System.in);
		System.out.println("================================");


		for(int i=0;i<3;i++)
		{ 
			System.out.println("Enter String without spaces");
			String s1=sc.nextLine();
			//Complete this line
			System.out.printf("%-15s%n",s1);

			System.out.println("Enter Integer ");
			int x=sc.nextInt();
			
			sc.nextLine();
			//Complete this line
			System.out.printf("%03d%n",x);
			//Complete this line
			//System.out.printf("%-15s%03d%n", s1,x);
		}
		System.out.println("================================");
	}
}
