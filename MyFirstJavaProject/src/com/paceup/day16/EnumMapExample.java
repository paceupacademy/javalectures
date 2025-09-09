package com.paceup.day16;

import java.util.EnumMap;

/*
 * enum EnumName{
 * 	CONSTANT1, CONSTANT2, ...., CONSTANT N
 * }
 */

//Define an enum
enum Day {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumMapExample {
	public static void main(String[] args) {
		// Create an EnumMap with Day as the key type
		EnumMap<Day, String> schedule = new EnumMap<>(Day.class);

		// Add key-value pairs
		schedule.put(Day.MONDAY, "Gym");
		schedule.put(Day.TUESDAY, "Yoga");
		schedule.put(Day.THURSDAY, "Cycling");
		schedule.put(Day.WEDNESDAY, "Swimming");
		
		schedule.put(Day.FRIDAY, "Running");

		// Access values
		System.out.println("Activity on Monday: " + schedule.get(Day.MONDAY));

		System.out.println("\n"+schedule+"\n");

		// Iterate through the EnumMap
		for (Day day : schedule.keySet()) {
			System.out.println(day + ": " + schedule.get(day));
		}
		
		//schedule.put(null, "Basketball"); //-> NullPointerException
		schedule.put(Day.SUNDAY, null);
		
		System.out.println("\nSize of EnumMap: "+schedule.size());
		
		System.out.println("\nHas Friday? "+schedule.containsKey(Day.FRIDAY));
		System.out.println("Has Gym? "+schedule.containsValue("Gym"));
		
		System.out.println("\nKeys: "+schedule.keySet());
		System.out.println("Values: "+schedule.values());
		System.out.println("EntrySet: "+schedule.entrySet());
		
		schedule.remove(Day.SUNDAY);
		System.out.println("\nAfter removing "+Day.SUNDAY+": "+schedule);
		
		EnumMap<Day, String> extra =  new EnumMap<>(Day.class);
		extra.put(Day.SUNDAY, "Family Time");
		extra.put(Day.SATURDAY, "Shopping");
		
		System.out.println("\nExtra enum: "+extra);
		
		schedule.putAll(extra);
		System.out.println("Updated Schedule is: "+schedule);
		
		schedule.clear();
		System.out.println("\nIs EnumMap empty? "+schedule.isEmpty());
		Day today = Day.FRIDAY;
		/*System.out.println("\n"+schedule+"\n");
		switch (today) {
		case MONDAY:
			System.out.println("Today's Monday");
			break;
		case TUESDAY:
			System.out.println("Today's Tuesday");
			break;
		case FRIDAY:
			System.out.println("Today's Friday");
			break;
		case THURSDAY:
			System.out.println("Today's Thursday");
			break;
		default:
			System.out.println("Wrong day entered");
			break;
		}
		*/
	}
}
