package com.paceup.day17;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ConcurrentSharedResource {
    private final Lock lock = new ReentrantLock(); //allows thread to reacquire the same lock when needed(reentrancy).

    void display(String message) {
        lock.lock(); //acquires lock meaning no other thread will enter this block 
        try {
            for (int i = 1; i <= 2; i++) {
                System.out.println(message + " - " + i + " Thread: "+Thread.currentThread().getId());
                try {
                    Thread.sleep(1000); // pauses for 100 ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock(); // release lock 
        }
    }
}

public class ConcurrentSynchronization {
    public static void main(String[] args) {
    	ConcurrentSharedResource resource = new ConcurrentSharedResource();

        Thread t1 = new Thread(() -> resource.display("Thread 1")); //Lambda Expression
        Thread t2 = new Thread(() -> resource.display("Thread 2"));

        t1.start();
        t2.start();
    }
}

