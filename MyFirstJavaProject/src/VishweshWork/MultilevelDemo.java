package VishweshWork;

class Animal{
	 String type;
	
	public void showType() {
		System.out.println("Animal type is "+type);;
	}
	
}

class Mamel extends Animal{
	
	String name;
	
	
	public void showName() {
	
		super.showType();
		System.out.println("mamel name is "+name);
	}
	
}

class Dog extends Mamel{
	void show() {
		super.showName();
	}
}



public class MultilevelDemo {

	public static void main(String[] args) {
		
		Dog d = new Dog();
		d.name = "tom";
		d.type = "mamel";
        d.show();;
	}

}
