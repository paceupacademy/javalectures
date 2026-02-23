package com.paceup.MultiThreading;

import java.io.IOException;

public class ProcessDemo {

    public static void main(String[] args) {
        // ProcessBuilder:
        // ----------------
        // Used to create operating system processes from Java.
        // Here, we are asking JVM to start another Java process.
        // Command breakdown:
        // "java" → run Java
        // "-cp out" → set classpath to 'out' folder (compiled classes)
        // "com.paceup.day19.Helloworld" → main class to run
        // "com.paceup.day19.Springbootexample" → argument passed to Helloworld
        ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", "out", 
                "com.paceup.MultiThreading.Helloworld", 
                "com.paceup.MultiThreading.Springbootexample"
        );

        try {
            // pb.start():
            // ------------
            // Starts a new process (like a new JVM instance).
            // This process runs independently of the current one.
            Process pr = pb.start();

            // Printing confirmation message from the main thread
            System.out.println("ProcessDemo Ran!!");

        } catch (IOException e) {
            // Exception handling:
            // -------------------
            // If process creation fails (e.g., wrong classpath, missing class),
            // IOException is thrown.
            e.printStackTrace();
        }
    }
}
