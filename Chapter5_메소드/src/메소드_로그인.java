import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 * 로그인 시 경우의 수
 * 	- ID 존재 여부 -> NOID
 * 	- PW 존재 여부 -> NOPW
 * 	- 일치 여부 -> OK
 * */

public class 메소드_로그인 {
	static boolean isLogin(String id, String pw) {
		final String ID = "admin";
		final String PW = "1234";
		
		boolean bCheck=false;
		if(id.equalsIgnoreCase(ID) && pw.equals(PW))
			bCheck=true;
		return bCheck; 
		
		/*
		if(id.equals(ID) && pw.equals(PW))
			return true;
		return false; //true가 아닐 경우 실행될 수 있는 return이 필요
		 */
	}
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
		return false;
	}
	public static void main(String[] args) {
		String id=JOptionPane.showInputDialog("ID 입력");
		String pw=JOptionPane.showInputDialog("PW 입력");
		
		boolean bCheck=isLogin(id, pw);
		if (bCheck)
			System.out.println(id+"님 로그인 되었습니다!!");
		else System.out.println("ID 또는 비밀번호를 확인하세요.");
		
		if(isLogin2())
			System.out.println("로그인되었습니다.");
		else System.out.println("ID/비밀번호 확인");
		
	}

}
