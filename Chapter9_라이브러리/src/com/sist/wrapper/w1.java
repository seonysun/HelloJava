package com.sist.wrapper;

import java.util.Scanner;

public class w1 {

	public static void main(String[] args) {
		Integer ii=10;
		int i=ii;
		System.out.println("ii:"+ii+", i:"+i);
		System.out.println(ii.toString());
		System.out.println(ii.MAX_VALUE); //int형의 최댓값
		System.out.println(ii.MIN_VALUE); //int형의 최솟값
		System.out.println(Integer.toBinaryString(ii));
		System.out.println(Integer.toOctalString(ii));
		System.out.println(Integer.toHexString(ii));
		String s="100";
		int k=Integer.parseInt(s);
		System.out.println(k);
		
		Double d=10.5;
		double d1=d;
		String s1="10.67";
		double d2=Double.parseDouble(s1);
		System.out.println(d2);
		
		String s2="true";
		boolean b=Boolean.parseBoolean(s2);
		System.out.println(s2);
		
		Scanner scan=new Scanner(System.in);
		System.out.print("문자열 두 개 입력:");
		String num1=scan.next();
		String num2=scan.next();
		Integer.parseInt(num1);
		Integer.parseInt(num2);

	}

}
