package com.paceup.day16;

import java.util.EnumMap;

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
     schedule.put(Day.WEDNESDAY, "Swimming");
     schedule.put(Day.THURSDAY, "Cycling");
     schedule.put(Day.FRIDAY, "Running");

     // Access values
     System.out.println("Activity on Monday: " + schedule.get(Day.MONDAY));
     
     System.out.println(schedule);
     
     // Iterate through the EnumMap
     for (Day day : schedule.keySet()) {
         System.out.println(day + ": " + schedule.get(day));
     }
 }
}
