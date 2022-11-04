import java.util.Scanner;

/*
 * 1. 메소드
 * 	- 특정 작업 수행하는 일련의 문장(명령문) 묶음
 * 	- 각각의 메소드는 한 개의 기능(입력, 처리, 출력)만 수행하도록 제작 -> 재사용하기 편하도록
 * 	- 기존에 있는 프로그램을 기능별로 나눠서 분리하여 작업
 * 
 * 	1) 특징
 * 		- 재사용성 : 다른 프로그램에서도 사용 가능
 * 		- 다른 클래스와 통신 : 다른 클래스에서도 불러와서 사용 가능
 * 		- 구조화된 프로그램(가독성 좋음) : 수정 용이(메소드 하나만 처리하면 자동 반영)
 * 		- 중복 코드 제거, 반복 제어 : 관리 용이, 오류 발생 가능성 낮음
 * 
 * 	2) 구성요소 : 처리 결과값(리턴값) + 사용자 요청값(매개변수)
 * 				ex. ID/PW 입력(매개변수) -> 로그인여부 boolean(리턴값)
 * 		- 결과값(리턴형)	매개변수
 * 			  O			  O		=> String.substring(int s)
 * 			  O			  X		=> String.trim()
 * 			  X			  O		=> System.out.println("A")
 * 								   void //결과값이 없는 상태
 * 			  X			  X		=> System.out.println()
 * 
 * 	3) 메소드 정의
 * 		- 선언부(원형) + 구현부
 * 			리턴형 메소드명(매개변수) {		return 결과값;	}
 * 			----------------- -------------------
 * 				  선언부				 구현부
 * 			ex. int add(int a, int b) {
 * 						...
 * 					return a+b; //메소드 종료 시점
 * 				} -> add 메소드 실행 시 a+b 출력
 * 
 *  	- 리턴형(반환 타입) : 사용자 요청을 처리한 결과값의 형식
 *  			 		- 결과값을 넘겨주는 경우 : 해당 결과값의 데이터형으로 설정
 *  									   : 메소드 사용 후 메소드의 결과값을 이용하는 과정이 필요할 때
 *  							ex. 로그인 여부 확인; boolean 타입의 결과값 도출하여 결과에 따라 화면 다르게 출력
 *  							cf. 리턴형은 결과값보다 큰 데이터형도 가능하지만 특별한 경우가 아니면 동일하게 설정
 * 								cf. 결과값 : return값, 메소드 한 개당 1개만 설정 가능(return은 여러번 처리 가능 ex.true/false)
 *  									    -> 여러 개일 경우 배열이나 클래스 하나로 출력
 *  					- 결과값이 메소드 내에서 자체적으로 처리되어 넘겨줄 결과값이 없는 경우 : void로 설정
 * 								ex. 데이터베이스 => insert, update, delete ; 따로 결과값 넘겨줄 필요 없이 DB 내에서 처리되고 끝
 * 								ex. 구구단 출력; 출력 과정 자체를 메소드 내에 포함시키는 것이 편리
 * 								cf. return(넘겨줄 결과값) 생략 가능(컴파일러가 자동으로 return; 추가하여 진행)
 * 						- 타입 예시
 * 							(1) 나누기 값 : double
 * 							(2) 영화 제목 : String[]
 * 							(3) 경우의 수 2개 : boolean
 * 							(4) 경우의 수 여러 개 : String
 * 
 * 		- 메소드명 : 변수 식별자 생성 조건과 동일
 * 				: 이름이 같은 메소드 여러 개 생성 가능, 이때 매개변수 갯수나 데이터형은 달라야 함
 * 						ex. 여러 데이터형을 받는 각각의 print/println
 * 		
 * 		- 매개변수 : 메소드가 작업 수행하기 위해 필요한 값(사용자 요청값)
 * 				   - 명시적 초기화, Scanner, random()
 * 				   - 여러 개일 때는 comma(,)로 구분 
 * 						-> 데이터형이 같을 때에도 타입 생략 불가(ex. int a, int b)
 * 						-> 3개 이상이면 배열(데이터형이 같을 때) 또는 클래스(데이터형이 다를 때) 이용
 * 				   - 지역변수의 일종 -> 메소드 안에서만 사용 가능
 * 				   - 웹에서의 검색, 입력, 버튼 출력, 메뉴 클릭, 페이지 요청, 상세보기 등이 해당
 * 			cf. 가변 매개변수 - 갯수 설정 X : 데이터형 + "..."
 * 						  - 타입 설정 X : Object(가장 큰 데이터형, 모든 데이터형 받을 수 있음)
 * 					ex. printf
 * 
 * 	4) 메소드 호출
 * 		- 메소드명(argument);
 * 		- argument(인자) : 메소드 호출 시 매개변수에 대입되는 값
 * 						  매개변수의 타입과 동일하거나 자동 형변환되는 데이터형의 값 
 * 
 * 	5) 메소드 종류
 * 		- static : 자동 메모리 생성됨
 * 		- instance : 메모리마다 따로 저장하는 메소드
 * 						-> 사용하기 전에 new를 이용해서 공간 생성
 * 		- 추상메소드
 * */

public class 메소드 {
	static int userInput(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg);
		int value=scan.nextInt();
		
		return value;
	}
	public static void main(String[] args) {
				//main 메소드는 void이므로 return 생략
		int year=userInput("년도 입력:");
		int month=userInput("월 입력:");
		int day=userInput("일 입력:");
		System.out.println(year+"년 "+month+"월 "+day+"일");
		
		/*
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력:");
		int year=scan.nextInt();
		System.out.print("월 입력:");
		int month=scan.nextInt();
		System.out.print("일 입력:");
		int day=scan.nextInt();
		*/
		
	}

}
