package com.paceup.day19;

class PrintNumbers implements Runnable {
    private int number;

    public PrintNumbers(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 2; i++) {
            System.out.println("Thread " + number + " prints: " + i+"\n");
            System.out.println("Thread " +Thread.currentThread().getName()+ " Priority: "+Thread.currentThread().getPriority()+"\n");
        }
    }
}

public class RunnableMultiThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintNumbers(1));
        Thread thread2 = new Thread(new PrintNumbers(2));
        int tpriority= Thread.MAX_PRIORITY;
        thread1.setPriority(tpriority);
        thread1.start();
        thread2.start();
    }
}
