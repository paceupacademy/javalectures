package com.paceup.MultiThreading;

// A simple class extending Thread
// -------------------------------
// In Java, we can create a thread by either:
// 1. Extending the Thread class
// 2. Implementing the Runnable interface
//
// Here we extend Thread, so our class itself becomes a thread.
class MyThread extends Thread {

    // run() method:
    // -------------
    // This is the entry point of the thread.
    // When start() is called on a thread object, JVM internally calls run().
    @Override
    public void run() {
        // Printing the current thread name
        System.out.println("Thread is running: " + Thread.currentThread().getName());

        // Simulating work by looping
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i + " by " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // pauses thread for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread finished: " + Thread.currentThread().getName());
    }

    // main() method:
    // ---------------
    // Entry point of the program.
    public static void main(String[] args) {
        // Creating thread objects
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // Starting threads
        // ----------------
        // start() → tells JVM to create a new thread and call run() internally.
        // DO NOT call run() directly, otherwise it runs like a normal method in the main thread.
        t1.start();
        t2.start();

        // Main thread continues execution in parallel
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}
