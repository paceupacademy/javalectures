package com.paceup.MultiThreading;

/* Restaurant Service Analogy:
 * ----------------------------
 * Callable → Chef preparing food (task that returns a dish/result).
 * ExecutorService → Manager assigning chefs (thread pool that manages execution).
 * Future → Your order token (lets you collect dish when ready).
 *
 * Key Concepts:
 * - Runnable → simple task, no return value.
 * - Callable → similar to Runnable, but can return a result and throw checked exceptions.
 * - ExecutorService → manages threads via pools (instead of creating manually).
 * - Future → represents the result of an asynchronous computation.
 * - future.get() → waits until result is ready (like picking up your order).
 * - isDone() → check if task is completed.
 * - cancel() → attempt to cancel task execution.
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadWithLambda {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Example of Runnable with Lambda (commented out):
        /*
        Thread thread = new Thread(() -> { // Runnable task
            System.out.println("Thread is running: " + Thread.currentThread().getName());
            System.out.println("Hi There");
        });
        thread.start(); // Starts the thread (no return value)
        */

        // Callable task (returns a result)
        Callable<String> task = () -> {
            Thread.sleep(1000); // simulate work
            System.out.println("Thread count: " + Thread.activeCount());
            return "Callable called"; // return result
        };

        // ExecutorService:
        // ----------------
        // Creates a thread pool with a single worker thread.
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submit Callable task to ExecutorService:
        // ----------------------------------------
        // Returns a Future object representing the pending result.
        Future<String> future = executor.submit(task);

        // Future.get():
        // -------------
        // Blocks until the Callable finishes and returns its result.
        String result = future.get();

        System.out.println("Result: " + result);

        // Shutdown ExecutorService:
        // -------------------------
        // Always shut down to release resources.
        executor.shutdown();
    }
}
