package com.paceup.MultiThreading;

// A simple class extending Thread
// -------------------------------
// In Java, threads can be created in two ways:
// 1. By extending the Thread class
// 2. By implementing the Runnable interface
//
// Here we extend Thread → the class itself becomes a thread.
class MyThread extends Thread {

    // run() method:
    // -------------
    // - This is the entry point of the thread.
    // - When start() is called on a thread object, JVM internally invokes run().
    // - All code inside run() executes in a separate thread.
    // - IMPORTANT: Calling run() directly will NOT start a new thread,
    //   it will just execute like a normal method in the current thread.
    @Override
    public void run() {
        // Printing the current thread name
        System.out.println("Thread is running: " + Thread.currentThread().getName());

        // Waiting State:
        // --------------
        // If join() is called on the current thread, it enters WAITING state
        // until the thread finishes execution.
        // Example (commented out here to avoid blocking):
        // Thread.currentThread().join();

        // Display current thread state
        System.out.println(Thread.currentThread().getName() + " Current State is " + Thread.currentThread().getState());

        // Simulating work by looping
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i + " by " + Thread.currentThread().getName());
            try {
                // TIMED_WAITING State:
                // --------------------
                // sleep() puts thread into TIMED_WAITING for given duration.
                Thread.sleep(2000); // pauses thread for 2 seconds
                System.out.println(Thread.currentThread().getState());

            } catch (InterruptedException e) {
                // Interrupted State:
                // ------------------
                // If another thread interrupts this thread during sleep/wait,
                // InterruptedException is thrown.
                System.out.println("Thread Interrupted");
                Thread.currentThread().interrupt(); // re-set interrupt flag
                // break; // optional: exit loop if interrupted
            }
        }

        // TERMINATED State:
        // -----------------
        // Once run() finishes, thread enters TERMINATED (DEAD) state.
        System.out.println("Thread Iteration Completed!! " + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + " Current State is " + Thread.currentThread().getState());
    }

    // main() method:
    // ---------------
    // Entry point of the program.
    public static void main(String[] args) {
        // Creating thread objects
        // NEW State:
        // ----------
        // When a thread object is created but start() not yet called → NEW.
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // Starting threads
        // ----------------
        // start() → tells JVM to create a new thread and call run() internally.
        // DO NOT call run() directly, otherwise it runs like a normal method in the main thread.
        // RUNNABLE State:
        // ---------------
        // After start() is called, thread enters RUNNABLE state (ready to run).
        t1.start();
        t2.start();

        // Checking states from main thread
        System.out.println(t1.getName() + " Current State for main block is " + t1.getState());
        System.out.println(t2.getName() + " Current State for main block is " + t2.getState());

        // Main thread continues execution in parallel
        System.out.println(Thread.currentThread().getName() + " Current State is " + Thread.currentThread().getState());
    }
}

/*
 * Thread Lifecycle States in Java:
 * --------------------------------
 * 1. NEW:
 *    - When a Thread object is created but start() has not yet been called.
 *    - Example: MyThread t = new MyThread(); → state is NEW.
 *
 * 2. RUNNABLE:
 *    - After start() is called, the thread is ready to run.
 *    - It may not run immediately → depends on CPU scheduling.
 *
 * 3. RUNNING:
 *    - When the thread scheduler picks the thread from RUNNABLE state,
 *      and its run() method is executing.
 *
 * 4. WAITING / TIMED_WAITING:
 *    - A thread can enter waiting states if it calls wait(), join(), or sleep().
 *    - WAITING → indefinite wait until notified.
 *    - TIMED_WAITING → waits for a specified time (e.g., sleep(2000)).
 *
 * 5. BLOCKED:
 *    - When a thread is waiting to acquire a lock (e.g., synchronized block).
 *
 * 6. TERMINATED (DEAD):
 *    - After run() method finishes execution, the thread is considered dead.
 *    - Once terminated, a thread cannot be restarted.
 *
 * Note:
 * - Thread states are managed by JVM and OS thread scheduler.
 * - Developers can observe states using getState() method.
 */
