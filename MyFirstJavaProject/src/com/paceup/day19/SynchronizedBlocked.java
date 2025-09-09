package com.paceup.day19;

/*
 * Thread1 --->-----> [Lock on Object] ----> [Critical Section ] -----> [Release Lock] -----> Thread2
 */

class SharedResource1 {
	int j = 0;

	void display(String message) {
		synchronized (this) { // only one thread can execute this block for any object //this refers to
								// current instance
			for (int i = 0; i < 2; i++) {
				System.out.print("[ " + message + " ] ");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
			System.out.println();
		}

		System.out.println("Display method executed by "+Thread.currentThread().getName()+ " " + j + " times!!!");
		j++;
	}
}

public class SynchronizedBlocked {
	public static void main(String[] args) {
		SharedResource1 resource = new SharedResource1();
		for (int i = 1; i <= 3; i++) {
			String message = "Hello " + i;
			Thread t1 = new Thread(() -> resource.display(message));
			t1.start();
			t1.setPriority(1);
			Thread t2 = new Thread(() -> resource.display("World"));
			t2.start();
			System.out.println("Thread 2 priority"+t2.getPriority());
		}
	}
}
