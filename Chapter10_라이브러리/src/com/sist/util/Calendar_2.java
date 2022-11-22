package com.sist.util;

import java.util.*;

public class Calendar_2 {

	public static void main(String[] args) {
		//달력만들기
		Scanner scan=new Scanner(System.in);
		System.out.print("년 월 입력:");
		int year=scan.nextInt();
		int month=scan.nextInt();
		
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		
		String[] strWeek= {"일","월","화","수","목","금","토"};
		for(String s:strWeek) {
			System.out.print(s+"\t");
		}
		System.out.println();
		int week=cal.get(Calendar.DAY_OF_WEEK)-1;
		//System.out.println("해당 달의 1일:"+strWeek[week]+"요일");
		int lastday=cal.getActualMaximum(Calendar.DATE);
		
		for(int i=1;i<=lastday;i++) {
			if(i==1) {
				for(int j=0;j<week;j++) { //1일이 해당되는 요일까지 공백 채우기
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i); //날짜 채우기
			week++; //요일 증가
			if(week>6) {
				week=0; //1주일 지날 때마다 요일 초기화, 줄바꿈
				System.out.println();
			}
		}

	}

}
