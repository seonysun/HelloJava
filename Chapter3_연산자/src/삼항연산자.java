import java.util.Scanner;

/*
 * 3. 삼항연산자 = 피연산자 3개 -> 앞에 조건이 붙음
 *	 - 조건에 따라 값1 or 값2 도출(조건문)
 *	 - (조건) ? 값1 : 값2
 *	 		  true false
 *	 - 보통은 if else	사용하나, 소스 코딩 줄이기 위해 사용 
 *
 * 대입연산자 : =
 * 		- 값을 메모리에 저장(변수의 초기값, 변수값 변경, 연산 결과값 받기)
 * 				ex. int a = 10; 
 * 					a = 20; a의 변수값 10->20으로 변경
 * 		- 최하위 연산자(가장 나중에 진행)
 * 		- 복합대입연산자 : +=, -=, *=, /=, <<=, >>=, &=, |=, ^=
 * 				- a+=1 -> a=a+1
 * 				  		cf. a++; 5번 반복 => a+=5;
 * 				  a-=1 -> a=a-1
 * 				  a*=1 -> a=a*1
 * 				  a/=1 -> a=a/1
 * 				- += ; 여러개(여러번) 더하기 -> 누적, 데이터 수집할 때 많이 사용 
 * */

public class 삼항연산자 {

	public static void main(String[] args) {
		char c = 'A';
		System.out.println(c>='A' && c<='Z' ? "대문자":"소문자");
		System.out.println((c>='A' && c<='Z') || (c>='a' && c<='z') ? "알파벳":"알파벳 아님");

		//윤년 여부 확인 -> 윤년의 조건 1. 4년마다 해당 2. 100년마다 제외 3. 400년마다 해당
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력:");
		int year = scan.nextInt();
		System.out.println((year%4==0 && year%100!=0 || year%400==0) ? year+"년은 윤년입니다.":year+"년은 평년입니다.");
									//&&가 ||보다 먼저 진행
		
		//대입연산자
	    int num1=1, num2=2, num3=3, num4=4, num5=5;     
	    num1+=num2;
	    	//num1 = num1 + num2;
	    num2-=2;
	    	//num2 = num2 - 2;     
	    num3*=2;	
	    	//num3 = num3 * 2;     
	    num4/=2;	
	    	//num4 = num4 / 2;     
	    num5%=2;	
	    	//num5 = num5 % 2;     
	    System.out.printf("%d, %d, %d, %d, %d \n",num1,num2,num3,num4,num5);   
		
		/* 
	    Scanner scanner1 = new Scanner(System.in);
	    System.out.print("정수 입력:");
		int num = scan.nextInt();
		num+=5;
			//num = num + 5;
		System.out.println("num1="+num);
		num-=5;
		System.out.println("num2="+num);
		num*=5;
		System.out.println("num3="+num);
		num/=5;
		System.out.println("num4="+num);
		num&=5;
		System.out.println("num5="+num);
		num|=5;
		System.out.println("num6="+num);
		num^=5;
		System.out.println("num7="+num);
		num>>=5;
		System.out.println("num8="+num);
		num<<=5;
		System.out.println("num9="+num); 
		*/
		
	}

}
