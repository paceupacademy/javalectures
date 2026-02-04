package com.paceup.day15;
/*
 * Can a finally block get executed if system.exit() is called in try block? why or why not?
 * No - System.exit() is a hard stop for the JVM — it doesn’t throw an exception or return normally.
 * finally is skipped because System.exit() halts the JVM before the normal try/finally execution path can complete.
 */
public class Systemexit {

	public static void main(String[] args) {
		try {
            System.out.println("In try block");
            System.exit(0); // Terminates JVM
        } finally {
            System.out.println("In finally block"); // Will NOT execute
        }
	}

}
