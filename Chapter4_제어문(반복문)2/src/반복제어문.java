import java.util.Scanner;

/*
 * 2. 반복제어문
 * 	1) break;(반복 종료) : break 이하의 문장 수행하지 않고 제어문 탈출 
 * 		- 웹에서 많이 사용됨
 * 		- l이중for문에서 바로 앞의 for문만 제어 가능
 * 
 *  2) continue;
 *  	- for(초기값;조건식;증감식){
 * 				continue; => 증감식으로 이동 : continue 위의 문장 제외하고 반복
 * 			}
 * 		- while(조건식){
 * 				continue; => 조건식으로 이동 : 무한루프 (continue 이하가 수행되지 못하고 조건식으로 이동 -> 증감식 수행되지 못하므로 false 조건 되지 못하고 계속 반복)
 *				증감식
 * 			}
 * 		- while의 continue는 잘못된 입력에 대한 경고줄 때 주로 사용 
 * 			ex. 다시 입력하세요 -> continue
 * 
 * 	3) 주의점 - break와 continue 바로 아랫줄(동일 괄호 내)에는 소스 코딩 시 오류 발생
 * 			- 사용 위치 : break -> 반복문(for, while), 선택문(switch)
 * 						continue -> 반복문
 *			- System.exit(0); 프로그램을 아예 종료하는 것이므로 아래에 있는 문장 전부 실행 불가
 *						(0) 정상 종료, (-1) 비정상 종료
 * */

public class 반복제어문 {

	public static void main(String[] args) {
		//break
		for(int i=1;i<100;i++) {
			System.out.print(i+" "); //출력이 선행되므로 5까지 출력
			if(i==5)
				break;
		}
		System.out.println();
		
		for(int i=1;i<100;i++) {
			if(i==5)
				break;
			System.out.print(i+" "); //출력이 나중이므로 4까지 출력
		}
		System.out.println();
		
		int i=1;
		while(i<=100) {
			System.out.print(i+" ");
			if(i==5)
				break;
			i++;
		}
		System.out.println();
		
		i=1;
		while(i<=100) {
			if(i==5)
				break;
			System.out.print(i+" ");
			i++;
		}
		System.out.println();
		
		
		//continue
		for(i=1;i<=10;i++) {
			if(i==5 || i==9)
				continue;
			System.out.print(i+" ");
		}
		System.out.println();
		
		
		//무한 가위바위보
		Scanner scan = new Scanner(System.in);
		int win=0, lose=0, draw=0;
		int count=0;
		while(true) {
			int com = (int)(Math.random()*3);
			System.out.print("가위(0) 바위(1) 보(2):");
			int user = scan.nextInt();
			if(user<0 || user>2) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			count++;
			
			if(com==0) System.out.println("컴퓨터: 가위");
			else if(com==1) System.out.println("컴퓨터: 바위");
			else if(com==2) System.out.println("컴퓨터: 보");
			if(user==0) System.out.println("플레이어: 가위");
			else if(user==1) System.out.println("플레이어: 바위");
			else if(user==2) System.out.println("플레이어: 보");
			
			switch(com-user) {
			case -1: case 2:
				System.out.println("=> Win");
				win++;
				break;
			case 1: case -2:
				System.out.println("=> Lose");
				lose++;
				break;
			case 0:
				System.out.println("=> 비겼습니다.");
				draw++;
			}
			
			System.out.println("게임을 종료할까요?(Y/N):");
			char c = scan.next().charAt(0);
			if(c=='Y' || c=='y') {
				System.out.println("Game Over!!");
				break; //while 탈출
			}
		}
		System.out.printf("%d전 %d승 %d무 %d패%n", count,win,draw,lose);

	}

}
