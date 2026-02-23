package com.paceup.MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ConcurrentSharedResource {
    // ReentrantLock:
    // --------------
    // A lock that allows the same thread to acquire it multiple times (reentrancy).
    private final Lock lock = new ReentrantLock();

    // Method demonstrating exclusive locking
    void display(String message) {
        lock.lock(); // acquires lock → only one thread can enter this block at a time
        try {
            for (int i = 1; i <= 2; i++) {
                System.out.println(message + " - " + i + " Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // pauses for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock(); // releases lock → allows other threads to enter
        }
    }

    /*
     * ReentrantReadWriteLock:
     * -----------------------
     * - Writer Lock → exclusive, blocks all readers and writers.
     * - Read Lock → shared, multiple readers allowed simultaneously.
     *
     * Rules:
     * - Many readers can run in parallel.
     * - Only one writer at a time.
     * - Writer blocks all readers.
     */

    int value = 0; // shared resource
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    // Writer method
    public void write(int newvalue) {
        rwLock.writeLock().lock(); // acquire exclusive write lock
        try {
            value = newvalue;
            System.out.println("Written " + value);
        } finally {
            rwLock.writeLock().unlock(); // release write lock
        }
    }

    // Reader method
    public void read() {
        rwLock.readLock().lock(); // acquire shared read lock
        try {
            System.out.println("Read " + value);
        } finally {
            rwLock.readLock().unlock(); // release read lock
        }
    }
}

public class ConcurrentSynchronization {
    public static void main(String[] args) {
        ConcurrentSharedResource resource = new ConcurrentSharedResource();

        // Two threads calling display() → only one enters at a time due to ReentrantLock
        Thread t1 = new Thread(() -> resource.display("Thread 1")); // Lambda Expression
        Thread t2 = new Thread(() -> resource.display("Thread 2"));

        t1.start();
        t2.start();

        // One writer thread → exclusive access
        new Thread(() -> resource.write(42)).start();

        // Three reader threads → can run in parallel
        for (int i = 0; i < 3; i++) {
            new Thread(resource::read).start();
        }
    }
}
