import java.util.Scanner;

/*
 * 1. String (클래스) : 데이터형, 클래스형
 * 	- 데이터형 초기화 : String 변수명 = "";
 *  - 기능 - 내용 비교 : equals(); 대소문자 구분
 *  				: equalsIgnoreCase(); 대소문자 구분 안함
 *  			-> 문자열에서 equals가 아닌 ==를 주면 두 문자열의 객체 자체가 같은지를 판단(내용 비교가 아님)
 *  	  - 문자열길이 : length()
 *  	  - 문자 1개 추출 : charAt()
 * */

public class Week2_제어문_String {

	public static void main(String[] args) {
		//문자열
		String s = "Hello Java";
		System.out.println("문장의 길이:"+s.length());
										//공백도 문자 1에 해당
		System.out.println("9번째 문자:"+s.charAt(9));
										//첫번째 문자 : 0번
		
		for(int i=s.length()-1;i>=0;i--) {
			char c = s.charAt(i);
						//첫번째 문자가 0번이므로 마지막 문자는 (총길이-1)번째 문자 -> length-1
			System.out.print(c);
		}
		System.out.println();
		
		
		//2진법 출력
		int num = (int)(Math.random()*101);
		int num2 = num; //아래 for문에 사용하기 위해 초기화
		System.out.println("num="+num);
		System.out.println(Integer.toBinaryString(num));
									//2진법으로 바꾸는 메소드
		System.out.println("==2진법 출력== while");
		String result="";
		while(true) {
			int a=num%2;
			result+=a;
			num=num/2;
			if(num==0) break;
		}
		for(int i=result.length()-1;i>=0;i--)
				//2진법은 뒤에서부터 출력해야 함
			System.out.print(result.charAt(i));
		System.out.println();
		
		System.out.println("==2진법 출력== for");
			//위의 for문에서 result값(2진법 나누기 결과)과 num값(0)이 변경되었으므로 다시 초기화 필요
		result="";
		for(;;) {
			int a=num2%2;
			result+=a;
			num2/=2;
			if(num2==0) break;
		}
		for(int i=result.length()-1;i>=0;i--)
			System.out.print(result.charAt(i));
		System.out.println();
		
		
		//로그인처리
		Scanner scan = new Scanner(System.in);
		final String ID = "Admin";
		final String PW = "1234";
		System.out.print("ID를 입력하세요:");
		String id = scan.next();
		System.out.print("비밀번호를 입력하세요:");
		String pw = scan.next();
		
		/*if(id.equalsIgnoreCase(ID) && pw.equals(PW)) {
			System.out.println("로그인 완료!");
			System.out.println("메인 페이지로 이동");
		} else {
			System.out.println("로그인 실패");
			System.out.println("ID 또는 비밀번호를 다시 확인해주세요 || 회원가입으로 이동");
		}*/
		
		if(id.equals(ID)) {
			if(pw.equals(PW)) System.out.println("로그인 완료!");
			else System.out.println("비밀번호를 확인해주세요.");
		} else {
			System.out.println("존재하지 않는 ID입니다.");
		}
		
	}

}
