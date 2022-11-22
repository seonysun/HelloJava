package com.sist.util;

import java.util.*;

/*
 * - Calendar : Date 보완
 * 		- 생성 : Calendar cal=Calendar.getInstance();
 * 				-> 추상클래스이므로 new 이용하지 않음
 * 				-> 필요한 경우 오버라이딩
 * 		- 날짜 설정 : get(), 읽기 : set()
 * 		- 각 달의 마지막 날짜 : getActualMaximum()
 * 		- Calendar -> Date : 오라클 저장 시 호환
 * 		  Date -> Calendar : 오라클에서 읽어와서 제어할 때(Date는 메소드 사용 금지)
 * */

public class Calendar_ {

	public static void main(String[] args) {
		Calendar today=Calendar.getInstance();
		System.out.println(today.get(Calendar.YEAR)+"년");
		System.out.println((today.get(Calendar.MONTH)+1)+"월");
											//month: 0부터 시작 -> 출력 시(get) +1, 입력 시(set) -1
		System.out.println(today.get(Calendar.DATE)+"일");
		String[] strWeek= {"","일","월","화","수","목","금","토"};
		System.out.println(strWeek[today.get(Calendar.DAY_OF_WEEK)]+"요일");
													//week: 1부터 시작(일요일 -> 1) -> 요일 배열 0번 공백 생성
		System.out.println(today.get(Calendar.HOUR)+"시");
		System.out.println(today.get(Calendar.MINUTE)+"분");
		System.out.println(today.get(Calendar.SECOND)+"초");
		System.out.println("마지막날:"+today.getActualMaximum(Calendar.DATE));
		System.out.println();
	
		
		//입력값으로 설정
		Scanner scan=new Scanner(System.in);
		System.out.print("년 월 일 입력:");
		int year=scan.nextInt();
		int month=scan.nextInt();
		int day=scan.nextInt();
		
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, day);
		int set_year=cal.get(Calendar.YEAR);
		int set_month=cal.get(Calendar.MONTH)+1;
		int set_day=cal.get(Calendar.DATE);
		int set_week=cal.get(Calendar.DAY_OF_WEEK);
		System.out.printf("%d년 %d월 %d일 %s요일%n",set_year,set_month,set_day,strWeek[set_week]);
		System.out.println();
		
		
		//Date 변환
		Calendar cal2=Calendar.getInstance();
		Date date=new Date(cal2.getTimeInMillis());
		System.out.println(date);
		
		Date date2=new Date();
		Calendar cal3=Calendar.getInstance();
		cal3.setTime(date2);
		System.out.println(cal3.get(Calendar.YEAR)+"년");
		System.out.println((cal3.get(Calendar.MONTH)+1)+"월");
		System.out.println(cal3.get(Calendar.DATE)+"일");
		
	}

}
