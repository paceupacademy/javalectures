package com.paceup.day2;

public class ReturnExample {
	// Method to calculate average
    double avg(double x, double y) {
        double res = (x + y) / 2.0;
        return res;    // Return the calculated result
    }

    // Main driver method
    public static void main(String[] args) {
        System.out.println(new ReturnExample().avg(5.5, 6.5));
    }
}
