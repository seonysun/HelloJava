/*
 * 1. 변수 설정 
 * 		: 데이터형(자료형) 변수명 = 값; 
 * 		  int a = 10;
 * 
 *  1) 메모리 크기 설정(데이터형, 기본형, 자료형); 자바에서 지원하는 메모리 크기 
 * 						cf. 사용자 정의 : 배열, 클래스(참조변수)
 * 		- 기본형: 정수(byte, short, int, long) =>int
 * 				실수(float, double) =>double
 * 				문자(char)
 * 				논리(boolean) =>false
 * 			-> 필요 시 데이터간 변환 가능(형변환) char -> int, double -> int
 * 		- 크기 비교 : byte < short/char < int < long < float < double
 * 			-> byte 크기가 아니라 수표현 많은 순서(long 1 < float 1.000000)
 * 			-> 최근 경향 : 작은 용량 < 최적화
 * 			-> boolean은 크기 비교 X, 1 byte(1 bit)
 * 
 *  2) 식별자(변수명)
 *  	- 중복 불가
 *  	- 대소문자 구분(소문자로 시작), 길이 제한 없음(보통 3~7자)
 *  	- 예약어(키워드) 사용 불가 : lib에 저장된 것(int)
 *  	- 숫자로 시작 불가
 *  	- 특수문자(_, $) 사용 가능 -> 임시변수 사용 시 주로 _ 맨 앞에 씀
 *  
 *  3) 각 데이터형 초기화
 *      - 초기값 : 변경 가능한 값 
 *      
 *  4) 변수 값 교환 -> 임시 변수 설정, 주로 tmp 사용
 *  
 *  5) 상수 : 변경 불가한 값, 맨 앞에 final -> final int K = 100; -> K의 값 변경 불가능
 * 							 	 	 -> 상수는 대문자 사용
 *     literal : 실제 값(10)
 *     type : 데이터형(int)
 *     변수 : 한개의 데이터를 임시로 저장하기 위한 공간 -> 프로그램 수행 중 값 변경 가능
 *     	   : 데이터 타입에서 정한 크기의 메모리 할당 -> 범위 벗어날 수 없음 
 *     									  -> 오버 플로우 
 *     										ex. byte b = 300; -> 44 도출
 *     
 *  6) 문자열 결합 +
 *  	- "" -> 문자열
 *  	- 문자열 + any type -> 문자열; 7+""+7+7 -> 777
 *        any type + 문자열 -> 문자열; 7+7+""+7 -> 147
 *        
 *  7) 프로그램 순서 (Application,Web,Mobile)
 *      - 변수설정 -> 제어문 -> 연산처리 -> 결과값 
 *  */

public class 변수 {

	public static void main(String[] args) {
		int kor=85, eng=72, math=100;
			// int kor,eng,math; kor=eng=math=100; //값 동일할 때는 한번에 처리 가능
		System.out.println("국어 점수:"+kor);
		System.out.println("영어 점수:"+eng);
		System.out.println("수학 점수:"+math);
		System.out.println("총점:"+(kor+eng+math)); //괄호 내 연산 먼저 처리, 기본은 순서대로
		System.out.println("평균:"+(kor+eng+math)/3.0);
		System.out.printf("평균:%.2f\n",(kor+eng+math)/3.0);
		
	}

}
