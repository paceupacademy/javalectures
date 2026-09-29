package com.paceup.Inheritance;

//Interface 1 that defines coding behavior
interface Coder {
	void writeCode();
	default void show() {
		System.out.println("Coder show called");
	}
}

//Interface 2 that defines testing behavior
interface Tester {
	void testCode();
	default void show() {
		System.out.println("Tester show called");
	}
}

//Class implementing both interfaces 
class DevOpsEngineer extends A implements Coder {
	@Override
	public void writeCode() {
		System.out.println("DevOps Engineer writes automation scripts.");
	}

	/*@Override
	public void testCode() {
		System.out.println("DevOps Engineer tests deployment pipelines.");
	}*/

	
	
	// Additional method specific to DevOpsEngineer
	public void deploy() {
		System.out.println("DevOps Engineer deploys code to cloud.");
	}
}

class Engineer extends A implements Coder, Tester {
	@Override
	public void writeCode() {
		System.out.println("Engineer writes automation scripts.");
	}

	@Override
	public void testCode() {
		System.out.println("Engineer tests deployment pipelines.");
	}

	// Additional method specific to DevOpsEngineer
	public void deploy() {
		System.out.println("Engineer deploys code to cloud.");
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Coder.super.show();
		Tester.super.show();
	}
	
}

//Driver class
public class MultipleInheritance {
	public static void main(String[] args) {
		DevOpsEngineer devOps = new DevOpsEngineer();

		devOps.writeCode();  
		//devOps.testCode(); 
		devOps.deploy();  
		devOps.show();
		
		System.out.println();
		Engineer e =  new Engineer();
		e.writeCode();
		e.show();
		
		Coder c =  new DevOpsEngineer();
		c.show();
	}
}