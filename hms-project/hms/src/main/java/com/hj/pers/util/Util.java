package com.hj.pers.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {

	public void FormatterCode() throws IOException{
		
	}
	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		File file = new File("C:/Users/hujian/Desktop/ww.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));
		String s = null;
		while ((s=reader.readLine())!=null) {
			if (s.length()>4) {
				s= s.substring(4,s.length())+"\r\n";
			}else {
				s="\r\n";
			}
			sb.append(s);
		}
		reader.close();
		FileOutputStream outputStream = new FileOutputStream("d:/qq.txt");
		outputStream.write(sb.toString().getBytes());
		
		outputStream.close();
		System.out.println("done");
	}
	
	
}
