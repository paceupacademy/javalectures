package com.paceup.day8;

//Usage
public class InterfaceFullAbstractionExample {
 public static void main(String[] args) {
     Payment payment = new CreditCardPayment();
     payment.processPayment(500.0);

     payment = new UpiPayment();
     payment.processPayment(1000.0);
     
     payment.dfMethod();
     Payment.display();
 }
}

