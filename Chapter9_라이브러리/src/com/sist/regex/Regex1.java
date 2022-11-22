package com.sist.regex;

import java.util.regex.*;

/*
 * 3. regex
 *		- 패턴의 형태를 만들어서 찾기
 *		- 한글 : [가-힣]
 *		  영문 : [A-Za-z]
 *		  숫자 : [0-9]
 *			cf. [abc] : a|b|c = [a-c]
 *		- []: 범위 / {}: 갯수
 *					//생략 시 1글자
 *			ex. [A-Z]{3} -> 대문자 3글자
 *				[가-힣]{1,3} -> 한글 1~3글자
 *		- ^: 시작(startsWith), 제외 / $: 끝(endsWith)
 *			ex. ^[가-힣]{3} -> 한글로 시작하는 3글자
 *				[^가-힣] -> 한글 제외 1글자
 *				[A-Z]$ -> 대문자로 끝난 문자열
 *		- dot(.): 임의의 문자 1개 / .*: 모든 문자 
 *		- +: 한글자 이상 / *: 0글자 이상
 *			ex. c[a-z] -> c 뒤에 소문자 1글자
 *				c[a-z]* -> c 뒤에 소문자 0글자 이상 
 *				.* -> 1글자 이상 모두
 *				.+ -> 임의의 문자로 시작하는 2글자 이상
 *				^[가-힣]* -> 한글로 시작하는 전체
 *		- 기호화 : [0-9] -> \\d(포함), \\D(제외)
 *				 공백 -> \\s, \\S
 *				 알파벳,숫자 -> \\w ([A-Za-z0-9]), \\W ([^A-Za-z0-9])
 * */

public class Regex1 {

	public static void main(String[] args) {
		String[] data= {
				"bat","baby","bonus","c","cA","ca",
				"co","c.","car","combat","c0","c#",
				"disc","date",
				"홍길동","맛있다OK","시작12345"};
		Pattern p=Pattern.compile("c\\W");
		for(String s:data) {
			Matcher m=p.matcher(s);
			if(m.matches()) {
				System.out.println(m.group());
			}
		}
		
		
		//
		String data1="HP:010-1111-1111, OFFICE:02-2222-2222";
		String pattern1="(0\\d{1,2})-(\\d{4})-(\\d{4})";
						//group(): 전체, group(1),group(2),group(3): 괄호로 구분
		Pattern p1=Pattern.compile(pattern1); //패턴 생성
		Matcher m1=p1.matcher(data1); //패턴 확인
		while(m1.find()) { //존재여부 확인
			System.out.println(m1.group());
		}
		
		
		//
		String ip="211.89.63.1,211.89.63.131,127.0.0.1,169.123.174.2,"
				+ "223.130.195.200,12345.123.11111.5555,676767676.567";
		String pattern2="(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.\\d{1,3}";
		Pattern p2=Pattern.compile(pattern2);
		Matcher m2=p2.matcher(ip);
		while(m2.find()) {
			if((m2.group(1)+"."+m2.group(2)+"."+m2.group(3)).equals("211.89.63"))
			System.out.println(m2.group()+" 해당 IP는 접근이 거부되었습니다.(403)");
		}
		
	}

}
