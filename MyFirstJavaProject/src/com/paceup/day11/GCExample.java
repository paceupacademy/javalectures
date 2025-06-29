package com.paceup.day11;

class Test {
	int id;
	String test;

	public Test(int id, String test) {
		super();
		this.id = id;
		this.test = test;
	}

	public void show() {
		System.out.println(this.id + " : " + this.test);
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Cleaning up " + this.id);
	}
}

public class GCExample {

	public static void main(String[] args) {
		Test t1 = new Test(1, "xyz");
		Test t2 = new Test(2, "pqr");

		t1.show();
		t2.show();

		t1 = null;
		t2 = null;

		System.gc();
		System.runFinalization();

	}

}
