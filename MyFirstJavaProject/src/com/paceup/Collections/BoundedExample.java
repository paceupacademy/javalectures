package com.paceup.Collections;

import java.util.concurrent.LinkedBlockingDeque;

public class BoundedExample {
	public static void main(String[] args) throws InterruptedException{
		LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<Integer>(3);
		
		Thread producer =  new Thread(()-> {
			try {
				for(int i=0;i<=5;i++) {
					deque.putLast(i); //will block if full
					System.out.println("Produced: "+i);
					Thread.sleep(500);
				}
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			deque.clear();
		});
		
		Thread consumer =  new Thread(()-> {
			try {
				while(true) {
					Integer val = deque.takeFirst(); //will block if empty
					System.out.println("Consumed: "+val);
					Thread.sleep(500);
				}
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		
		producer.start();
		consumer.start();
		
		producer.join();
		consumer.join();
	}
}
