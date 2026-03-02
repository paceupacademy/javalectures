package com.paceup.MultiThreading;

/*
 * Thread1 --->-----> [Lock on Object] ----> [Critical Section ] -----> [Release Lock] -----> Thread2
 *
 * This diagram shows how synchronization works:
 * - Only one thread can hold the lock on an object at a time.
 * - That thread enters the critical section (synchronized method).
 * - Other threads are blocked until the lock is released.
 */

class SharedResource {
	// synchronized method:
	// --------------------
	// Ensures only one thread at a time can execute this method on a given object.
	// 'this' → refers to the current instance of SharedResource.
	synchronized void display(String message) {
		System.out.println(Thread.currentThread().getName()+"-------------------------------------------------------------------");
		for (int i = 0; i < 2; i++) {
			System.out.print(" [ " + message + " ] " + Thread.currentThread().getName() + "\n");
			try {
				Thread.sleep(500); // pauses thread for 0.5 seconds
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		System.out.println();
		System.out.println("-------------------------------------------------------------------");
	}

	//Static Synchronization locks the class SharedResource
	synchronized public static void printMethod(int n) {
		System.out.println("***********************************************************************");
		System.out.println("Static Synchronized Method Called!!");
		for(int i = 0; i<=n; i++) {
			System.out.println(Thread.currentThread().getName()+" executed "+i+ "times");
			try {
				Thread.sleep(2000);
			} catch(Exception e) {
				System.out.println(e.toString());
			}
		} 
		try {
			Thread.sleep(2000);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("***********************************************************************");
	}
}

// Thread class that uses SharedResource
class MySynchronizedThread extends Thread {
	SharedResource resource;
	String message;
	int n;

	// Constructor: assigns shared resource and message
	MySynchronizedThread(SharedResource resource, String message, int n) {
		this.resource = resource;
		this.message = message;
		this.n =  n;
	}

	// run() method: executed when thread starts
	@Override
	public void run() {
		resource.display(message); // calls synchronized method
		SharedResource.printMethod(n);
	}
}

public class ThreadSynchronization {
	public static void main(String[] args) {
		// Shared resource object
		SharedResource resource = new SharedResource();

		// Two threads created with same shared resource
		MySynchronizedThread t1 = new MySynchronizedThread(resource, "Hello", 1);
		MySynchronizedThread t2 = new MySynchronizedThread(resource, "World", 2);

		// Starting threads
		t1.start();
		t2.start();
	}
}
