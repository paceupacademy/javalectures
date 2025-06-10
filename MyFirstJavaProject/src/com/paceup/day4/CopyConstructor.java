package com.paceup.day4;

class CopyConstructorExample {
    int x;

    CopyConstructorExample(int value) {
        x = 30;
    }

    CopyConstructorExample(CopyConstructorExample obj) { // Copy constructor
        x = obj.x;
    }
}

public class CopyConstructor {
	public static void main(String[] args) {
		CopyConstructorExample obj1 = new CopyConstructorExample(20);
		CopyConstructorExample obj2 = new CopyConstructorExample(obj1); // Calls the copy constructor
        System.out.println("Value in obj2: " + obj2.x);
    }
}
