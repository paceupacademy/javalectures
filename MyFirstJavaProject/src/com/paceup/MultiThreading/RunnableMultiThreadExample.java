package com.paceup.MultiThreading;

/*
 * Using Runnable:
 * ---------------
 * - Runnable allows us to define a reusable task (run() method).
 * - Multiple threads can execute the same task concurrently.
 * - This design is widely used in enterprise applications because:
 *   → It separates task logic (Runnable) from thread management (Thread).
 *   → It avoids the limitation of single inheritance (since we don’t extend Thread).
 */
class RunnableMultiThreadExample implements Runnable {
    private int number;

    // Constructor:
    // ------------
    // Accepts a number that this thread will print.
    public RunnableMultiThreadExample(int number) {
        this.number = number;
    }

    // run() method:
    // -------------
    // - Entry point of the thread when executed.
    // - When a Thread object is created with this Runnable and start() is called,
    //   JVM internally invokes run().
    // - All code inside run() executes in a separate thread.
    @Override
    public void run() {
        System.out.println("Thread started: " + Thread.currentThread().getName() +
                           " | Initial State: " + Thread.currentThread().getState());

        // Simulating work by printing numbers
        for (int i = 1; i <= number; i++) {
            System.out.println("Number " + i + " printed by " + Thread.currentThread().getName());
            try {
                // TIMED_WAITING State:
                // --------------------
                // sleep() puts thread into TIMED_WAITING for given duration.
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " Current State: " +
                                   Thread.currentThread().getState());
            } catch (InterruptedException e) {
                // Interrupted State:
                // ------------------
                // If another thread interrupts this thread during sleep/wait,
                // InterruptedException is thrown.
                System.out.println("Thread Interrupted: " + Thread.currentThread().getName());
                Thread.currentThread().interrupt(); // re-set interrupt flag
            }
        }

        // TERMINATED State:
        // -----------------
        // Once run() finishes, thread enters TERMINATED (DEAD) state.
        System.out.println("Thread completed: " + Thread.currentThread().getName() +
                           " | Final State: " + Thread.currentThread().getState());
    }

    // main() method:
    // ---------------
    // Entry point of the program.
    public static void main(String[] args) {
        // Creating Runnable tasks
        RunnableMultiThreadExample task1 = new RunnableMultiThreadExample(3);
        RunnableMultiThreadExample task2 = new RunnableMultiThreadExample(5);

        // Creating Thread objects with Runnable targets
        // NEW State:
        // ----------
        // When a Thread object is created but start() not yet called → NEW.
        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");
        
     // Checking states from main thread
        System.out.println(t1.getName() + " State (main block): " + t1.getState());
        System.out.println(t2.getName() + " State (main block): " + t2.getState());


        // Starting threads
        // ----------------
        // start() → tells JVM to create a new thread and call run() internally.
        // DO NOT call run() directly, otherwise it runs like a normal method in the main thread.
        // RUNNABLE State:
        // ---------------
        // After start() is called, thread enters RUNNABLE state (ready to run).
        t1.start();
        t2.start();

        
        // Main thread continues execution in parallel
        System.out.println(Thread.currentThread().getName() + " State: " +
                           Thread.currentThread().getState());
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
