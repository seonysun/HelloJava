import java.util.Scanner;

public class Week3_메소드 {
	//문제 1. 1~10까지 출력하는 메소드
	static void printen() {
		for(int i=1;i<=10;i++)
			System.out.print(i+" ");
		System.out.println();
	}
	//문제 2. 1~10까지 합 구하는 메소드
	static int sumtoten() {
		int sum=0;
		for(int i=1;i<=10;i++) {
			sum+=i;
		}
		return sum;
	}
	//문제 3. 1~n까지 합 구하는 메소드
	static int total(int n) {
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		return sum;
	}
	//문제 4. 두 정수의 나눗셈 결과 구하는 메소드
	static String div(int a, int b) {
		String result="";
		if(b==0) result="0으로 나눌 수 없습니다.";
		else result=String.valueOf(a/(double)b); //결과값을 실수->문자열로 변경
		return result;
	}
	//문제 5. 문자열의 소문자를 대문자로 바꾸는 메소드
	static String change(String a) {
		return a.toUpperCase();
	}
	//문제 6. 문자열의 좌우대칭 확인하는 메소드
	static boolean daech(String s) {
		boolean result=true;
		for(int i=0;i<s.length()/2;i++) {
			int last=s.length()-1-i;
			if(s.charAt(i)!=s.charAt(last)) {
				result=false;
			}
		}
		return result;
	}
	static void daech2() {
		Scanner scan=new Scanner(System.in);
		String s;
		while(true) {
			System.out.print("문자열을 입력하세요:");
			s=scan.next();
			if(s.length()%2!=0) {
				System.out.println("짝수개로 입력하세요.");
				continue;
			}
			break;
		}
		boolean b=true;
		for(int i=0;i<s.length()/2;i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
				b=false;
		}
		if(b) System.out.println("대칭입니다.");
		else System.out.println("대칭이 아닙니다.");
	}	
	//문제 7. 문자열 거꾸로 출력하는 메소드
	static void rev(String s) {
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
		System.out.println();
	}
	//문제 9. 윤년 여부 확인하는 메소드
	static boolean year(int y) {
		if(y%4==0 && y%100!=0 || y%400==0)
			return true;
		return false;
	}
	//문제 10. 더 큰 수를 출력하는 메소드
	static int max(int a, int b) {
		int max=a;
		if(a<b) max=b;
		return max;
		// return a<b?b:a;
	}
	//문제 11. 홀짝 구분하는 메소드
	static String evenodd(int a) {
		if(a%2==0)
			return a+"는 짝수";
		return a+"는 홀수";
	}
	//문제 12. 3의 배수 판별하는 메소드 
	static void tripp(int a) {
		if(a%3==0 && a!=0)
			System.out.println(a+"는 3의 배수");
		else System.out.println(a+"는 3의 배수가 아님");
	}
	//문제 14. 숫자 거꾸로 출력하는 메소드
	static void revnum(int num) {
		String s=String.valueOf(num);
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
	}
	public static void main(String[] args) {
		//문제 1.
		printen();
				
		//문제 2.
		System.out.println(sumtoten());
				
		//문제 3.
		System.out.println(total(10));
				
		//문제 4.
		int a=(int)(Math.random()*100)+1;
		int b=(int)(Math.random()*100)+1;
		String result=div(a, b);
		System.out.println("a:"+a+" b:"+b);
		System.out.println("-> "+result);
		
		//문제 5.
		System.out.println(change("hi"));
				
		//문제 6.
		Scanner scan=new Scanner(System.in);
		String s;
		while(true) {
			System.out.print("문자열 입력:");
			s=scan.next();
			if(s.length()%2!=0) {
				System.out.println("짝수개의 문자를 입력하세요.");
				continue;
			}
			break;
		}
		if(daech(s)) System.out.println("좌우 대칭입니다.");
		else System.out.println("좌우 대칭이 아닙니다.");
		
		daech2();
		
		//문제 7.
		rev("Hello Java");
		
		//문제 9.
		if(year(2022))
			System.out.println("윤년입니다.");
		else System.out.println("윤년이 아닙니다.");
				
		//문제 10.
		System.out.println("MAX="+max(3,53));
		
		//문제 11.
		String ans=evenodd(23849);
		System.out.println(ans);

		//문제 12.
		tripp(36234);
		
		//문제 14.
		System.out.print("거꾸로 읽을 숫자 입력:");
		int num=scan.nextInt();
		revnum(num);
	}

}
