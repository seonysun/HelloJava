import java.util.Scanner;

public class 메소드_사칙연산 {
	static int add(int a, int b) {
		return a+b;
	}
	static int minus(int a, int b) {
		return a-b;
	}
	static int multi(int a, int b) {
		return a*b;
	}
	static int div(int a, int b) {
		return a/b;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 정수 입력:");
		int a=scan.nextInt();
		System.out.print("두번째 정수 입력:");
		int b=scan.nextInt();
		System.out.print("연산자 입력(+,-,*,/):");
		String op=scan.next();
		
		int result=0;
		switch(op) {
		case "+":
			result=add(a,b);
			break;
		case "-":
			result=minus(a,b);
			break;
		case "*":
			result=multi(a,b);
			break;
		case "/":
			result=div(a,b);
			break;
		}
		System.out.println("답:"+result);
		
	}

}
