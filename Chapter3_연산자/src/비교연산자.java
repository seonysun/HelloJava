import java.util.Scanner;

/*
 * 비교연산자 : 기본형(정수, 실수, 문자, 논리)만 비교 가능
 * 		- 무조건 결과값이 boolean(true/false) -> 조건문, 반복문에서 주로 사용
 * 		- 문자열 비교 불가 : equals로 비교) -> 로그인, 아이디체크; 참조형(배열, 클래스)
 * 		- 객체 비교 불가 : instanceof로 비교
 * 
 * 	1) == : 같다
 * 		- boolean 사용 가능 (true==true)
 *  2) != : 같지 않다
 * 		- boolean 사용 가능 (true!=false)
 *  3) < : 작다 -> 기준점 왼쪽
 *  4) < : 크다
 *  5) <= : 작거나 같다
 *  6) >= : 크거나 같다
 *  
 *  	- char 비교 -> 정수형(아스키 코드)으로 변경 후 비교
 *  						cf. 아스키코드 | 스캔코드(키보드번호)
 *  										-> 스캔코드는 버리고 아스키코드로 들어옴
 *  						ex. 1 > '0' = false
 *  								(48)
 * */

public class 비교연산자 {

	public static void main(String[] args) {
		// 정수 비교
		int a = (int)(Math.random()*5)+1;
							//0.0~0.99 -> 0~4 -> 1~5
		int b = (int)(Math.random()*5)+1;
		System.out.println("a="+a+",b="+b);
		
		System.out.println("a==b:"+(a==b));
		System.out.println("a!=b:"+(a!=b));
		System.out.println("a<b:"+(a<b));
		System.out.println("a>b:"+(a>b));
		System.out.println("a<=b:"+(a<=b));
		System.out.println("a>=b:"+(a>=b));
		
		
		//문자 비교
		char m = 'C';
		char n = 'c';
		System.out.printf("%c==%c:%b\n", m, n, m==n);
		System.out.printf("%c==%c:%b\n", (m+32), n, (m+32)==n);
											//알파벳 대소문자 차이 32
		System.out.printf("%c!=%c:%b\n", m, n, m!=n);
								 //boolean 출력
						  //대입하는 데이터 %d: 정수, c: 문자, f: 실수, s: 문자열
		
		int c = 99;
		System.out.printf("%d==%c:%b\n", c, n, c==n);
		
		
		//논리형 비교
		boolean b1 = true;
		boolean b2 = false;
		System.out.printf("%b==%b:%b\n", b1, b2, b1==b2);
		System.out.printf("%b!=%b:%b\n", b1, b2, b1!=b2);
							//boolean은 크기 비교 불가
		
		
		Scanner scan = new Scanner(System.in);
			//Scanner + Ctrl Space -> import 자동 생성 가능
		System.out.println("정수 입력:");
		int k = scan.nextInt();
		System.out.println((k%2==0)?"짝수":"홀수");
							//삼항연산자 -> k를 2로 나눈 나머지가 0이면 짝수 아니면 홀수
		
	}

}
