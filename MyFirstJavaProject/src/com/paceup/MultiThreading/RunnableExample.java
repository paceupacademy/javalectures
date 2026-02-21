package com.paceup.MultiThreading;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
        System.out.println("Thread details: "+Thread.currentThread().getId());
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        Thread t1 =  new Thread(new MyRunnable());
        thread.start(); // Starts the thread
       
    }
}

