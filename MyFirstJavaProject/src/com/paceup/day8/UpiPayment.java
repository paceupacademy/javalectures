package com.paceup.day8;

//Implementation 2: UPI Payment
public class UpiPayment implements Payment {
@Override
public void processPayment(double amount) {
   System.out.println("Processing UPI payment of ₹" + amount);
}
}
