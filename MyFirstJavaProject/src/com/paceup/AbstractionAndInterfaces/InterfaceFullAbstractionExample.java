package com.paceup.AbstractionAndInterfaces;

//Usage
public class InterfaceFullAbstractionExample {
 public static void main(String[] args) {
     Payment payment = new CreditCardPayment();
     payment.processPayment(500.89);

     payment = new UpiPayment();
     payment.processPayment(1000.50);
     
     payment.dfMethod();
     
     
     Payment.display();
 }
 
}

