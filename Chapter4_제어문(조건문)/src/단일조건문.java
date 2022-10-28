import java.util.Scanner;

/*
 * - 프로그래밍 정리 1. 데이터 묶기 -> 배열
 * 	 			2. 명령문 묶기 -> 메소드
 * 				3. 전체 묶기 -> 클래스
 * 				4. 라이브러리 연결
 * 
 * 0. 문장의 종류
 * 	- 평문 : 순차적으로 한줄씩 처리되는 문장
 * 	- 제어문 : 프로그램의 흐름을 제어; 조건에 따라서 선별적으로(조건문), 반복적으로(반복문) 수행
 *		  -> 연산자의 응용
 *  
 * 1. 제어문의 종류
 *	1) 조건문
 *  	- 단일 조건문(*) : 조건이 true일 경우에만 수행
 *  	- 선택 조건문(*) : 조건이 true일 때와 false일 때 처리하는 문장 따로 만들어서 처리
 *  	- 다중 조건문 : 조건이 여러개 있을 경우 처리하는 문장
 *  	- 선택문 : 잘 안쓰임 -> 키보드 선택 등
 *  
 *  2) 반복문
 *  	- for(*) : 반복 횟수가 지정된 경우
 *  			   자바에서 가장 많이 사용
 *  	- while(*) : 반복 횟수가 지정되지 않은 경우 -> 선조건 존재
 *  			  	 데이터베이스 DB에서 많이 사용(데이터의 갯수를 확인할 수 있는 방법이 없음)
 *  	- do~while : 한 번 이상 반드시 수행해야 하는 경우 -> 후조건 존재
 *  	
 * 	3) 반복제어문
 * 		- break(*) : 반복 중지
 * 		- continue : 특정 부분을 제외할 때
 *  
 * 2. 제어문의 형식
 *  1) 단일 조건문 : 독립적인 문장 -> 여러개 사용시 여러개의 문장이 수행될 수 있음
 * 		- 조건은 부정연산자, 비교연산자, 논리연산자 이용 -> boolean 값으로 결과가 나와야 함
 * 		- 오류 체크시 많이 사용(코테 필수)
 * 		- if(조건)
 * 			 수행문장 1
 * 		   수행문장 2
 * 		- true일 경우 수행문장 1 + 2
 * 		  false일 경우 수행문장 2
 * 		- 수행문장 2는 무조건 수행 -> if문 소속 문장이 아님
 * 									cf. 자바에서 지원하는 모든 제어문은 바로 밑에 문장 1개만 제어 가능
 * 																	(괄호가 없으므로)
 * 								만약에 여러개의 문장을 if문에서 제어할 때는 {} 사용
 * 										ex. if(조건){
 * 												수행문장 1
 * 												수행문장 2 }
 * 											-> 조건 true : 수행문장 1+2, false : 수행문장 없음
 * */		

public class 단일조건문 {

	public static void main(String[] args) { //start
		//홀짝 판단
		int num = (int)(Math.random()*100)+1;
		if(num%2==0) System.out.println(num+"은(는) 짝수입니다.");
		if(num%2==1) System.out.println(num+"은(는) 홀수입니다.");
			//두 조건은 단일 조건문 -> 두 조건이 모두 맞으면 모두 수행될 수도 있음
		
		
		//알파벳 판단
		char ch = 'F';
		if(ch>='A' && ch<='Z') System.out.println(ch+"은(는) 대문자입니다.");
		if(ch>='a' && ch<'z') System.out.println(ch+"은(는) 소문자입니다.");
		if(!(ch>='A' && ch<='Z' || ch>='a' && ch<'z')) {
			System.out.println(ch+"은(는) 알파벳이 아닙니다.");
		}	//if가 제어하는 문장이 하나일 때 괄호 없어도 되지만 습관 들이기! 
		
		
		//가위바위보 게임
		int com = (int)(Math.random()*3);
		Scanner scan = new Scanner(System.in);
		System.out.print("가위:0 바위:1 보:2 ->");
		int user = scan.nextInt(); 
		
		if(com==0) System.out.println("컴퓨터: 가위");
		if(com==1) System.out.println("컴퓨터: 바위");
		if(com==2) System.out.println("컴퓨터: 보");
				
		if(user==0)	System.out.println("플레이어: 가위");
		if(user==1)	System.out.println("플레이어: 바위");
		if(user==2)	System.out.println("플레이어: 보");
		
		
		//학점 판단
		System.out.println("국어 영어 수학:");
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		int total = kor+eng+math;
		double avg = total/3.0;
		
		System.out.println("국어점수:"+kor);
		System.out.println("영어점수:"+eng);
		System.out.println("수학점수:"+math);
		System.out.println("총점:"+total);
		System.out.printf("평균:%.2f%n",avg);
		
		char grade='A';
		if(avg>=90 && avg<=100) grade='A';
						//and 앞의 내용만 쓰면 90점일 때 아래 조건들도 모두 해당되므로 결과가 달라짐 -> 조건은 상세하게
		if(avg>=80 && avg<90) grade='B';
		if(avg>=70 && avg<80) grade='C';
		if(avg>=60 && avg<70) grade='D';
		if(avg<60) grade='F';
		System.out.println("학점:"+grade);
		
	} //end

}
