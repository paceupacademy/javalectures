package com.paceup.Java8Features;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * BoundedExample:
 * ---------------
 * Theoretical Notes:
 * ------------------
 * 1. **BlockingQueue / LinkedBlockingDeque**:
 *    - A thread-safe queue introduced in Java’s concurrency package.
 *    - Supports blocking operations: put() waits if full, take() waits if empty.
 *    - LinkedBlockingDeque is a double-ended queue (supports putFirst/putLast, takeFirst/takeLast).
 *
 * 2. **Producer-Consumer Problem**:
 *    - Classic concurrency example where producer threads generate data and consumer threads process it.
 *    - BlockingQueue helps coordinate producer and consumer without explicit synchronization.
 *
 * 3. **Bounded Queue**:
 *    - Queue with fixed capacity (here capacity=3).
 *    - Ensures controlled memory usage and backpressure (producer waits when full).
 *
 * Interrelation:
 * --------------
 * - Producer adds items → blocks if queue is full.
 * - Consumer removes items → blocks if queue is empty.
 * - Both threads safely share the queue without manual locks.
 *
 * Purpose of this Class:
 * ----------------------
 * - Demonstrates producer-consumer coordination using LinkedBlockingDeque.
 * - Shows blocking behavior when queue is full/empty.
 * - Illustrates bounded capacity and thread synchronization.
 */
public class BoundedExample {
	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<>(3);

		// Producer thread
		/*
		 * Produces integers 0–5
		 * Pipeline:
		 * for(i=0..5) → putLast(i) → blocks if full → print
		 *
		 * Example:
		 * 0 ---> [putLast] ---> queue
		 * 1 ---> [putLast] ---> queue
		 * ...
		 */
		Thread producer = new Thread(() -> {
			try {
				for (int i = 0; i <= 5; i++) {
					deque.putLast(i); // will block if full
					System.out.println("Produced: " + i);
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			deque.clear();
		});

		// Consumer thread
		/*
		 * Consumes integers from queue
		 * Pipeline:
		 * while(true) → takeFirst() → blocks if empty → print
		 *
		 * Example:
		 * queue ---> [takeFirst] ---> val ---> print
		 */
		Thread consumer = new Thread(() -> {
			try {
				while (true) {
					Integer val = deque.takeFirst(); // will block if empty
					System.out.println("Consumed: " + val);
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		producer.start();
		consumer.start();

		producer.join();
		consumer.join();
	}
}

/*
==============================================================================
Quick Reference: Producer-Consumer with LinkedBlockingDeque
==============================================================================
| Concept        | Operation         | Behavior                              |
|----------------|-------------------|---------------------------------------|
| putLast()      | Producer inserts  | Blocks if queue is full               |
| takeFirst()    | Consumer removes  | Blocks if queue is empty              |
| Capacity=3     | Bounded queue     | Controls memory, applies backpressure |
| Synchronization| Automatic         | No explicit locks needed              |
==============================================================================
 */
