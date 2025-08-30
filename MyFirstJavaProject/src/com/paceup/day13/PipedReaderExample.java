package com.paceup.day13;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedReaderExample {

	public static void main(String[] args) {
		try {
			final PipedWriter pw = new PipedWriter();
			final PipedReader pr = new PipedReader(pw);
			
			Thread writerThread = new Thread(()-> {
				try {
					pw.write("Hello Students!! \n@Welcome@");
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			Thread readerThread = new Thread(()->{
				try {
					int data;
					System.out.println("Data: ");
					while((data = pr.read())!=-1) {
						System.out.print((char)data);
					}
					pr.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			});
			
			writerThread.start();
			readerThread.start();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
