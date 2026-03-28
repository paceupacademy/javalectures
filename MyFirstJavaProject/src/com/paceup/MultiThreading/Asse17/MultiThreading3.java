//3. Create a Java program where two threads attempt to access a method that is synchronized using ReentrantLock. Demonstrate mutual exclusion.
package com.paceup.MultiThreading.Asse17;

import java.util.concurrent.locks.ReentrantLock;

public class MultiThreading3 {

	private static final ReentrantLock Mylock = new ReentrantLock();

	public static void main(String[] args) {

		MultiThreading3 runnable = new MultiThreading3();
		Thread t1 = new Thread(() -> runnable.display("T1"));

		Thread t2 = new Thread(() -> runnable.display("T2"));

		t1.start();
		t2.start();

	}

	static void display(String name) {
		Mylock.lock();

		try {
			System.out.println(name + " is thread working...");
			Thread.sleep(500);
			for (int i = 1; i <= 3; i++) {
				System.out.println(name + " called iteration is " + i + " times.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Mylock.unlock();
		}
	}

}
