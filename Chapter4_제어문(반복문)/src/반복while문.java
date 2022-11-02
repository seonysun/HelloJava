import java.util.Scanner;

/*
 * 0. 변수 설정 
 *	지역변수(멤버변수 = 전역변수), 매개변수(사용자의 입력값 받음)
 * 
 * cf. 조건문(if)에서 조건문 다음에 ; 입력하면 결과에 상관없이 모두 출력됨 주의 -> if 수행문장까지 내려가지 않고 문장 종료
 * cf. 선택조건문(if else) = 삼항연산자
 * 	   다중조건문(if else if) = switch case
 * 
 * 1. 반복문
 * 	0) 반복문의 결과값
 * 		- 총합: sum+=i
 * 		- 곱: multi*=i
 * 		- 갯수: count++
 * 			-> 추천목록(추천 알고리즘에 해당되는 값 더해서 가장 큰 수 가진 것 제시)
 * 
 * 	1) for
 * 		- 프론트엔드에서 많이 사용
 * 		- for(초기값;조건식;증감식) { 수행문장 }
 * 		- for(;;) -> 초기값, 조건식 없음 -> 무한루프
 * 
 * 	2) while
 * 		- 네트워크 서버 만들 때, DB 가져올 때 주로 사용 -> 백엔드에서 많이 사용
 * 		- 초기값
 * 		  while(조건식) {  수행문장
 * 						  증감식(종료조건)  }
 * 		- 선조건 : 조건에 해당되지 않는 경우 수행되지 않을 수 있음
 * 					ex. String id = "" -> id가 없는 경우 while문이 수행되지 않도록 프로그래밍
 * 		- 조건식 생략 시 오류 발생 -> true/false 결과 도출 가능하도록 설정 필요
 * 		- while(true) -> false인 경우 없음 -> 무한루프 : 종료하는 프로그램 따로 첨부하거나 break 설정 해야 함 
 * 													ex. 게임 ESC -> System.exit(0);
 * 
 * 	3) do~while
 * 		- 웹에서 사용 빈도 거의 없음
 * 		- 초기값
 * 		  do { 수행문장
 * 				증감식(종료조건) } while(조건식); 
 * 								// 얘는 괄호가 없으니까 ; 필요
 * 		- 후조건 : 조건에 해당되지 않더라도 최소 1번은 무조건 수행
 * 
 * cf. 웹에서는 배열은 잘 안씀
 * */

public class 반복while문 {

	public static void main(String[] args) {
		//1~10까지 출력
		System.out.println("1 2 3 4 5 6 7 8 9 10");
		
		System.out.println("for문===");
		for(int i=1;i<=10;i++) {
			System.out.print(i+" ");
		}
		
		System.out.println("\nwhile문===");
		int i=1;
		while(i<=10) {
			System.out.print(i+" ");
			i++;
		}
		
		System.out.println("\ndo while문===");
		i=1; //새로운 변수를 선언할 필요는 없음, 그냥 초기화만 다시 해주면 됨
		do {
			System.out.print(i+" ");
			i++;
		} while(i<=10);
		System.out.println();
		
		
		//1~100까지의 합
		System.out.println("===for문");
		int sum=0;
		for(i=1;i<=100;i++) {
			sum+=i;
			//System.out.println("i:"+i+", sum:"+sum);
		}
		System.out.println(sum);
		
		System.out.println("===while문");
		sum=0;
		i=1;
		while(i<=100) {
			sum+=i;
			i++;
		}
		System.out.println(sum);
		
		System.out.println("===do while문");
		sum=0;
		i=1;
		do {
			sum+=i;
			i++;
		} while(i<=100);
		System.out.println(sum);
		
		
		//알파벳 출력
		char al = 'A';
		while(al<='Z') {
			System.out.print(al+" ");
			al++;
		}
		
		System.out.println();
		al-=1;
			//위에서 while문 종료 시 al='Z'+1이므로 새로 초기화 필요
		while(al>='A') {
			System.out.print((char)(al+32)+" ");
			al--;
		}
		System.out.println();

		
		//난수 6개 추출하여 합 구하기
		sum = 0;
		i=1;
		while(i<=6) {
			int a = (int)(Math.random()*100)+1;
				//6번 반복할 때마다 각각 a 추출되므로 계속 새로운 변수로 바뀜 -> 지역변수(블록변수)
			System.out.println(i+"번째 숫자:"+a);
			sum+=a;
			i++;
		}
		System.out.println("=>총합:"+sum);
		
		
		//정수 10개 입력 후 누적하여 출력
		Scanner scan = new Scanner(System.in);
		sum=0;
		i=1;
		while(i<=10) {
			//System.out.print(i+"번째 정수 입력:");
			//int num = scan.nextInt();
			int num = (int)(Math.random()*100)+1;
			System.out.println(i+"번째 정수:"+num);
			sum+=num;
			i++;
		}
		System.out.println("누적:"+sum);
				
			
		//화폐매수구하기
		System.out.print("금액을 입력하세요:");
		int won = scan.nextInt();
		int a=won/10000;
		int b=(won%10000)/1000;
		int c=(won%1000)/100;
		int d=(won%100)/10;
		int e=won%10;
				
		System.out.println("만원권:"+a);
		System.out.println("천원권:"+b);
		System.out.println("백원:"+c);
		System.out.println("십원:"+d);
		System.out.println("일원:"+e);
				
				
		//
		String[] arr = {"홍길동", "심청이", "춘향이", "박문수", "이순신"};
		for(i=0;i<5;i++) {
			System.out.println(arr[1]);
		}
		
	}

}
