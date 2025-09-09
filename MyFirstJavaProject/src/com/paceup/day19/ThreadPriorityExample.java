package com.paceup.day19;

class MyPriorityThread extends Thread {
	@Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " with priority " +
                           Thread.currentThread().getPriority() + " is running.");
        try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
    	MyPriorityThread t1 = new MyPriorityThread();
    	MyPriorityThread t2 = new MyPriorityThread();
    	MyPriorityThread t3 = new MyPriorityThread();
    	MyPriorityThread t4 = new MyPriorityThread();

        t1.setPriority(Thread.MIN_PRIORITY); // Priority 1
        t2.setPriority(Thread.NORM_PRIORITY); // Priority 5
        t3.setPriority(Thread.MAX_PRIORITY); // Priority 10
        t4.setPriority(7);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
