import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/* 
 * cf. 명령문 아래 소스코딩을 못하는 경우
 * 		: throw, break, continue, return
 * 	   명령문 위에 소스코딩을 못하는 경우
 *  	: this(), super()
 * */

class MyException extends Exception{
	public MyException(String msg) {
		super(msg);
	}
}
public class 예외처리_예외던지기 {

	public static void main(String[] args) {
		//예외던지기(예외 임의발생)
		try {
			int a=10;
			if(a%2==0) {
				throw new MyException(a+"은(는) 홀수가 아닙니다.");
			}
		} catch(MyException e) {
				//사용자정의 예외처리 클래스는 catch문에서 읽을 수 없으므로 throw 처리(예외 임의로 발생함)
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		
		//숫자야구게임
		int[] com=new int[3];
		int[] user=new int[3];
		for(int i=0;i<com.length;i++) {
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0;j<i;j++) {
				if(com[i]==com[j]) {
					i--;
					break;
					}
				}
			}
		System.out.println(Arrays.toString(com));
		
		Scanner scan=new Scanner(System.in);
		while(true) {
			try {
				System.out.print("세자리 정수 입력:");
				int input=scan.nextInt();
				if(input<99 || input>999) {
					throw new Exception("세자리 정수만 입력할 수 있습니다."); //continue의 역할
						//throw 아래 문장은 소스 코딩 불가(오류 발생시켰으므로)
				}	
				user[0]=input/100;
				user[1]=(input%100)/10;
				user[2]=input%10;
				if(user[0]==user[1] || user[0]==user[2] || user[1]==user[2]) {
					throw new Exception("같은 수는 입력할 수 없습니다.");
				}
				
				int s=0,b=0;
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						if(com[i]==user[j]) {
							if(i==j) s++;
							else b++;
						}
					}
				}
				System.out.printf("Input Number:%d, Result:%dS-%dB%n",input,s,b);
				if(s==3) {
					System.out.println("Game Over!");
					break;
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
