package com.paceup.MultiThreading;

public class Helloworld {

    public static void main(String[] args) {
        // The JVM automatically creates the "main thread"
        // ----------------------------------------------
        // When you run a Java program:
        // 1. JVM starts and creates the main thread.
        // 2. The main thread executes the main() method.
        // 3. Here, it prints "Hello from another JVM!!!".
        // 4. After finishing main(), the main thread terminates.
        //
        // Other background threads (system threads) also exist:
        // - Garbage Collector Thread → cleans unused objects.
        // - Finalizer Thread → runs finalization before objects are removed.
        // - Signal Dispatcher Thread → handles signals sent to JVM.
        // - Reference Handler Thread → manages special references.
        //
        // These system threads run invisibly in the background.
        // The program ends when the main thread and all non-daemon threads finish.

        System.out.println("Hello from another JVM!!!");
    }
}
