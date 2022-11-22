package com.sist.util;

import java.util.*;
import java.text.*;

/*
 * - Date : 시스템의 현재 날짜, 시간 읽어옴
 * 				-> 오라클 데이터형과 연결됨
 * 		- 기능 거의 없음(메소드 사용 금지) -> 저장용
 * 		- 대소문자 주의
 * 		- 년도 : yyyy
 * 		  월 : MM, M(오라클 MM)
 * 				-> 08, 09(MM)의 경우 앞에 0 때문에 8진법으로 생각했을 때 오류 발생 
 * 				-> 주로 한글자로(8, 9)(M) 사용
 * 		  일 : dd, d
 * 		  시간 : 12시간 hh, h / 24시간 HH, H
 * 		  분 : mm, m(오라클 MI)
 * 		  초 : ss, s
 * */

public class Date_ {

	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		while(true) {
			Date date=new Date();
			String today=sdf.format(date);
			System.out.println(today);
			try {
				Thread.sleep(1000); //1초(1/1000*1000)마다 반복
			} catch(Exception e) {}
		}

	}

}
