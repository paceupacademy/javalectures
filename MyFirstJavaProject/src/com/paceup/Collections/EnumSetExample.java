package com.paceup.Collections;

import java.util.EnumSet;

public class EnumSetExample {
	
	enum Day {
	    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}
	public static void main(String[] args) {
		
		EnumSet<Day> workDays =  EnumSet.range(Day.TUESDAY, Day.SATURDAY);
		
		for(Day d : workDays) {
			System.out.println(d);
		}

	}

}
