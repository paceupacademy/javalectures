/*1. Write a Java program that creates two threads using Runnable interface to print numbers from 1 to 5. 
Each thread should print its own tag (e.g., Thread-1, Thread-2).
*/
package com.paceup.MultiThreading.Asse16;

public class MultiThreading1 implements Runnable {
	private String ThreadName;

	/*
	 * public MultiThreading1(String name) { this.ThreadName = name; }
	 */

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		MultiThreading1 runnable = new MultiThreading1();
		Thread t1 = new Thread(runnable, "Thread-1");
		Thread t2 = new Thread(runnable, "Thread-2");
		t1.start();
		t2.start();
	}

}
