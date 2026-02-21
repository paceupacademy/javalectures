package com.paceup.Encapsulation;

// Java Program demonstrating Encapsulation
// ----------------------------------------
// Encapsulation = Wrapping data (variables) and code (methods) together
// and restricting direct access to data using access specifiers (usually private).
// Controlled access is provided via public getter and setter methods.

class Account {

    // Private data members (encapsulated)
    // -----------------------------------
    // These cannot be accessed directly outside the class.
    private long accNo;   // Account number
    private String name;  // Account holder name
    private String email; // Account holder email
    private float amount; // Balance amount

    // Getter and Setter methods:
    // --------------------------
    // Provide controlled access to private variables.

    public long getAccNo() {
        return this.accNo;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    // Business logic method:
    // ----------------------
    // Demonstrates encapsulation by updating balance safely.
    public void deposit(float d) {
        this.setAmount(this.getAmount() + d);
    }
}

public class EncapsulationExample {
    // Demonstrating access to another class (AccessSpecifiers)
    AccessSpecifiers as = new AccessSpecifiers();
    int var = as.pubvar; // accessing public variable

    public static void main(String[] args) {
        // Create first Account object
        Account acc = new Account();

        // Set values using setter methods (controlled access)
        acc.setAccNo(90482098491L);
        acc.setName("ABC");
        acc.setEmail("abc@gmail.com");
        acc.setAmount(100000f);

        // Get values using getter methods
        System.out.println("Account Number: " + acc.getAccNo());
        System.out.println("Name: " + acc.getName());
        System.out.println("Email: " + acc.getEmail());
        System.out.println("Amount: " + acc.getAmount());

        // Deposit money using encapsulated method
        acc.deposit(48475.483748f);
        System.out.println("Updated amount: " + acc.getAmount());

        System.out.println();

        // Create second Account object
        Account acc1 = new Account();

        acc1.setAccNo(90482098492L);
        acc1.setName("XYZ");
        acc1.setEmail("xyz@gmail.com");
        acc1.setAmount(200000f);

        System.out.println("Account Number: " + acc1.getAccNo());
        System.out.println("Name: " + acc1.getName());
        System.out.println("Email: " + acc1.getEmail());
        System.out.println("Amount: " + acc1.getAmount());
    }
}
