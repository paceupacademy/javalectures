//4. Using lambda expressions, start a thread that prints “Learning multithreading with lambda!” 3 times with a delay of 500ms between prints.
package com.paceup.MultiThreading.Asse16;

public class MultiThreading4 {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 1; i < 4; i++) {
				System.out.println("Learining  Multithreading with lambda!");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		t1.start();
	}

}
