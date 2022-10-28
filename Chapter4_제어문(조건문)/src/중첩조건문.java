import java.util.Scanner;

/*
 * 4) 중첩 조건문(이중 if)
 *  	- if(조건 && 조건)
 *  	- if(조건) {
 *  			if(조건) { true/true일 때 수행	}
 *  			else { true/false일 때 수행 }
 *  		}
 */

public class 중첩조건문 {
	public static void main(String[] args) {
		//간단연산
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 정수 입력:");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수 입력:");
		int num2 = sc.nextInt();
		System.out.println("연산자 입력(+,-,*,/):");
		char op = sc.next().charAt(0);
		
		int num3=0;
		if(op=='+')
			System.out.printf("%d+%d=%d%n", num1,num2,num1+num2);
		if(op=='-')
			System.out.printf("%d-%d=%d%n", num1,num2,num1-num2);
		if(op=='*')
			System.out.printf("%d*%d=%d%n", num1,num2,num1*num2);
		if(op=='/') {
			if(num2==0)
				System.out.println("0으로 나눌 수 없습니다."); //오류 처리
			else
				System.out.printf("%d/%d=%.2f%n", num1,num2,(double)num1/num2);
		}
			
		
		//가위바위보
		Scanner scan = new Scanner(System.in);
		System.out.print("가위(0) 바위(1) 보(2):");
		int user = scan.nextInt(); 
		int com = (int)(Math.random()*3);
		
		if(com==0) System.out.println("컴퓨터: 가위");
		else if(com==1) System.out.println("컴퓨터: 바위");
		else if(com==2) System.out.println("컴퓨터: 보");
				
		if(user==0)	System.out.println("플레이어: 가위");
		else if(user==1) System.out.println("플레이어: 바위");
		else if(user==2) System.out.println("플레이어: 보");
		
		/*
		if(com==0) {
			if(user==0) System.out.println("비겼다!");
			else if(user==1) System.out.println("You Win!!");
			else if(user==2) System.out.println("You Lose");
		}
		if(com==1) {
			if(user==0) System.out.println("You Lose");
			else if(user==1) System.out.println("비겼다!");
			else if(user==2) System.out.println("You Win!!");
		}
		if(com==2) {
			if(user==0) System.out.println("You Win!!");
			else if(user==1) System.out.println("You Lose");
			else if(user==2) System.out.println("비겼다!");
		}
		*/
		
		int res = com-user;
					// 결과값을 산술연산자 등으로 정리해보고 가장 경우의 수가 작은 것 선택 -> 알고리즘 개발
		if(res==1 || res==-2) System.out.println("You Lose ㅠㅠ");
		else if(res==-1 || res==2) System.out.println("You Win!!");
		else System.out.println("비겼다~");
		
	}
	
}
