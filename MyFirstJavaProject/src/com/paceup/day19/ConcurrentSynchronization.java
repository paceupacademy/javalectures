package com.paceup.day19;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ConcurrentSharedResource {
	private final Lock lock = new ReentrantLock(); // allows thread to reacquire the same lock when needed(reentrancy).

	void display(String message) {
		lock.lock(); // acquires lock meaning no other thread will enter this block
		try {
			for (int i = 1; i <= 2; i++) {
				System.out.println(message + " - " + i + " Thread: " + Thread.currentThread().getName());
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
	
	/*
	 * WriterLock -> exclusive, block all readers and writer
	 * Read Lock -> shared, multiple readers allowed
	 * 
	 * Rules:
	 * -Many readers can run in parallel
	 * -Only one writer at a time
	 * -Writer blocks all readers
	 */
	
	int value =0; //shared resource
	private final ReentrantReadWriteLock rwLock =  new ReentrantReadWriteLock(); //manages both read and write locks
	
	public void write(int newvalue) {
		rwLock.writeLock().lock(); //acquired lock
		try {
			value = newvalue;
			System.out.println("Written "+value);
		} finally {
			rwLock.writeLock().unlock(); //release
		}
	}
	
	public void read() {
		rwLock.readLock().lock();
		try {
			System.out.println("Read "+value);
		}finally {
			rwLock.readLock().unlock();
		}
		
	}
}

public class ConcurrentSynchronization {
	public static void main(String[] args) {
		ConcurrentSharedResource resource = new ConcurrentSharedResource();

		Thread t1 = new Thread(() -> resource.display("Thread 1")); // Lambda Expression
		Thread t2 = new Thread(() -> resource.display("Thread 2"));

		t1.start();
		t2.start();
		
		new Thread(()->resource.write(42)).start(); //one writer
		
		for(int i=0;i<3;i++) {
			new Thread(resource::read).start(); //three reader
		}
	}
}
