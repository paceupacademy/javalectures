package com.paceup.MultiThreading;

// A simple class implementing Runnable
// ------------------------------------
// In Java, threads can be created in two ways:
// 1. By extending the Thread class
// 2. By implementing the Runnable interface
//
// Here we implement Runnable → the class does not itself become a thread,
// but provides the run() method logic that can be executed by a Thread object.
class MyRunnable implements Runnable {

    // run() method:
    // -------------
    // - This is the entry point of the thread when executed.
    // - When a Thread object is created with this Runnable and start() is called,
    //   the JVM internally invokes run().
    // - All code inside run() executes in a separate thread.
    @Override
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());

        // Simulating work with a loop
        for (int i = 1; i <= 3; i++) {
            System.out.println("Iteration " + i + " by " + Thread.currentThread().getName());
            try {
                // TIMED_WAITING State:
                // --------------------
                // sleep() puts thread into TIMED_WAITING for given duration.
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " Current State is " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                // Interrupted State:
                // ------------------
                // If another thread interrupts this thread during sleep/wait,
                // InterruptedException is thrown.
                System.out.println("Thread Interrupted");
                Thread.currentThread().interrupt(); // re-set interrupt flag
            }
        }

        // TERMINATED State:
        // -----------------
        // Once run() finishes, thread enters TERMINATED (DEAD) state.
        System.out.println("Thread Execution Completed!! " + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + " Current State is " + Thread.currentThread().getState());
    }

    // main() method:
    // ---------------
    // Entry point of the program.
    public static void main(String[] args) {
        // Creating Runnable object
        MyRunnable runnable = new MyRunnable();

        // Creating Thread objects with Runnable target
        // NEW State:
        // ----------
        // When a Thread object is created but start() not yet called → NEW.
        Thread t1 = new Thread(runnable, "Thread-1");
        Thread t2 = new Thread(runnable, "Thread-2");

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
 *    - Example: Thread t = new Thread(runnable); → state is NEW.
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
 *    - TIMED_WAITING → waits for a specified time (e.g., sleep(1000)).
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
