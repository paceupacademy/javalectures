package com.paceup.day6;

import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a value
        System.out.println("Enter a number (1-3): ");
        int choice = scanner.nextInt();

        // Switch statement to handle user input
        switch (choice) {
            case 1:
                System.out.println("You selected option 1: Hello!");
                break;
            case 2:
                System.out.println("You selected option 2: Welcome!");
                break;
            case 3:
                System.out.println("You selected option 3: Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }

        scanner.close();
    }
}

