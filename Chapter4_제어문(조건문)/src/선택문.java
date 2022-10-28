import java.util.Scanner;

/* 
 * - 프로그래밍 시 중요도
 * 	1) 가독성 
 * 	2) 최적화(default 주로 사용) 
 * 	3) 간결화
 * 
 * 5) 선택문 : 조건의 여러 결과값 중 한 개를 선택하여 실행
 * 		- 키보드, 점수 등에 사용 -> 네트워크, 메뉴처리 등
 * 		- 다중 조건문(if-else if)과 비슷, 상황에 따라 편한 것 선택하여 사용
 * 				ex. switch의 case는 범위 설정 불가(값 하나씩 모두 case 설정 필요) -> 다중 조건문 사용
 * 					경우의 수가 많은 경우 -> switch문이 더 효율적(해당하지 않는 경우 else로 거치지 않아도 됨)
 * 		- switch(조건식) {
 * 			case 값1 : 
 * 				처리문장 1;
 * 				break; //필수 아님, 필요한 곳에 배치
 * 			case 값2 : 
 * 				처리문장 2;
 * 				break;
 * 			case 값3 : 
 * 				처리문장 3;
 * 				break;
 * 			default :
 * 				처리문장; //해당 번호가 없는 경우에 사용 -> 생략 가능
 * 			}
 * 		- 조건식의 결과값에 해당하는 case문으로 이동하여 진행
 * 		- 조건식의 결과 정수, 문자, 문자열만 가능 -> 실수 불가
 * 		- 중첩 선택문; 거의 안나옴
 * 				switch() {
 * 					case 1:
 * 						switch() {
 * 					}
 * 				}
 * 		- 블록(변수의 사용 범위 지정; 지역변수) 사용에 주의
 * 			-> 여러 case에서 같은 변수를 사용할 경우 처리 문장에 블록 설정하여 각각 해당 case에서만 사용되도록 설정
 * 											 or switch 밖에서 변수 설정 후 값만 변경
 * 				ex. case 1: {
 * 						int a = 10;
 * 					} //a는 이 블록이 닫히면 사라짐
 * 					case 2: {
 * 						int a = 20;
 * 					}
 * */

public class 선택문 {

	public static void main(String[] args) {
		//사칙연산
		Scanner scan = new Scanner(System.in);
		System.out.println("첫번째 정수 입력:");
		int num1 = scan.nextInt();
		System.out.println("두번째 정수 입력:");
		int num2 = scan.nextInt();
		
		System.out.println("연산자 입력(+,-,*,/):");
		switch(scan.next()) {
					//문자열 아무거나 가능 -> 정수, 문자, 문자열
			case "+":
				System.out.printf("%d+%d=%d%n", num1,num2,num1+num2);
				break; //break 걸린 곳까지 수행 -> break 없으면 case1에 해당하더라도 1~4 모두 수행됨
			case "-":
				System.out.printf("%d-%d=%d%n", num1,num2,num1-num2);
				break;
			case "*":
				System.out.printf("%d*%d=%d%n", num1,num2,num1*num2);
				break;
			case "/":
				if(num2==0) 
					System.out.println("0으로 나눌 수 없습니다.");
				else 
					System.out.printf("%d/%d=%.2f%n", num1,num2,(double)num1/num2);
				break;
			default:
				System.out.println("연산자를 입력하세요!");
		}
		
		
		//학점
		System.out.println("국어, 영어, 수학 점수:");
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		int total = kor+eng+math;
		double avg = total/3.0;
		
		char score;
		switch((int)(avg/10)) {
				//실수형 불가 -> 정수로 형변환
					//case 경우의 수를 줄이기 위해 10으로 나눔
			case 10:
			case 9:
				score='A';
				//변수 switch 밖에서 설정되었으므로 괄호 불필요
				break; 
			//case 10에 수행문장, break 없음 -> 10, 9의 경우 모두 'A' 처리
			case 8:
				score='B';
				break;
			case 7:
				score='C';
				break;
			case 6:
				score='D';
				break;
			default:
				score='F';
		}
		
		System.out.println("국어:"+kor+",영어:"+eng+",수학:"+math);
		System.out.println("총점:"+total);
		System.out.printf("평균:%.2f%n", avg);
		System.out.println("학점:"+score);

		
		//계절
		int month = (int)(Math.random()*12)+1;
							//0 <= double < 1
		System.out.print(month+"월은 ");
		switch(month) {
			case 12: case 1: case 2: 
				//if(month==12 || month==1 || month==2)
				System.out.println("겨울입니다.");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("봄입니다.");
				break;
			case 6: case 7: case 8:
				System.out.println("여름입니다.");
				break;
			case 9: case 10: case 11:
				System.out.println("가을입니다.");
				break;
		}

		
		//가위바위보
		System.out.println("가위(0) 바위(1) 보(2):");
		int user = scan.nextInt();
		int com = (int)(Math.random()*3);
		
		switch(com) {
			case 0:	System.out.println("컴퓨터: 가위");
			break;
			case 1:	System.out.println("컴퓨터: 바위");
			break;
			case 2:	System.out.println("컴퓨터: 보");
			break;
		}
		switch(user) {
			case 0:	System.out.println("플레이어: 가위");
			break;
			case 1:	System.out.println("플레이어: 바위");
			break;
			case 2:	System.out.println("플레이어: 보");
			break;
		}
		
		/*
		String[] res = {"가위, 바위, 보"};
		System.out.println("컴퓨터:"+res[com]);
		System.out.println("플레이어:"+res[user]);
		 */
		
		System.out.print("게임 결과: ");
		switch(com) {
		case 0:
			switch(user) {
			case 0:
				System.out.println("비겼다~");
				break;
			case 1:
				System.out.println("이겼다!!");
				break;
			case 2:
				System.out.println("졌다ㅠㅠ");
				break;
			}
			break;
		case 1:
			switch(user) {
			case 0:
				System.out.println("졌다ㅠㅠ");
				break;
			case 1:
				System.out.println("비겼다~");
				break;
			case 2:
				System.out.println("이겼다!!");
				break;
			}
			break;
		case 2:
			switch(user) {
			case 0:
				System.out.println("이겼다!!");
				break;
			case 1:
				System.out.println("졌다ㅠㅠ");
				break;
			case 2:
				System.out.println("비겼다~");
				break;
			}
			break;
		}

	}

}
