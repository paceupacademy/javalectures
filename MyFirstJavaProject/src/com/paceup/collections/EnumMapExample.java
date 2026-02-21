package com.paceup.collections;

import java.util.EnumMap;

/**
 * 
 * Enum:
 * - An enum (short for "enumeration") is a special data type in Java.
 * - It is used to define a fixed set of constants (unchangeable values).
 * - Example: Days of the week, directions (NORTH, SOUTH, EAST, WEST), etc.
 * - Each constant is type-safe (cannot be mixed with other values).
 * - Each constant has an ordinal (position index starting from 0).
 * 
 * EnumMap:
 * - A specialized Map implementation for enum keys.
 * - Keys must be of a single enum type (cannot mix different enums).
 * - Internally backed by an array, indexed by the ordinal of enum constants.
 * - Maintains natural order of enum constants (as declared in the enum).
 * - Very efficient compared to HashMap when keys are enums.
 * - Does not allow null keys (NullPointerException).
 * - Allows null values.
 * 
 * Internal Working:
 * -----------------
 * - Each enum constant has an ordinal (0-based index).
 * - EnumMap uses this ordinal to store/retrieve values in an internal array.
 * - Example: Day.MONDAY (ordinal=0), Day.TUESDAY (ordinal=1), etc.
 * 
 * Representation Example:
 * -----------------------
 * EnumMap<Day, String> schedule = {MONDAY=Gym, TUESDAY=Yoga, WEDNESDAY=Swimming}
 * Internally:
 *   [0] → Gym        (MONDAY)
 *   [1] → Yoga       (TUESDAY)
 *   [2] → Swimming   (WEDNESDAY)
 *   [3] → Cycling    (THURSDAY)
 *   [4] → Running    (FRIDAY)
 *   [5] → null       (SATURDAY)
 *   [6] → null       (SUNDAY)
 */
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
        System.out.println("\nSchedule: " + schedule + "\n");

        // Iterate through the EnumMap (in enum order)
        for (Day day : schedule.keySet()) {
            System.out.println(day + ": " + schedule.get(day));
        }

        // Null key not allowed → NullPointerException
        // schedule.put(null, "Basketball");

        // Null values allowed
        schedule.put(Day.SUNDAY, null);

        System.out.println("\nSize of EnumMap: " + schedule.size());
        System.out.println("Has Friday? " + schedule.containsKey(Day.FRIDAY));
        System.out.println("Has Gym? " + schedule.containsValue("Gym"));

        // KeySet, Values, EntrySet
        System.out.println("\nKeys: " + schedule.keySet());
        System.out.println("Values: " + schedule.values());
        System.out.println("EntrySet: " + schedule.entrySet());

        // Remove entry
        schedule.remove(Day.SUNDAY);
        System.out.println("\nAfter removing SUNDAY: " + schedule);

        // putAll() example
        EnumMap<Day, String> extra = new EnumMap<>(Day.class);
        extra.put(Day.SATURDAY, "Shopping");
        extra.put(Day.SUNDAY, "Family Time");

        System.out.println("\nExtra EnumMap: " + extra);
        schedule.putAll(extra);
        System.out.println("Updated Schedule: " + schedule);

        // Clear EnumMap
        schedule.clear();
        System.out.println("\nIs EnumMap empty? " + schedule.isEmpty());
    }
}
