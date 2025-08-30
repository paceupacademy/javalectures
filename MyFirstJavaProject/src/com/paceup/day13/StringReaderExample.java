package com.paceup.day13;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderExample {

	public static void main(String[] args) {
		String data ="This is for StringReader!!!";
		try(StringReader sr =  new StringReader(data);
				StringWriter sw = new StringWriter()){
			int ch;
			while((ch = sr.read())!= -1) {
				sw.write(ch);
			}
			sw.append('$');
			System.out.println("Input String: "+data);
			System.out.println("Output String: "+sw.toString());
		} catch(IOException e){
			e.printStackTrace();
		}

	}

}
