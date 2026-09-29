package com.paceup.OperatorsAndLoops;

public class NestedSwitch {

	public static void main(String[] args) {
		String Branch = "CSE";
		int year = 2;
		
		switch(year) {
			case 1:
					System.out.println("Elective Courses are: Civil, Mechnical, Electronics");
					break;
			case 2:
					switch(Branch) {
						case "CSE":
						case "CE":
								System.out.println("Elective Courses are: ML, Big Data, AI");
								break;
						default:
								System.out.println("Elective Courses: Computer Algorithm");
								
					}
					break;
			default:
					System.out.println("You have chosen different Elective Courses");
			
		}
	}

}
