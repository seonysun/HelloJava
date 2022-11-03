import java.util.Scanner;

public class 반복문_연습문제 {

	public static void main(String[] args) {
		//1.  int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식 작성 (조건문) 
		int x = (int)(Math.random()*100)+1;
		if(x>10 && x<20)
			System.out.println(x+": true");
		else 
			System.out.println(x+": false");
		
		
		//2. char형 변수 ch가 공백이고 탭이 아닐 때 true인 조건식 작성
		char ch = ' ';
		if(ch==' ' && ch!='\t') {	}
		

		//3. char형 변수 ch가 'x' 또는 'X'일 때 true인 조건식 작성
		int a = (int)(Math.random()*26)+65;
		ch = (char)a;
		if(ch=='x' || ch=='X')
			System.out.println(ch+"은(는) X(x)입니다.");
		else 
			System.out.println(ch+"은(는) X(x)가 아닙니다.");
		
		
		//4. char형 변수 ch가 숫자('0' ~ '9')일 때 true인 조건식 작성
		if(ch>='0' && ch<='9') {	}
		
		
		//5. 두 개의 주사위 던져서 합이 6이 되는 수 출력하는 프로그램
		for(int i=1;i<=6;i++) {
			for(int j=1;j<=6;j++) {
				if(i+j==6) System.out.printf("[%d,%d]%n", i,j);
			}
		}
		
				
		//6. 사용자로부터 두개의 정수(시작,끝)를 입력받아 시작(포함)해서 끝(포함)까지의 곱을 출력하는 프로그램을 작성하시오.
		Scanner scan = new Scanner(System.in);
		int multi = 1;
			//곱을 실행할 것이므로 초기값 1로 제시, 합이면 0으로 줌
		int start=0, end=0;
		while(true) {
			System.out.print("시작: ");
			start = scan.nextInt();
			System.out.print("끝: ");
			end = scan.nextInt();
			if(start<end) //오류 처리 -> 조건에 해당되지 않으면 다시 돌아가서 오류 나오지 않을 때까지 반복 
				break; //조건에 해당되면 while문 탈출 -> 아래 for문 진행
		}
		for(int i=start;i<=end;i++) {
			multi*=i;
		}
		System.out.printf("%d~%d의 곱:%d%n",start,end,multi);
		
		
		//7. 5~16까지의 합을 구하시오
		int sum=0;
		for(int i=5;i<=16;i++) {
			sum+=i;
		}
		System.out.println("5~16의 합:"+sum);
		
		sum=0;
		int i=5;
		while(i<=16) {
			sum+=i;
			i++;
		}
		System.out.println("5~16의 합:"+sum);
		
		
		//8. 3 이상 4462 이하에서 짝수인 정수의 합을 구하여라.
		sum=0;
		i=3;
		while(i<=4462) {
			if(i%2==0) sum+=i;
			i++;
		}
		System.out.println("3~4462까지 짝수의 합:"+sum);
		

		//9. 0~12까지 2의 배수, 3의 배수의 합을 구하여라.
		int sum2=0, sum3=0;
		for(i=0;i<=12;i++) {
			if(i%2==0) sum2+=i;
			if(i%3==0) sum3+=i;
		}
		System.out.println("2의 배수의 합:"+sum2);
		System.out.println("3의 배수의 합:"+sum3);

		
		//10. 1~100까지의 정수 중 4의 배수의 합계를 구하라
		sum=0;
		for(i=1;i<=100;i++) {
			if(i%4==0) sum+=i;
		}
		System.out.println("1~100까지 4의 배수의 합:"+sum);
		

		//11. 10개의 정수를 입력받아 그 수들 중 짝수의 개수가 몇개인지 출력하는 프로그램 작성
		int jjak=0;
		i=1;
		while(i<=10) {
			int input = (int)(Math.random()*100)+1;
			System.out.println(i+"번째 정수:"+input);
			if(input%2==0) jjak++;
			i++;
		}
		System.out.println("=> 짝수의 개수:"+jjak+"개");

		
		//12. 10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램
		int a3=0, a5=0;
		for(i=1;i<=10;i++) {
			int num = (int)(Math.random()*100)+1;
			System.out.println(i+"번째 정수:"+num);
			if(num%3==0) a3++;
			if(num%5==0) a5++;
		}
		System.out.println("=> 3의 배수:"+a3+"개");
		System.out.println("=> 5의 배수:"+a5+"개");
		
		i=1;
		while(i<=10) {
			System.out.print(i+"번째 정수 입력:");
			int input = scan.nextInt();
			if(input%3==0) a3++;
			if(input%5==0) a5++;
			i++;
		}
		System.out.println("=> 3의 배수:"+a3+"개");
		System.out.println("=> 5의 배수:"+a5+"개");
		
		
		//13.
		for(i=1;i<=5;i++) {
			for(int j=1;j<=10;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		//14.
		for(i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		
		//16.
		for(i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		
		//
		for(i=1;i<=4;i++) {
			for(int j=1;j<=4-i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/* 	i	j	k -> i+j=4, k=i
		 * 줄수 공백  별표
		 *  1	3	1
		 *  2	2	2
		 *  3	1	3
		 *  4	0	4
		 * */
		
		for(i=1;i<=4;i++) {
			for(int j=1;j<5-i;j++)
				System.out.print(" ");
			for(int k=5-i;k<5;k++)
				System.out.print("*");
			System.out.println();
		}
		
		
		//
		for(i=1;i<=4;i++) {
			for(int j=1;j<=i-1;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=5-i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		//
		for(i=1;i<=4;i++) {
			for(int j=1;j<=4-i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i*2-1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		 * 	i	j	k -> i+j=4, k=2*i-1
		 * 줄수 공백  별표
		 * 1	3	1
		 * 2	2	3
		 * 3	1	5
		 * 4	0	7
		 * */

	}

}
