import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class 예외처리2 {
	
	public static void main(String[] args) {
		try {
			Scanner scan=new Scanner(System.in);
			System.out.print("첫번째 정수 입력:");
			String num1=scan.next();
			System.out.print("두번째 정수 입력:");
			String num2=scan.next();
			
			int n1=Integer.parseInt(num1);
			int n2=Integer.parseInt(num2);
			
			int n3=n1/n2;
			System.out.println("결과값:"+n3);
		} catch(NumberFormatException | ArithmeticException ex) {
			if(ex instanceof NumberFormatException)
					//ex는 예외처리 클래스의 객체 -> 어떤 클래스의 객체에 해당하는지 확인하는 조건문
				System.out.println("문자열이 입력되었습니다.\n정수를 입력하세요.");
			else if(ex instanceof ArithmeticException)
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("프로그램 종료");
		System.out.println();
		
		
		//
		FileReader fr=null; //finally문에서도 사용되는 변수이므로 try문 밖에 설정해야 함
		try {
			fr=new FileReader("c:\\javaDev\\guest.txt");
			int i=0;
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
		} catch(IOException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} finally {
			try {
				fr.close();
			} catch(IOException ex) {
				System.out.println("파일을 닫을 수 없습니다.");
			}
		}
		
		try (FileReader fr1=new FileReader("c:\\javaDev\\shop.txt")) { //fr.close() 자동처리
			int i=0;
			while((i=fr1.read())!=-1) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			System.out.println("파일이 존재하지 않습니다.");
		}
		System.out.println();
		
		
		//
		try {
			int[] arr=new int[6];
			for(int i=0;i<arr.length;i++) {
				arr[i]=(int)(Math.random()*45)+1;
				for(int j=0;j<i;j++) {
					if(arr[j]==arr[i]) {
						i--;
						break;
					}
				}
			}
			System.out.println("오늘의 로또 번호:");
			Arrays.sort(arr);
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
				Thread.sleep(1000); //수행 사이에 (1000)*1/1000초 간격 설정 
			}
		} catch(InterruptedException e) { //충돌 방지
			System.out.println(e.getMessage());
		}
		
	}
	
}
