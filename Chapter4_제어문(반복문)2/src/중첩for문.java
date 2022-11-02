import java.util.Scanner;

/*
 * 1) 조건문의 중첩
 * 		if(조건문){
 * 			if(조건문){}
 * 		} => if(조건문 && 조건문){} 으로 표현 가능 
 * 
 * 2) 선택문의 중첩 -> 게임/네트워크에서 많이 사용
 *		switch(변수) {
 *		case 값:
 *			switch(변수) {
 *			case 값:
 *			}
 *			break;
 *		}
 *
 * 3) 반복문의 중첩
 * 	- 이중 for문 : for(초기값;조건식1;증감식1){
 * 							//반복 횟수 결정
 * 						for(초기값;조건식2;증감식2){ 실행문장 }
 * 								//실제 출력물 결정
 * 	  			 }
 * 					-> 증감식1이 가장 마지막에 실행
 * 	- 변수 위치(for문 바깥, 1차 for문 내, 2차 for문 내)에 주의해야 함 -> 출력 결과 달라짐 
 * */

public class 중첩for문 {

	public static void main(String[] args) {
		System.out.println("☆☆☆☆☆");
		System.out.println("☆☆☆☆☆");
		System.out.println("☆☆☆☆☆");
		System.out.println("☆☆☆☆☆");
		System.out.println("☆☆☆☆☆");
		
		//1차
		System.out.println("===1차 for문===");
		for(int i=1;i<=5;i++) {
			System.out.print("☆");
		}
		System.out.println();
		
		//2차
		System.out.println("===2차 for문===");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) System.out.print("☆");
			System.out.println();
		}
		
		
		//
		char c='A';
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print(c);
			}
			c++;
			System.out.println();
		}
		
		
		//
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i==j) System.out.print(i);
				else System.out.print("#");
			}
			System.out.println();
		}
		
		
		//
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i==j) System.out.print("★");
				else System.out.print("☆");
			}
			System.out.println();
		}
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i+j==6) System.out.print("★");
				else System.out.print("☆");
			}
			System.out.println();
		}
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i==j || i+j==6) System.out.print("★");
				else System.out.print("☆");
			}
			System.out.println();
		}

		for(int i=1;i<=4;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=5-i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.print("출력할 줄 수:");
		int n = scan.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		
		//
		c='A';
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(c);
				c++;
			}
			System.out.println();
		}
		
		for(int i=1;i<=4;i++) {
			c='A';
			for(int j=1;j<=i;j++) {
				System.out.print(c);
				c++;
			}
			System.out.println();
		}
		
		
		//구구단
		System.out.println("구구단 출력");
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				System.out.printf("%2d *%2d =%3d\t", j,i,i*j);
			}
			System.out.println();
		}
		
		
		//
		for(int i=1;i<=5;i++) {
			c='A';
			for(int j=1;j<=5;j++) {
				if(i==j) System.out.print((char)(c+32));
				else System.out.print(c);
				c++;
			}
			System.out.println();
		}
		
		
		//
		System.out.print("2~12 사이의 정수 입력:");
		int hap = scan.nextInt();
		for(int i=1;i<=6;i++) {
			for(int j=1;j<=6;j++) {
				if(i+j==hap) System.out.printf("[%d,%d]%n", i,j);
			}
		}
		
	}

}
