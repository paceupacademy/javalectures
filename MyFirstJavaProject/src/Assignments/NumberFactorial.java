package Assignments;

public class NumberFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number = 11;
        int factorial = 1;

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            for (int i = 1; i <= number; i++) {
                factorial *= i; 
            }
            System.out.println("Factorial of " + number + " is: " + factorial);
        }

	}

}
