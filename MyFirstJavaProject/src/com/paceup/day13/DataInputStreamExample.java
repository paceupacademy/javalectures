package com.paceup.day13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DataInputStreamExample {

	public static void main(String[] args) {
		
		//Writing the data to file
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("file.dat"))){
			System.out.println("Writing data to file");
			dos.writeDouble(23.45);
			dos.writeInt(65);
			dos.writeBoolean(false);
			dos.writeChar('$');
		}catch(FileNotFoundException f) {
			System.out.println("Cannot find the file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Reading the data
		try(DataInputStream dis =  new DataInputStream(new FileInputStream("file.dat"))){
			System.out.println("Reading data from file");
			double d = dis.readDouble();
			int i = dis.readInt();
			boolean b =  dis.readBoolean();
			char c = dis.readChar();
			System.out.println("\n Values are double: "+d+"\tinteger:  "+i+"\tboolean: "+b+"\tchar: "+c);
			
		}catch(FileNotFoundException f) {
			f.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
