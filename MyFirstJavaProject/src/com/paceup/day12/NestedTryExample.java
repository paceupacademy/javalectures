package com.paceup.day12;

//Nested try-catch demonstration
public class NestedTryExample {

	public static void main(String[] args) {

		try {
			String str = null;
			try {
				int len = str.length();
				System.out.println(len);
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			str = "this is test line.";
			str.charAt(50);
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

	}

}
