package com.paceup.MultiThreading;

// A simple thread class demonstrating thread priorities
class MyPriorityThread extends Thread {

    // run() method:
    // -------------
    // This is the entry point of the thread.
    // When start() is called, JVM internally calls run().
    @Override
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName() +
                           " with priority " + Thread.currentThread().getPriority());

        // Simulate some work
        for (int i = 1; i <= 3; i++) {
            System.out.println("Iteration " + i + " by " + Thread.currentThread().getName());
            try {
                Thread.sleep(500); // pause for 0.5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread finished: " + Thread.currentThread().getName());
    }

    // main() method:
    // ---------------
    // Entry point of program.
    public static void main(String[] args) {
        // Creating three threads
        MyPriorityThread t1 = new MyPriorityThread();
        MyPriorityThread t2 = new MyPriorityThread();
        MyPriorityThread t3 = new MyPriorityThread();

        // Setting priorities:
        // -------------------
        // Thread priorities range from 1 (MIN_PRIORITY) to 10 (MAX_PRIORITY).
        // Default priority is 5 (NORM_PRIORITY).
        t1.setPriority(Thread.MIN_PRIORITY); // lowest priority (1)
        t2.setPriority(Thread.NORM_PRIORITY); // normal priority (5)
        t3.setPriority(Thread.MAX_PRIORITY); // highest priority (10)

        // Starting threads
        t1.start();
        t2.start();
        t3.start();

        // Main thread continues in parallel
        System.out.println("Main thread: " + Thread.currentThread().getName() +
                           " with priority " + Thread.currentThread().getPriority());
    }
}
