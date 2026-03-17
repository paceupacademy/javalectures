/*
 *  Modify the above program to synchronize the print output using a synchronized block so that the messages don’t overlap.
 */
package com.paceup.MultiThreading.Asse16;

public class MultiThreading2 implements Runnable {

	@Override
	public void run() {
		synchronized (this) { // synchronize block

			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public static void main(String[] args) {
		MultiThreading2 runnable = new MultiThreading2();
		Thread t1 = new Thread(runnable, "Thread-1");
		Thread t2 = new Thread(runnable, "Thread-2");
		t2.setPriority(8);
		t1.start();
		t2.start();
		
	}

}
