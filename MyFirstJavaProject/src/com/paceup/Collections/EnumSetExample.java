package com.paceup.Collections;

import java.util.EnumSet;

/**
 * 
 * EnumSet:
 * - Specialized Set implementation for enum types.
 * - Stores only enum constants (no other objects allowed).
 * - Very fast and memory-efficient (uses bit vector internally).
 * - Maintains natural order of enum (defined order).
 * - Does NOT allow null elements.
 * 
 * Key Methods:
 * - range(start, end) → creates set from start to end (inclusive)
 * - of(...) → specific enum values
 * - allOf() → all enum constants
 * - noneOf() → empty EnumSet
 */
public class EnumSetExample {

    // Enum representing days of the week
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {

        System.out.println("=========== ENUMSET ==========");

        System.out.println("\n--- Creating EnumSet using range ---");

        /**
         * range(start, end):
         * - Includes both start and end values
         * - Follows enum declaration order
         * - Here: TUESDAY → SATURDAY
         */
        EnumSet<Day> workDays = EnumSet.range(Day.TUESDAY, Day.SATURDAY);

        System.out.println("Work Days Set: " + workDays);

        System.out.println("\n--- Iterating EnumSet ---");

        // Iteration preserves enum order
        for (Day d : workDays) {
            System.out.println("Day: " + d);
        }

        System.out.println("\n--- Additional Examples ---");

        // All days
        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All Days: " + allDays);

        // Specific days
        EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend: " + weekend);

        // Empty EnumSet
        EnumSet<Day> emptySet = EnumSet.noneOf(Day.class);
        System.out.println("Empty Set: " + emptySet);
    }
}