package com.paceup.MultiThreading;

public class Springbootexample {

    public static void main(String[] args) {
        // The JVM automatically creates the "main thread"
        // ------------------------------------------------
        // When you run any Java program:
        // 1. JVM starts and creates the main thread.
        // 2. The main thread executes the main() method.
        // 3. Here, it prints "Hello from SpringBoot Example".
        // 4. After finishing main(), the main thread terminates.
        //
        // Other background threads (system threads) also exist:
        // - Garbage Collector Thread → cleans unused objects from memory.
        // - Finalizer Thread → runs finalization before objects are removed.
        // - Signal Dispatcher Thread → handles signals/events for JVM.
        // - Reference Handler Thread → manages weak/soft references.
        //
        // These system threads run invisibly in the background.
        // The program ends when the main thread and all non-daemon threads finish.

        System.out.println("Hello rom SpringBoot Example");
    }
}
