import java.util.Random;
import java.util.Scanner;

/*
 * 변수 : 한 개의 데이터 저장할 수 있는 메모리 공간, 변경 가능 
 * 		- 데이터형 변수명(소문자)
 * 		- 변수의 초기화
 * 			1. 명시적인 초기화 int a = 10;
 * 				: 소스 크기를 줄일 수 있음
 * 			2. 입력값을 받아서 처리 int a = scan.next();
 * 			3. 난수 발생
 * 				Random r = new Random();
 * 				int a = r.nextInt(100)+1; //
 * 			4. 이미 저장된 변수의 값을 대입
 * 				int a = 10;
 * 				int b = a;
 * 			5. 연산처리 int a = 1024*1024;
 * 		- 멤버변수(클래스 영역에 선언되는 변수) => 자동 초기화(int a; -> a=0)
 * 		  지역변수(메소드 영역에 선언되는 변수) => 자동 초기화 되지 않음 -> 사용하기 전에 반드시 초기화 선행 필요
 * 
 * 상수 : 한 개의 데이터 저장할 수 있는 메모리 공간, 변경 불가 
 * 		- final 데이터형 변수명(전부 대문자)
 * 
 * 데이터형 - 기본형 : 자바에서 지원
 * 		 - 참조형 : 사용자 정의 -> 배열, 클래스(*), 인터페이스(*), 열거형
 * 		 - 프로그램은 변수, 연산자, 제어문으로 구성
 * 				==> 메소드 : 명령문 집합, 클래스 : 메소드 여러개 묶어서 사용 -> 패키지
 * 
 * 제어문 관련 연산자 : 부정, 비교, 논리 -> boolean 형태로 도출, 조건, 반복에 사용
 * */

public class Week1_변수_데이터형_연산자 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
									//매개변수 
		Random r = new Random(); 
		int a = r.nextInt(100)+1; 
					//1~100까지 
		System.out.println(a);

	}

}
