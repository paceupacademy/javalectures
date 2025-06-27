package com.paceup.day17;

class PrintNumbers implements Runnable {
    private int number;

    public PrintNumbers(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + number + " prints: " + i);
            System.out.println("Thread Priority: "+Thread.currentThread().getPriority());
        }
    }
}

public class RunnableMultiThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintNumbers(1));
        Thread thread2 = new Thread(new PrintNumbers(2));

        thread1.start();
        thread2.start();
    }
}
