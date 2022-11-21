package com.sist.string;

public class Concat {

	public static void main(String[] args) {
		 // equals : 같은 경우에 true / 다른 경우에 false
		// 원형 : public boolean equals(String s)
		// ==> 일반 문자열은 같은 문자면 주소가 동일하다 
		String s1="Hello"; // "Hello"라는 주소가 s1에 저장
		String s2="Hello"; // "Hello"라는 주소가 s2에 저장 
		// ==> s1과 s2는 같은 주소를 가지고 있다 
		// new를 이용시에는 다른 메모리에 저장이 된다 
		if(s1==s2) // 메모리 주소값이 동일?
		{
			System.out.println("s1==s2");
		}
		else
		{
			System.out.println("s1!=s2");
		}
		String s3=new String("hello");// 새로운 메모리에 저장 
		if(s1==s3)
		{
			System.out.println("s1==s3");
		}
		else
		{
			System.out.println("s1!=s3");
		}
		/////////////////////////////// 주소값 비교 
		/////////////////////////////// 실제값을 비교 
		if(s1.equals(s3)) // equals ==> 실제 저장되어 있는 값을 비교 (대소문자 구분) => 로그인 
		{
			System.out.println("equals:같은 문자열을 가지고 있다");
		}
		else
		{
			System.out.println("equals:다른 문자열을 가지고 있다");
		}
		/// 대소문자 구분없이 비교 equalsIgnoreCase
		// 원형 : public boolean equalsIgnoreCase(String s)
		if(s1.equalsIgnoreCase(s3)) // ==> 검색 
		{
			System.out.println("equalsIgnoreCase:같은 문자열을 가지고 있다");
		}
		else
		{
			System.out.println("equalsIgnoreCase:다른 문자열을 가지고 있다");
		}
	
		 // concat => 문자열 결합 (+) 
		// 원형 : public String concat(String s)
		/*String s1="Hello ";
		String s2="Java!!";
		String s12=s1.concat(s2);
		String s3=s1+s2;
		System.out.println(s12);
		System.out.println(s3);*/
		// replace => 단어/문자열 변경 
		/*String s="Hello Java";
		String s1=s.replace('a', 'b'); // Hello Jbvb
		String s2=s.replace("Java", "Oracle");
		System.out.println(s1);
		System.out.println(s2);
		String ss="a.jpg&b.jpg&c.jpg"; // 오라클(&=>Scanner)
		String ss1=ss.replace("&", "^");
		System.out.println(ss1);*/
		// replaceAll ==> 정규식 
		// 원형 : public String replaceAll(String p,String s)
		String s="안녕하세요 Hello 12345";
		// 추천 => 해당하는 영화명 , 맛집명 
		// LIKE ==> REGEXP
		System.out.println("한글만 출력:"+s.replaceAll("[^가-힣]", ""));
		// ^ => 제외하고  [가-힣] => 한글 전체 
		System.out.println("영어만 출력:"+s.replaceAll("[^A-Za-z]", ""));
		System.out.println("숫자만 출력:"+s.replaceAll("[^0-9]", ""));
		
		String ss="Hello Java";
		String ss1=ss.substring(6);
		System.out.println(ss1);
		String ss2=ss.substring(0,5);
		System.out.println(ss2);// 마지막은 제외 
		// 원형 : public String substring(int s) : s부터 나머지 전체를 읽어 온다
		//       public String substring(int s,int e) : s부터 e-1번까지 읽어온다 
		
		String sss="red,green,black,white,pink";
		String[] color=sss.split(",");
		for(String c:color)
		{
			System.out.println(c);
		}
		// 원형 : String[] split(String regex) ==> 정규식  ==> \\(|) 
		// 정규식 기호 : . | ^ ? + *   ==> \\. \\| \\^ \\? \\+ \\*
		
		// => 해당 문자의 위치값 inexOf , lastIndexOf 
		String temp="Hello Java";
		//           0123456789
		int index=temp.indexOf("a");
		System.out.println(index);
		index=temp.lastIndexOf("a");
		System.out.println(index);
		// ==> substring 
		String temp2="adkladaklda.dakjdakd.png";
		String k=temp2.substring(temp2.lastIndexOf(".")+1);
		System.out.println(k);
		
		String temp3=" Hello Java ";
		System.out.println(temp3.length());
		String m=temp3.trim(); // 좌우에 공백 제거
		System.out.println(m.length());
		// 원형 : public String trim()
		// valueOf() : 문자열 변환 
		int a=10;
		int b=20;
		String p1=String.valueOf(a); // "10"
		String p2=String.valueOf(b); // "20";
		System.out.println(p1+p2); //1020
		// 원도우 / 웹 ==> 문자열 
		
		// String / Collection:CURD / read,write
		// Wrapper ==> Integer => parseInt
	}

}
