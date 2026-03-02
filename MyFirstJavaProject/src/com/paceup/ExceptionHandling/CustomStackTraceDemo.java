package com.paceup.ExceptionHandling;

public class CustomStackTraceDemo {

	public static void main(String[] args) {
		try {
			triggerCustomException();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void triggerCustomException() throws Exception {
		Exception ex = new Exception("A custom error occurred!");
		
		StackTraceElement[] customTrace = new StackTraceElement[] {
				new StackTraceElement("FakeClassName", "secretMethod","HiddenSource.java",99),
				new StackTraceElement("OriginalApp","main","MainApp.java",10)
		};
		
		ex.setStackTrace(customTrace);
		
		throw ex;
	}

}
