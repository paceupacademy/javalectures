package com.paceup.day19;

/* With respect to Restaurant Service
 * Callable- similar to Runnable, this will return some result , can throw checked exception (chef preparing food)
 * Executor Service -  Will create threadpool where we can manage how our threads are executed : newSingleThreadExecutor, newFixedThreadPool(n), newCachedThreadPool (manager assigns chef)
 * Future -  When we submit Callable to ExecutorService it will return future object. get()- waits and return the result of computation , isDone()- check if task is completed, cancel() - Attempts to cancel the execution (your order token lets ou collect dish from counter
 * get() pick up order when it is ready
 * Execution Exception -  thread execution (task fail) from which you are expecting result (when a assistant chef has messed your order)
 * 
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadWithLambda {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*
		 * Thread thread = new Thread(() -> { //Available only after Java 8+
		 * System.out.println("Thread is running: " + Thread.currentThread().getName());
		 * System.out.println("Hi There"); }); thread.start(); // Starts the thread
		 */
        Callable<String> task = () -> { //Callable object created
        	Thread.sleep(1000);
        	System.out.println("Thread : "+Thread.activeCount());
        	return "Callable called";
        };
        
        //Creates thread pool with one thread
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        //submits callable task and returns future string object
        Future<String> future = executor.submit(task);
        
        //indirectly return value retrieve from call()
        String result = future.get();
        
        System.out.println("Result: "+result);
        
        executor.shutdown();
        
        
        
    }
}

