package VishweshWork;

class vehicle{
	String engine,capacity,type,tyre;
	
	void showVehicle() {
		System.out.println("vehicle is showing ");
	}
	
}

class Car extends vehicle{
	public void showCar() {
		System.out.println("car has this engine "+engine+ " having capacity "+capacity + " and type is "+type + " and tyre are "+tyre);
	}
}

public class SingleInheritanceDemo {
	
	public static void main(String []args) {
		Car c = new Car();
		c.engine = "BS4";
		c.capacity = "4";
		c.type = "light weight";
		c.tyre = "4";
		c.showCar();
		c.showVehicle();
	}

}
