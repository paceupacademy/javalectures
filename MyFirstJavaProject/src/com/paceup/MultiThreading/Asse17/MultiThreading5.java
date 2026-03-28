//5. Create a program where three threads are created with MIN, NORM, and MAX priority. Observe and explain the output.
package com.paceup.MultiThreading.Asse17;

public class MultiThreading5 extends Thread {
	private String name;

	public MultiThreading5(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 1; i < 4; i++) {
			System.out.println(name + " Priority: " + Thread.currentThread().getPriority() + " - count: " + i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MultiThreading5 t1 = new MultiThreading5("MIN");
		MultiThreading5 t2 = new MultiThreading5("NORM");
		MultiThreading5 t3 = new MultiThreading5("MAX");

		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(NORM_PRIORITY);
		t3.setPriority(MAX_PRIORITY);

		t1.start();
		t2.start();
		t3.start();
	}

}
