import static java.lang.Math.random;
import static java.lang.System.out;
import static java.lang.String.*;

/*
 * 1. 패키지
 * 	- 관련된 클래스 그룹 단위로 묶어서 관리(폴더)
 * 	- comma(.)로 폴더 단위 구분(계층 구조)
 * 	- 모든 클래스는 각각 하나의 패키지에만 속함 -> 맨 첫 줄에 패키지 선언 : package 패키지명;
 * 	- 패키지명(폴더명) 설정 시 식별자 조건 지켜야 함 -> 키워드 사용 불가, 소문자 권장(클래스와 구분 위함)
 * 
 * 	1) 목적 
 * 		- 검색이 용이
 * 		- 다른 클래스에서 불러서 사용하기 편리
 * 		- 패키지 단위로 라이브러리 제작 가능 -> .jar
 * 		- 서로 다른 패키지에서는 동일한 클래스명 사용 가능 -> 클래스 이름 충돌 가능성 낮춤
 * 	
 * 	2) 종류 : 데이터형 클래스 모음 -> VO(value object) ex. MovieVO
 * 			 활용 메소드 모음 -> Manager 			ex. MovieManager
 * 
 * 2. import
 * 	- 라이브러리, 사용자 정의 클래스 가져올 때 사용
 * 	- 자바 소스(*.java) 구조(선언) -> import 선언문은 package 선언문 다음, class 선언문 전에 위치
 * 	 	(1) 패키지 선언 //1번만 설정 가능
 * 	 	(2) import 설정 //여러번 사용 가능(없어도 됨)
 * 	 	(3) public class 내 멤버변수(인스턴스변수, 공유변수), 생성자, 메소드 설정 						생성자 설정
 * 	- 종류
 * 		- import 패키지명.클래스명 : 클래스 1개만 가지고 올 때
 * 		- import 패키지명.* : 패키지에 있는 모든 클래스 가지고 올 때
 * 		- import static 패키지명.클래스명.메소드명 : 메소드 1개만 가지고 올 때
 * 		- import static 패키지명.클래스명.* : 클래스에 있는 모든 메소드 가지고 올 때
 * 	- 같은 패키지에 있는 클래스 가져올 때는 import 설정하지 않아도 됨 -> 다른 패키지의 클래스 가져올 때 사용
 * 	- import java.lang.* -> 가장 기본 라이브러리, 생략됨
 * 						 -> String, System, Math 등은 import 없이 사용 가능
 * */

public class 패키지 {

	public static void main(String[] args) {
		int a=(int)(random()*10)+1;
					//static 메소드 Math.random을 import 했으므로 Math. 클래스 생략 가능
		out.println(valueOf(a));
			//static 메소드 System.out을 import 했으므로 System. 클래스 생략 가능
					//static 클래스 String을 import 했으므로 String. 생략 가능

	}

}
