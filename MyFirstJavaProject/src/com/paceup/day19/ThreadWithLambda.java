package com.paceup.day19;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadWithLambda {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread thread = new Thread(() -> { //Available only after Java 8+
            System.out.println("Thread is running: " + Thread.currentThread().getName());
            System.out.println("Hi There");
        });
        thread.start(); // Starts the thread
        
        Callable<String> task = () -> { //Callable object created
        	Thread.sleep(1000);
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

