package com.paceup.MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ConcurrentSharedResource {
    // ReentrantLock:
    // --------------
    // - A lock that supports reentrancy → the same thread can acquire it multiple times.
    // - Ensures only one thread executes the locked section at a time.
    private final Lock lock = new ReentrantLock();

    // Method demonstrating exclusive locking
    void display(String message) {
        lock.lock(); // acquire lock → only one thread allowed inside
        try {
            for (int i = 1; i <= 2; i++) {
                System.out.println(message + " called " + i + " times");
                try {
                    Thread.sleep(1000); // simulate work → pause for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock(); // release lock → other threads can enter
        }
    }

    /*
     * ReentrantReadWriteLock:
     * -----------------------
     * - Write Lock → exclusive, blocks all readers and writers.
     * - Read Lock → shared, multiple readers can hold it simultaneously.
     *
     * Rules:
     * - Multiple readers can run in parallel.
     * - Only one writer at a time.
     * - Writer blocks all readers until it finishes.
     */

    int value = 0; // shared resource
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    // Writer method
    public void write(int newvalue) {
        rwLock.writeLock().lock(); // acquire exclusive write lock
        try {
            value = newvalue;
            System.out.println("Written " + value + " Thread: " + Thread.currentThread().getName());
        } finally {
            rwLock.writeLock().unlock(); // release write lock
        }
    }

    // Reader method
    public void read() {
        rwLock.readLock().lock(); // acquire shared read lock
        try {
            System.out.println("Read " + value + " Thread: " + Thread.currentThread().getName());
        } finally {
            rwLock.readLock().unlock(); // release read lock
        }
    }
}

public class ConcurrentSynchronization {
    public static void main(String[] args) {
        ConcurrentSharedResource resource = new ConcurrentSharedResource();

        // Two threads calling display() → only one enters at a time due to ReentrantLock
        Thread t0 = new Thread(() -> resource.display("Thread 1")); // Lambda Expression
        Thread t1 = new Thread(() -> resource.display("Thread 2"));

        t0.start();
        t1.start();

        System.out.println("T1 Name: " + t0.getName());
        System.out.println("T2 Name: " + t1.getName());

        // Writer threads → exclusive access
        for (int i = 0; i < 3; i++) {
            new Thread(() -> resource.write(42)).start();
        }

        // Reader threads → can run in parallel
        for (int i = 0; i < 3; i++) {
            new Thread(resource::read).start();
        }
    }
}
