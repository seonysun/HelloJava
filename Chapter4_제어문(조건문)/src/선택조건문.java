import java.util.Scanner;

/*
 *  2) 선택 조건문 : true/false 나눠서 처리 -> 단일 조건문의 경우 false일 때를 조건을 따로 줘야 함
 * 		- if(조건) { true일 때 수행 } 
 * 		  else { false일 때 수행 }
 *  	- 하나의 조건은 계산하지 않아도 됨 -> 더 효율적
 *  	- 조건이 2개일 때 if else 사용 가능 
 *  		-> 조건이 3개 이상이면 단일 조건문 or 다중 조건문 사용
 *  	- 삼항연산자와 동일한 표현 가능
 *  */

public class 선택조건문 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("알파벳 입력:");
		char alpha = scan.next().charAt(0);
							//Scanner는 문자열만 인식 가능(문자 불가) -> charAt으로 첫번째 문자 추출
		if (alpha>='A' && alpha<='Z')
			System.out.println(alpha+"은(는) 대문자입니다.");
		else
			System.out.println(alpha+"은(는) 소문자입니다.");
		
	}

}
