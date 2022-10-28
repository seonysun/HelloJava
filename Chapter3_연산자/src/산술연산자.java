/* 
 * 2. 이항연산자 = 피연산자 2개
 *  1) 산술연산자 : +, -, *, /, %(나누고 나머지)
 *  	- 우선순위 : *, /, %는 +, -보다 먼저 연산
 *  	- 형변환에 주의; 연산은 같은 데이터형 간에만 가능  -> 데이터형 큰 것으로 자동 형변환
 *   	- int 이하(byte, short, char)는 연산 처리 시 결과값 int로 받음
 *   	- / ; 정수/정수=정수(소수점이하 버림)
 *    		  0으로 나눌 수 없음
 *   	- % ; 부호가 있을 떄는 왼쪽편 부호가 남음 
 *   						ex. 10%-3=1
 *   		  화폐 매수 구하기, 배수, 달력(요일 구하기), 윤년 등에 사용
 *   
 *  2) 비트연산자 : &(*), |(or= +), ^(Xor= 비트가 다른 경우 true(1))
 *  	- 0 0	  0		  0				0
 *  	  0 1	  0		  1				1
 *  	  1 0	  0		  1				1
 *  	  1 1	  1		  1				0
 *  	- 2진법 변경 후 연산 -> 정수는 32bit
 *  			ex. 25&10 -> 11001
 * 							 01010
 * 						   = 01000 (8)
 * 					25|10 -> 11001
 * 						 	 01010
 * 		  				   = 11011 (27)
 * 					25^10 -> 11001
 * 							 01010
 * 		  				   = 10011 (19)
 * 		- 웹에서 사용 빈도 극히 드뭄, 임베디드 등에서 사용
 *  
 *  3) 쉬프트연산자 : 비트 이동 연산자
 *  	- <<(왼쪽 이동) : 10<<3; 2진법에서 뒤에 3칸 0으로 채움
 *  					 = 1010 -> 1010000
 *  				 : X<<Y = X*2^Y
 * 		- >>(오른쪽 이동) : 10<<3; 2진법에서 뒤에 3칸 지움 
 * 						  = 1010 -> 1
 * 		- 웹에서 사용 빈도 극히 드뭄
 *  
 *  4) 비교연산자 : ==(같다), !=(같지 않다), <, >, <=, >=
 *             
 *  5) 논리연산자 : &&(and), ||(or)
 *  
 *  6) 대입연산자 : =
 *  */

import java.util.Scanner;

public class 산술연산자 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("두 개의 정수 입력:");
		int a = scan.nextInt(); //입력된 정수값 a라는 메모리에 가져옴
		int b = scan.nextInt();
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		System.out.printf("%d+%d=%d\n", a, b, a+b);
			//System.out.println(a+"+"+b+"="+(a+b));
		System.out.printf("%d-%d=%d\n", a, b, a-b);
		System.out.printf("%d*%d=%d\n", a, b, a*b);
		
		System.out.printf("%d/%d=%d\n", a, b, a/b);
		System.out.printf("%d/%d=%.2f\n", a, b, (double)a/b); 
												//정수/정수=정수이므로 소수점 뒤에 자리 출력하려면 강제 형변환 필요
		
		System.out.printf("%d%%%d=%d\n", a, b, a%b); 
		System.out.printf("%d%%%d=%d\n", -a, b, -a%b); 
		System.out.printf("%d%%%d=%d\n", a, -b, a%-b); 
							 //%를 이미 사용중이므로 나누고 나머지 출력하려면 %% 두개 써야함
		
		int c = 367;
		System.out.println(c%10);
		System.out.println((c%100)/10); //10의 자리 수만 가져오고 싶을 때 -> %100의 나머지 67/10
		
	}

}
