package com.sist.util;

import java.util.*;
import java.text.*;

/*
 * - Date : 시스템의 현재 날짜, 시간 읽어옴
 * 				-> 오라클 데이터형과 연결됨
 * 		- 년도 : yyyy(대소문자 주의)
 * 		  월 : MM, M(오라클 MM) -> 08, 09의 경우 앞에 0 때문에 8진법으로 생각했을 때 오류 발생 -> 주로 한글자로(8, 9) 사용
 * 		  일 : dd, d
 * 		  시간 : hh, h
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
				Thread.sleep(1000);
			} catch(Exception e) {}
		}

	}

}
