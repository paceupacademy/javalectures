package com.paceup.GarbageCollection;

/**
 * NoGarbageCollection:
 * --------------------
 * 
 * Key Concepts:
 * -------------
 * 1. **Static Variables**:
 *    - `nextId` is declared static, meaning it is shared among all objects.
 *    - Every time a new Employee object is created, `nextId` increments.
 * 
 * 2. **Scope of Variables**:
 *    - Variables declared inside a block `{ ... }` are local to that block.
 *    - Once the block ends, those variables go out of scope (cannot be accessed).
 *    - However, their objects are still in memory until garbage collection (GC) occurs.
 * 
 * 3. **Garbage Collection**:
 *    - Java automatically reclaims memory of unreachable objects.
 *    - In this example, interns `X` and `Y` go out of scope after the block ends.
 *    - They are eligible for GC but not immediately collected.
 * 
 * 4. **Output Behavior**:
 *    - Even after `X` and `Y` go out of scope, `nextId` continues to increment globally.
 *    - Therefore, the next ID shown is 6, not reset to 4.
 */
class Employee {
    private int ID;
    private String name;
    private int age;
    private static int nextId = 1; // shared among all objects

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
        this.ID = nextId++;
    }

    public void show() {
        System.out.println("Id=" + ID + "  Name=" + name + "  Age=" + age);
    }

    // Shows ID of next employee
    public void showNextId() {
        System.out.println("Next employee id will be=" + (ID + 1) + "\n");
    }
}

class NoGarbageCollection {
    public static void main(String[] args) {
        // Create three employees
        Employee E = new Employee("GFG1", 56);
        Employee F = new Employee("GFG2", 45);
        Employee G = new Employee("GFG3", 25);

        E.show();
        E.showNextId();

        F.show();
        F.showNextId();

        G.show();
        G.showNextId();

        { // Sub-block to keep interns
          // Variables X and Y are local to this block and stored on stack
            Employee X = new Employee("GFG4", 23);
            Employee Y = new Employee("GFG5", 21);

            X.show();
            X.showNextId();
            Y.show();
            Y.showNextId();
            // At this point, nextId = 6
        }
        // After exiting the block, X and Y go out of scope.
        // They are no longer accessible, but not garbage collected yet.
        // nextId continues to increment globally.

        // Output of this line shows nextId as 6 (not reset to 4)
        G.showNextId();
    }
}
