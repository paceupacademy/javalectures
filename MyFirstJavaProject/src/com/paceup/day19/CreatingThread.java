package com.paceup.day19;

class MyThread extends Thread {
    @Override
    public void run() { //Running
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }
}

public class CreatingThread {
    public static void main(String[] args) {
    	MyThread thread = new MyThread(); //new state
    	MyThread t1 = new MyThread();
    	MyThread t2 = new MyThread();
        thread.start(); // Starts the thread //Runnable
        t1.start();
        t2.start();
    }
}

