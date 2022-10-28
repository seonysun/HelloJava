import java.util.Scanner;

/*
 * 논리연산자 : &&(and), ||(or)
 * 		- &&(직렬연산자) : 두 개의 조건이 모두 true일 경우 true
 * 					-> 범위나 기간에 포함될 때(구간 사이를 출력할 때)
 * 		- ||(병렬연산자) : 두 개의 조건 중 한 개 이상 true일 경우 true
 * 					-> 범위나 기간에 미포함될 때
 * 		- && 우선순위, || 후순위
 * 		- 효율적인 연산(최적화 연산) : (조건 false) && (조건) -> 연산 처리 안 함, 무조건 false 
 * 														false일 확률이 높은 조건을 앞에 두면 효율적으로 진행 가능
 *        						(조건 true) || (조건) -> 연산 처리 안 함, 무조건 true
 * 														true일 확률이 높은 조건을 앞에 두면 효율적으로 진행 가능
 * */

public class 논리연산자 {

	public static void main(String[] args) {
		int a = 10;
		int b = 9;
		boolean result1 = (a<b) && ++b==a;
		System.out.println("result1:"+result1);
							//앞의 조건이 false이므로 뒤의 조건은 확인하지 않음
		boolean result2 = (a>b) && ++b==a;
		System.out.println("result2:"+result2);
		
		
		int c = (int)(Math.random()*100)+1;
		char d = (char)((int)(Math.random()*26)+65);
		System.out.println("c="+c+",d="+d);
		boolean result3 = c>50 && d<'K';
		System.out.println("result3:"+result3);
		boolean result4 = c>50 || d<'K';
		System.out.println("result4:"+result4);

		
		Scanner scan = new Scanner(System.in);
			//Math, System 등의 애들은 java.lang에 들어있어서 생략 가능(자동 인식), Scanner는 생략 안 됨
		System.out.print("알파벳 입력:");
		char c1 = scan.next().charAt(0); 
		boolean b1 = c1>='A' && c1<='Z'; 
					//A~Z 사이에 있는지 : 대문자인지
			//boolean b1 = scan.next().charAt(0)>='A' && scan.next().charAt(0)<='Z';
		boolean b2 = c1>='a' && c1<='z'; 
					//a~z 사이에 있는지 : 소문자인지
		System.out.println("b1="+b1+" --> 대문자");
		System.out.println("b2="+b2+" --> 소문자");
							//조건문 쓰면 더 예쁘게 표현 가능
		
	}

}
