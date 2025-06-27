package com.paceup.day19;

class SharedResource {
    synchronized void display(String message) {
        for (int i = 0; i < 2; i++) {
            System.out.print(" [ " + message + " ] "+Thread.currentThread().getName() +"\n");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println();
    }
}

class MySynchronizedThread extends Thread {
    SharedResource resource;
    String message;

    MySynchronizedThread(SharedResource resource, String message) {
        this.resource = resource;
        this.message = message;
    }

    @Override
    public void run() {
        resource.display(message);
    }
}

public class ThreadSynchronization {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        MySynchronizedThread t1 = new MySynchronizedThread(resource, "Hello");
        MySynchronizedThread t2 = new MySynchronizedThread(resource, "World");

        t1.start();
        t2.start();
    }
}
