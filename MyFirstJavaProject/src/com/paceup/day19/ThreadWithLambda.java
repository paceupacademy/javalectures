package com.paceup.day19;

public class ThreadWithLambda {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> { //Available only after Java 8+
            System.out.println("Thread is running: " + Thread.currentThread().getName());
        });
        thread.start(); // Starts the thread
    }
}

