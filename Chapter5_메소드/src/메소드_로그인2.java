import java.util.Scanner;

public class 메소드_로그인2 {
	static boolean isLogin2() {
		final String ID = "admin";
		final String PW = "1234";
		
		Scanner scan = new Scanner(System.in);
		System.out.print("ID 입력:");
		String id=scan.next();
		System.out.print("PW 입력:");
		String pw=scan.next();
		
		if(id.equals(ID) && pw.equals(PW))
			return true;
		return false; //true가 아닐 경우 실행될 수 있는 return이 필요
	}
	public static void main(String[] args) {
		if(isLogin2())
			System.out.println("로그인되었습니다.");
		else System.out.println("ID 비번 확인");
		
	}

}
