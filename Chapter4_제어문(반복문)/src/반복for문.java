import java.util.Scanner;

/* 
 * 0. 반복문 : 같은 형태 여러개 입력하고 싶을 때
 *  1) for : 반복 횟수가 지정된 경우
 *  		 화면 UI 출력 시 사용
 *  	for(초기값;조건식;증감식) {
 *  			수행문장
 * 		}
 * 			-> 수행 순서 : 초기값 > 조건식 > 수행문장 > 증감식 > 조건식(false까지 반복)
 * 					ex. for(int i=1;i<=10;i++) { 수행	 }
 * 			- 초기값 : 어디서부터
 * 			  조건식 : 어디까지
 * 			  증감식 : 몇 번 반복
 * 
 *  2) while : 반복 횟수가 지정되지 않은 경우
 *  		   DB에서 사용(데이터량 모름)
 *  		 : 조건 검색이 먼저(선조건) -> 한번도 수행하지 않을 수 있음
 *  	초기값
 *  		while(조건식) {
 *  				수행문장
 *  				증감식
 *			}
 *				cf. 무한 반복 -> for(;;) / while(true)
 *							  주로 while 사용(for는 거의 사용 안 함)
 *
 *  3) do~while : 조건 검색이 나중(후조건) -> 한번 이상은 반드시 수행
 *  	초기값
 *  		do {
 *  			수행문장
 *  			증감식
 *  		} while(조건식);
 *  
 * 1. for문
 *  1) 일반 for문
 *  2) forEach(웹에서 사용); 데이터가 필요(배열, 컬렉션에서 사용) 
 * 			-> 자바스크립트의 map, forEach, for of, for in
 * */

public class 반복for문 {

	public static void main(String[] args) {
		//구구단
		int dan = (int)(Math.random()*8)+2;
		System.out.println(dan+"단");
		for(int i=1;i<=9;i++) {
			System.out.printf("%2d *%2d = %2d%n", dan,i,dan*i);
		}
		
		
		//짝수 출력
		//1)
		for(int i=1;i<=10;i++)
			if(i%2==0) System.out.print(i+" ");
		
		//2)
		System.out.println();
		for(int i=2;i<=10;i+=2)
			System.out.print(i+" ");
		
		
		//합 구하기
		int total=0, even=0, odd=0;
		for(int i=1;i<=100;i++) {
			if(i%2==0) even+=i; //짝수 누적
			else odd+=i; //홀수 누적
			total+=i; //총 누적
		}
		
		System.out.println("1~100까지 총합:"+total);
		System.out.println("1~100까지 짝수합:"+even);
		System.out.println("1~100까지 홀수합:"+odd);
					
		int a3=0, a5=0, a7=0;
		for(int i=1;i<=100;i++) {
			if(i%3==0) a3+=i;
			if(i%5==0) a5+=i; //a3와 a5에 중복되는 값 있으므로 단일 if문 사용해야 함 -> else if로 하면 공배수가 제외됨
			if(i%7==0) a7+=i;
		}

		System.out.println("1~100까지 3의 배수 합:"+a3);
		System.out.println("1~100까지 5의 배수 합:"+a5);
		System.out.println("1~100까지 7의 배수 합:"+a7);
				
				
		//updown 게임
		Scanner scan = new Scanner(System.in);
		int com = (int)(Math.random()*100)+1;
		
		for(;;) {
			System.out.println("정수 입력(1~100):");
			int user = scan.nextInt();
			if(user<1 || user>100) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			if(com>user) {
				System.out.println("입력값보다 큰 수를 입력하세요.");
			} else if(com<user) {
				System.out.println("입력값보다 작은 수를 입력하세요");
			} else {
				System.out.println("Game Over!!");
				System.exit(0);
			}
		}
		
	}

}
