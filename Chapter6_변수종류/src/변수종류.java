/*
 * 1. 변수의 종류
 * 	1) 지역변수 : 메소드 안에서만 사용할 수 있는 변수
 * 		- 지역변수 : 메소드 내에서 선언, 사용
 * 		- 매개변수 : 메소드 호출시마다 생성, 메소드에서 사용자 요청값을 받을 때 사용
 * 	2) 전역변수(멤버변수) : 프로그램 종료시까지 유지되는 변수
 *		- 공유변수(클래스변수); static
 *		- 인스턴스변수
 *			ex. class Student{
 *					String name; -> 객체마다 다르게 가지는 변수(s1.name, s2.name : 학생명)
 *					static String sName; -> 모든 객체가 사용할 수 있는 변수(sName : 학교명)
 *				}
 *			cf. static변수(공유변수)는 범위에 따라 static 해당 여부가 달라지므로 사용 빈도는 적음
 *					ex. Student라는 클래스 내에서는 static이지만 그보다 더 큰 범위가 있다면 static이 아님
 * */
public class 변수종류 {

	public static void main(String[] args) {
		

	}

}
