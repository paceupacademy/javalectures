package com.paceup.day3;

//Java Program to Demonstrate the 
//use of a class with instance variable 

//Class Declaration
public class Dog { //public - accessible from other packages as well

	// Instance Variables
	String name;
	String breed;
	int age;
	String color;

	public Dog() {
		System.out.println("Default Constructor called");
		this.name = "ABC";
		this.breed = "Lab";
		this.age = 5;
		this.color = "Golden";
	}

	// Parameterized Constructor Declaration of Class
	public Dog(String name1, String breed, int age,
			String color)
	{
		this.name = name1;  //this refers to current object max.name="Papillon"
		this.breed = breed;
		this.age = age;
		this.color = color;
	}
	
	public Dog(String name) {
		this.name=name;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the breed
	 */
	public String getBreed() {
		return this.breed;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return this.color;
	}

	@Override public String toString()
	{
		return ("Dog Name is: " + this.getName()
		+ "\nBreed, age, and color are: "
		+ this.getBreed() + "," + this.getAge()
		+ "," + this.getColor()+"\n\n");
	}

	public static void main(String[] args)
	{
		Dog tuffy = new Dog("tuffy", "papillon", 5, "white");
		Dog max = new Dog("Papillion", "german shephard", 7, "brown");
		Dog abc = new Dog();
		Dog xyz = new Dog("Tom");
		System.out.println(tuffy.toString());
		System.out.println(max.toString());
		System.out.println(xyz.toString());
		System.out.println("Name: "+abc.name+" Age: "+abc.age+" Breed: "+abc.breed+" Color: "+abc.color);
	}
}