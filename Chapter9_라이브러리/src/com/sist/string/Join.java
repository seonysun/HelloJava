package com.sist.string;

import java.util.Arrays;
import java.util.StringJoiner;

public class Join {

	public static void main(String[] args) {
		//join
		String color="red,green,blue,black,white,yellow,magenta";
		String[] colors=color.split(",");
		for(String c:colors) {
			System.out.println(c);
		}
		System.out.println();
		
		String s=String.join("-", colors);
						//배열 요소 각각을 구분자로 묶어서 문자열 하나에 저장
		System.out.println(s);
		String c=color.replace(",", "-");
		System.out.println(c);
		System.out.println();
		
		
		//StringJoiner
		StringJoiner sj=new StringJoiner("/","{","}");
									//구분자,접두어(prefix),접미어(suffix)
			//이미지 저장시 주로 사용 -> 여러개 묶어서 동시에 저장 후 구분자 사용해 나눠서 출력
		for(String ss:colors) {
			sj.add(ss);
		}
		System.out.println(sj.toString());
		System.out.println();
		
		
		//byte 배열
		try {
			String name="자바";
			//인코딩(한글을 byte 배열로 변환)
			byte[] b=name.getBytes("UTF-8");
			System.out.println(Arrays.toString(b));
			for(byte bb:b) {
				System.out.print(String.format("%02X", bb));
			}
			System.out.println();
			
			byte[] b2=name.getBytes("CP949");
			System.out.println(Arrays.toString(b2));
			for(byte bb:b2) {
				System.out.print(String.format("%02X", bb));
			}
			System.out.println();
			
			//디코딩
			String s1=new String(b,"UTF-8");
									//한글 3byte
			String s2=new String(b2,"CP949");
									//한글 2byte
			System.out.println(s1);
			System.out.println(s2);
		} catch(Exception e) {}

		
		//format
		int a=10;
		int b=20;
		String temp=String.format("%d + %d = %d", a,b,a+b);
						//문자를 원하는 형식으로 변경 후 출력 -> 웹에서는 printf가 없으므로 format 사용
		System.out.println(temp);
		
	}

}
