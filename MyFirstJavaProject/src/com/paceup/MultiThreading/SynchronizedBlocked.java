package com.paceup.MultiThreading;

/*
 * Thread1 --->-----> [Lock on Object] ----> [Critical Section ] -----> [Release Lock] -----> Thread2
 *
 * This diagram shows how synchronization works:
 * - Only one thread can hold the lock on an object at a time.
 * - That thread enters the critical section (synchronized block).
 * - Other threads are blocked until the lock is released.
 */

class SharedResource1 {
    int j = 0; // shared counter

    void display(String message) {
        // synchronized block:
        // -------------------
        // Ensures only one thread at a time can execute this block for the same object.
        // 'this' refers to the current instance of SharedResource1.
        synchronized (this) {
            for (int i = 0; i < 2; i++) {
                System.out.print("[ " + message + " ] ");
                try {
                    Thread.sleep(500); // pauses thread for 0.5 seconds
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println();
        }

        // After leaving synchronized block, other threads can enter.
        System.out.println("Display method executed by " 
                           + Thread.currentThread().getName() 
                           + " " + j + " times!!!");
        j++;
    }
}

public class SynchronizedBlocked {
    public static void main(String[] args) {
        SharedResource1 resource = new SharedResource1();

        // Creating multiple threads
        for (int i = 1; i <= 3; i++) {
            String message = "Hello " + i;

            // Thread t1 → prints "Hello i"
            Thread t1 = new Thread(() -> resource.display(message));
            t1.start();
            t1.setPriority(1); // setting priority (hint to scheduler, not guaranteed)

            // Thread t2 → prints "World"
            Thread t2 = new Thread(() -> resource.display("World"));
            t2.start();

            System.out.println("Thread 2 priority " + t2.getPriority());
        }
    }
}
