package com.paceup.ExceptionHandling;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * BasicExceptionHandling:
 * -----------------------
 * 
 * Exception:
 * - An event that disrupts the normal flow of a program.
 * - Can occur during runtime (unchecked exceptions) or must be handled at compile time (checked exceptions).
 * 
 * Common Runtime Exceptions:
 * - NullPointerException → calling a method on a null reference.
 * - ClassCastException → invalid type casting.
 * - OutOfMemoryError → memory allocation failure.
 * - StringIndexOutOfBoundsException → invalid string index access.
 * - ArrayIndexOutOfBoundsException → invalid array index access.
 * - ArithmeticException → divide by zero.
 * 
 * Exception Handling Keywords:
 * - try: Block of code monitored for exceptions (risky code).
 * - catch: Block that handles the exception if it occurs.
 * - finally: Block that always executes (cleanup code).
 * 
 * Error vs Exception:
 * - Error: Serious issues (e.g., OutOfMemoryError) → usually not recoverable.
 * - Exception: Recoverable issues (e.g., ArithmeticException).
 * 
 * Checked vs Unchecked Exceptions:
 * - Checked: Must be handled at compile time (e.g., IOException).
 * - Unchecked: Occur at runtime (e.g., NullPointerException).
 */
public class BasicExceptionHandling {
	public static void main(String[] args) throws IOException {
		
		try {
			Class c = Class.forName("com.paceup.Example");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Example: type casting double → int (narrowing conversion)
		double data = 10.459d;
		int n = (int) data; 
		System.out.println(n); // prints 10

		// Example risky code with try-catch-finally
		try {
			//int result = 10 / 0; // ArithmeticException (divide by zero)
		} catch (Exception e) {
			// Exception handling block
			System.out.println("Cannot divide by zero: " + e.getMessage());
		} finally {
			// Always executes regardless of exception
			System.out.println("Execution completed.");
		}

		//Device Failure
		/*FileNotFoundException
		 * NoSuchFileException
		 * AccessDeniedExceptio
		Files.exists(Path.of("D:/sample.txt));
		Files.readAllBytes(Path .of("D:/sample.txt"));
		 */
		//Physical Limitations
		/*
		 * List<Byte> list = new ArrayList<>(); while(true) { list.add(new Byte((byte)
		 * 10000000)); }
		 */
		
		BigDecimal num1 =  new BigDecimal("12102901");
		BigDecimal num2 = new BigDecimal("83791837");

		BigDecimal result = num1.divide(num2);
		  //IndexOutOfBound 
		  int[] a = {10,20}; 
		  System.out.println(a[2]);
		 
		/*
		 * //Null Reference String s = null; if(s !=null) {
		 * System.out.println(s.length()); }
		 */
		/*
		 * //Type Mismatch Object o = "Hello"; String s1 = (String) o; Integer x =
		 * (Integer) o;
		 */
		
		//Database ErrorsPreparedStatement stmt = new PreparedStatement(Connection conn);
		
		//stmt.executeQuery("Selec * from student;");
		//SQLException(syntax)
	}

}
