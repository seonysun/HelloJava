package com.sist.stringBuffer;
import java.io.FileReader;

public class Append {

	public static void main(String[] args) {
		FileReader fr=null;
		try {
			fr=new FileReader("c:\\javadev\\movie.txt");
			StringBuffer sb=new StringBuffer();
				//문자열 저장하는 메모리 임시공간 -> 한 공간에 계속해서 더해서 붙여나감 -> 속도 빠름
			int i=0;
			while((i=fr.read())!=-1) {
				sb.append(String.valueOf((char)i));
			}
			System.out.println(sb.toString());
		} catch(Exception e) {}
		finally {
			try {
				fr.close();
			} catch(Exception e) {}
		}

	}

}
