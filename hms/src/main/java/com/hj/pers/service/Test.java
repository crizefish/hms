package com.hj.pers.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;


public class Test {
	public void inputStreamTest() throws IOException{
		File file = new  File("D://qq.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
	StringBuilder sb = new StringBuilder();
	byte[] b = new byte[512];
	while((reader.readLine())!=null){
		sb.append(b);
	}
	}
	
	public   void outputStream() throws IOException{
		OutputStream outputStream = new FileOutputStream(new File("D:/qq.txt"));
		outputStream.write(new String("hello").getBytes());
		outputStream.close();
	}
	
	public static void main(String[] args) throws IOException {
		Test t = new Test();
		t.outputStream();
		t.inputStreamTest();
	}
}
