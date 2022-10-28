import java.util.Scanner;

/*
 *  3) 다중 조건문
 *   	- if(조건) { true일 때 수행	} 
 *   	  else if (조건) { false/true일 때 수행	} 
 *   	  else { false/false일 때 수행 }
 *   	- 마지막 else 조건은 생략 가능 -> 아무것도 실행되지 않는 경우 존재
 *   	- 여러 조건문 중 해당되는 경우 1개만 수행 
 *   		-> 중복으로 수행해야 하는 조건이 있을 경우에는 단일 조건문 사용해야 함
 *   			ex. 3의 배수, 5의 배수, 7의 배수 출력 => 15의 배수는 중복되므로 다중 조건문 사용 불가
 *  */

public class 다중조건문 {

	public static void main(String[] args) {
		//학점 판단
		int kor = (int)(Math.random()*51)+50;
		int eng = (int)(Math.random()*51)+50;
		int math = (int)(Math.random()*51)+50;
		int avg = (kor+eng+math)/3;
		
		char grade = 'A';
		if(avg>=90) grade='A';
		else if(avg>=80) grade='B';
			//단일 if문과 달리 다중 if문(else if)는 중복 수행하지 않으므로 범위 이렇게 설정해도 됨
		else if(avg>=70) grade='C';
		else if(avg>=60) grade='D';
		else if(avg<60) grade='F';
							// else if이므로 A~F 중 하나만 출력
		
		System.out.println("국어:"+kor+", 영어:"+eng+", 수학:"+math);
		System.out.println("평균:"+avg);
		System.out.println("학점:"+grade);
		
		
		//메뉴 선택
		System.out.println("============Menu===========");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 영화 목록");
		System.out.println("4. 영화 상세보기");
		System.out.println("5. 영화 예매");
		System.out.println("6. 종료");
			
		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 선택(1~6):");
		int menu = scan.nextInt();
		if(menu==1)
			System.out.println("로그인을 요청하셨습니다!");
		else if(menu==2)
			System.out.println("회원가입을 요청하셨습니다!");
		else if(menu==3)
			System.out.println("영화 목록을 요청하셨습니다!");
		else if(menu==4)
			System.out.println("영화 상세보기를 요청하셨습니다!");
		else if(menu==5)
			System.out.println("예매를 요청하셨습니다!");
		else if(menu==6)
			System.exit(0); //프로그램 종료
		else System.out.println("잘못 선택하셨습니다.");
		
	}

}
