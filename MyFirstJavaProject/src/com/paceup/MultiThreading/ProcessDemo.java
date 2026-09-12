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
                "java", "-cp", "bin", 
                "com.paceup.MultiThreading.Springbootexample"
        );
        
        ProcessBuilder pb1 = new ProcessBuilder(
                "java", "-cp", "bin", 
                "com.paceup.MultiThreading.Helloworld",
                "Aishwarya",
                "Java"
        );

        try {
        	pb.inheritIO();
        	
            // pb.start():
            // ------------
            // Starts a new process (like a new JVM instance).
            // This process runs independently of the current one.
            Process pr = pb.start();
            
            int exitCode = pr.waitFor();
            
            System.out.println("ExitCode:"+exitCode);
            // Printing confirmation message from the main thread
            
            pb1.inheritIO();
        	
            // pb.start():
            // ------------
            // Starts a new process (like a new JVM instance).
            // This process runs independently of the current one.
            Process pr1 = pb1.start();
            
            int exitCode1 = pr1.waitFor();
            
            System.out.println("ProcessDemo Ran!!");

        } catch (IOException e) {
            // Exception handling:
            // -------------------
            // If process creation fails (e.g., wrong classpath, missing class),
            // IOException is thrown.
            e.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
