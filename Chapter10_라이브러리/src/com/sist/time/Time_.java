package com.sist.time;

import java.time.*;
import java.util.*;

/*
 * - Time : Date, Calendar 보완
 * 		- MYSQL 날짜 저장 -> LocalDateTime
 * 		- now() : 현재 날짜, 시간 읽기
 * 		  of() : 날짜, 시간 지정
 * 		- Calendar와 비교 -> 월(month) 1부터 시작(1~12로 구성)
 * 		  				   월요일부터 시작
 * */

public class Time_ {

	public static void main(String[] args) {
		LocalDate date=LocalDate.now();
		System.out.println(date);
		LocalTime time=LocalTime.now();
		System.out.println(time);
		LocalDateTime dt=LocalDateTime.now();
		System.out.println(dt);
		
		date=LocalDate.of(2022, 12, 1);
		time=LocalTime.of(15, 30,45);
		System.out.println(date+" / "+time+"\n");
		
		//
		Scanner scan=new Scanner(System.in);
		System.out.print("년 월 일 입력:");
		int year=scan.nextInt();
		int month=scan.nextInt();
		int day=scan.nextInt();
		LocalDate date1=LocalDate.now();
		LocalDate date2=LocalDate.of(year,month,day);
		
		/*int result=date2.compareTo(date1);
		if(result==0)
			System.out.println("이벤트 마감일입니다.");
		else if(result<0)
			System.out.println("아직 이벤트 기간입니다.");
		else if(result>0)
			System.out.println("이벤트가 종료되었습니다.");*/
		
		if(date2.isAfter(date1))
			System.out.println("날짜가 아직 오지 않음");
		else if(date2.isBefore(date1))
			System.out.println("날짜가 지남");
		else if(date2.isEqual(date1))
			System.out.println("오늘");

	}

}
