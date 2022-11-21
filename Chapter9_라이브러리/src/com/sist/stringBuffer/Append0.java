package com.sist.stringBuffer;
import java.io.FileReader;

public class Append0 {

	public static void main(String[] args) {
		FileReader fr=null;
		try {
			long start=System.currentTimeMillis();
			fr=new FileReader("c:\\javadev\\movie.txt");
				//문자번호로 한글자씩 읽어옴
			String movie="";
				//문자열 결합시마다 메모리 계속해서 변경되면서 새롭게 저장(Hello, Hello Java, Hello Java!! 각각 메모리 다름) -> 속도 느림
			int i=0; 
			while((i=fr.read())!=-1) {
				movie+=String.valueOf((char)i);
			}
			long end=System.currentTimeMillis();
			System.out.println(movie);
			System.out.println("읽은 시간:"+(end-start)); //로그파일(실행에 걸린 시간)
		} catch(Exception e) {}
		finally {
			try {
				fr.close();
			} catch(Exception e) {}
		}
		
	}

}
