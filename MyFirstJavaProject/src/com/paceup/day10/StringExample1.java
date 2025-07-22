package com.paceup.day10;

public class StringExample1 {

    public static void main(String[] args) {

        String original = "  Hello Java Developers!  ";
        String test = "Java";
        String test2 = "java";

        // contains()
        System.out.println("Contains 'Java': " + original.contains("Java"));

        // substring()
        System.out.println("Substring (6, 10): " + original.substring(6, 10));

        // join()
        String joined = String.join("-", "2025", "07", "15");
        System.out.println("Joined: " + joined);

        // replace()
        System.out.println("Replace 'Java' with 'World': " + original.replace("Java", "World"));

        // replaceAll()
        System.out.println("ReplaceAll whitespace with '-': " + original.replaceAll("\\s", "-"));

        // replaceFirst()
        System.out.println("ReplaceFirst whitespace with '*': " + original.replaceFirst("\\s", "*"));

        // charAt()
        System.out.println("Character at index 6: " + original.charAt(6));

        // getBytes()
        byte[] byteArray = original.getBytes();
        System.out.print("getBytes(): ");
        for (byte b : byteArray) {
            System.out.print(b + " ");
        }
        System.out.println();

        // indexOf()
        System.out.println("Index of 'Java': " + original.indexOf("Java"));
  
        // compareTo()
        System.out.println("CompareTo 'Java': " + test.compareTo(test2));

        // compareToIgnoreCase()
        System.out.println("CompareToIgnoreCase 'java': " + test.compareToIgnoreCase(test2));

        // trim()
        System.out.println("Trimmed: '" + original.trim() + "'");

        // format() using format specifier %s-String, %d-Integer(Decimal), %f - float, %n-newline
        String formatted = String.format("My name is %s and I am %d years old", "Aishwarya", 28);
        System.out.println("Formatted: " + formatted);

        // split()
        String[] words = original.trim().split(" "); //words={"Hello","Java","Developers!"}
        System.out.print("Split words: ");
        for (String word : words) {
            System.out.print(word + " | ");
        }
        System.out.println();

        // toLowerCase()
        System.out.println("To Lower Case: " + original.toLowerCase());

        // toUpperCase()
        System.out.println("To Upper Case: " + original.toUpperCase());

        // valueOf()
        int num = 100;
        String numStr = String.valueOf(num);
        System.out.println("Value Of int: " + numStr);

        // toCharArray()
        char[] chars = original.trim().toCharArray();
        System.out.print("ToCharArray: ");
        for (char c : chars) {
            System.out.print(c + ", ");
        }
        System.out.println();

        // matches()
        System.out.println("Matches regex '.*Java.*': " + original.matches(".*Java.*"));

        // startsWith()
        System.out.println("StartsWith '  Hello': " + original.startsWith("  Hello"));

        // endsWith()
        System.out.println("EndsWith 'Developers!  ': " + original.endsWith("Developers!  "));

        // isEmpty()
        String emptyStr = "";
        System.out.println("Is empty string empty? " + emptyStr.isEmpty());

        // contentEquals()
        StringBuffer sb = new StringBuffer("Hello Java Developers!");
        System.out.println("ContentEquals StringBuffer: " + original.trim().contentEquals(sb));

        // hashCode()
        System.out.println("HashCode of original: " + original.hashCode());

        // subSequence()
        CharSequence subSeq = original.subSequence(2, 7);
        System.out.println("SubSequence (2, 7): " + subSeq);
    }
}