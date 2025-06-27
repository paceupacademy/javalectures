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
        thread.start(); // Starts the thread //Runnable
    }
}

