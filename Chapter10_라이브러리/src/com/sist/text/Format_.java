package com.sist.text;

import java.text.*;

/*
 *	- Format : 변환
 *		- 숫자 변환 : DecimalFormat(천단위에 ,)
 *		- 날짜 변환 : SimpleDateFormat
 *		- 선택 변환 : ChoiceFormat
 *		- 메세지 변환(출력 형식 복잡할 경우) : MessageFormat
 * */

public class Format_ {

	public static void main(String[] args) {
		//숫자
		DecimalFormat df=new DecimalFormat("##,###,###");
		int value=123456789;
		System.out.println("￦"+df.format(value));
		System.out.println();
		
		
		//선택
		double[] limit= {59,60,70,80,90};
		String[] grade= {"F","D","C","B","A"};
		int[] score= {100,90,85,90,45,67,78};
		ChoiceFormat cf=new ChoiceFormat(limit,grade);
		for(int i=0;i<score.length;i++) {
			System.out.println(score[i]+":"+cf.format(score[i]));
		}
		System.out.println();
		
		
		//메세지
		String msg="이름:{0}\n성별:{1}\n나이:{2}\n";
		Object[] obj= {"홍길동","남자","25"};
		System.out.println(MessageFormat.format(msg, obj));
		
		//
		String name="이순신";
		String sex="남자";
		String addr="서울";
		String tel="010-1111-1111";
		int age=26;
		String post="100-111";
		String email="lee@co.kr";
		
		String sql="INSERT INTO member VALUES('"+name+"','"+sex+"','"+addr+"','"+tel+"','"+age+"','"+post+"','"+email+"')";
		System.out.println(sql);
		
		String msg2="INSERT INTO member VALUES(''{0}'',''{1}'',''{2}'',''{3}'',''{4}'',''{5}'',''{6}'')";
		Object[] obj2= {name,sex,addr,tel,age,post,email};
		System.out.println(MessageFormat.format(msg2, obj2));
		
	}

}
